package buffer;

import java.util.Arrays;

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

            System.out.println("Добавлен элемент: " + buffer[in - 1]);
            System.out.println("Содержимое буфера: " + Arrays.toString(buffer));
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

        System.out.println("Взят элемент: " + buffer[out]);
        buffer[out] = null;
        System.out.println("Содержимое буфера: " + Arrays.toString(buffer));

        return object;
    }

    public int size() {
        return buffer.length;
    }
}
