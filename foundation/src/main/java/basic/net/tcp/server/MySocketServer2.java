package basic.net.tcp.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer2 {
    public static void main(String[] args) {
        // 双向，使用字节流接收和发送数据
        int port = 9995;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("=====等待客户端连接=======");
                socket = serverSocket.accept();
                System.out.println("=======连接中=======");
                // 处理接收数据
                inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int readLength = 0;

                StringBuilder str = new StringBuilder();
                while ((readLength = inputStream.read(bytes)) != -1) {
                    String temp = new String(bytes, 0, readLength);
                    str.append(temp);
                }

                System.out.println("接收数据=" + str);

                // 发送数据到客户端
                outputStream = socket.getOutputStream();
                outputStream.write("sasdasd".getBytes());
                socket.shutdownOutput();
                System.out.println("=======等待下一次循环======");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (outputStream != null) {
                outputStream.close();
            }

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
