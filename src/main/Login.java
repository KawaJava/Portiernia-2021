package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    public String username, password, dataConn;
    readDBConfig readDBConfig = new readDBConfig();

    public Login() {
        
        initComponents();
        readDBConfig.read();
        username = readDBConfig.username;
        password = readDBConfig.password;
        dataConn = readDBConfig.dataConn;
        jBTNKeys.setEnabled(false);
        jBTNEditDB.setEnabled(false);
        jBTNProperties.setEnabled(false);
        jBTNLogout.setEnabled(false);
          
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTFlogin = new javax.swing.JTextField();
        JPFpassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBTNLogout = new javax.swing.JButton();
        jBTNLogin = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jBTNKeys = new javax.swing.JButton();
        jBTNEditDB = new javax.swing.JButton();
        jBTNProperties = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Jesteś zalogowaniy jako:");

        jLName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLName, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTFlogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTFlogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        JPFpassword.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        JPFpassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Login:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Hasło:");

        jBTNLogout.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jBTNLogout.setText("Wyloguj");
        jBTNLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNLogoutActionPerformed(evt);
            }
        });

        jBTNLogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jBTNLogin.setText("Zaloguj");
        jBTNLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPFpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBTNLogin)
                .addGap(27, 27, 27)
                .addComponent(jBTNLogout)
                .addGap(289, 289, 289))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPFpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBTNLogout)
                    .addComponent(jBTNLogin))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jBTNKeys.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jBTNKeys.setText("Wydawanie kluczy");
        jBTNKeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNKeysActionPerformed(evt);
            }
        });

        jBTNEditDB.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jBTNEditDB.setText("Edycja bazy danych");
        jBTNEditDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNEditDBActionPerformed(evt);
            }
        });

        jBTNProperties.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jBTNProperties.setText("Ustawienia");
        jBTNProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNPropertiesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBTNKeys)
                .addGap(29, 29, 29)
                .addComponent(jBTNEditDB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jBTNProperties)
                .addGap(21, 21, 21))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBTNKeys)
                    .addComponent(jBTNEditDB)
                    .addComponent(jBTNProperties))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void zaloguj() {
        
        jBTNKeys.setEnabled(false);
        jBTNEditDB.setEnabled(false);
        jBTNProperties.setEnabled(false);
        jLName.setText("");
        
        String userLogin = jTFlogin.getText();
        String userPassword = JPFpassword.getText();
        int zmiana = 0;
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn, username, password);
            pst = sqlConn.prepareStatement("select * from moderatorzy");
            rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString(2).equals(userLogin) && rs.getString(3).equals(userPassword)) {
                    
                    int upr = rs.getInt(4);
                    jTFlogin.setText("");
                    JPFpassword.setText("");
                    jBTNLogout.setEnabled(true);
                    jBTNLogin.setEnabled(false);
                    
                    if (upr == 1) {
                        
                        jBTNKeys.setEnabled(true);
                        JOptionPane.showMessageDialog(this, "Zalogowano. Twoje uprawnienia: Użytkownik");
                        String imie = rs.getString(5);
                        String nazw = rs.getString(6);
                        jLName.setText(imie + " " + nazw + " (Użytkownik)");
                        
                    }
                    if (upr == 2) {
                        
                        jBTNKeys.setEnabled(true);
                        jBTNEditDB.setEnabled(true);
                        JOptionPane.showMessageDialog(this, "Zalogowano. Twoje uprawnienia: Moderator");
                        String imie = rs.getString(5);
                        String nazw = rs.getString(6);
                        jLName.setText(imie + " " + nazw + " (Moderator)");
                        
                    }
                    if (upr == 3) {
                        
                        jBTNKeys.setEnabled(true);
                        jBTNEditDB.setEnabled(true);
                        jBTNProperties.setEnabled(true);
                        JOptionPane.showMessageDialog(this, "Zalogowano. Twoje uprawnienia: Admin");
                        String imie = rs.getString(5);
                        String nazw = rs.getString(6);
                        jLName.setText(imie + " " + nazw + " (Admin)");
                        
                    }
                     zmiana=1;
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        if(zmiana==0){
            JOptionPane.showMessageDialog(this, "Nie udało się zalogować");
        }
    }

    private void jBTNLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNLoginActionPerformed
        
        zaloguj();

    }//GEN-LAST:event_jBTNLoginActionPerformed

    private void jBTNEditDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNEditDBActionPerformed

        String namenazw = jLName.getText();
        new BazaDanych(namenazw).setVisible(true);
        dispose();
    }//GEN-LAST:event_jBTNEditDBActionPerformed

    private void jBTNKeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNKeysActionPerformed

        String namenazw = jLName.getText();
        new Wypożyczenia(namenazw).setVisible(true);
        dispose();
    }//GEN-LAST:event_jBTNKeysActionPerformed

    private void jBTNLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNLogoutActionPerformed

        jBTNKeys.setEnabled(false);
        jBTNEditDB.setEnabled(false);
        jBTNProperties.setEnabled(false);
        jLName.setText("");
        jBTNLogout.setEnabled(false);
        jBTNLogin.setEnabled(true);

    }//GEN-LAST:event_jBTNLogoutActionPerformed

    private void jBTNPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNPropertiesActionPerformed

        String namenazw = jLName.getText();
        new Ustawienia(namenazw).setVisible(true);
        dispose();
    }//GEN-LAST:event_jBTNPropertiesActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JPFpassword;
    private javax.swing.JButton jBTNEditDB;
    private javax.swing.JButton jBTNKeys;
    private javax.swing.JButton jBTNLogin;
    private javax.swing.JButton jBTNLogout;
    private javax.swing.JButton jBTNProperties;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTFlogin;
    // End of variables declaration//GEN-END:variables
}
