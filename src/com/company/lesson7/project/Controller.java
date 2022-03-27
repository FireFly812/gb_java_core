package com.company.lesson7.project;

import com.company.lesson7.project.enums.Functionality;
import com.company.lesson7.project.enums.Periods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller {

    WeatherProvider weatherProvider = new AccuWeatherProvider();
    Map<Integer, Functionality> variantResult = new HashMap();
    DatabaseRepository databaseRepository = new DatabaseRepository();

    public Controller() {
        variantResult.put(1, Functionality.GET_CURRENT_WEATHER);
        variantResult.put(2, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
        variantResult.put(3, Functionality.GET_WEATHER_BY_DATE);
    }

    public void onUserInput(String input) throws IOException {
        int command = Integer.parseInt(input);
        if (!variantResult.containsKey(command)) {
            throw new IOException("There is no command for command-key " + command);
        }

        switch (variantResult.get(command)) {
        case GET_CURRENT_WEATHER:
            getCurrentWeather();
            break;
        case GET_WEATHER_IN_NEXT_5_DAYS:
            getWeatherIn5Days();

            try {
                databaseRepository.readDB();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;
        case GET_WEATHER_BY_DATE:
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите дату в формате YYYY-MM-DD");
            String date = scanner.nextLine();
            getWeatherIn5Days();
            try {
                databaseRepository.getDataByDate(date);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;
        }
    }

    public void getCurrentWeather() throws IOException {
        weatherProvider.getWeather(Periods.NOW);
    }

    public void getWeatherIn5Days() throws IOException {
        weatherProvider.getWeather(Periods.FIVE_DAYS);
        ;
    }
}
