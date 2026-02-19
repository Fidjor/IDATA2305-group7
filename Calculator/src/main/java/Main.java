import Client.Client;

public class Main {
  public static void main(String[] args) {

    Client client1 = new Client(8080);
    Client client2 = new Client(8080);
    Client client3 = new Client(8080);
    Client client4 = new Client(8080);

    String r1 = client1.sendMessage(2,2,'+');
    String r2 = client2.sendMessage(194,3,'*');
    String r3 = client3.sendMessage(67,42,'-');
    String r4 = client4.sendMessage(2,0.0002,'/');

    System.out.println("Response 1: " + r1);
    System.out.println("Response 2: " + r2);
    System.out.println("Response 3: " + r3);
    System.out.println("Response 4: " + r4);

  }
}
