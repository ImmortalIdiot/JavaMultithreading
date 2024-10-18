package intro.threads;

public class MultiThread {
    public static void main(String[] args) {
        // TODO: Создайте массив для хранения потоков
        Thread[] threads = new Thread[5];
        // TODO: Используйте цикл для создания и запуска потоков
        for (int i = 0; i < 5; i++) {
            // Используем переменную для хранения номера потока
            // используя final, мы гарантируем, что переменная будет захвачена
            // внутри потока с неизменным значением
            final int threadNumber = i + 1;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    // TODO: Реализуйте логику работы потока
// Подсказка: выведите номер потока 10 раз, используйте переменную threadNumber
                    for (int i = 1; i <= 10; i++) {
                        System.out.printf("Поток %s", threadNumber + "\n");
                        //System.out.printf("Поток %s вывод номер %s\n", threadNumber, i);

                    }
                }
            });
            threads[i].start();
        }
        // TODO: Дождитесь завершения всех потоков
        try {
            for (int i = 0; i < 5; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Все потоки завершили работу");
    }

}
