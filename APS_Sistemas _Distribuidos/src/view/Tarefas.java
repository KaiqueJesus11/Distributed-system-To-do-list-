/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import server.Servico;

/**
 *
 * @author zatch
 */
public class Tarefas extends javax.swing.JFrame {

    Servico man = null;
    ArrayList<String> arrlocal;

    public Tarefas() throws IOException {
        initComponents();
        String localizacao = "//localhost/servico";
        arrlocal = new ArrayList<>();
        try {
            this.man = (Servico) Naming.lookup(localizacao);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
        atualizar();
        new Thread() {

            @Override
            public void run() {
                while (true) {
                    try {
                        DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
                        String estado, dado, id;
                        ArrayList<String> arr = man.atualizar();
                        ArrayList<String> cleanArr = new ArrayList<String>();
                        for (int i = 0; i < arr.size(); i++) {
                            if (!"".equals(arr.get(i)) && arr.get(i) != null) {
                                cleanArr.add(arr.get(i));
                            }
                        }
                        arrlocal.clear();
                        for (int i = 0; i < tabela.getRowCount(); i++) {
                            estado = modeloTabela.getValueAt(i, 1).toString();
                            dado = modeloTabela.getValueAt(i, 0).toString();
                            if (estado.equals("A fazer")) {
                                estado = "false";
                            } else {
                                estado = "true";
                            }
                            id = modeloTabela.getValueAt(i, 2).toString();
                            arrlocal.add("{" + estado + "<" + dado + ">" + id + "}");
                        }
                        if (!comparaArray(arrlocal, cleanArr)) {
                            atualizar();
                            //JOptionPane.showMessageDialog(null, "asdasdsad");

                        }

                    } catch (IOException ex) {
                        Logger.getLogger(Tarefas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        Adicionar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton5.setText("Sair");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mensagem", "Status", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaMouseReleased(evt);
            }
        });
        tabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        Adicionar.setText("Adicionar");
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
            }
        });

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        alterar.setText("Alterar");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });

        jLabel1.setText("Tarefa");

        jLabel2.setText("Status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(Adicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(excluir)
                                .addGap(41, 41, 41)
                                .addComponent(alterar)
                                .addGap(31, 31, 31)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Adicionar)
                    .addComponent(excluir)
                    .addComponent(alterar)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
        // TODO add your handling code here:
        try {
            boolean a = false;

            if (jCheckBox1.isSelected()) {
                a = true;
            } else if (jCheckBox2.isSelected()) {
                a = false;
            }
            man.adicionar(jTextField1.getText(), a);

        } catch (IOException ex) {
            //Logger.getLogger(Adicionar.class
            //      .getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "Dado adicionado");
        try {
            atualizar();
        } catch (IOException ex) {
            Logger.getLogger(Tarefas.class.getName()).log(Level.SEVERE, null, ex);
        }
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jTextField1.setText(" ");
    }//GEN-LAST:event_AdicionarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        if (tabela.getSelectedRowCount() != 0) {
            try {
                // TODO add your handling code here:
                String dadoAExcluir = jTextField1.getText();
                boolean booleanAExluir = false;
                if (tabela.getValueAt(tabela.getSelectedRow(), 1).equals("true")) {
                    booleanAExluir = true;
                }
                String id = (tabela.getValueAt(tabela.getSelectedRow(), 2)).toString();
                man.excluir(dadoAExcluir, booleanAExluir, id);
            } catch (IOException ex) {
                Logger.getLogger(Tarefas.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                atualizar();
            } catch (IOException ex) {
                Logger.getLogger(Tarefas.class.getName()).log(Level.SEVERE, null, ex);
            }
            jCheckBox1.setSelected(false);
            jCheckBox2.setSelected(false);
            jTextField1.setText(" ");
    }//GEN-LAST:event_excluirActionPerformed
        else {
            JOptionPane.showMessageDialog(null, "Selecione o item que deseja excluir");
        }
    }
    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        if (tabela.getSelectedRowCount() != 0) {
            try {
                // TODO add your handling code here:
                boolean boo = false;
                if (jCheckBox1.isSelected()) {
                    boo = true;
                }
                man.alterar(jTextField1.getText(), boo, (String) tabela.getValueAt(tabela.getSelectedRow(), 2));
            } catch (IOException ex) {
                Logger.getLogger(Tarefas.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                atualizar();
            } catch (IOException ex) {
                Logger.getLogger(Tarefas.class.getName()).log(Level.SEVERE, null, ex);
            }
            jCheckBox1.setSelected(false);
            jCheckBox2.setSelected(false);
            jTextField1.setText(" ");
    }//GEN-LAST:event_alterarActionPerformed
            else{JOptionPane.showMessageDialog(null, "Selecione o item que deseja alterar");}
    }
    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:

        String mensagem = (String) (tabela.getValueAt(tabela.getSelectedRow(), 0));
        String estado = (String) (tabela.getValueAt(tabela.getSelectedRow(), 1));
        if (estado.equals("Feito")) {
            jCheckBox1.setSelected(true);
            jCheckBox2.setSelected(false);
        } else if (estado.equals("A fazer")) {
            jCheckBox2.setSelected(true);
            jCheckBox1.setSelected(false);
        }

        jTextField1.setText(mensagem);//aqui pego o valor da linha selecionada na coluna 0 e adiciono ao jtextfield } }

    }//GEN-LAST:event_tabelaMouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        jCheckBox2.setSelected(false);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        jCheckBox1.setSelected(false);
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void tabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyReleased
        String mensagem = (String) (tabela.getValueAt(tabela.getSelectedRow(), 0));
        String estado = (String) (tabela.getValueAt(tabela.getSelectedRow(), 1));
        if (estado.equals("Feito")) {
            jCheckBox1.setSelected(true);
            jCheckBox2.setSelected(false);
        } else if (estado.equals("A fazer")) {
            jCheckBox2.setSelected(true);
            jCheckBox1.setSelected(false);
        }

        jTextField1.setText(mensagem);//aqui pego o valor da linha selecionada na coluna 0 e adiciono ao jtextfield } }
    }//GEN-LAST:event_tabelaKeyReleased

    private void tabelaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseReleased
        String mensagem = (String) (tabela.getValueAt(tabela.getSelectedRow(), 0));
        String estado = (String) (tabela.getValueAt(tabela.getSelectedRow(), 1));
        if (estado.equals("Feito")) {
            jCheckBox1.setSelected(true);
            jCheckBox2.setSelected(false);
        } else if (estado.equals("A fazer")) {
            jCheckBox2.setSelected(true);
            jCheckBox1.setSelected(false);
        }

        jTextField1.setText(mensagem);//aqui pego o valor da linha selecionada na coluna 0 e adiciono ao jtextfield } }
    }//GEN-LAST:event_tabelaMouseReleased

    public boolean comparaArray(ArrayList<String> x, ArrayList<String> y) {
        if (x.size() != y.size()) {
            return false;
        }
        for (int i = 0; i < x.size(); i++) {
            if (!x.get(i).equals(y.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void atualizar() throws IOException {
        try {
            ArrayList<String> arr = man.atualizar();
            DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
            modeloTabela.setRowCount(0);
            for (int i = 0; i < arr.size() - 1; i++) {
                if (!arr.get(i).equals("")) {
                    int chaveA = arr.get(i).indexOf("{");
                    int chaveF = arr.get(i).indexOf("}");
                    int menor = arr.get(i).indexOf("<");
                    int maior = arr.get(i).indexOf(">");
                    String estado = arr.get(i).substring(chaveA + 1, menor);
                    String dado = arr.get(i).substring(menor + 1, maior);
                    String id = arr.get(i).substring(maior + 1, chaveF);

                    if (estado.equals("true")) {
                        modeloTabela.addRow(new String[]{dado, "Feito", id});
                    } else {
                        modeloTabela.addRow(new String[]{dado, "A fazer", id});

                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Tarefas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tarefas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Tarefas().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Tarefas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JButton alterar;
    private javax.swing.JButton excluir;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
