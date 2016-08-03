package caesarcrack;

import caesarcrack.cipher.Caesar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author fulopm
 */
public class Cracker {

    private static final URI DEF_WORD_LIST = URI.create("https://raw.githubusercontent.com/danielmiessler/SecLists/master/Passwords/english.txt");
    private File wordList;
    Scanner sc;

    public Cracker(String wordlistFile) throws MalformedURLException, IOException {
        if (wordlistFile.contains("default")) {
            wordList = null;
            sc = new Scanner(DEF_WORD_LIST.toURL().openStream());
        } else if (new File(wordlistFile).exists()) {
            wordList = new File(wordlistFile);
            sc = new Scanner(new File(wordlistFile));
        } else {
            Logger.getLogger(Cracker.class.getName()).severe("Wordlist file is not specified, bruteforcing the string is infeasible");
            System.exit(-1);
        }

    }

    public int crack(String string) throws FileNotFoundException, IOException {
        for (int k = 0; k < 26; k++) {
            String s = Caesar.decrypt(string, k);

            if (search(s)) {
                return k;
            }
        }
        return -1;
    }

    public boolean search(String s) throws FileNotFoundException, MalformedURLException, IOException {

        while (sc.hasNextLine()) {
            String st = sc.nextLine();
            if (st.contains(s)) {
                

                return true;
            }

        }
        sc.close();
        if (wordList == null) {
            sc = new Scanner(DEF_WORD_LIST.toURL().openStream());
        } else {
            sc = new Scanner(wordList);
        }
        return false;
    }

}
