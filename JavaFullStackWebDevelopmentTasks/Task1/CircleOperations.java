import java.util.Scanner;

public class CircleOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radius;

        while (true) {
            System.out.print("Enter radius of the circle (positive number): ");
            if (scanner.hasNextDouble()) {
                radius = scanner.nextDouble();
                if (radius > 0) break;
                else System.out.println("Radius must be positive.");
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        System.out.println("Circle with radius: " + radius);
        System.out.printf("Circumference: %.2f\n", calculateCircumference(radius));
        System.out.printf("Area: %.2f\n", calculateArea(radius));
        scanner.close();
    }

    static double calculateCircumference(double r) {
        return 2 * Math.PI * r;
    }

    static double calculateArea(double r) {
        return Math.PI * r * r;
    }
}