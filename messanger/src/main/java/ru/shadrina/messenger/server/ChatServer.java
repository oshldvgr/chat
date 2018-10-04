package ru.shadrina.messenger.server;

import lombok.SneakyThrows;
import ru.shadrina.messenger.ChatContent;
import ru.shadrina.messenger.config.Config;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ChatServer implements ChatContent {
    private ExecutorService executor;
    private ServerSocket serverSocket;
    Socket client;

    public ChatServer() {
        executor = Executors.newFixedThreadPool(Config.getThreads());
    }

    @SneakyThrows
    @Override
    public void run() {
        serverSocket = new ServerSocket(Config.getPort());
        System.out.println("Сервер запущен, ожидаем подключение");
        executor.execute(new StartConnection(serverSocket, executor));
        serverSocket.close();
    }
}


