package caesarcrack.cipher;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author fulopm
 */
public class Caesar {

    public static String encrypt(String message, int shiftKey) {

        char[] msg = message.toCharArray();
        char[] result = new char[msg.length];
        for (int i = 0; i < msg.length; i++) {
            result[i] = (char) ((((int) msg[i] - 'a') + shiftKey + 26) % 26 + 'a');
        }
        return new String(result);
    }

    public static String decrypt(String message, int shiftKey) {
        return encrypt(message, -shiftKey);
       

    }
}
