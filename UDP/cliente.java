import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class cliente {
    public static void main(String[] args) {

        Socket socket_cliente;
        try {
            socket_cliente = new Socket("localhost", 5000);
            System.out.println("Cliente conectado");
            while (true) {
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
                PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(), true);
                // escribir datos mensaje de salida
                String mensaje_enviar = "Hola soy el cliente";
                salida.println(mensaje_enviar);

                // leer datos recibidois por elñ cliente , almacenador en entrada
                String datos_recibidos = entrada.readLine();
                System.out.println("El mensaje recibido es: " + datos_recibidos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
