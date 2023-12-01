import static org.junit.jupiter.api.Assertions.*;
public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return balance == 0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int num) {
        boolean isNegative = num < 0;
        num = Math.abs(num);

        int reversed = 0;
        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        String result = Integer.toString(reversed);
        return isNegative ? "-" + result : result;
    }

    // 3. encryptThis
    public static String encryptThis(String message) {
        if (message == null || message.isEmpty()) {
            return "";
        }
        String[] words = message.split(" ");
        StringBuilder encrypted = new StringBuilder();
        for (String word : words) {
            int len = word.length();
            int firstChar = word.charAt(0);
            encrypted.append(firstChar);
            if (len > 1) {
                char secondChar = word.charAt(1);
                char lastChar = word.charAt(len - 1);
                encrypted.append(lastChar).append(word, 2, len - 1).append(secondChar);
            } else {
                encrypted.append(word.charAt(0));
            }
            encrypted.append(" ");
        }
        return encrypted.toString().trim();
    }

    // 4. decipherThis
    public static String decipherThis(String message) {
        if (message == null || message.isEmpty()) {
            return "";
        }
        String[] words = message.split(" ");
        StringBuilder decrypted = new StringBuilder();

        for (String word : words) {
            int len = word.length();
            int digitIndex = -1;
            for (int i = 0; i < len; i++) {
                if (Character.isDigit(word.charAt(i))) {
                    digitIndex = i;
                    break;
                }
            }
            if (digitIndex != -1) {
                int charCode = Integer.parseInt(word.substring(0, digitIndex));
                decrypted.append((char) charCode);

                if (len > digitIndex + 1) {
                    char secondChar = word.charAt(digitIndex + 1);
                    char lastChar = word.charAt(len - 1);
                    decrypted.append(lastChar).append(word, digitIndex + 2, len - digitIndex - 3).append(secondChar);
                } else {
                    decrypted.append(word.charAt(digitIndex + 1));
                }
            } else {
                decrypted.append(word);
            }
            decrypted.append(" ");
        }
        return decrypted.toString().trim();
    }
}


