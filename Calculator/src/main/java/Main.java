public class Main {
  public static void main(String[] args) {

    Client client1 = new Client(8080);
    Client client2 = new Client(8080);
    Client client3 = new Client(8080);
    Client client4 = new Client(8080);

    client1.sendMessage(2,2,'+');
    client2.sendMessage(194,3,'*');
    client3.sendMessage(67,42,'-');
    client4.sendMessage(2,0.0002,'/');

  }
}
