import java.util.Scanner;

public class Fibonacci_Generator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();
        printFibonacciSeries(n);
    }

    public static void printFibonacciSeries(int n) {
        int a = 0, b = 1, c;
        System.out.print(a + " " + b + " ");
        for (int i = 3; i <= n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}