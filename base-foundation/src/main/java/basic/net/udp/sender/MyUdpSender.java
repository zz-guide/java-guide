package basic.net.udp.sender;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MyUdpSender {
    public static void main(String[] args) {
        int port = 9998;
        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            String str = "我要吃火锅";
            byte[] bytes = str.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9996);
            datagramSocket.send(datagramPacket);
            System.out.println("=====发送结束=======");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
