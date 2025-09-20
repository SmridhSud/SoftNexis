import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;

        while (true) {
            System.out.print("Enter number of elements in the array (positive integer): ");
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size > 0) break;
                else System.out.println("Please enter a positive integer.");
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        int[] numbers = new int[size];
        System.out.println("Enter " + size + " integers:");

        for (int i = 0; i < size; i++) {
            while (true) {
                System.out.print("Element " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    numbers[i] = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next();
                }
            }
        }

        int sum = 0;
        System.out.print("Array elements: ");
        for (int n : numbers) {
            System.out.print(n + " ");
            sum += n;
        }
        System.out.println("\nArray sum: " + sum);
        scanner.close();
    }
}