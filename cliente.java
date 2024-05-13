import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {
        // Crear un objeto socket
        int puerto = 5000;
        boolean adios = true; 
        try {

            DatagramSocket socket = new DatagramSocket(puerto);

            // Direccion ip servidor
            InetAddress ip = InetAddress.getByName("172.31.115.135");

            while(true){
            // Crear arreglo de bytes para recibir los datos del cliente
            Scanner lectura = new Scanner(System.in); // crear escaneo de teclado
            System.out.println("mensaje enviado: "); //dar opcion de recibir mensaje
            String mensajeSalida =lectura.next(); // escribir mernsje en escritorio
            byte[] bufferSalida = mensajeSalida.getBytes();

            // Crear objeto datagrama para enviar los datos
            DatagramPacket packetSalida = new DatagramPacket(bufferSalida, bufferSalida.length,ip,puerto);
            socket.send(packetSalida);

            // Crear arreglo de bytes para recibir los datos del cliente
            byte[] bufferEntrada = new byte[1024];
            // Crear objeto datagrama para recibir los datos
            DatagramPacket packetEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length,ip,puerto);

            // Recibir el paquete
            socket.receive(packetEntrada);

            // Extraer la informacion del paquete
            String mensajeRecibido = new String(packetEntrada.getData());
            System.out.println("respuesta del servidor: " + mensajeRecibido);
            }
        } catch (Exception e) {
            // Todo auto generated catch block
            e.printStackTrace();
        }
    }
}