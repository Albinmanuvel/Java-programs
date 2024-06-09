import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        int score = calculatePasswordStrength(password);
        System.out.println("Password strength score: " + score);
        printFeedback(score);
    }

    private static int calculatePasswordStrength(String password) {
        int score = 0;

        // Length
        if (password.length() >= 8) {
            score++;
        }

        // Uppercase letters
        if (password.matches(".*[A-Z].*")) {
            score++;
        }

        // Lowercase letters
        if (password.matches(".*[a-z].*")) {
            score++;
        }

        // Numbers
        if (password.matches(".*\\d.*")) {
            score++;
        }

        // Special characters
        if (password.matches(".*[!@#$%^&*(),.?\\\":{}|<>].*")) {
            score++;
        }

        return score;
    }

    private static void printFeedback(int score) {
        switch (score) {
            case 0:
                System.out.println("Password strength: Very weak");
                break;
            case 1:
                System.out.println("Password strength: Weak");
                System.out.println("Suggestion: Include a mix of uppercase, lowercase, numbers, and special characters.");
                break;
            case 2:
                System.out.println("Password strength: Fair");
                System.out.println("Suggestion: Include more character types for better strength.");
                break;
            case 3:
                System.out.println("Password strength: Good");
                System.out.println("Suggestion: Consider adding more characters for better strength.");
                break;
            case 4:
            case 5:
                System.out.println("Password strength: Strong");
                break;
        }
    }
}