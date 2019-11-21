package server;

import java.io.BufferedReader;
import java.io.File;
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
import java.util.concurrent.Semaphore;

/**
 * Classe responsavel pela controle de acesso aos dados do servidor.
 *
 * @author Kaique Jesus Do Nascimento RA:
 * @author Matheus Lopes RA:
 * @author Marcos Vinícius Renaldini RA:20885667
 * @author Pedro Akira RA:20871621
 * @author Pedro Oeste RA:
 * @author Thais Mota RA:
 * @version 1.00
 *
 */
public class ManipuladorArquivo extends UnicastRemoteObject implements Servico {

    private final FileWriter caminho;
    private final FileWriter caminhoID;

    public ManipuladorArquivo() throws RemoteException, IOException {
        super();
        this.caminho = new FileWriter(new File("Arquivo.txt")); 
        this.caminhoID = new  FileWriter(new File("ArquivoID.txt")); 
    }

    @Override
    public synchronized void adicionar(String dado, boolean estado)
            throws RemoteException, IOException {
        String dadosFinal = null;
        dadosFinal = "\n{" + estado + "<" + dado + ">" + retornaID() + "}";
        try (FileWriter arq = new FileWriter(this.caminho.toString(), true);
                PrintWriter gravarArq = new PrintWriter(arq)) {
            gravarArq.append(dadosFinal);
            incrementID();

        }

    }

    @Override
    public synchronized void excluir(String mensagem, boolean status, String id) throws RemoteException, IOException {
        String dados = null;
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(this.caminho.toString()))) {
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
        caminho.write(dados);

    }

    @Override
    public synchronized void alterar(String novaMensagem, boolean novoStatus, String id) throws RemoteException, IOException {

        String dados = null;
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(this.caminho.toString()))) {
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
        caminho.write(dados);

    }

    @Override
    public ArrayList atualizar() throws RemoteException, IOException {
        ArrayList<String> arr = new ArrayList<>();

        try (BufferedReader buffRead = new BufferedReader(new FileReader(this.caminho.toString()))) {
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
        caminhoID.write(id);

    }

    private int retornaID() throws FileNotFoundException, IOException {

        BufferedReader buffRead = new BufferedReader(new FileReader(this.caminhoID.toString()));
        String linha = buffRead.readLine();
        int id = Integer.parseInt(linha);
        buffRead.close();
        return id;
    }
}
