package Ejercicio2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(42500);
            byte[] buffer = new byte[64];

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            byte[] buffer2 = new byte[64];

            DatagramPacket packet2 = new DatagramPacket(buffer2, buffer2.length);

            socket.receive(packet2);

            String mensaje = new String(packet.getData());

            byte[] bufferSalida = mensaje.getBytes();

            DatagramPacket packetSalida = new DatagramPacket(bufferSalida, bufferSalida.length, packet.getAddress(), packet.getPort());

            socket.send(packetSalida);


            String mensaje2 = new String(packet2.getData());

            byte[] bufferSalida2 = mensaje2.getBytes();

            DatagramPacket packetSalida2 = new DatagramPacket(bufferSalida2, bufferSalida2.length, packet.getAddress(), packet.getPort());

            socket.send(packetSalida2);



        }catch (SocketException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
