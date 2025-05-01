import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер задачи (1-8):");
        String taskNumLine = scanner.nextLine();
        int taskNum;
        try {
            taskNum = Integer.parseInt(taskNumLine);
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод, программа завершена.");
            scanner.close();
            return;
        }

        switch (taskNum) {
            case 1: {
                String defaultStr = "abrkaabcdefghijjxxx";
                System.out.println("Задача 1. Введите строку (по умолчанию: \"" + defaultStr + "\"):");
                String inputStr = scanner.nextLine();
                if (inputStr.isEmpty()) {
                    inputStr = defaultStr;
                    System.out.println("Используются стандартные параметры: \"" + defaultStr + "\"");
                }
                String result = task1(inputStr);
                System.out.println("Результат: " + result);
                break;
            }
            case 2: {
                String defaultArr1Str = "1 3 5 7";
                String defaultArr2Str = "2 4 6 8";
                System.out.println("Задача 2. Введите элементы первого отсортированного массива через пробел (по умолчанию: " + defaultArr1Str + "):");
                String inputArr1Str = scanner.nextLine();
                if (inputArr1Str.isEmpty()) {
                    inputArr1Str = defaultArr1Str;
                    System.out.println("Используются стандартные параметры: " + defaultArr1Str);
                }
                System.out.println("Введите элементы второго отсортированного массива через пробел (по умолчанию: " + defaultArr2Str + "):");
                String inputArr2Str = scanner.nextLine();
                if (inputArr2Str.isEmpty()) {
                    inputArr2Str = defaultArr2Str;
                    System.out.println("Используются стандартные параметры: " + defaultArr2Str);
                }
                int[] arr1 = parseIntArray(inputArr1Str);
                int[] arr2 = parseIntArray(inputArr2Str);
                int[] merged = task2(arr1, arr2);
                System.out.print("Результат: ");
                for (int num : merged) {
                    System.out.print(num + " ");
                }
                System.out.println();
                break;
            }
            case 3: {
                String defaultArrStr = "-2 1 -3 4 -1 2 1 -5 4";
                System.out.println("Задача 3. Введите элементы массива через пробел (по умолчанию: " + defaultArrStr + "):");
                String inputArrStr = scanner.nextLine();
                if (inputArrStr.isEmpty()) {
                    inputArrStr = defaultArrStr;
                    System.out.println("Используются стандартные параметры: " + defaultArrStr);
                }
                int[] arr = parseIntArray(inputArrStr);
                int maxSum = task3(arr);
                System.out.println("Результат: " + maxSum);
                break;
            }
            case 4: {
                String defaultMatrixStr = "1,2,3;4,5,6;7,8,9";
                System.out.println("Задача 4. Введите матрицу в формате row1;row2;row3, где элементы строки разделены запятыми (по умолчанию: " + defaultMatrixStr + "):");
                String inputMatrixStr = scanner.nextLine();
                if (inputMatrixStr.isEmpty()) {
                    inputMatrixStr = defaultMatrixStr;
                    System.out.println("Используются стандартные параметры: " + defaultMatrixStr);
                }
                int[][] matrix = parse2DIntArray(inputMatrixStr);
                int[][] rotated = task4(matrix);
                System.out.println("Результат (матрица, повернутая по часовой стрелке):");
                printMatrix(rotated);
                break;
            }
            case 5: {
                String defaultPairArrStr = "10 15 3 7";
                String defaultTargetStr = "17";
                System.out.println("Задача 5. Введите элементы массива через пробел (по умолчанию: " + defaultPairArrStr + "):");
                String inputPairArrStr = scanner.nextLine();
                if (inputPairArrStr.isEmpty()) {
                    inputPairArrStr = defaultPairArrStr;
                    System.out.println("Используются стандартные параметры: " + defaultPairArrStr);
                }
                System.out.println("Введите целевое число (target) (по умолчанию: " + defaultTargetStr + "):");
                String inputTargetStr = scanner.nextLine();
                int target;
                if (inputTargetStr.isEmpty()) {
                    target = Integer.parseInt(defaultTargetStr);
                    System.out.println("Используются стандартные параметры: " + defaultTargetStr);
                } else {
                    target = Integer.parseInt(inputTargetStr);
                }
                int[] arr = parseIntArray(inputPairArrStr);
                int[] pair = task5(arr, target);
                if (pair != null) {
                    System.out.println("Результат: Найдена пара: " + pair[0] + " и " + pair[1]);
                } else {
                    System.out.println("Результат: Пара с суммой " + target + " не найдена.");
                }
                break;
            }
            case 6: {
                String defaultMatrixStr = "1,2,3;4,5,6;7,8,9";
                System.out.println("Задача 6. Введите матрицу в формате row1;row2;row3 (по умолчанию: " + defaultMatrixStr + "):");
                String inputMatrixStr = scanner.nextLine();
                if (inputMatrixStr.isEmpty()) {
                    inputMatrixStr = defaultMatrixStr;
                    System.out.println("Используются стандартные параметры: " + defaultMatrixStr);
                }
                int[][] matrix = parse2DIntArray(inputMatrixStr);
                int totalSum = task6(matrix);
                System.out.println("Результат: Сумма элементов матрицы = " + totalSum);
                break;
            }
            case 7: {
                String defaultMatrixStr = "1,2,3;4,5,6;7,8,9";
                System.out.println("Задача 7. Введите матрицу в формате row1;row2;row3... (по умолчанию: " + defaultMatrixStr + "):");
                String inputMatrixStr = scanner.nextLine();
                if (inputMatrixStr.isEmpty()) {
                    inputMatrixStr = defaultMatrixStr;
                    System.out.println("Используются стандартные параметры: " + defaultMatrixStr);
                }
                int[][] matrix = parse2DIntArray(inputMatrixStr);
                int[] maxEach = task7(matrix);
                System.out.print("Результат: Максимальные элементы в каждой строке: ");
                for (int num : maxEach) {
                    System.out.print(num + " ");
                }
                System.out.println();
                break;
            }
            case 8: {
                String defaultMatrixStr = "1,2,3;4,5,6;7,8,9";
                System.out.println("Задача 8. Введите матрицу в формате row1;row2;row3 (по умолчанию: " + defaultMatrixStr + "):");
                String inputMatrixStr = scanner.nextLine();
                if (inputMatrixStr.isEmpty()) {
                    inputMatrixStr = defaultMatrixStr;
                    System.out.println("Используются стандартные параметры: " + defaultMatrixStr);
                }
                int[][] matrix = parse2DIntArray(inputMatrixStr);
                int[][] rotated = task8(matrix);
                System.out.println("Результат (матрица, повернутая против часовой стрелки):");
                printMatrix(rotated);
                break;
            }
            default:
                System.out.println("Неверный номер задачи.");
                break;
        }
        scanner.close();
    }

    public static String task1(String s) {
        if (s == null || s.isEmpty())
            return "";
        int[] lastIndex = new int[256];
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }
        int start = 0, maxStart = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (lastIndex[ch] >= start) {
                start = lastIndex[ch] + 1;
            }
            lastIndex[ch] = i;
            if (i - start + 1 > maxLength) {
                maxLength = i - start + 1;
                maxStart = start;
            }
        }
        return s.substring(maxStart, maxStart + maxLength);
    }

    public static int[] task2(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] merged = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }
        return merged;
    }

    public static int task3(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Массив не должен быть пустым");
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = (arr[i] > (maxEndingHere + arr[i])) ? arr[i] : (maxEndingHere + arr[i]);
            maxSoFar = (maxSoFar > maxEndingHere) ? maxSoFar : maxEndingHere;
        }
        return maxSoFar;
    }

    public static int[][] task4(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0][0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] rotated = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static int[] task5(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[] { arr[i], arr[j] };
                }
            }
        }
        return null;
    }

    public static int task6(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int[] task7(int[][] matrix) {
        int[] maxElements = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int max = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            maxElements[i] = max;
        }
        return maxElements;
    }

    public static int[][] task8(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0][0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] rotated = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[n - 1 - j][i] = matrix[i][j];
            }
        }
        return rotated;
    }

    // Вспомогательный метод для вывода двумерной матрицы.
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Вспомогательный метод для парсинга одномерного массива из строки.
    // Ожидается, что элементы разделены пробелами или запятыми.
    public static int[] parseIntArray(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new int[0];
        }
        String[] tokens = input.trim().split("[,\\s]+");
        int[] result = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i]);
        }
        return result;
    }

    // Вспомогательный метод для парсинга двумерного массива из строки.
    // Формат ввода: "row1;row2;row3", где row — это числа, разделенные запятыми.
    public static int[][] parse2DIntArray(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new int[0][0];
        }
        String[] rows = input.trim().split(";");
        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            matrix[i] = parseIntArray(rows[i]);
        }
        return matrix;
    }
}
