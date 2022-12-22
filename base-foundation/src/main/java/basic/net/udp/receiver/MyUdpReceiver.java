package basic.net.udp.receiver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MyUdpReceiver {
    public static void main(String[] args) {
        int port = 9996;
        try (DatagramSocket socket = new DatagramSocket(port)) {
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            while (true) {
                System.out.println("=====准备接收======");
                socket.receive(datagramPacket);

                int length = datagramPacket.getLength();
                byte[] data = datagramPacket.getData();
                String res = new String(data, 0, length);
                System.out.println("接收到的数据长度：" + length);
                System.out.println("接收到的数据：" + res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
