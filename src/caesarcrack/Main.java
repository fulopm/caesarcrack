package caesarcrack;

import caesarcrack.cipher.Caesar;
import java.io.IOException;

/**
 *
 * @author fulopm
 */
public class Main {

    private static Cracker cracker;

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java -jar CaesarCrack.jar \"string to crack\" wordlistfile.txt or default");
        }

        cracker = new Cracker(args[1]);
        int keyFound;
        System.out.println((keyFound = cracker.crack(args[0])) > -1 ? "Key found: " + keyFound : "Bruteforcing the string was not succesful");

        System.out.println("Plaintext deciphered with shiftkey \"" + keyFound + "\": " + Caesar.decrypt(args[0], keyFound));
    }

}
