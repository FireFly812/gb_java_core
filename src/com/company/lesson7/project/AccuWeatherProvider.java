package com.company.lesson7.project;

import com.company.lesson7.project.AccuWeatherCurrentResponse.CurrentResponse;
import com.company.lesson7.project.enums.Periods;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AccuWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String DAYS_5 = "5day";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String cityName;

    @Override
    public void getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            String jsonResponse = client.newCall(request).execute().body().string();
            System.out.println(jsonResponse);
            ObjectMapper mapper = new ObjectMapper();
            List<CurrentResponse> crs = mapper.readValue(jsonResponse, new TypeReference<List<CurrentResponse>>() {
            });
            CurrentResponse cr = crs.get(0);
            System.out.println("В городе " + cityName + " на " + new SimpleDateFormat("yyyy-MM-dd")
                    .format(cr.localObservationDateTime) + " " + cr.temperature.metric.value +
                    cr.temperature.metric.unit + " " + cr.weatherText);
        } else if (periods.equals(Periods.FIVE_DAYS)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(DAILY)
                    .addPathSegment(DAYS_5)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru")
                    .addQueryParameter("metric", "true")
                    .build();
            System.out.println(url);
            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();
            String jsonResponse = client.newCall(request).execute().body().string();
            //System.out.println(jsonResponse);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonResponse);
            for (int i = 0; i < 5; i++) {
                String dateS = root.get("DailyForecasts").get(i).at("/Date").textValue();
                try {
                    Date date = (new SimpleDateFormat("yyyy-MM-dd")).parse(dateS);
                    dateS = new SimpleDateFormat("yyyy-MM-dd").format(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String temperatureMin = root.get("DailyForecasts").get(i).get("Temperature").get("Minimum").get("Value")
                        .asText();
                String temperatureMax = root.get("DailyForecasts").get(i).get("Temperature").get("Maximum").get("Value")
                        .asText();
                String unit = root.get("DailyForecasts").get(i).get("Temperature").get("Minimum").get("Unit")
                        .textValue();
                String daytimeWeather = root.get("DailyForecasts").get(i).at("/Day/IconPhrase").asText();
                String weatherAtNight = root.get("DailyForecasts").get(i).at("/Night/IconPhrase").asText();
                System.out.println(
                        "В городе " + cityName + " на " + dateS + " минимальная температура воздуха: " + temperatureMin
                                + unit + ", максимальная температура воздуха: " + temperatureMax + unit + ", днем: "
                                + daytimeWeather + ", ночью: " + weatherAtNight);
            }

        }
    }

    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else
            throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }
}
