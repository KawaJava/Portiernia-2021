package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Ustawienia extends javax.swing.JFrame {
    
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    String username, password, dataConn;
    ComboBox combobox = new ComboBox();
    readDBConfig readDBConfig = new readDBConfig();
    DBEditor DBEditor = new DBEditor();
    ValuesChanger ValuesChanger = new ValuesChanger();

    public Ustawienia() {
        setup();
    }

    Ustawienia(String namenazw) {
        
        setup();
        jLUser.setText(namenazw);
        
    }
    
    public void setup(){
        
        initComponents();
        readDBConfig.read();
        username = readDBConfig.username;
        password = readDBConfig.password;
        dataConn = readDBConfig.dataConn;
        showDate();
        showTime();
        upDateModeratorzy();
        upDateWypozyczenia();
        uprComboBox();
        email();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLUser = new javax.swing.JLabel();
        jLBDate = new javax.swing.JLabel();
        jLBTime = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTBLModeratorzy = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jTFLogin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTFHaslo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTFIImie = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTFNazwisko = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jCBUprawnienia = new javax.swing.JComboBox<>();
        jBTNAddMod = new javax.swing.JButton();
        jBTNUpdateMod = new javax.swing.JButton();
        jBTNDeleteMod = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jRBYes = new javax.swing.JRadioButton();
        jRBNo = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTBLHistoria = new javax.swing.JTable();
        JTBFiltruj = new javax.swing.JToggleButton();
        jTFSala = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTFPracownik = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(95, 158, 160), 8, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Zalogowany jako:");

        jLUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLBDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLBTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Wyloguj");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 32));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLUser, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(jLBDate, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLBTime, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLUser, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLBTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLBDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTBLModeratorzy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MOD_ID", "MOD_LOGIN", "MOD_HASLO", "UPRMOD_ID", "MOD_IMIE", "MOD_NAZWISKO"
            }
        ));
        jTBLModeratorzy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBLModeratorzyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTBLModeratorzy);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTFLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Login:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Hasło:");

        jTFHaslo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Imię:");

        jTFIImie.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Nazwisko:");

        jTFNazwisko.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Uprawnienia:");

        jCBUprawnienia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCBUprawnienia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBTNAddMod.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBTNAddMod.setText("Dodaj");
        jBTNAddMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNAddModActionPerformed(evt);
            }
        });

        jBTNUpdateMod.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBTNUpdateMod.setText("Aktualizuj");
        jBTNUpdateMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNUpdateModActionPerformed(evt);
            }
        });

        jBTNDeleteMod.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBTNDeleteMod.setText("Usuń");
        jBTNDeleteMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNDeleteModActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addComponent(jLabel7)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jBTNAddMod)))
                        .addGap(23, 23, 23)
                        .addComponent(jTFIImie, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBTNUpdateMod, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jBTNDeleteMod)
                                .addGap(55, 55, 55))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFNazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFHaslo, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCBUprawnienia, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFHaslo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jCBUprawnienia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFIImie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(46, 46, 46)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBTNAddMod)
                    .addComponent(jBTNUpdateMod)
                    .addComponent(jBTNDeleteMod))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Moderatorzy", jPanel3);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Automatyczne wysyłanie powiadomień email:");

        buttonGroup1.add(jRBYes);
        jRBYes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRBYes.setText("Tak");
        jRBYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBYesActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBNo);
        jRBNo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRBNo.setText("Nie");
        jRBNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel10)
                .addGap(88, 88, 88)
                .addComponent(jRBYes)
                .addGap(42, 42, 42)
                .addComponent(jRBNo)
                .addContainerGap(336, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jRBYes)
                    .addComponent(jRBNo))
                .addContainerGap(313, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ogólne", jPanel4);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTBLHistoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID wypożyczenia", "Pracownik", "Sala", "Data", "Czas wydania", "Czas oddania", "Termin", "Powiadomienie"
            }
        ));
        jScrollPane2.setViewportView(jTBLHistoria);

        JTBFiltruj.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JTBFiltruj.setText("Filtruj");
        JTBFiltruj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTBFiltrujActionPerformed(evt);
            }
        });

        jTFSala.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Numer sali:");

        jTFPracownik.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Pracownik:");

        jDateChooser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Data:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(JTBFiltruj)
                        .addGap(69, 69, 69)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFPracownik, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTFSala, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFSala, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(jTFPracownik)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(JTBFiltruj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Historia wypożyczeń", jPanel7);

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1120, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void email() {

        readDBConfig.readEmail(jRBYes, jRBNo);

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void uprComboBox() {

        combobox.fill(jCBUprawnienia, "uprawnieniamoderatorzy", "UPRMOD_NAZWA");

    }

    public void upDateModeratorzy() {

        try {
            sqlConn = DriverManager.getConnection(dataConn, username, password);
        } catch (Exception ex) {
        }

        ArrayList<String> columns = new ArrayList<>();
        columns.add("MOD_ID");
        columns.add("MOD_LOGIN");
        columns.add("MOD_HASLO");
        columns.add("UPRMOD_ID");
        columns.add("MOD_IMIE");
        columns.add("MOD_NAZW");

        DBEditor.upDate("moderatorzy", jTBLModeratorzy, columns);

    }

    public void upDateWypozyczenia() {

        ArrayList<String> columns = new ArrayList<>();
        columns.add("WYP_ID");
        columns.add("PRAC_NAZW");
        columns.add( "SALA_NUMER");
        columns.add("WYP_DATA");
        columns.add("WYP_CZASWYD");
        columns.add("WYP_CZASOD");
        columns.add("WYP_TERMIN");
        columns.add("WYP_POW");

        String advancedSQL = "SELECT WYPOŻYCZENIA.WYP_ID, PRACOWNICY.PRAC_NAZW, SALE.SALA_NUMER, WYPOŻYCZENIA.WYP_DATA, WYPOŻYCZENIA.WYP_CZASWYD, WYPOŻYCZENIA.WYP_CZASOD, WYPOŻYCZENIA.WYP_TERMIN, WYPOŻYCZENIA.WYP_POW\n"
                + "FROM SALE INNER JOIN (PRACOWNICY INNER JOIN WYPOŻYCZENIA ON PRACOWNICY.PRAC_ID = WYPOŻYCZENIA.PRAC_ID) ON SALE.SALA_ID = WYPOŻYCZENIA.SALA_ID;";
        DBEditor.updateWithAdvancedSQL(advancedSQL, jTBLHistoria, columns);

    }
    private void jBTNAddModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNAddModActionPerformed

        String uprawnienia = ValuesChanger.OtherToID(jCBUprawnienia, "uprawnieniamoderatorzy", "UPRMOD_ID", "UPRMOD_NAZWA");

        ArrayList<String> values = new ArrayList<>();
        values.add(jTFLogin.getText());
        values.add(jTFHaslo.getText());
        values.add(uprawnienia);
        values.add(jTFIImie.getText());
        values.add(jTFNazwisko.getText());
        DBEditor.addRecord("moderatorzy", "MOD_LOGIN,MOD_HASLO,UPRMOD_ID,MOD_IMIE,MOD_NAZW", "(?,?,?,?,?)", values);
        if (DBEditor.done = true) {
            upDateModeratorzy();
            JOptionPane.showMessageDialog(this, "Dodano moderatora");
        }

    }//GEN-LAST:event_jBTNAddModActionPerformed

    private void jBTNUpdateModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNUpdateModActionPerformed

        String uprawnienia = ValuesChanger.OtherToID(jCBUprawnienia, "uprawnieniamoderatorzy", "UPRMOD_ID", "UPRMOD_NAZWA");

        String[] values = new String[10];
        values[0] = jTFLogin.getText();
        values[1] = jTFHaslo.getText();
        values[2] = uprawnienia;
        values[3] = jTFIImie.getText();
        values[4] = jTFNazwisko.getText();

        DBEditor.updateRecord("moderatorzy", jTBLModeratorzy, "MOD_LOGIN=?,MOD_HASLO=?,UPRMOD_ID=?,MOD_IMIE=?,MOD_NAZW=?", " MOD_ID ", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Zaktualizowano");
            upDateModeratorzy();
        }

    }//GEN-LAST:event_jBTNUpdateModActionPerformed

    private void jTBLModeratorzyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBLModeratorzyMouseClicked

        int SelectedRows = ValuesChanger.SelectedRow(jTBLModeratorzy);
        jTFLogin.setText(jTBLModeratorzy.getValueAt(SelectedRows, 1).toString());
        jTFHaslo.setText(jTBLModeratorzy.getValueAt(SelectedRows, 2).toString());
        ValuesChanger.IDToOther(jTBLModeratorzy, jCBUprawnienia, "uprawnieniamoderatorzy", "UPRMOD_ID", "UPRMOD_NAZWA", 3);
        jTFIImie.setText(jTBLModeratorzy.getValueAt(SelectedRows, 4).toString());
        jTFNazwisko.setText(jTBLModeratorzy.getValueAt(SelectedRows, 5).toString());

    }//GEN-LAST:event_jTBLModeratorzyMouseClicked

    private void jRBYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBYesActionPerformed
       
        readDBConfig.write("email.txt", "Tak");

    }//GEN-LAST:event_jRBYesActionPerformed

    private void jRBNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBNoActionPerformed

        readDBConfig.write("email.txt", "Nie");
        
    }//GEN-LAST:event_jRBNoActionPerformed

    private void jBTNDeleteModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNDeleteModActionPerformed
 
        DBEditor.deleteRecordHard("moderatorzy", jTBLModeratorzy, "MOD_ID");
        upDateModeratorzy();
        JOptionPane.showMessageDialog(this, "Usunięto moderatora");
        
    }//GEN-LAST:event_jBTNDeleteModActionPerformed

    private void JTBFiltrujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTBFiltrujActionPerformed
        
        if (JTBFiltruj.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) jTBLHistoria.getModel();
            int a = model.getRowCount();
            String salazpola = jTFSala.getText();
            if (salazpola.isEmpty()) {

            } else {
                for (int i = 0; i < a; i++) {
                    String sala = (String) jTBLHistoria.getValueAt(i, 2);
                    if (sala.equals(salazpola)) {

                    } else {
                        model.removeRow(i);
                        i--;
                        a--;
                    }
                }
            }

            DefaultTableModel model1 = (DefaultTableModel) jTBLHistoria.getModel();
            int b = model1.getRowCount();
            String pracownikzpola = jTFPracownik.getText();
            if (pracownikzpola.isEmpty()) {

            } else {
                for (int o = 0; o < b; o++) {
                    String pracownik = (String) jTBLHistoria.getValueAt(o, 1);
                    if (pracownik.equals(pracownikzpola)) {

                    } else {
                        model1.removeRow(o);
                        o--;
                        b--;
                    }
                }
            }
            DefaultTableModel model2 = (DefaultTableModel) jTBLHistoria.getModel();
            int c = model2.getRowCount();
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            Date date = jDateChooser.getDate();

            if (date == null) {

            } else {
                String datazpola = SimpleDateFormat.getDateInstance().format(date);
                for (int oi = 0; oi < c; oi++) {
                    String data = (String) jTBLHistoria.getValueAt(oi, 3);
                    if (datazpola.equals(data)) {

                    } else {
                        model2.removeRow(oi);
                        oi--;
                        c--;
                    }
                }
            }
        } else {
            upDateWypozyczenia();
        }
    }//GEN-LAST:event_JTBFiltrujActionPerformed

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
            java.util.logging.Logger.getLogger(Ustawienia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ustawienia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ustawienia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ustawienia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ustawienia().setVisible(true);
            }
        });
    }

    void showDate() {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        jLBDate.setText(simpleDateFormat.format(date));
    }

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Date date = new java.util.Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                jLBTime.setText(simpleDateFormat.format(date));

            }
        }
        ).start();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton JTBFiltruj;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBTNAddMod;
    private javax.swing.JButton jBTNDeleteMod;
    private javax.swing.JButton jBTNUpdateMod;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCBUprawnienia;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLBDate;
    private javax.swing.JLabel jLBTime;
    private javax.swing.JLabel jLUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRBNo;
    private javax.swing.JRadioButton jRBYes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTBLHistoria;
    private javax.swing.JTable jTBLModeratorzy;
    private javax.swing.JTextField jTFHaslo;
    private javax.swing.JTextField jTFIImie;
    private javax.swing.JTextField jTFLogin;
    private javax.swing.JTextField jTFNazwisko;
    private javax.swing.JTextField jTFPracownik;
    private javax.swing.JTextField jTFSala;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
