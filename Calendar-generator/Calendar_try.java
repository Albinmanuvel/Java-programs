import java.util.Scanner;

public class Calendar_try {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year, month;

        while (true) {
            System.out.print("Enter the year (or 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            year = Integer.parseInt(input);

            System.out.print("Enter the month (1-12): ");
            month = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            printCalendar(year, month);
        }
    }

    public static void printCalendar(int year, int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year) && month == 2) {
            days[1] = 29;
        }

        System.out.println("\n" + months[month - 1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int firstDayOfWeek = getFirstDayOfWeek(year, month);
        printSpaces(firstDayOfWeek);

        int currentDay = 1;
        while (currentDay <= days[month - 1]) {
            System.out.printf("%3d ", currentDay);
            if ((currentDay + firstDayOfWeek) % 7 == 0) {
                System.out.println();
            }
            currentDay++;
        }
        System.out.println();
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static int getFirstDayOfWeek(int year, int month) {
        int[] monthCodes = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        year -= (month < 3) ? 1 : 0;
        return (year + year / 4 - year / 100 + year / 400 + monthCodes[month - 1] + 1) % 7;
    }

    private static void printSpaces(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("    ");
        }
    }
}