package ru.shadrina.messenger.config;

public class Config {
    private static Integer port = 5000;
    private static String hostName = "localhost";
    private static Integer threads = 3;

    public static Integer getPort() {
        return port;
    }

    public static Integer getThreads() {
        return threads;
    }

    public static String getHostName() {
        return hostName;
    }

    public static void setPort(Integer port) {
        port = port;
    }

    ;

    public static void setThreads(Integer threads) {
        threads = threads;
    }

    ;

    public static void setHostName(String hostName) {
        hostName = hostName;
    }

    ;

}
