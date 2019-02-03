/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class VentanaOrdenamiento extends javax.swing.JFrame {
    ArrayList<String> listElmt = new ArrayList();
    ArrayList<String> listElmtOrden = new ArrayList();
    /**
     * Creates new form VentanaOrdenamienot
     */
    public VentanaOrdenamiento() {
        initComponents();
        this.setTitle("Algoritmos de ordenamiento");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOrdenar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtElmt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAelmt = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAelmtOrden = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jLabel2.setText("Elemento:");

        txtAelmt.setEditable(false);
        txtAelmt.setColumns(20);
        txtAelmt.setRows(5);
        jScrollPane1.setViewportView(txtAelmt);

        txtAelmtOrden.setEditable(false);
        txtAelmtOrden.setColumns(20);
        txtAelmtOrden.setRows(5);
        jScrollPane2.setViewportView(txtAelmtOrden);

        jLabel1.setText("Lista desordenada:");

        jLabel3.setText("Lista ordenada:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(txtElmt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIngresar)
                        .addGap(18, 18, 18)
                        .addComponent(btnOrdenar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(110, 110, 110)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtElmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIngresar)
                    .addComponent(btnOrdenar))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        
        int[] num = null;
        int aux=0;
        for(String n : listElmt){
            num[aux]=Integer.valueOf(n);
        }
        Cronometro timer = new Cronometro();
        
        timer.Iniciar();
        ProyectoAlgoritmos.binSort(num, num.length);
        timer.SegundosTranscurridos();
        
        timer.Iniciar();
        ProyectoAlgoritmos.burbuja(num);
        timer.SegundosTranscurridos();
        
        timer.Iniciar();
        ProyectoAlgoritmos.heapSort(num, num.length);
        timer.SegundosTranscurridos();
        
        timer.Iniciar();
        ProyectoAlgoritmos.insercion(num);
        timer.SegundosTranscurridos();
        
        timer.Iniciar();
        ProyectoAlgoritmos.mergeSort(num);
        timer.SegundosTranscurridos();
        
        timer.Iniciar();
        ProyectoAlgoritmos.quicksort(num, aux, aux);
        timer.SegundosTranscurridos();
        
        timer.Iniciar();
        ProyectoAlgoritmos.ordenarArray(num, aux);
        timer.SegundosTranscurridos();
        
        timer.Iniciar();
        ProyectoAlgoritmos.radixSort(num);
        timer.SegundosTranscurridos();
        
        timer.Iniciar();
        ProyectoAlgoritmos.seleccion(num);
        timer.SegundosTranscurridos();
        
        ProyectoAlgoritmos.quicksort(num, aux, aux).toString();
        for(int j=0;j<num.length;j++){
            
        }
        
        
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String tElmt = txtElmt.getText();
        
        if(!tElmt.equals("")){
            int option = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(option == 0){
                this.listElmt.add(tElmt);
                txtElmt.setText("");
                txtAelmt.setText("");
                for(String item : listElmt){
                    if(txtAelmt.getText().equals("")){
                        txtAelmt.setText(item);
                    }else{
                        txtAelmt.setText(txtAelmt.getText()+", "+item);
                    }
                }
                JOptionPane.showMessageDialog(rootPane, "El elemento se añadió satisfactoriamente a la lista.");
            }else if (option == 1){
                JOptionPane.showMessageDialog(rootPane, "El elemento NO se añadió a la lista.");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ingrese un elemento a su lista, por favor.");
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaOrdenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaOrdenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaOrdenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaOrdenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaOrdenamiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAelmt;
    private javax.swing.JTextArea txtAelmtOrden;
    private javax.swing.JTextField txtElmt;
    // End of variables declaration//GEN-END:variables
}