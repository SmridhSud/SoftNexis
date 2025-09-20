import java.util.Scanner;

public class DayFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day;

        while (true) {
            System.out.print("Enter day number (1-7): ");
            if (scanner.hasNextInt()) {
                day = scanner.nextInt();
                if (day >= 1 && day <= 7) break;
                else System.out.println("Please enter a number between 1 and 7.");
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        System.out.print("Day " + day + " is: ");
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
        }
        scanner.close();
    }
}