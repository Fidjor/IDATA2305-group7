import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
  public static void main(String[] args) {
    String host = "localhost";
    int port = 8080;

    try(Socket socket = new Socket(host, port);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

      out.println("PING");
      System.out.println("Sent: PING");

      String response = in.readLine();
      System.out.println("Received: " + response);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
