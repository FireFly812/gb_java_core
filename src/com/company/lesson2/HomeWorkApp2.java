package com.company.lesson2;

/**
 * @author Sveta
 */
public class HomeWorkApp2 {

    public static void main(String[] args) {

        String[][] matrix1 = { { "1", "2", "3", "3" },
                { "3", "2", "4", "1" },
                { "3", "3", "3", "2" },
                { "2", "5", "2", "3" } };

        String[][] matrix2 = { { "1", "2", "3", "3" },
                { "3", "2", "mmm", "1" },
                { "3", "3", "3", "1" },
                { "2", "2", "2", "2" } };

        String[][] matrix3 = { { "1", "2", "3", "3" },
                { "3", "2", "1", "1" },
                { "3", "3", "3", "1" },
                { "2", "2", "2", "2" },
                { "2", "2", "2", "2" } };

        String[][] matrix4 = { { "1", "1", "1", "1", "1" },
                { "1", "1", "1", "1", "1" },
                { "1", "1", "1", "1", "1" },
                { "1", "1", "1", "1", "1" } };

        try {
            System.out.println(sumMatrix(matrix1));
        } catch (MyArrayDataException | MyArraySizeException ex) {
            ex.printStackTrace();
        }
        try {

            System.out.println(sumMatrix(matrix2));

        } catch (MyArrayDataException | MyArraySizeException ex) {
            ex.printStackTrace();
        }
        try {

            System.out.println(sumMatrix(matrix3));
        } catch (MyArrayDataException | MyArraySizeException ex) {
            ex.printStackTrace();
        }
        try {

            System.out.println(sumMatrix(matrix4));
        } catch (MyArrayDataException | MyArraySizeException ex) {
            ex.printStackTrace();
        }
    }

    public static int sumMatrix(String[][] matrix) {
        int sum = 0;
        if (matrix.length != 4) {
            throw new MyArraySizeException(
                    "Неверный размер массива - " + matrix.length + ". Требуется массив размером 4");
        }
        for (int rowN = 0; rowN < matrix.length; rowN++) {
            if (matrix[rowN].length != 4) {
                throw new MyArraySizeException(
                        "Неверный размер " + rowN + " строки - " + matrix[rowN].length
                                + ". Требуется строка размером 4");
            }
            for (int colN = 0; colN < matrix[rowN].length; colN++) {

                try {
                    sum += Integer.parseInt(matrix[rowN][colN]);

                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(rowN, colN);
                }
            }

        }
        return sum;
    }

}
