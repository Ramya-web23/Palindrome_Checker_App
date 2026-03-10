import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        String reversed = "";
        for (int i = normalized.length() - 1; i >= 0; i--) {
            reversed = reversed + normalized.charAt(i);
        }

        if (normalized.equals(reversed)) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is not a Palindrome.");
        }

        scanner.close();
    }
}