/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author zatch
 */
public interface Servico extends Remote {
    
    public void adicionar(String dado, boolean estado) throws RemoteException, IOException;
    public void alterar(String mensagem,boolean status, String id) throws RemoteException, IOException;
    public void excluir(String mensagem,boolean status, String id) throws RemoteException, IOException;
    public ArrayList atualizar() throws RemoteException, IOException;
    public String[] leitor() throws RemoteException, IOException;
    
    
    
    
    
    
}
