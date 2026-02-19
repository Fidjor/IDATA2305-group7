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
        try (Socket clientSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

          System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

          String line = in.readLine();
          System.out.println("Recieved: " + line);
          String[] lineSplit = line.split(",");
          double number1 = Double.parseDouble(lineSplit[0]);
          double number2 = Double.parseDouble(lineSplit[1]);
          char operator =  lineSplit[2].charAt(0);
          out.println(calculate(number1,number2,operator));
        }
      }

        System.out.println("Server done (single connection).");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static double calculate(double number1, double number2, char operator) {
    return switch (operator) {
      case '+' -> number1 + number2;
      case '-' -> number1 - number2;
      case '*' -> number1 * number2;
      case '/' -> number1 / number2;
      default -> throw new IllegalArgumentException("Unknown operator: " + operator);
    };
  }
}
