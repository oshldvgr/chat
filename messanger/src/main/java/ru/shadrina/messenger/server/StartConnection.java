package ru.shadrina.messenger.server;

import lombok.SneakyThrows;
import ru.shadrina.messenger.ReadMessage;
import ru.shadrina.messenger.SendMessage;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class StartConnection implements Runnable {
    private ServerSocket serverSocket;
    private ExecutorService executor;
    private Socket clientSocket;

    StartConnection(ServerSocket serverSocket, ExecutorService executor) {
        this.serverSocket = serverSocket;
        this.executor = executor;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            clientSocket = serverSocket.accept();
            System.out.print("Клиент подключился");
            Scanner in = new Scanner(clientSocket.getInputStream());
            Scanner message = new Scanner(System.in);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            executor.execute(new ReadMessage(in));
            executor.execute(new SendMessage(out, message));
        }
    }
}
