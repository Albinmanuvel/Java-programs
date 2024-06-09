import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        boolean isPalindrome = isPalindrome(input);
        System.out.println(input + " is " + (isPalindrome ? "a palindrome" : "not a palindrome"));
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        str = str.replaceAll("\\s", "").toLowerCase();

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}