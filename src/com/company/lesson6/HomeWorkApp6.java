package com.company.lesson6;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.net.URL;

/**
 * @author Sveta
 */
public class HomeWorkApp6 {
    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        URL url = new URL(
                "http://dataservice.accuweather.com/forecasts/v1/daily/5day/474212_PC?apikey=zo4Jx9T0llTNMDvb2cjEYloGKzJsY4ed&language=ru-ru&details=false&metric=false");

        Request requesthttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String jsonResponse = client.newCall(requesthttp).execute().body().string();
        System.out.println(jsonResponse);
    }
}
