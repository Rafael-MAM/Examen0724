
package interfaces;

//import java.io.*;
import clases.Cartel;
import clases.Sistema;
import java.util.ArrayList;
import javax.swing.JOptionPane; // tengo que importar el JOptionPane porque se coloca a mano y no desde el Deign
                                
public class ConsultaDeCostos extends javax.swing.JFrame {

    private Sistema modelo;
    
    public ConsultaDeCostos(Sistema unSistema) {
        this.modelo = unSistema;
        initComponents();
        this.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabMontoMin = new javax.swing.JLabel();
        jTFmontoMinimo = new javax.swing.JTextField();
        jLabMontoMax = new javax.swing.JLabel();
        jTFMontoMaximo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListCarteles = new javax.swing.JList<>();
        jLabCarteles = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabMontoMin.setText("Monto minimo:");
        getContentPane().add(jLabMontoMin);
        jLabMontoMin.setBounds(30, 30, 110, 29);

        jTFmontoMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFmontoMinimoActionPerformed(evt);
            }
        });
        getContentPane().add(jTFmontoMinimo);
        jTFmontoMinimo.setBounds(160, 30, 110, 30);

        jLabMontoMax.setText("Monto maximo:");
        getContentPane().add(jLabMontoMax);
        jLabMontoMax.setBounds(30, 90, 110, 30);

        jTFMontoMaximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFMontoMaximoActionPerformed(evt);
            }
        });
        getContentPane().add(jTFMontoMaximo);
        jTFMontoMaximo.setBounds(160, 90, 110, 30);

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(170, 200, 100, 30);

        jScrollPane1.setViewportView(jListCarteles);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(320, 90, 180, 140);

        jLabCarteles.setText("Carteles");
        getContentPane().add(jLabCarteles);
        jLabCarteles.setBounds(320, 60, 80, 30);

        setBounds(380, 330, 527, 283);
    }// </editor-fold>//GEN-END:initComponents

    private void jTFMontoMaximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFMontoMaximoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFMontoMaximoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            int min = Integer.parseInt(jTFmontoMinimo.getText());
            int max = Integer.parseInt(jTFMontoMaximo.getText());
            ArrayList<Cartel> aux = this.modelo.cartelMontoFranja(min, max, this.modelo.getListaCarteles());
            this.modelo.cartelOrdenado(aux);
            jListCarteles.setListData(aux.toArray());
        }
        catch (NumberFormatException e) {
             // Mostrar mensaje de error
            JOptionPane.showMessageDialog(this,"ingresa valor correcto","Error",JOptionPane.ERROR_MESSAGE);
        }  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTFmontoMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFmontoMinimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFmontoMinimoActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabCarteles;
    private javax.swing.JLabel jLabMontoMax;
    private javax.swing.JLabel jLabMontoMin;
    private javax.swing.JList<Object> jListCarteles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFMontoMaximo;
    private javax.swing.JTextField jTFmontoMinimo;
    // End of variables declaration//GEN-END:variables
}
