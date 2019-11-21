
package Tarefas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kaique Jesus
 */
public class ServicoImpl implements Servico{
    String bancoDeDados = null;
    ManipuladorArquivo man = new ManipuladorArquivo();

    public void adicionar(String dado, boolean estado) throws RemoteException, IOException {
        String dadosFinal = null;
        if (man.retornaID() < 10) {
            dadosFinal = "\n{" + estado + "<" + dado + ">" + "000" + man.retornaID() + "}";
        } else if (man.retornaID() < 100) {
            dadosFinal = "\n{" + estado + "<" + dado + ">" + "00" + man.retornaID() + "}";
        } else if (man.retornaID() < 1000) {
            dadosFinal = "\n{" + estado + "<" + dado + ">" + "0" + man.retornaID() + "}";
        }
        try (FileWriter arq = new FileWriter(this.man.getCaminho().toString(), true); PrintWriter gravarArq = new PrintWriter(arq)) {
            gravarArq.append(dadosFinal);
            man.incrementID();
        }
    }


    public String leitor() throws RemoteException, IOException {
        String BancoDeDados = null;
        try (BufferedReader buffRead = new BufferedReader(new FileReader(this.man.getCaminho().toString()))) {
            String linha = "";
            while (true) {
                if (linha != null) {
                    if (linha.contains("true")) {
                        boolean estado = Boolean.getBoolean(linha.substring(1, 5));
                        String dado = linha.substring(6, linha.length() - 6);
                        String id = linha.substring(linha.length() - 5, linha.length() - 1);

                    } else if (linha.contains("false")) {

                        boolean estado = Boolean.getBoolean(linha.substring(1, 6));
                        String dado = linha.substring(7, linha.length() - 6);
                        String id = linha.substring(linha.length() - 5, linha.length() - 1);
                        BancoDeDados = (dado + " " + estado + " " + id);
                    }
                } else {
                    break;
                }
                linha = buffRead.readLine();
            }
        }
        return BancoDeDados;
    }

    
    public void Excluir(boolean status, String tarefa, String ID) throws RemoteException {
        String dados = null;
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(man.getCaminho().toString()))) {
                while (br.ready()) {
                    String linha = br.readLine();
                    if (linha.contains(ID)) {
                        linha = "";
                    }
                    if (dados == null) {
                        dados = linha;
                    } else {
                        dados = dados + "\n" + linha;
                    }
                }
            }

        } catch (IOException ioe) {
        }
        byte[] dadosEmByte = dados.getBytes();
        try {
            Files.write(man.getCaminho(), dadosEmByte);
        } catch (IOException ex) {
            Logger.getLogger(Gerenciar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void Alterar(boolean status, String tarefa, String ID) throws RemoteException {
        String dados = null;
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(man.getCaminho().toString()))) {
                while (br.ready()) {
                    String linha = br.readLine();
                    if (linha.contains(ID)) {
                        linha = "{" + status + "<" + tarefa + ">" + ID + "}";
                    }
                    if (dados == null) {
                        dados = linha;
                    } else {
                        dados = dados + "\n" + linha;
                    }
                }
            }
            System.out.println("\n" + dados);
        } catch (IOException ioe) {
        }
        byte[] dadosEmByte = dados.getBytes();
        try {
            Files.write(man.getCaminho(), dadosEmByte);
        } catch (IOException ex) {
            Logger.getLogger(Gerenciar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
