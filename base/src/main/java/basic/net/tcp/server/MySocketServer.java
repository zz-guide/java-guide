package basic.net.tcp.server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {
    public static void main(String[] args) {
        // 单向，使用字节流
        int port = 9995;
        Socket socket = null;
        InputStream inputStream = null;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("=====等待客户端连接=======");
                socket = serverSocket.accept();
                System.out.println("=======连接中=======");
                inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int readLength = 0;

                StringBuilder str = new StringBuilder();
                while ((readLength = inputStream.read(bytes)) != -1) {
                    String temp = new String(bytes, 0, readLength);
                    str.append(temp);
                }

                System.out.println("接收数据=" + str);
                System.out.println("=======等待下一次循环======");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (inputStream != null) {
                inputStream.close();
            }

            if (socket != null) {
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
