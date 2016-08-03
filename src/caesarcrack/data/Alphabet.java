package caesarcrack.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fulopm
 */
public class Alphabet {

    private static final char[] ENG_LETTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final HashMap<Character, Double> ENG_LETTER_FREQ = new HashMap<>();

    public static int letterIndex(char letter) {
        return Arrays.asList(ENG_LETTERS).indexOf(letter);
    }
    
    
}
