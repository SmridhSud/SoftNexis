import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print("Enter a non-negative integer: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number >= 0) break;
                else System.out.println("Please enter a non-negative integer.");
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        int count = 0;
        int tempNumber = number;

        if (tempNumber == 0) {
            count = 1;
        } else {
            while (tempNumber != 0) {
                tempNumber /= 10;
                count++;
            }
        }

        System.out.println("Total digits in " + number + ": " + count);
        scanner.close();
    }
}