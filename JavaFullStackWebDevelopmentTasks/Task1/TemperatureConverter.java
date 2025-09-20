import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double fahrenheit;

        while (true) {
            System.out.print("Enter temperature in Fahrenheit: ");
            if (scanner.hasNextDouble()) {
                fahrenheit = scanner.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.printf("%.2f°F = %.2f°C\n", fahrenheit, celsius);
        scanner.close();
    }
}