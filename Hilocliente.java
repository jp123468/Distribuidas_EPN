import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Hilocliente extends Thread {

    private DatagramPacket packet;
    private DatagramSocket socket;

    public Hilocliente(DatagramSocket socket, DatagramPacket packet) {
        this.socket = socket;
        this.packet = packet;
    }

    public void run() {

        // extraer informacion del paquete
        String suscessmsg = new String(packet.getData());
        System.out.println(suscessmsg);

        // obtener la direccion del cliente
        InetAddress dirIp_cliente = packet.getAddress();
        int puerto_cli = packet.getPort();

        // crear arreglo de bites para enviar los datos del cliente
        String messageOut = "hola soy el servidor";
        byte[] bufferSalida = messageOut.getBytes();

        // crear objeto datagrama
        DatagramPacket packetout = new DatagramPacket(bufferSalida, bufferSalida.length, dirIp_cliente, puerto_cli);
        try {
            socket.send(packetout);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}