import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class hilo_Cliente extends Thread {

    Socket socket_cliente;

    public hilo_Cliente(Socket socket_cliente) {
        this.socket_cliente = socket_cliente;
    }

    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(), true);

            // leer datos recibidois por elñ cliente , almacenador en entrada
            String datos_recibidos = entrada.readLine();
            System.out.println("El mensaje recibido es: " + datos_recibidos);

            // escribir datos mensaje de salida
            String mensaje_enviar = "Hola soy el servidor";
            salida.println(mensaje_enviar);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
