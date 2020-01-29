class Consumer implements Runnable {
    public void run() {
        while (true) {
            try {
                synchronized (FruitMarket.inventory) {
                    Integer requiredQuantity = (int)(Math.random() * 3 + 1);
                    Integer fruitIndex = (int)(Math.random() * 3);
                    String fruit = FruitMarket.fruits[fruitIndex];

                    System.out.println("[" + Thread.currentThread().getName() + "]: Need " + requiredQuantity + " " + fruit);

                    Integer availableQuantity = FruitMarket.inventory.get(fruit);

                    if (availableQuantity == 0) {
                        System.out.println("[Farmer]: " + fruit + " isn't available.");

                        FruitMarket.inventory.wait();
                    } else {
                        System.out.println("[Farmer]: " + fruit + " is available.");

                        FruitMarket.inventory.put(fruit, Math.max(availableQuantity - requiredQuantity, 0));
                        FruitMarket.inventory.notifyAll();

                        System.out.println("[" + Thread.currentThread().getName() + "]: Bought " + Math.min(availableQuantity, requiredQuantity) + " " + fruit);

                        Thread.sleep(1000);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
