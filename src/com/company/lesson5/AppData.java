package com.company.lesson5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sveta
 */
public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void saveToFile(String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            {
                for (String s : header) {
                    bw.write(s + ";");
                }
                bw.newLine();
                for (int row = 0; row < data.length; row++) {
                    for (int col = 0; col < data[row].length; col++) {
                        bw.write(data[row][col] + ";");
                    }
                    bw.newLine();
                }
            }
        }
    }

    public void loadFromFile(String filePath) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            this.header = br.readLine().split(";");

            List<String> dataRows = br.lines().collect(Collectors.toList());
            int rowCount = dataRows.size();
            int colCount = header.length;
            this.data = new int[rowCount][colCount];

            for (int row = 0; row < rowCount; row++) {
                String[] rowList = dataRows.get(row).split(";");
                for (int col = 0; col < colCount; col++) {
                    this.data[row][col] = Integer.parseInt(rowList[col]);
                }
            }
        }
    }

    public void clean() {
        header = null;
        data = null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AppData{");
        sb.append("header=").append(Arrays.toString(header));
        if (data != null) {
            for (int row = 0; row < data.length; row++) {
                sb.append(", data[").append(row).append("]=").append(Arrays.toString(data[row]));
            }
        } else {
            sb.append(", data=null");
        }

        sb.append('}');
        return sb.toString();
    }
}

