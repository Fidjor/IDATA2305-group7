package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSingleThread {

  static boolean running = false;

  public static void main(String[] args) {
    int port = 8080;

    try(ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("Server listening on port " + port);

      running = true;
      while (running) {
        try (Socket clientSocket = serverSocket.accept()) {

          System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

          ClientHandler clientHandler = new ClientHandler(clientSocket);
          clientHandler.run();

        }
      }

        System.out.println("Server done (single connection).");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
