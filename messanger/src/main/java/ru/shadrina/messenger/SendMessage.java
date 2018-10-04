package ru.shadrina.messenger;

import lombok.SneakyThrows;

import java.io.PrintWriter;
import java.util.Scanner;

public class SendMessage implements Runnable {
    private Scanner message;
    private PrintWriter out;

    public SendMessage(PrintWriter out, Scanner message) {
        this.out = out;
        this.message = message;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (message.hasNext()) {
            String userMessage = message.nextLine();
            if ("exit".equalsIgnoreCase(userMessage)) {
                System.out.println("Вы покидаете чат");
                break;
            } else {
                System.out.println("Ваше сообщение: " + message);
                sendMessage(userMessage);
            }
        }
    }

    private void sendMessage(String message) {
        out.println(message);
        out.flush();
    }
}
