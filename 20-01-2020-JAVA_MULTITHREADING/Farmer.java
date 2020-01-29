class Farmer implements Runnable {
    @Override
    public void run() {
        try {
            String[] fruits = { "Apple", "Orange", "Grape", "Watermelon" };

            for (int i = 100; i <= 200; i++) {
                synchronized (FruitMarket.inventory) {
                    String item = fruits[i % 3];
                    Integer count = (int)(Math.random() * 10 + 1);

                    FruitMarket.inventory.put(item, count);

                    System.out.println("[FARMER]: Added " + count + " " + item + "s");

                    FruitMarket.inventory.notifyAll();
                }

                Thread.sleep(i * 100);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
