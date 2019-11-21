package Servidor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ManipuladorArquivo {

    private final Path caminho;
    private final Path caminhoID;

    public Path getCaminho() {
        return caminho;
    }

    public Path getCaminhoID() {
        return caminhoID;
    }

    public ManipuladorArquivo() {
        this.caminho = Paths.get("C:/Users/Kaique Jesus/Desktop/APS_Sistemas _Distribuidos/APS_Sistemas _Distribuidos/BancoDeDadosServidor.txt");
        this.caminhoID = Paths.get("C:/Users/Kaique Jesus/Desktop/APS_Sistemas _Distribuidos/APS_Sistemas _Distribuidos/id.txt");
    }

   
    public void incrementID() throws FileNotFoundException, IOException {
        String id = (retornaID() + 1) + "";
        byte[] id2 = id.getBytes();
        Files.write(this.caminhoID, id2);
    }

    public int retornaID() throws FileNotFoundException, IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(this.caminhoID.toString()));
        String linha = buffRead.readLine();
        int id = Integer.parseInt(linha);
        buffRead.close();
        return id;
    }

}