package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        char[] chars = password.toCharArray();
        if (availabilityUpper(chars)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (availabilityLower(chars)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (availabilityDigit(chars)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (availabilitySpecialChar(chars)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (containSubstring(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }

    public static boolean availabilityUpper(char[] chars) {
        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean availabilityLower(char[] chars) {
        for (char ch : chars) {
            if (Character.isLowerCase(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean availabilityDigit(char[] chars) {
        for (char ch : chars) {
            if (Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean availabilitySpecialChar(char[] chars) {
        for (char ch : chars) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containSubstring(String password) {
        String[] words = {"qwerty", "12345", "password", "admin", "user"};
        for (String word : words) {
            if (password.toLowerCase().contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
