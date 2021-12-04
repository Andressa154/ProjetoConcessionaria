/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.info.telas;

import br.com.info.dal.ConexaoBD;
import java.sql.*;
import javax.swing.JOptionPane;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Toolkit;
/**
 *
 * @author andde
 */
public class Cliente extends javax.swing.JFrame {
Connection conexao=null;
PreparedStatement pst=null;
ResultSet rs=null;
    /**
     * Creates new form Cliente
     */
    public Cliente() {
        initComponents();
        conexao=ConexaoBD.conector();
        setTitle("Clientes");
        setExtendedState(MAXIMIZED_BOTH);
    }

    private void Inserir()
{
     String sql="insert into Cliente(idCliente,NomeCliente,CPF,VeiculoAdquirido,ValorCompra) values(?,?,?,?,?)";
 try{
     pst=conexao.prepareStatement(sql);
     pst.setString(1,idCliente.getText());
     pst.setString(2,NomeCliente.getText());
     pst.setString(3,CPF.getText());
     pst.setString(4,VeiculoAdquirido.getText());
     pst.setString(5,ValorCompra.getText());
     int adicionar=pst.executeUpdate();
     if(adicionar>0)
     {
       JOptionPane.showMessageDialog(null,"Usuário adicionado com sucesso");  
     }
 }catch(Exception e){
     JOptionPane.showMessageDialog(null, e);
    
}
}
   private void Editar()
{
    String sql="update Cliente set NomeCliente=?,CPF=?,VeiculoAdquirido=?,ValorCompra=? where idCliente=?";
        try{pst=conexao.prepareStatement(sql);
        pst.setString(1,NomeCliente.getText());
         pst.setString(2,CPF.getText());
        pst.setString(3,VeiculoAdquirido.getText());
        pst.setString(4,ValorCompra.getText());
       
        int alterar=pst.executeUpdate();
     if(alterar>0)
     {
       JOptionPane.showMessageDialog(null,"Dados do Cliente alterado com sucesso");  
     }
 }catch(Exception e){
     JOptionPane.showMessageDialog(null, e);
    
}     
} 
   private void Pesquisar()
{
    String sql="Select * from Cliente where idCliente=?";
    try{
        pst=conexao.prepareStatement(sql);
        pst.setString(1,idCliente.getText());
        
        rs=pst.executeQuery();
        if(rs.next())
        {
            
            
            jTextArea1.append("\n"+rs.getString(2));
            jTextArea1.append("\n"+rs.getString(3));
            jTextArea1.append("\n"+rs.getString(4));
            jTextArea1.append("\n"+rs.getString(5));
        }
        else{
            JOptionPane.showMessageDialog(null,"Cliente não cadastrado");
            NomeCliente.setText(null);
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
               }
}
   

   private void Deletar()
{
    String sql="delete from Cliente where idCliente=?";
    try {
        pst=conexao.prepareStatement(sql);
        pst.setString(1,idCliente.getText());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"Removido com sucesso");
        
    }catch(Exception e){
     JOptionPane.showMessageDialog(null, e);
    
}     
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon=new ImageIcon(getClass().getResource("/pconcessionaria/carro3.jpg"));
        Image image=icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        NomeCliente = new javax.swing.JTextField();
        CPF = new javax.swing.JTextField();
        VeiculoAdquirido = new javax.swing.JTextField();
        ValorCompra = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        idCliente2 = new javax.swing.JTextField();
        idCliente3 = new javax.swing.JTextField();
        idCliente4 = new javax.swing.JTextField();
        idCliente5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        idCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeClienteActionPerformed(evt);
            }
        });

        ValorCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorCompraActionPerformed(evt);
            }
        });

        jButton1.setText("Inserir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Deletar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Pesquisar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        idCliente2.setText("Nome do Cliente:");
        idCliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCliente2ActionPerformed(evt);
            }
        });

        idCliente3.setText("CPF:");
        idCliente3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCliente3ActionPerformed(evt);
            }
        });

        idCliente4.setText("Veículo Adquirido:");
        idCliente4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCliente4ActionPerformed(evt);
            }
        });

        idCliente5.setText("Valor da Compra:");
        idCliente5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCliente5ActionPerformed(evt);
            }
        });

        jButton5.setText("Voltar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        idCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idClienteActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(NomeCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(CPF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(VeiculoAdquirido, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(ValorCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(idCliente2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(idCliente3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(idCliente4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(idCliente5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(idCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idCliente2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idCliente3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idCliente4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(idCliente5)))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton2)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton4)
                                    .addContainerGap())
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(VeiculoAdquirido, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                                        .addComponent(NomeCliente, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CPF, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ValorCompra)
                                        .addComponent(idCliente, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(203, 203, 203)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(334, 334, 334))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(idCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VeiculoAdquirido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idCliente4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idCliente5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton5)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeClienteActionPerformed

    private void ValorCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorCompraActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Inserir();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      Editar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       Pesquisar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       Deletar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void idCliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCliente2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idCliente2ActionPerformed

    private void idCliente3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCliente3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idCliente3ActionPerformed

    private void idCliente4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCliente4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idCliente4ActionPerformed

    private void idCliente5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCliente5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idCliente5ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         new Tela1().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void idClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idClienteActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CPF;
    private javax.swing.JTextField NomeCliente;
    private javax.swing.JTextField ValorCompra;
    private javax.swing.JTextField VeiculoAdquirido;
    private javax.swing.JTextField idCliente;
    private javax.swing.JTextField idCliente2;
    private javax.swing.JTextField idCliente3;
    private javax.swing.JTextField idCliente4;
    private javax.swing.JTextField idCliente5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
