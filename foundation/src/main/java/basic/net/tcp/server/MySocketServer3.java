package basic.net.tcp.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer3 {
    public static void main(String[] args) {
        // 单向，使用字符流
        int port = 9995;
        Socket socket = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("=====等待客户端连接=======");
                socket = serverSocket.accept();
                System.out.println("=======连接中=======");
                inputStream = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String res = "";
                StringBuilder str = new StringBuilder();
                while ((res = bufferedReader.readLine()) != null) {
                    str.append(res);
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
