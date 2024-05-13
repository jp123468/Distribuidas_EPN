import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class servidor {

    public static void main(String[] args) {
        int puerto = 5000;
        try {
            // crear un objeto socket
            DatagramSocket socket = new DatagramSocket(puerto);
            System.out.println("Wait for the host...");
            while (true) {

                // crear arreglo de bites para recibir los datos del cliente
                byte[] bufferEntrada = new byte[1024];

                // crear objeto datagrama
                DatagramPacket packet = new DatagramPacket(bufferEntrada, bufferEntrada.length);

                // recibir el paquete
                socket.receive(packet);

                /////////////////////////////////////////////////////////////////////////////////////////
                // Iniciar un hilo para cada cliente
                Thread HiloCliente = new Hilocliente(socket, packet);
                HiloCliente.start();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}