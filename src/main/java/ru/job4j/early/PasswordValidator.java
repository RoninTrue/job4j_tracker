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
        boolean upperChar = true;
        boolean lowerChar = true;
        boolean digitChar = true;
        boolean specialChar = true;

        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                upperChar = false;
            } else if (Character.isLowerCase(ch)) {
                lowerChar = false;
            } else if (Character.isDigit(ch)) {
                digitChar = false;
            } else if (!Character.isLetterOrDigit(ch)) {
                specialChar = false;
            }
            if (!upperChar && !lowerChar && !digitChar && !specialChar) {
                break;
            }
        }
        if (upperChar) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (lowerChar) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (digitChar) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (specialChar) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (containSubstring(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
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
