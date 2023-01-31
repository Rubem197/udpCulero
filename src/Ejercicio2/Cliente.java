package Ejercicio2;

import java.io.IOException;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            InetAddress direccion = InetAddress.getLocalHost();
            DatagramSocket socket = new DatagramSocket();

            String mensaje = "Hola";
            byte[] buffer = mensaje.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, direccion, 42500);
            socket.send(packet);

            String mensaje2 = "diego";
            byte[] buffer2 = mensaje2.getBytes();

            DatagramPacket packet2 = new DatagramPacket(buffer2, buffer2.length, direccion, 42500);
            socket.send(packet2);


            byte[] bufferEntrada = new byte[64];
            DatagramPacket packetRecibir = new DatagramPacket(bufferEntrada, bufferEntrada.length);
            socket.receive(packetRecibir);
            String mensajeRecibido =  new String(packetRecibir.getData());
            System.out.println(mensajeRecibido.trim());


            byte[] bufferEntrada2 = new byte[64];
            DatagramPacket packetRecibir2 = new DatagramPacket(bufferEntrada2, bufferEntrada2.length);
            socket.receive(packetRecibir2);
            String mensajeRecibido2 =  new String(packetRecibir2.getData());
            System.out.println(mensajeRecibido2.trim());




        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
