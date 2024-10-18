package intro.racer;

public class RacerDemo {
    public static void main(String[] args) {
        // TODO: Создайте и запустите несколько "гонщиков"
        // TODO: Дождитесь завершения всех "гонщиков"

        for (int i = 1; i <= 5; i++) {
            Thread racer = new Thread(new Racer("Гонщик " + i));
            racer.start();
        }
    }
}
