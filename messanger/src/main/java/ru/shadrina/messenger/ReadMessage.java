package ru.shadrina.messenger;

import lombok.SneakyThrows;

import java.util.Scanner;

public class ReadMessage implements Runnable {
    private Scanner in;

    public ReadMessage(Scanner in) {
        this.in = in;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            if (in.hasNext()) {
                String inMessage = in.nextLine();
                if (inMessage != null) {
                    if ("exit".equalsIgnoreCase(inMessage)) {
                        System.out.println("Собеседник вышел из чата");
                    }
                    System.out.println(inMessage);
                }
            }
        }
    }
}
