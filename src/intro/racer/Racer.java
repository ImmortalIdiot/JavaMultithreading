package intro.racer;

class Racer implements Runnable {
    private String name;

    public Racer(String name) { this.name = name; }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                /* do nothing */
            }
        });
        thread.start();
        long endTime = System.nanoTime();
        System.out.println(this.name + " завершил гонку за " + (endTime - startTime));
        // TODO: Выведите в консоль информацию о финише и времени гонки
    }
}