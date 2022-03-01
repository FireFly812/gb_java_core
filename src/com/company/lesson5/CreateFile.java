package com.company.lesson5;

import java.io.IOException;

/**
 * @author Sveta
 */
public class CreateFile {
    public static void main(String[] args) throws IOException {

        String[] header = { "Value1", "Value2", "Value3" };
        int[][] data = { { 1, 2, 3 }, { 3, 4, 5 } };
        AppData appData = new AppData(header, data);

        appData.saveToFile("src/com/company/lesson5/demo.csv");
        System.out.println(appData);
        appData.clean();
        System.out.println(appData);
        appData.loadFromFile("src/com/company/lesson5/demo.csv");
        System.out.println(appData);
    }
}
