import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scrambler s = new Scrambler();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Введите сообщение для шифровки: ");
            String message = scanner.nextLine();
            s.encryptText(message);
            System.out.println("Ваше сообщение зашифровано: " + s.getCipherText() );
            System.out.println("Ваш ключ дешифровки: " + s.getKey());
            System.out.println("Введите любой символ для дешифровки");
            String menu = scanner.nextLine();
            s.desckryptText(s.getCipherText());
            System.out.println("Расшифровка: " + s.getCipherText());
        }
    }
}
