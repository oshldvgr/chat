package ru.shadrina.messenger.client;

import java.util.Scanner;

public class readServerMessage implements Runnable {
    private Scanner in;

    public readServerMessage(Scanner in) {
        this.in = in;
    }

    @Override
    public void run() {
        if (in.hasNext()) {
            String inMessage = in.nextLine();
            System.out.println(inMessage);
        }
        this.run();


    }
}
