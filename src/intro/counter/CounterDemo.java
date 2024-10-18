package intro.counter;

public class CounterDemo {
    public static void main(String[] args) {
        final int NUM_THREADS = 5;
        final int INCREMENTS_PER_THREAD = 100000;
        Counter counter = new Counter();
        Thread[] threads = new Thread[NUM_THREADS];
        // TODO: Создайте и запустите потоки, увеличивающие счетчик
        // TODO: Дождитесь завершения всех потоков

        for (int i = 0; i < threads.length; i++) {
            Thread thread = new Thread(() -> {
                for (int i1 = 0; i1 < INCREMENTS_PER_THREAD; i1++) {
                    counter.increment();
                }
            });
            thread.start();
        }


        System.out.println("Ожидаемое значение: " + (NUM_THREADS *
                INCREMENTS_PER_THREAD));
        System.out.println("Фактическое значение: " + counter.getCount());
    }
}
