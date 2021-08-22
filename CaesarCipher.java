
import javax.swing.JOptionPane;

public class CaesarCipher {

    static public int key;

    // The class constructor. It receives the secret key as parameter
    public CaesarCipher(String s) {
        key = Integer.parseInt(s.trim());  // convert the key from string to integer
    }

    public String encrypt(String plaintext) {
        String ciphertext = "";

        String letters[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",};

 
        char[] input = plaintext.toCharArray();

        for (int i = 0; i < plaintext.length(); i++) {

            int ch = (int) input[i];
            if ((input[i] + "").equalsIgnoreCase(" ")) {
                ciphertext += " ";
            }
            for (int j = 0; j < letters.length; j++) {

                if ((input[i] + "").equalsIgnoreCase(letters[j])) {
                    ch = (ch - 'a' + 12) % 26 + 'a';
                    ciphertext += (char) ch;
                    {
                    }

                    // return the ciphertext
                }
            }
        }
        return ciphertext;
    }
    //------------------------------------------------------

    public String decrypt(String ciphertext) {

        String letters[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",};

        char ciphered[] = ciphertext.toCharArray();
        String decryptPlain = "";
        for (int i = 0; i < ciphered.length; i++) {
            int ch = (int) ciphered[i]; //convert the encrypt character into ASCII number
            if ((ciphered[i] + "").equalsIgnoreCase(" ")) {
                decryptPlain += " ";
            }
            for (int j = 0; j < letters.length; j++) {
                if ((ciphered[i] + "").equalsIgnoreCase(letters[j])) {
                    ch = (ch - 'a' - key + 26) % 26 + 'a'; //return the ASCII number of the character
                    decryptPlain += (char) ch; // convert ASCII number to character
                }
            }

        }

        return decryptPlain;

    }

    //---------------------------------------------------------
    /* Simple main method for testing the Caesar cipher */
    public static void main(String[] args) {
        String plaintext = JOptionPane.showInputDialog("Input your message: "); // to input the plaintext
        String sk = JOptionPane.showInputDialog("Input the key (a number [0-25]): "); // to input the key
        CaesarCipher cipher = new CaesarCipher(sk); // Create a Caesar cipher object
        String ciphertext = cipher.encrypt(plaintext); // get the encrypted text (ciphertext)
        System.out.println(ciphertext);
        plaintext = cipher.decrypt(ciphertext); // get the decrypted text (should be plaintext again)
        System.out.println(plaintext);
        JOptionPane.showMessageDialog(null,
                "encrypted text: " + ciphertext + "\n"
                + "decrypted text: " + plaintext);
    }
}
