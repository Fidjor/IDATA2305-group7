import Client.Client;

public class Main {
  public static void main(String[] args) {

    long startTime = System.nanoTime();

    for (int i = 0; i < 100; i++) {
      Client client = new Client(8080);
      client.sendMessage(2,2,'+');
    }

    long duration = (System.nanoTime() - startTime)/1000000;
    System.out.println(duration + "ms");

  }
}
