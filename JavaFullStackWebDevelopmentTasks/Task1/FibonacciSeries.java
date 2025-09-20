import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("Enter how many Fibonacci numbers to generate (positive integer): ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break;
                else System.out.println("Please enter a positive integer.");
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        int t1 = 0, t2 = 1;
        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(t1 + " ");
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
        System.out.println();
        scanner.close();
    }
}