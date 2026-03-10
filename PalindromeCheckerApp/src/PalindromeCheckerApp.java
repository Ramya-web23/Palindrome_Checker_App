import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        long start, end;

        // Stack-based palindrome
        start = System.nanoTime();
        boolean stackResult = isPalindromeStack(input);
        end = System.nanoTime();
        long stackTime = end - start;

        // Deque-based palindrome
        start = System.nanoTime();
        boolean dequeResult = isPalindromeDeque(input);
        end = System.nanoTime();
        long dequeTime = end - start;

        System.out.println("\nResults:");
        System.out.println("Stack approach: " + (stackResult ? "Palindrome" : "Not Palindrome") + ", Time: " + stackTime + " ns");
        System.out.println("Deque approach: " + (dequeResult ? "Palindrome" : "Not Palindrome") + ", Time: " + dequeTime + " ns");

        scanner.close();
    }

    private static boolean isPalindromeStack(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) return false;
        }
        return true;
    }

    private static boolean isPalindromeDeque(String input) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}