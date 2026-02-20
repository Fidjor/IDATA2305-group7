import Client.Client;

public class Main {
  public static void main(String[] args) throws InterruptedException {

    int timesToRun = 10;
    long averageDuration = 0;

    for (int i = 0; i < timesToRun; i++) {
      long startTime = System.nanoTime();
      Thread[] threads = new Thread[10];

      for (int j = 0; j < 10; j++) {
        threads[j] = new Thread(() -> {
          Client client = new Client(8080);
          client.sendMessage(2, 2, '+');
        });
        threads[j].start();
      }

      for (Thread thread : threads) {
        thread.join();
      }
      long duration = (System.nanoTime() - startTime)/1000000;
      averageDuration += duration;
    }

    System.out.println(averageDuration/timesToRun + "ms");

  }
}
