package Tarefas;

import Tarefas.Servico;
import Tarefas.ManipuladorArquivo;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Gerenciar extends javax.swing.JInternalFrame {
    private final Path caminho;
    private Servico servicoStub = null;
    Servico man = null;
    public Gerenciar() throws IOException {
        initComponents();
         String localizacao = "//localhost/servico";
        try {
            this.man = (Servico) Naming.lookup(localizacao);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
        this.caminho = Paths.get("C:/Users/Kaique Jesus/Pictures/APS_Sistemas _Distribuidos/APS_Sistemas _Distribuidos/BancoDeDadosLocal.txt");
        atualizar();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        sair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        alterar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gerenciar");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mensagem", "Estado ", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        jLabel1.setText("Tarefa");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Status");

        jCheckBox1.setText("Feito");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("A fazer");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        alterar.setText("Alterar");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 31, Short.MAX_VALUE)
                        .addComponent(excluir)
                        .addGap(18, 18, 18)
                        .addComponent(alterar)
                        .addGap(18, 18, 18)
                        .addComponent(sair)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jCheckBox1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sair)
                    .addComponent(alterar)
                    .addComponent(excluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            String mensagem = (String) (tabela.getValueAt(tabela.getSelectedRow(), 0));
            String estado = (String) (tabela.getValueAt(tabela.getSelectedRow(), 1));
            if (estado.equals("true")) {
                jCheckBox1.setSelected(true);
                jCheckBox2.setSelected(false);
            } else if (estado.equals("false")) {
                jCheckBox2.setSelected(true);
                jCheckBox1.setSelected(false);
            }

            jTextField1.setText(mensagem);//aqui pego o valor da linha selecionada na coluna 0 e adiciono ao jtextfield } }
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        jCheckBox2.setSelected(false);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        jCheckBox1.setSelected(false);
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        String mensagem = jTextField1.getText();
        boolean status = false;
        if (jCheckBox1.isSelected()) {
            status = true;
        } else if (jCheckBox2.isSelected()) {
            status = false;
        }
        String id = tabela.getValueAt(tabela.getSelectedRow(), 2).toString();
        try {
            man.Alterar(status, mensagem, id);
        } catch (RemoteException ex) {
            Logger.getLogger(Gerenciar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            atualizar();
        } catch (IOException ex) {
            Logger.getLogger(Gerenciar.class.getName()).log(Level.SEVERE, null, ex);
        }
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jTextField1.setText(" ");

    }//GEN-LAST:event_alterarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        String mensagem = jTextField1.getText();
        boolean status = false;
        if (jCheckBox1.isSelected()) {
            status = true;
        } else if (jCheckBox2.isSelected()) {
            status = false;
        }
        String id = tabela.getValueAt(tabela.getSelectedRow(), 2).toString();
        try {
            man.Excluir(status, mensagem, id);
        } catch (RemoteException ex) {
            Logger.getLogger(Gerenciar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            atualizar();
        } catch (IOException ex) {
            Logger.getLogger(Gerenciar.class.getName()).log(Level.SEVERE, null, ex);
        }
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jTextField1.setText(" ");
    }//GEN-LAST:event_excluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar;
    private javax.swing.JButton excluir;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton sair;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

    private void atualizar() throws IOException {
        try (FileWriter arq = new FileWriter(caminho.toString(), true); PrintWriter gravarArq = new PrintWriter(arq)) {
            gravarArq.write(man.leitor());
        }
        DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
        modeloTabela.setRowCount(0);
        try (BufferedReader buffRead = new BufferedReader(new FileReader(caminho.toString()))) {
            String linha = "";
            while (true) {
                if (linha != null) {
                    if (linha.contains("true")) {
                        String estado = linha.substring(1, 5);
                        String dado = linha.substring(6, linha.length() - 6);
                        String id = linha.substring(linha.length() - 5, linha.length() - 1);

                        modeloTabela.addRow(new String[]{dado, "Feito", id});
                    } else if (linha.contains("false")) {

                        String estado = linha.substring(1, 6);
                        String dado = linha.substring(7, linha.length() - 6);
                        String id = linha.substring(linha.length() - 5, linha.length() - 1);

                        modeloTabela.addRow(new String[]{dado, "A fazer", id});
                    }
                } else {
                    break;
                }
                linha = buffRead.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Gerenciar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void iniciarStub(){
     try {
            // Pegando o registro 
            Registry registry = LocateRegistry.getRegistry(null);

            // Procurando por um registro que utilize a Interface Hello
            servicoStub = (Servico) registry.lookup("Servico");
            
        } catch (Exception e) {
            System.err.println("Exceção do Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
