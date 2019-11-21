
package server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class ManipuladorArquivo extends UnicastRemoteObject implements Servico{

    private final Path caminho;
    private final Path caminhoID;

    public Path getCaminho() {
        return caminho;
    }

    public Path getCaminhoID() {
        return caminhoID;
    }

    public ManipuladorArquivo() throws RemoteException {
        super();
        this.caminho = Paths.get("C:/Users/Kaique Jesus/Downloads/APS_Sistemas _Distribuidos/APS_Sistemas _Distribuidos/Arquivos.txt");
        this.caminhoID = Paths.get("C:/Users/Kaique Jesus/Downloads/APS_Sistemas _Distribuidos/APS_Sistemas _Distribuidos/id.txt");
    }

    @Override
    public void adicionar(String dado, boolean estado) throws RemoteException, IOException {
        String dadosFinal = null;
        if (retornaID() < 10) {
            dadosFinal = "\n{" + estado + "<" + dado + ">" + "000" + retornaID() + "}";
        } else if (retornaID() < 100) {
            dadosFinal = "\n{" + estado + "<" + dado + ">" + "00" + retornaID() + "}";
        } else if (retornaID() < 1000) {
            dadosFinal = "\n{" + estado + "<" + dado + ">" + "0" + retornaID() + "}";
        }

        try (FileWriter arq = new FileWriter(this.caminho.toString(), true); PrintWriter gravarArq = new PrintWriter(arq)) {
            gravarArq.append(dadosFinal);
            incrementID();

        }

    }

    @Override
    public String[] leitor() throws IOException {
        String dados = null;
        try (BufferedReader buffRead = new BufferedReader(new FileReader(this.caminho.toString()))) {
            String linha = "";
            int incremento = 0;

            for (int i = 0; linha != null; i++) {
                linha = buffRead.readLine();
                incremento++;
                if (linha == null) {
                    break;
                }
            }
            System.out.println(incremento);
            linha = "";

            for (int i = 0; linha != null; i++) {
                linha = buffRead.readLine();
                if (linha == null) {
                    break;
                } else {
                    dados = linha;
                    System.out.println(dados);
                }

            }

        }
        return null;
    }

    public void excluir(String mensagem, boolean status, String id) throws RemoteException, IOException {
        String dados = null;
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(getCaminho().toString()))) {
                while (br.ready()) {

                    String linha = br.readLine();

                    if (linha.contains(mensagem) && linha.contains(id)) {
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
            ioe.printStackTrace();
        }
        byte[] dadosEmByte = dados.getBytes();
        try {
            Files.write(getCaminho(), dadosEmByte);

        } catch (IOException ex) {
            
        }

    }

    @Override
    public void alterar(String novaMensagem, boolean novoStatus, String id) throws RemoteException, IOException {

        String dados = null;
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(getCaminho().toString()))) {
                while (br.ready()) {

                    String linha = br.readLine();

                    if (linha.contains(id)) {
                        linha = "{" + novoStatus + "<" + novaMensagem + ">" + id + "}";
                    }
                    if (dados == null) {
                        dados = linha;
                    } else {
                        dados = dados + "\n" + linha;
                    }

                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        byte[] dadosEmByte = dados.getBytes();
        try {
            Files.write(getCaminho(), dadosEmByte);

        } catch (IOException ex) {
            
        }

    }

    @Override
    public ArrayList atualizar() throws RemoteException, IOException {
        ArrayList<String> arr = new ArrayList<>();

        try (BufferedReader buffRead = new BufferedReader(new FileReader(getCaminho().toString()))) {
            String linha = "";
            for (int i = 0; linha != null; i++) {
                linha = buffRead.readLine();
                arr.add(linha);
            }
        } catch (IOException ex) {
           
        }

        return arr;
    }
        
    private void incrementID() throws FileNotFoundException, IOException {

        //Incrementa o id
        String id = (retornaID() + 1) + "";
        byte[] id2 = id.getBytes();
        Files.write(this.caminhoID, id2);

    }

    private int retornaID() throws FileNotFoundException, IOException {

        BufferedReader buffRead = new BufferedReader(new FileReader(this.caminhoID.toString()));
        String linha = buffRead.readLine();
        int id = Integer.parseInt(linha);
        buffRead.close();
        return id;
    }
}
