import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {
    int port = 8080;

    try(ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("Server listening on port " + port);

      try (Socket clientSocket = serverSocket.accept();
           BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
           PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

             System.out.println("Client connected: "+clientSocket.getRemoteSocketAddress());

             String line = in.readLine();
             System.out.println("Received: "+line);

             out.println("OK");
             System.out.println("Sent: OK");
           }

           System.out.println("Server done (single connection).");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
