import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class hilo_Cliente extends Thread {

    Socket socket_cliente;

    public hilo_Cliente(Socket socket_cliente) {
        this.socket_cliente = socket_cliente;
    }

    public void run() {
        try {
            while (true) { 
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(), true);

            // leer datos recibidois por elñ cliente , almacenador en entrada
            String datos_recibidos = entrada.readLine();
            System.out.println("respuesta del cliente: " + datos_recibidos);

            // escribir datos mensaje de salida
             Scanner lectura = new Scanner(System.in); // crear escaneo de teclado
            String mensajeSalida =lectura.next(); // escribir mernsje en escritorio
            salida.println(mensajeSalida);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
