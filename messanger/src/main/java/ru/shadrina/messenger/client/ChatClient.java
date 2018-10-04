package ru.shadrina.messenger.client;

import lombok.Getter;
import lombok.SneakyThrows;
import ru.shadrina.messenger.ChatContent;
import ru.shadrina.messenger.config.Config;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class ChatClient implements ChatContent {
    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    private Scanner message;
    private ExecutorService executor;

    public ChatClient() {
        executor = Executors.newFixedThreadPool(Config.getThreads());
    }

    @SneakyThrows
    @Override
    public void run() {
        socket = new Socket(Config.getHostName(), Config.getPort());
        in = new Scanner(socket.getInputStream());
        message = new Scanner(System.in);
        out = new PrintWriter(socket.getOutputStream());
        while (!socket.isOutputShutdown()) {
            //пока есть соединение запускаем потоки для чтения и записи на сервер
            // это у меня отдельный поток для постоянного чтения данных с сервера
            executor.execute(new readServerMessage(in));
            //это поток для отправки собщений на сервер
            executor.execute(new writeClientMessage(out));
        }
        //закрываю потоки после разрыва соединения
        executor.shutdown();
    }
}

