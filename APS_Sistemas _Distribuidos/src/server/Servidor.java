package server;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
/**Classe responsavel por iniciar o servidor que irá gerenciar os arquivos.
*/
public class Servidor {

    public static void main(String[] args) throws IOException {
        try {

            ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
            String localizacao = "//localhost/servico";
            Naming.rebind(localizacao, manipuladorArquivo);
        } catch (RemoteException ex) {
            System.out.println("Erro:" + ex.getMessage());
        } catch (MalformedURLException ex) {
            System.out.println("Erro url" + ex.getMessage());
        }
    }
}





