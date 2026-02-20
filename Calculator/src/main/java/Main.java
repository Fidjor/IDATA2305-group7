import Client.Client;

public class Main {
  public static void main(String[] args) throws InterruptedException {

    long startTime = System.nanoTime();
    Thread[] threads = new Thread[10];

    for (int i = 0; i < 10; i++) {
      threads[i] = new Thread(() -> {
        Client c = new Client(8080);
        c.sendMessage(2, 2, '+');
      });
      threads[i].start();
    }

    for (Thread thread : threads) {
      thread.join();
    }

    long duration = (System.nanoTime() - startTime)/1000000;
    System.out.println(duration + "ms");

  }
}
