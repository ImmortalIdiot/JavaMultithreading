package threads.sync.basket;

class AppleBasket {
    private int apples = 0;
    private final int maxApples = 20;

    public synchronized boolean pickApple(String picker) {
        if (apples < maxApples) {
            apples++;
            System.out.println(picker + "собрал яблоко. В корзине " + apples + " яблок");
            return true;
        }
        else {
            System.out.println(picker + " не может собрать яблоко. Корзина заполнена");
            return false;
        }
    }

    public int getApples() {
        return apples;
    }
}

class Picker implements Runnable {
    private final AppleBasket basket;
    private final String name;

    public int apples = 0;

    public Picker(AppleBasket basket, String name) {
        this.basket = basket;
        this.name = name;
    }

    @Override
    public void run() {
        while (basket.pickApple(name)) {
            apples++;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


