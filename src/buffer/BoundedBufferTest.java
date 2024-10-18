package buffer;

import java.util.concurrent.CountDownLatch;

public class BoundedBufferTest {
    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(10);
        int operations = 10;

        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch finish = new CountDownLatch(2 * operations);

        for (int i = 0; i < operations; i++) {
            new Thread(new IntegerPutter(buffer, start, finish)).start();
            new Thread(new IntegerTaker(buffer, start, finish)).start();
        }

        start.countDown();
        finish.await();
    }
}
