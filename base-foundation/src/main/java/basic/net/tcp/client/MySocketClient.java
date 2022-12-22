package basic.net.tcp.client;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class MySocketClient {
    public static void main(String[] args) {
        // 单向，客户端只发送数据，使用字节流
        int port = 9995;
        OutputStream outputStream = null;
        try (Socket socket = new Socket(InetAddress.getLocalHost(), port)) {
            outputStream = socket.getOutputStream();
            outputStream.write("你好，世界123".getBytes());
            outputStream.flush();
            System.out.println("======客户端退出=======");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (outputStream != null) {
                outputStream.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
