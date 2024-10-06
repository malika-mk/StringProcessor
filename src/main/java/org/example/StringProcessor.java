package org.example;
import java.util.Stack;
public class StringProcessor {

    // Method to check if the password is strong
    public boolean isStrongPassword(String password) {

        // Flags to track whether the password contains required elements
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        // Defining a set of special characters
        String specialCharacters = "!@#$%^&*()_-+=<>?/{}~|";

        // Traversing each character of the password string
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            // Checking for an uppercase letter
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }
            // Checking for a lowercase letter
            else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            }
            // Checking for a digit
            else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            // Checking for a special character
            else if (specialCharacters.contains(String.valueOf(ch))) {
                hasSpecialChar = true;
            }

            // If all conditions are met, returning true early
            if (hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        // Returning false if one or more conditions are not met
        return false;
    }



        // Method to count the number of digits in the sentence
        public int calculateDigits(String sentence) {
            int digitCount = 0;

            // Traverse each character in the sentence
            for (int i = 0; i < sentence.length(); i++) {
                char ch = sentence.charAt(i);

                // Check if the character is a digit
                if (Character.isDigit(ch)) {
                    digitCount++;
                }
            }

            // Return the total count of digits found
            return digitCount;
        }

        // Method to count the number of words in the sentence
        public int calculateWords(String sentence) {
            if (sentence == null || sentence.trim().isEmpty()) {
                return 0; // Handle null or empty strings
            }

            // Split the sentence by spaces (one or more) and store in an array
            String[] words = sentence.trim().split("\\s+");

            // Return the number of words
            return words.length;
        }



        // Method to calculate the result of a given expression
        public double calculateExpression(String expression) {
            // Stack to store numbers (operands)
            Stack<Double> operands = new Stack<>();
            // Stack to store operators and parentheses
            Stack<Character> operators = new Stack<>();

            // Traverse through the expression character by character
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                // Skip spaces
                if (ch == ' ') {
                    continue;
                }

                // If the character is a digit or part of a number (multiple digits or decimal), process it
                if (Character.isDigit(ch) || ch == '.') {
                    StringBuilder sb = new StringBuilder();
                    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                        sb.append(expression.charAt(i));
                        i++;
                    }
                    i--; // Adjust index to compensate for the last increment in the while loop
                    operands.push(Double.parseDouble(sb.toString()));
                }

                // If the character is '(', push it to the operators stack
                else if (ch == '(') {
                    operators.push(ch);
                }

                // If the character is ')', solve the entire bracket
                else if (ch == ')') {
                    while (operators.peek() != '(') {
                        operands.push(applyOperation(operators.pop(), operands.pop(), operands.pop()));
                    }
                    operators.pop(); // Remove '(' from stack
                }

                // If the character is an operator (+, -, *, /)
                else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    // While the operator at the top of the operators stack has the same or greater precedence,
                    // apply it to the top two operands
                    while (!operators.isEmpty() && precedence(ch) <= precedence(operators.peek())) {
                        operands.push(applyOperation(operators.pop(), operands.pop(), operands.pop()));
                    }
                    // Push the current operator to the stack
                    operators.push(ch);
                }
            }

            // After the expression is fully traversed, apply the remaining operators
            while (!operators.isEmpty()) {
                operands.push(applyOperation(operators.pop(), operands.pop(), operands.pop()));
            }

            // The result is the remaining operand in the stack
            return operands.pop();
        }

        // Helper method to apply an operation and return the result
        private double applyOperation(char operator, double b, double a) {
            switch (operator) {
                case '+': return a + b;
                case '-': return a - b;
                case '*': return a * b;
                case '/':
                    if (b == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    return a / b;
            }
            return 0;
        }

        // Helper method to return precedence of operators
        private int precedence(char operator) {
            switch (operator) {
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
            }
            return -1;
        }



}

