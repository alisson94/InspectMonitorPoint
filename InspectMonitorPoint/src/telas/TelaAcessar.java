
package telas;

public class TelaAcessar extends javax.swing.JFrame {

    public TelaAcessar() {
        initComponents();
    }
    
    public void limparCampos(){
        tfUsuario.setText("");
        pfSenha.setText("");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pfSenha = new javax.swing.JPasswordField();
        tfUsuario = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(850, 585));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pfSenha.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pfSenha.setBorder(null);
        getContentPane().add(pfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 280, 60));

        tfUsuario.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tfUsuario.setBorder(null);
        getContentPane().add(tfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 290, 60));

        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/btnentrar.png"))); // NOI18N
        btnEntrar.setBorder(null);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/labelsenha.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/labelusuario.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/telainicial.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(843, 595));
        jLabel1.setMinimumSize(new java.awt.Dimension(843, 595));
        jLabel1.setPreferredSize(new java.awt.Dimension(843, 595));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 850, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnEntrarActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAcessar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
