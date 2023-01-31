package Ejercicio1;

import java.io.IOException;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            InetAddress direccion = InetAddress.getLocalHost();
            DatagramSocket socket = new DatagramSocket();

            String mensaje = "diego";
            byte[] buffer = mensaje.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, direccion, 42500);
            socket.send(packet);
            byte[] bufferEntrada = new byte[64];
            DatagramPacket packetRecibir = new DatagramPacket(bufferEntrada, bufferEntrada.length);
            socket.receive(packetRecibir);
            String mensajeRecibido =  new String(packetRecibir.getData());
            System.out.println(mensajeRecibido.trim());

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
