package Servidor;
import Servidor.Servico;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends ServidorImpl {

    public static void main(String args[]) {
        try {
            // Instanciação
            ServidorImpl obj = new ServidorImpl();

            // Exportando o objeto para o stub
            Servico stub = (Servico) UnicastRemoteObject.exportObject(obj, 0);

            // Binding o objeto remoto (stub) no registro
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Servico", stub);

            System.err.println("Servidor Pronto");
        } catch (Exception e) {
            System.err.println("Exceção do Servidor: " + e.toString());
            e.printStackTrace();
        }
    }

}
