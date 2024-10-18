package buffer;

import java.util.concurrent.CountDownLatch;

public class IntegerTaker implements Runnable {

    private final BoundedBuffer<Integer> boundedBuffer;

    private final CountDownLatch start;
    private final CountDownLatch finish;

    public IntegerTaker(BoundedBuffer<Integer> boundedBuffer, CountDownLatch start, CountDownLatch finish) {
        this.boundedBuffer = boundedBuffer;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public void run() {
        try {
            start.await();
            boundedBuffer.take();
            finish.countDown();
        } catch (InterruptedException interruptedException) {
            /* do nothing */
        }
    }
}
