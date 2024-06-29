package basic.net.tcp.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class MySocketClient2 {
    public static void main(String[] args) {
        // 双向，使用字节流接收发送数据
        int port = 9995;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try (Socket socket = new Socket(InetAddress.getLocalHost(), port)) {
            // 先发送
            outputStream = socket.getOutputStream();
            outputStream.write("你好，世界123".getBytes());
            // 设置结束标记，并且发送之前的数据
            socket.shutdownOutput();
            // 等待从server接收
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int readLength = 0;
            StringBuilder builder = new StringBuilder();
            while ((readLength = inputStream.read(bytes)) != -1) {
                String temp = new String(bytes, 0, readLength);
                builder.append(temp);
            }

            System.out.println("客户端接收数据:" + builder);
            socket.shutdownInput();
            
            inputStream.close();
            outputStream.close();
            System.out.println("======客户端退出=======");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (inputStream != null) {
                inputStream.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
