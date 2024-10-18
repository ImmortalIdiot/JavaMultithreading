package buffer;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class IntegerPutter implements Runnable {

    private final BoundedBuffer<Integer> buffer;

    private final CountDownLatch start;
    private final CountDownLatch finish;

    private final Random random = new Random();

    public IntegerPutter(BoundedBuffer<Integer> buffer, CountDownLatch start, CountDownLatch finish) {
        this.buffer = buffer;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public void run() {
        try {
            start.await();
            buffer.put(random.nextInt(0, 100));
            finish.countDown();
        } catch (InterruptedException interruptedException) {
            /* do nothing */
        }
    }
}
