package buffer;

class BoundedBuffer<T> {
    private final T[] buffer;
    private int count = 0;
    private int in = 0;
    private int out = 0;

    @SuppressWarnings("unchecked")
    public BoundedBuffer(int size) {
        buffer = (T[]) new Object[size];
    }

    public synchronized void put(T item) throws InterruptedException {
        // TODO: Реализуйте метод

        if (count == buffer.length) {
            wait();
        }
        else {
            buffer[in] = item;
            count++;
            in++; out++;
            notifyAll();
        }
    }

    public synchronized T take() throws InterruptedException {
        // TODO: Реализуйте метод
        T object;

        while (count == 0) {
            wait();
        }

        object = buffer[out];
        count--;
        out--; in--;
        notifyAll();

        return object;
    }

    public int size() {
        return buffer.length;
    }
}
