import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;

        while (true) {
            System.out.print("Enter an integer greater than 1: ");
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num > 1) break;
                else System.out.println("Number must be greater than 1.");
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.println(num + (isPrime ? " is prime" : " is not prime"));
        scanner.close();
    }
}