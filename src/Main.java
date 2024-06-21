import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your time is limited,");
        System.out.println("    so don’t waste it");
        System.out.println("        living someone else’s life");
        System.out.println("            Steve Jobs");

        System.out.println("Write number");
        double num = scanner.nextDouble();
        System.out.println("Write percentage");
        double percentage = scanner.nextDouble();
        double result = (num * percentage) / 100;
        System.out.println(result);

        System.out.println("Write 3 nums");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        System.out.println(Integer.toString(num1) + num2 + num3);

        System.out.println("Write 6-digit number");
        String input = scanner.next();
        char[] chars = input.toCharArray();
        if (chars.length == 6) {
            char temp = chars[0];
            chars[0] = chars[5];
            chars[5] = temp;
            temp = chars[1];
            chars[1] = chars[4];
            chars[4] = temp;
            String res = new String(chars);
            System.out.println("Transformed string: " + res);
        } else {
            System.out.println("Invalid input");
        }
        System.out.println("Write number");
        int month = scanner.nextInt();
        Season season = getSeason(month);
        if (season != null) {
            System.out.println("The season is: " + season.toString().toLowerCase());
        } else {
            System.out.println("Error: Invalid month number.");
        }

        System.out.print("Enter meters: ");
        double meters = scanner.nextDouble();

        System.out.println("Convert to: 1. Miles 2. Inches 3. Yards");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                double miles = meters / 1609.34;
                System.out.println(meters + " meters is " + miles + " miles");
                break;
            case 2:
                double inches = meters * 39.3701;
                System.out.println(meters + " meters is " + inches + " inches");
                break;
            case 3:
                double yards = meters * 1.09361;
                System.out.println(meters + " meters is " + yards + " yards");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        System.out.print("Enter first number: ");
        int start = scanner.nextInt();
        System.out.print("Enter second number: ");
        int end = scanner.nextInt();
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        System.out.print("Enter start number: ");
        start = scanner.nextInt();
        System.out.print("Enter end number: ");
        end = scanner.nextInt();

        for (int i = start; i <= end; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
            System.out.println();
        }
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(random.nextInt(200) - 100);
        }
        int min = list.getFirst();
        int max = list.getFirst();
        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;

        for (int i : list) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
            if (i < 0) {
                negativeCount++;
            } else if (i > 0) {
                positiveCount++;
            } else {
                zeroCount++;
            }
        }
        System.out.println("Array: " + java.util.Arrays.toString(list.toArray()));
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Negative count: " + negativeCount);
        System.out.println("Positive count: " + positiveCount);
        System.out.println("Zero count: " + zeroCount);

        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(201) - 100;
        }

        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        ArrayList<Integer> positiveNumbers = new ArrayList<>();

        for (int i : array) {
            if (i % 2 == 0) {
                evenNumbers.add(i);
            } else {
                oddNumbers.add(i);
            }
            if (i < 0) {
                negativeNumbers.add(i);
            } else if (i > 0) {
                positiveNumbers.add(i);
            }
        }

        System.out.println("Array: " + java.util.Arrays.toString(array));
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
        System.out.println("Negative numbers: " + negativeNumbers);
        System.out.println("Positive numbers: " + positiveNumbers);

        drawLine(5, "horizontal", '*');
        drawLine(3, "v", '#');

        System.out.print("Sort in ascending or descending order? (asc/desc): ");
        String order = scanner.next();

        int[] arr = new int[20];
        for (int i = 0; i < array.length; i++) {
            arr[i] = random.nextInt(201) - 100;
        }

        if (order.equalsIgnoreCase("asc")) {
            Arrays.sort(arr);
            System.out.println("Sorted array: " + Arrays.toString(arr));
        } else if (order.equalsIgnoreCase("desc")) {
            var buf = Arrays.stream(arr).boxed().toArray();
            Arrays.sort(buf, Collections.reverseOrder());
            System.out.println("Sorted array: " + Arrays.toString(buf));
        } else {
            System.out.println("Invalid order");
        }
    }

    public static void drawLine(int length, String direction, char symbol) {
        if (direction.equalsIgnoreCase("horizontal") || direction.equalsIgnoreCase("h")) {
            for (int i = 0; i < length; i++) {
                System.out.print(symbol);
            }
            System.out.println();
        } else if (direction.equalsIgnoreCase("vertical") || direction.equalsIgnoreCase("v")) {
            for (int i = 0; i < length; i++) {
                System.out.println(symbol);
            }
        } else {
            System.out.println("Invalid direction");
        }
    }

    public static Season getSeason(int month) {
        return switch (month) {
            case 12, 1, 2 -> Season.WINTER;
            case 3, 4, 5 -> Season.SPRING;
            case 6, 7, 8 -> Season.SUMMER;
            case 9, 10, 11 -> Season.AUTUMN;
            default -> null;
        };
    }

    public enum Season {
        WINTER, SPRING, SUMMER, AUTUMN
    }
}