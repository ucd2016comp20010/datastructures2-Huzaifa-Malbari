package project20280.stacksqueues;

import java.util.Scanner;

public class Exercises {

    static String convertToBinary(long n) {

        LinkedStack<Character> ans = new LinkedStack<Character>();

        while (n != 0) {
            ans.push((n%2 == 1) ? '1' : '0');
            n/=2;
        }

        StringBuilder str = new StringBuilder();
        while (!ans.isEmpty()) {
           str.append(ans.pop());
        }

        return str.toString();
    }

    static String convertToHex(long n) {

        LinkedStack<Character> ans = new LinkedStack<Character>();

        while (n != 0) {
            int rem = (int) n % 16;
            int digit =  ((rem < 10) ? rem + '0' : rem - 10 + 'A');

            ans.push((char) digit);
            n/=16;
        }

        StringBuilder str = new StringBuilder();
        while (!ans.isEmpty()) {
            str.append(ans.pop());
        }

        return str.toString();
    }

    public static boolean checkParentheses(String in) {
        // TODO

        LinkedStack<Character> openingBraces = new LinkedStack<Character>();
        Scanner scan = new Scanner(in);

        while (scan.hasNext()) {
            char c = scan.next().charAt(0);
            switch (c) {
                case '{':
                    openingBraces.push(c);
                    break;
                case '[':
                    openingBraces.push(c);
                    break;
                case '(':
                    openingBraces.push(c);
                    break;
                case '}':
                    if ((openingBraces.isEmpty()) || !openingBraces.pop().equals(c)) {
                        return false;
                    }
                case ']':
                    if ((openingBraces.isEmpty()) || !openingBraces.pop().equals(c)) {
                        return false;
                    }
                case ')':
                    if ((openingBraces.isEmpty()) || !openingBraces.pop().equals(c)) {
                        return false;
                    }
            }
        }

        if (openingBraces.size() == 0) {
            return true;
        }

        return false;
    }

    public static void main() {

        String [] inputs = {
                    "[]]()()", // not correct
                    "c[d]", // correct
                    "a{b[c]d}e", // correct
                    "a{b(c]d}e", // not correct; ] doesn't match
                    "a[b{c}d]e}", // not correct; nothing matches final }
                    "a{b(c) ", // not correct; Nothing matches opening {
                    "][]][][[]][]][][[[", //
                    "(((abc))((d)))))", //
                   };

        for(String input : inputs) {
            boolean isBalanced = Exercises.checkParentheses(input);
            System.out.println("isBalanced " + (isBalanced ? " yes! " : " no! ") + input);
        }

    }
}