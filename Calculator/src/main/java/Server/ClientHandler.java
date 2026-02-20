package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
  private final Socket clientSocket;
  private final boolean addSleepTime = false;
  public ClientHandler(Socket socket) {
    this.clientSocket = socket;
  }

  @Override
  public void run() {
    PrintWriter out;
    BufferedReader in;
    try {
      out = new PrintWriter(clientSocket.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

      String line = in.readLine();
      System.out.println("Received: " + line);
      String[] lineSplit = line.split(",");
      double number1 = Double.parseDouble(lineSplit[0]);
      double number2 = Double.parseDouble(lineSplit[1]);
      char operator =  lineSplit[2].charAt(0);
      double answer = calculate(number1,number2,operator);
      if (addSleepTime) {
        Thread.sleep(2000);
      }
      out.println(answer);
    } catch (IOException | InterruptedException e) {
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
