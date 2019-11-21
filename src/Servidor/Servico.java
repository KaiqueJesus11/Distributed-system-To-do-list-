package Servidor;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Servico extends Remote {

    public void adicionar(String dado, boolean estado) throws RemoteException, IOException;
    
    public String leitor() throws RemoteException, IOException;
    
    public void Excluir(boolean status, String tarefa, String ID) throws RemoteException;

    public void Alterar(boolean status, String tarefa, String ID) throws RemoteException;

}
