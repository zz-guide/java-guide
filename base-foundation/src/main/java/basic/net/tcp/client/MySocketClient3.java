package basic.net.tcp.client;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MySocketClient3 {
    public static void main(String[] args) {
        // 单向，客户端只发送数据，使用字符流
        int port = 9995;
        OutputStream outputStream = null;
        BufferedWriter bufferedWriter = null;
        try (Socket socket = new Socket(InetAddress.getLocalHost(), port)) {
            outputStream = socket.getOutputStream();
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("你好，我是字符流");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            socket.shutdownOutput();
            System.out.println("======客户端退出=======");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
