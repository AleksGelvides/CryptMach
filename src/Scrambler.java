import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scrambler {
    private static String encryptText;
    private static int[] key;

    private static void encryptor() {
        /*
        Написать скрипт, который успешно сменит местоположение символов на отзеркаленный. Тогда всё будет работать
        дописать шифровку даты. Но это мелочи. Самая сложная работа уже проделана.
         */
        String alphabetRu = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя"; // 66
        String alphabetEn = "BCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; //52
        String numbers = "1234567890";
        Pattern pRu = Pattern.compile("[А-аЯ-я]");
        Pattern pEn = Pattern.compile("[A-aZ-z]");
        Pattern pNum = Pattern.compile("[1234567890]");
        Pattern pSymbols = Pattern.compile("[^А-аЯ-яA-aZ-z0-9]");
        Matcher mRu;
        Matcher mEn;
        Matcher mNum;
        Matcher mSymbols;

        for (int i = 0; i < encryptText.length(); i++) {
            mRu = pRu.matcher(String.valueOf(encryptText.charAt(i)));
            mEn = pEn.matcher(String.valueOf(encryptText.charAt(i)));
            mNum = pNum.matcher(String.valueOf(encryptText.charAt(i)));
            mSymbols = pSymbols.matcher(String.valueOf(encryptText.charAt(i)));
            if(mSymbols.find())
                continue;
            if (mRu.find()) {
                int shift = alphabetRu.indexOf(encryptText.charAt(i)) + key[i];
                if(shift < 0)
                    shift = Math.abs(shift);
                if (shift >= alphabetRu.length())
                    shift = shift % alphabetRu.length();
                encryptText = encryptText.replaceFirst(String.valueOf(encryptText.charAt(i)),String.valueOf(alphabetRu.charAt(shift)));
            } else if (mEn.find()) {
                int shift = alphabetEn.indexOf(encryptText.charAt(i)) + key[i];
                if(shift < 0)
                    shift = Math.abs(shift);
                if (shift >= alphabetEn.length())
                    shift = shift % alphabetEn.length();
                encryptText = encryptText.replace(encryptText.charAt(i),alphabetEn.charAt(shift));
            } else if (mNum.find()) {
                int shift = numbers.indexOf(encryptText.charAt(i)) + key[i];
                if (shift < 0)
                    shift = Math.abs(shift);
                if (shift >= numbers.length())
                    shift = shift % numbers.length();
                encryptText = encryptText.replace(encryptText.charAt(i), numbers.charAt(shift));
            }
        }
    }

    private void keygen(int keyLenght) {
        key = new int[keyLenght];
        for (int i = 0; i < keyLenght; i++) {
            key[i] = (int) (0 + Math.random() * 100);
        }
    }

    public void encryptText(String text) {
        keygen(text.length());
        encryptText = text;
        encryptor();
    }

    public String getKey() {
        return Arrays.toString(key);
    }

    public String getCipherText() {
        return encryptText;
    }

}
