package ru.shadrina.messenger.server;

import ru.shadrina.messenger.ChatContent;
import ru.shadrina.messenger.config.Config;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;


public class ChatServer implements ChatContent {
    private ExecutorService executor;
    private ServerSocket serverSocket;
    Socket client;


    public ChatServer() {

        @Override
        public void run () {

            try {
                serverSocket = new ServerSocket(Config.getPort());
                System.out.println("Сервер запущен, ожидаем подключение");
                this.startConnection();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void startConnection () throws Exception {

            client = serverSocket.accept();
            System.out.print("Клиент подключился");
        }

        public void readMessage () throws Exception {
            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("DataInputStream created");
        }

        public void printMessage () throws Exception {
            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("DataInputStream created");
        }


    }

