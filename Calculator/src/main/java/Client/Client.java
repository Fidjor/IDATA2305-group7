package Client;

import java.io.*;
import java.net.Socket;

public class Client {

  private int port;
  private BufferedReader in;
  private PrintWriter out;
  private Socket socket;

  public Client(int port) {

    String host = "localhost";
    this.port = port;

    try {

      socket = new Socket(host, port);

      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String sendMessage(double number1, double number2, char operator) {
    out.println(number1+","+number2+","+operator);

    try {
      String response = in.readLine();
      return response;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    } finally {
      try {
        if (socket != null && !socket.isClosed()) socket.close();
      } catch (IOException ignored) {}
    }
  }
}
