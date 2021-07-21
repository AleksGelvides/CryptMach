import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scrambler {
    private static String encryptText;
    private static int[] key;
    private static final String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюяABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890 ><?,.;:\'\"|\\!@#$%^&*()_-+=№%";

    private static void encryptor(int[] key, String message) {
        int shift = 0;
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < message.length(); i++) {
            shift = key[i] + alphabet.indexOf(message.charAt(i));
            if (shift >= alphabet.length())
                shift = shift % alphabet.length();
            if (alphabet.indexOf(message.charAt(i)) + key[i] < 0) {
                shift = shift % alphabet.length();
                stringBuilder.append(alphabet.charAt(alphabet.length() +shift));
            } else
            stringBuilder.append(alphabet.charAt(shift));
        }
        encryptText = stringBuilder.toString();
    }

    private void keygen(int keyLenght) {
        key = new int[keyLenght];
        for (int i = 0; i < keyLenght; i++) {
            key[i] = (int) (0 + Math.random() * 100);
        }
    }

    public void encryptText(String message) {
        keygen(message.length());
        encryptor(key, message);
    }

    public void desckryptText(String message, String keyString) {
        String[] toInt = keyString.replaceAll("(\\[|]| )", "").split(",");
        int[] key = new int[toInt.length];
        for (int i = 0; i < toInt.length; i++) {
            key[i] = Integer.parseInt(toInt[i]);
            key[i] *= -1;
        }
        encryptor(key, message);
    }

    public String getKey() {
        return Arrays.toString(key);
    }

    public String getCipherText() {
        return encryptText;
    }

}
