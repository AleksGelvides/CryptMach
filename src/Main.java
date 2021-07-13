public class Main {
    public static void main(String[] args) {
        Scrambler s = new Scrambler();
        s.encryptText("Шапка и куртка");
        System.out.println("Шифр: " + s.getKey());
        System.out.println("Ваше сообщение " + s.getCipherText());
    }
}
