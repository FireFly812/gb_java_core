package com.company.lesson7.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

/**
 * @author Sveta
 */
public class DatabaseRepository {

    public DatabaseRepository() {
    }

    public void initDB() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = getConnection("jdbc:sqlite:lesson8db.db");
                Statement statement = connection.createStatement()) {

            performDropTable(statement);
            performCreateDB(statement);
        }
    }

    private static void performDropTable(Statement statement) throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS weather");

    }

    private static void performCreateDB(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS weather (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "date_str STRING,min_temp STRING,max_temp STRING,daytimeWeather STRING, weatherAtNight STRING);");
    }

    public void performPreparedStatement(String date, String minTemp, String maxTemp, String daytimeWeather,
            String weatherAtNight) throws SQLException {
        try (Connection connection = getConnection("jdbc:sqlite:lesson8db.db");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO weather (date_str,min_temp, max_temp,daytimeWeather,weatherAtNight) VALUES (?,?,?,?,?)")) {
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, minTemp);
            preparedStatement.setString(3, maxTemp);
            preparedStatement.setString(4, daytimeWeather);
            preparedStatement.setString(5, weatherAtNight);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        }
    }

    public void readDB() throws SQLException {
        try (Connection connection = getConnection("jdbc:sqlite:lesson8db.db");
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM weather;");
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt(1) + " - " +
                                resultSet.getString(2) + " | " +
                                resultSet.getString(3) + " | " +
                                resultSet.getString(4) + " | " +
                                resultSet.getString(5) + " | " +
                                resultSet.getString(6)

                );

            }
        }
    }

    public void getDataByDate(String dateValue) throws SQLException {
        try (Connection connection = getConnection("jdbc:sqlite:lesson8db.db");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM weather WHERE date_str = ?;")) {
            preparedStatement.setString(1, dateValue);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                System.out.println(

                        resultSet.getInt(1) + " - " +
                                resultSet.getString(2) + " | " +
                                resultSet.getString(3) + " | " +
                                resultSet.getString(4) + " | " +
                                resultSet.getString(5) + " | " +
                                resultSet.getString(6));
            } else {
                System.out.println("Данных за указанную дату не найдено");
            }
        }
    }
}

