package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BazaDanych extends javax.swing.JFrame {

    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    String username, password, dataConn;
    ComboBox combobox = new ComboBox();
    readDBConfig readDBConfig = new readDBConfig();
    DBEditor DBEditor = new DBEditor();
    ValuesChanger ValuesChanger = new ValuesChanger();

    public BazaDanych() {
        setup();

    }

    public BazaDanych(String namenazw) {
        setup();
        jLUser.setText(namenazw);
    }
    
    public void setup(){
        initComponents();
        readDBConfig.read();
        username = readDBConfig.username;
        password = readDBConfig.password;
        dataConn = readDBConfig.dataConn;
        upDateSale();
        upDatePrzedmioty();
        upDatePracownicy();
        saleComboBoxes();
        upDateUprawnienia();
        pracownicyComboBoxes();
        dnitygodniaComboBox();
        przedmiotyComboBox();
        upDateZajecia();
        uprawnieniaComboBox();
        upDateuprawnieniauzytkownikow();
        upDateKlucze();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLUser = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTBLSale = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        aktualizujzale = new javax.swing.JButton();
        dodajsale = new javax.swing.JButton();
        usunsale = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JTFNumerSali = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTBLPrzedmioty = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        dodajprzedmiot = new javax.swing.JButton();
        aktualizujprzedmiot = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTFSkrotPrzedmiotu = new javax.swing.JTextField();
        JTFNazwaPrzedmiotu = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTBLPracownicy = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFPracImie = new javax.swing.JTextField();
        jTFPracNazwisko = new javax.swing.JTextField();
        jTFPracEmail = new javax.swing.JTextField();
        dodajpracownika = new javax.swing.JButton();
        aktualizujpracownika = new javax.swing.JButton();
        usunpracownika = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jTFPracSkrot = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTBLUprawnienia = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        JTFOpisUprawnienia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jCBSale1 = new javax.swing.JComboBox<>();
        dodajprzedmiot1 = new javax.swing.JButton();
        updateUprawnienia = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTBLZajecia = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        aktualizujprzedmiot2 = new javax.swing.JButton();
        dodajprzedmiot2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jCBPrzedmiot = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jCBDzien = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jCBSale2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        JCBCzasRozp = new javax.swing.JComboBox<>();
        jCBCzasZak = new javax.swing.JComboBox<>();
        jCBProwadzacy = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTBLUprawnieniaPrac = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jCBUprawnienia = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        dodajupranieniauz = new javax.swing.JButton();
        aktualizujuprawnieniauz = new javax.swing.JButton();
        jCBPracownik = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTBLKlucze = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        dodajklucze = new javax.swing.JButton();
        aktualizujklucze = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLBOpisKlucza = new javax.swing.JTextField();
        jCBSale3 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Zalogowany jako:");

        jLUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Wyloguj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLUser, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1)
                    .addComponent(jLUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTBLSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SALA_ID", "SALA_NUMER", "SALA_AKT"
            }
        ));
        jTBLSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBLSaleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTBLSale);

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        aktualizujzale.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        aktualizujzale.setText("Aktualizuj");
        aktualizujzale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktualizujzaleActionPerformed(evt);
            }
        });

        dodajsale.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dodajsale.setText("Dodaj");
        dodajsale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajsaleActionPerformed(evt);
            }
        });

        usunsale.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        usunsale.setText("Usuń");
        usunsale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usunsaleActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Numer sali:");

        JTFNumerSali.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(JTFNumerSali, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(usunsale)
                    .addComponent(dodajsale)
                    .addComponent(aktualizujzale))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFNumerSali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(79, 79, 79)
                .addComponent(dodajsale)
                .addGap(18, 18, 18)
                .addComponent(aktualizujzale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usunsale)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sale", jPanel1);

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTBLPrzedmioty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRZ_ID", "PRZ_NAZWA", "PRZ_SKROT"
            }
        ));
        jTBLPrzedmioty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBLPrzedmiotyMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTBLPrzedmioty);

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        dodajprzedmiot.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dodajprzedmiot.setText("Dodaj");
        dodajprzedmiot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajprzedmiotActionPerformed(evt);
            }
        });

        aktualizujprzedmiot.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        aktualizujprzedmiot.setText("Aktualizuj");
        aktualizujprzedmiot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktualizujprzedmiotActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Nazwa przedmiotu:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Skrót przedmiotu:");

        JTFSkrotPrzedmiotu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        JTFNazwaPrzedmiotu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dodajprzedmiot)
                            .addComponent(aktualizujprzedmiot))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFSkrotPrzedmiotu, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                            .addComponent(JTFNazwaPrzedmiotu))))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFNazwaPrzedmiotu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFSkrotPrzedmiotu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addComponent(dodajprzedmiot)
                .addGap(18, 18, 18)
                .addComponent(aktualizujprzedmiot)
                .addGap(159, 159, 159))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Przedmioty", jPanel2);

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTBLPracownicy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRAC_ID", "PRAC_IMIE", "PRAC_NAZWISKO", "PRAC_EMAIL", "PRAC_NAZW", "PRAC_AKT"
            }
        ));
        jTBLPracownicy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBLPracownicyMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTBLPracownicy);

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Adres e-mail:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Nazwisko:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Imię");

        jTFPracImie.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jTFPracNazwisko.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jTFPracEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        dodajpracownika.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dodajpracownika.setText("Dodaj");
        dodajpracownika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajpracownikaActionPerformed(evt);
            }
        });

        aktualizujpracownika.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        aktualizujpracownika.setText("Aktualizuj");
        aktualizujpracownika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktualizujpracownikaActionPerformed(evt);
            }
        });

        usunpracownika.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        usunpracownika.setText("Usuń");
        usunpracownika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usunpracownikaActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setText("Skrót:");

        jTFPracSkrot.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFPracImie, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFPracNazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFPracEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dodajpracownika)
                    .addComponent(usunpracownika)
                    .addComponent(aktualizujpracownika, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTFPracSkrot, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPracImie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPracNazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPracEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPracSkrot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(dodajpracownika)
                .addGap(18, 18, 18)
                .addComponent(aktualizujpracownika)
                .addGap(18, 18, 18)
                .addComponent(usunpracownika)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pracownicy", jPanel3);

        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTBLUprawnienia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UPR_ID", "UPR_OPIS", "SALA_ID"
            }
        ));
        jTBLUprawnienia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBLUprawnieniaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTBLUprawnienia);

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Opis uprawnienia:");

        JTFOpisUprawnienia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Sala:");

        dodajprzedmiot1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dodajprzedmiot1.setText("Dodaj");
        dodajprzedmiot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajprzedmiot1ActionPerformed(evt);
            }
        });

        updateUprawnienia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateUprawnienia.setText("Aktualizuj");
        updateUprawnienia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUprawnieniaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFOpisUprawnienia, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBSale1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dodajprzedmiot1)
                    .addComponent(updateUprawnienia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFOpisUprawnienia))
                .addGap(26, 26, 26)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBSale1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(26, 26, 26)
                .addComponent(dodajprzedmiot1)
                .addGap(18, 18, 18)
                .addComponent(updateUprawnienia)
                .addGap(116, 116, 116))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Uprawnienia", jPanel4);

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTBLZajecia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ZAJ_ID", "ZAJ_CZASROZ", "ZAJ_CZASZAK", "PRAC_ID", "SALA_ID", "DZIEN_ID", "PRZ_ID"
            }
        ));
        jTBLZajecia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBLZajeciaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTBLZajecia);

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        aktualizujprzedmiot2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        aktualizujprzedmiot2.setText("Aktualizuj");
        aktualizujprzedmiot2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktualizujprzedmiot2ActionPerformed(evt);
            }
        });

        dodajprzedmiot2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dodajprzedmiot2.setText("Dodaj");
        dodajprzedmiot2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajprzedmiot2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Przedmiot:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Dzień:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Sala:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Czas rozpoczęcia:");

        JCBCzasRozp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:15:00", "9:15:00", "10:15:00", "11:15:00", "12:15:00", "13:15:00", "14:15:00", "15:15:00", "16:15:00", "17:15:00", "18:15:00", "19:15:00" }));

        jCBCzasZak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "9:00:00", "10:00:00", "11:00:00", "12:00:00", "13:00:00", "14:00:00", "15:00:00", "16:00:00", "17:00:00", "18:00:00", "19:00:00", "20:00:00" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Prowadzący:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Czas zakończenia:");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCBDzien, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCBCzasZak, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCBCzasRozp, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCBProwadzacy, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCBSale2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCBPrzedmiot, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dodajprzedmiot2)
                            .addComponent(aktualizujprzedmiot2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCBCzasRozp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jCBCzasZak, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBProwadzacy, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCBSale2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCBDzien)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBPrzedmiot, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(dodajprzedmiot2)
                .addGap(18, 18, 18)
                .addComponent(aktualizujprzedmiot2)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Zajęcia", jPanel5);

        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTBLUprawnieniaPrac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UPRUZ_ID", "PRAC_ID", "UPR_ID"
            }
        ));
        jTBLUprawnieniaPrac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBLUprawnieniaPracMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTBLUprawnieniaPrac);

        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Pracownik:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Uprawnienia:");

        dodajupranieniauz.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dodajupranieniauz.setText("Dodaj");
        dodajupranieniauz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajupranieniauzActionPerformed(evt);
            }
        });

        aktualizujuprawnieniauz.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        aktualizujuprawnieniauz.setText("Aktualizuj");
        aktualizujuprawnieniauz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktualizujuprawnieniauzActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCBUprawnienia, 0, 361, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dodajupranieniauz)
                            .addComponent(aktualizujuprawnieniauz))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCBPracownik, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBPracownik, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBUprawnienia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dodajupranieniauz)
                .addGap(18, 18, 18)
                .addComponent(aktualizujuprawnieniauz)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Uprawnienia Pracowników", jPanel6);

        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTBLKlucze.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "KLUCZ_ID", "KLUCZ_OPIS", "SALA_ID"
            }
        ));
        jTBLKlucze.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBLKluczeMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTBLKlucze);

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        dodajklucze.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dodajklucze.setText("Dodaj");
        dodajklucze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajkluczeActionPerformed(evt);
            }
        });

        aktualizujklucze.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        aktualizujklucze.setText("Aktualizuj");
        aktualizujklucze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktualizujkluczeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Opis:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("Sala:");

        jLBOpisKlucza.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dodajklucze)
                            .addComponent(aktualizujklucze)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLBOpisKlucza, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBSale3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLBOpisKlucza))
                .addGap(26, 26, 26)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBSale3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(67, 67, 67)
                .addComponent(dodajklucze)
                .addGap(18, 18, 18)
                .addComponent(aktualizujklucze)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Klucze", jPanel7);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void upDatePrzedmioty() {

        ArrayList<String> columns = new ArrayList<>();
        columns.add("PRZ_ID");
        columns.add("PRZ_NAZWA");
        columns.add("PRZ_SKROT");
        DBEditor.upDate("przedmioty", jTBLPrzedmioty, columns);

    }

    public void upDateSale() {

        ArrayList<String> columns = new ArrayList<>();
        columns.add("SALA_ID");
        columns.add("SALA_NUMER");
        columns.add("SALA_AKT");
        DBEditor.upDate("sale", jTBLSale, columns);

    }

    public void upDatePracownicy() {

        try {
            sqlConn = DriverManager.getConnection(dataConn, username, password);
        } catch (Exception ex) {
        }

        ArrayList<String> columns = new ArrayList<>();
        columns.add("PRAC_ID");
        columns.add("PRAC_IMIE");
        columns.add("PRAC_NAZWISKO");
        columns.add("PRAC_EMAIL");
        columns.add("PRAC_NAZW");
        columns.add("PRAC_AKT");
        DBEditor.upDate("pracownicy", jTBLPracownicy, columns);

    }

    public void upDateUprawnienia() {

        ArrayList<String> columns = new ArrayList<>();
        columns.add("UPR_ID");
        columns.add("UPR_OPIS");
        columns.add("SALA_ID");
        DBEditor.upDate("uprawnienia", jTBLUprawnienia, columns);

    }

    public void upDateZajecia() {

        ArrayList<String> columns = new ArrayList<>();
        columns.add("ZAJ_ID");
        columns.add("ZAJ_CZASROZ");
        columns.add("ZAJ_CZASZAK");
        columns.add("PRAC_ID");
        columns.add( "SALA_ID");
        columns.add("DZIEN_ID");
        columns.add("PRZ_ID");
        DBEditor.upDate("zajęcia", jTBLZajecia, columns);

    }

    public void upDateuprawnieniauzytkownikow() {

        ArrayList<String> columns = new ArrayList<>();
        columns.add("UPRUZ_ID");
        columns.add("PRAC_ID");
        columns.add("UPR_ID");
        DBEditor.upDate("uprawnieniaużytkowników", jTBLUprawnieniaPrac, columns);

    }

    public void upDateKlucze() {

        ArrayList<String> columns = new ArrayList<>();
        columns.add("KLUCZ_ID");
        columns.add("KLUCZ_ILOSC");
        columns.add("SALA_ID");
        DBEditor.upDate("klucze", jTBLKlucze, columns);

    }
    private void dodajsaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajsaleActionPerformed

        ArrayList<String> values = new ArrayList<>();
        values.add(JTFNumerSali.getText());
        values.add("1");

        DBEditor.addRecord("sale", "SALA_NUMER,SALA_AKT", "(?,?)", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Dodano Salę");
            upDateSale();
            saleComboBoxes();
        }
    }//GEN-LAST:event_dodajsaleActionPerformed

    private void aktualizujzaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktualizujzaleActionPerformed

        String[] values = new String[10];
        values[0] = JTFNumerSali.getText();

        DBEditor.updateRecord("sale", jTBLSale, "SALA_NUMER = ?", "SALA_ID", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Zaktualizowano");
            upDateSale();
            saleComboBoxes();
        }
    }//GEN-LAST:event_aktualizujzaleActionPerformed

    private void jTBLSaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBLSaleMouseClicked

        int SelectedRow = ValuesChanger.SelectedRow(jTBLSale);
        JTFNumerSali.setText(jTBLSale.getValueAt(SelectedRow, 1).toString());

    }//GEN-LAST:event_jTBLSaleMouseClicked

    private void usunsaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usunsaleActionPerformed

        DBEditor.deleteRecord("sale", jTBLSale, "SALA_AKT", "SALA_ID");
        JOptionPane.showMessageDialog(this, "Usunięto");
        upDateSale();

    }//GEN-LAST:event_usunsaleActionPerformed
    private void saleComboBoxes() {

        combobox.fillWithActivity(jCBSale1, "sale", "SALA_NUMER", "SALA_AKT");
        combobox.fillWithActivity(jCBSale2, "sale", "SALA_NUMER", "SALA_AKT");
        combobox.fillWithActivity(jCBSale3, "sale", "SALA_NUMER", "SALA_AKT");

    }

    private void pracownicyComboBoxes() {

        combobox.fillWithActivity(jCBProwadzacy, "pracownicy", "PRAC_NAZW", "PRAC_AKT");
        combobox.fillWithActivity(jCBPracownik, "pracownicy", "PRAC_NAZW", "PRAC_AKT");

    }

    private void dnitygodniaComboBox() {

        combobox.fill(jCBDzien, "dnitygodnia", "DZIEN_NAZWA");

    }

    private void przedmiotyComboBox() {

        combobox.fill(jCBPrzedmiot, "przedmioty", "PRZ_NAZWA");

    }

    private void uprawnieniaComboBox() {

        combobox.fill(jCBUprawnienia, "uprawnienia", "UPR_OPIS");

    }
    private void dodajprzedmiotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajprzedmiotActionPerformed

        ArrayList<String> values = new ArrayList<>();
        values.add(JTFNazwaPrzedmiotu.getText());
        values.add(JTFSkrotPrzedmiotu.getText());

        DBEditor.addRecord("przedmioty", "PRZ_NAZWA,PRZ_SKROT", "(?,?)", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Dodano Przedmiot");
            upDatePrzedmioty();
            przedmiotyComboBox();
            pracownicyComboBoxes();
        }


    }//GEN-LAST:event_dodajprzedmiotActionPerformed

    private void aktualizujprzedmiotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktualizujprzedmiotActionPerformed

        String[] values = new String[10];
        values[0] = JTFNazwaPrzedmiotu.getText();
        values[1] = JTFSkrotPrzedmiotu.getText();

        DBEditor.updateRecord("przedmioty", jTBLPrzedmioty, "PRZ_NAZWA =?, PRZ_SKROT = ?", "PRZ_ID", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Zaktualizowano");
            upDatePrzedmioty();
            przedmiotyComboBox();
            pracownicyComboBoxes();
        }
    }//GEN-LAST:event_aktualizujprzedmiotActionPerformed

    private void jTBLPrzedmiotyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBLPrzedmiotyMouseClicked

        int SelectedRow = ValuesChanger.SelectedRow(jTBLPrzedmioty);
        JTFNazwaPrzedmiotu.setText(jTBLPrzedmioty.getValueAt(SelectedRow, 1).toString());
        JTFSkrotPrzedmiotu.setText(jTBLPrzedmioty.getValueAt(SelectedRow, 2).toString());

    }//GEN-LAST:event_jTBLPrzedmiotyMouseClicked

    private void dodajpracownikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajpracownikaActionPerformed

        ArrayList<String> values = new ArrayList<>();
        values.add(jTFPracImie.getText());
        values.add(jTFPracNazwisko.getText());
        values.add(jTFPracEmail.getText());
        values.add(jTFPracSkrot.getText());
        values.add("1");

        DBEditor.addRecord("pracownicy", "PRAC_IMIE,PRAC_NAZWISKO, PRAC_EMAIL,PRAC_NAZW,PRAC_AKT", "(?,?,?,?,?)", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Dodano Pracownika");
            upDatePracownicy();
            pracownicyComboBoxes();
        }
    }//GEN-LAST:event_dodajpracownikaActionPerformed

    private void aktualizujpracownikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktualizujpracownikaActionPerformed

        String[] values = new String[10];
        values[0] = jTFPracImie.getText();
        values[1] = jTFPracNazwisko.getText();
        values[2] = jTFPracEmail.getText();
        values[3] = jTFPracSkrot.getText();

        DBEditor.updateRecord("pracownicy", jTBLPracownicy, "PRAC_IMIE =?, PRAC_NAZWISKO = ? , PRAC_EMAIL =?, PRAC_NAZW=?", "PRAC_ID", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Zaktualizowano");
            upDatePracownicy();
            pracownicyComboBoxes();
        }
    }//GEN-LAST:event_aktualizujpracownikaActionPerformed

    private void usunpracownikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usunpracownikaActionPerformed

        DBEditor.deleteRecord("pracownicy", jTBLPracownicy, "PRAC_AKT", "PRAC_ID");
        JOptionPane.showMessageDialog(this, "Usunięto");
        upDatePracownicy();

    }//GEN-LAST:event_usunpracownikaActionPerformed

    private void jTBLPracownicyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBLPracownicyMouseClicked

        int SelectedRow = ValuesChanger.SelectedRow(jTBLPracownicy);
        jTFPracImie.setText(jTBLPracownicy.getValueAt(SelectedRow, 1).toString());
        jTFPracNazwisko.setText(jTBLPracownicy.getValueAt(SelectedRow, 2).toString());
        jTFPracEmail.setText(jTBLPracownicy.getValueAt(SelectedRow, 3).toString());
        jTFPracSkrot.setText(jTBLPracownicy.getValueAt(SelectedRow, 4).toString());
    }//GEN-LAST:event_jTBLPracownicyMouseClicked

    private void dodajprzedmiot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajprzedmiot1ActionPerformed

        String sala = ValuesChanger.OtherToID(jCBSale1, "sale", "SALA_ID", "SALA_NUMER");
        ArrayList<String> values = new ArrayList<>();
        values.add(JTFOpisUprawnienia.getText());
        values.add(sala);

        DBEditor.addRecord("uprawnienia", "UPR_OPIS,SALA_ID", "(?,?)", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Dodano uprawnienie");
            upDateUprawnienia();
            uprawnieniaComboBox();
        }
    }//GEN-LAST:event_dodajprzedmiot1ActionPerformed

    private void updateUprawnieniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUprawnieniaActionPerformed

        String sala = ValuesChanger.OtherToID(jCBSale1, "sale", "SALA_ID", "SALA_NUMER");
        String[] values = new String[10];
        values[0] = JTFOpisUprawnienia.getText();
        values[1] = (sala);

        DBEditor.updateRecord("uprawnienia", jTBLUprawnienia, "UPR_OPIS =?, SALA_ID = ?", "UPR_ID", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Zaktualizowano");
            upDateUprawnienia();
            uprawnieniaComboBox();
        }
    }//GEN-LAST:event_updateUprawnieniaActionPerformed

    private void jTBLUprawnieniaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBLUprawnieniaMouseClicked

        int SelectedRows = ValuesChanger.SelectedRow(jTBLUprawnienia);
        JTFOpisUprawnienia.setText(jTBLUprawnienia.getValueAt(SelectedRows, 1).toString());
        ValuesChanger.IDToOther(jTBLUprawnienia, jCBSale1, "sale", "SALA_ID", "SALA_NUMER", 2);

    }//GEN-LAST:event_jTBLUprawnieniaMouseClicked

    private void dodajprzedmiot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajprzedmiot2ActionPerformed

        String pracownik = ValuesChanger.OtherToID(jCBProwadzacy, "pracownicy", "PRAC_ID", "PRAC_NAZW");
        String sala = ValuesChanger.OtherToID(jCBSale2, "sale", "SALA_ID", "SALA_NUMER");
        String dzien = ValuesChanger.OtherToID(jCBDzien, "dnitygodnia", "DZIEN_ID", "DZIEN_NAZWA");
        String przedmiot = ValuesChanger.OtherToID(jCBPrzedmiot, "przedmioty", "PRZ_ID", "PRZ_NAZWA");
        String czasroz = (String) JCBCzasRozp.getSelectedItem();
        String czaszak = (String) jCBCzasZak.getSelectedItem();

        ArrayList<String> values = new ArrayList<>();
        values.add(czasroz);
        values.add(czaszak);
        values.add(pracownik);
        values.add(sala);
        values.add(dzien);
        values.add(przedmiot);

        DBEditor.addRecord("zajęcia", "ZAJ_CZASROZ,ZAJ_CZASZAK,PRAC_ID,SALA_ID,DZIEN_ID,PRZ_ID", "(?,?,?,?,?,?)", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Dodano Zajęcia");
            upDateZajecia();
        }
    }//GEN-LAST:event_dodajprzedmiot2ActionPerformed

    private void aktualizujprzedmiot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktualizujprzedmiot2ActionPerformed

        int SelectedRow = ValuesChanger.SelectedRow(jTBLZajecia);
        String pracownik = ValuesChanger.OtherToID(jCBProwadzacy, "pracownicy", "PRAC_ID", "PRAC_NAZW");
        String sala = ValuesChanger.OtherToID(jCBSale2, "sale", "SALA_ID", "SALA_NUMER");
        String dzien = ValuesChanger.OtherToID(jCBDzien, "dnitygodnia", "DZIEN_ID", "DZIEN_NAZWA");
        String przedmiot = ValuesChanger.OtherToID(jCBPrzedmiot, "przedmioty", "PRZ_ID", "PRZ_NAZWA");
        jTBLZajecia.setValueAt(pracownik, SelectedRow, 3);
        jTBLZajecia.setValueAt(sala, SelectedRow, 4);
        jTBLZajecia.setValueAt(dzien, SelectedRow, 5);
        jTBLZajecia.setValueAt(przedmiot, SelectedRow, 6);

        String czasroz = (String) JCBCzasRozp.getSelectedItem();
        String czaszak = (String) jCBCzasZak.getSelectedItem();
        String[] values = new String[10];
        values[0] = czasroz;
        values[1] = czaszak;
        values[2] = (String) jTBLZajecia.getValueAt(SelectedRow, 3);
        values[3] = (String) jTBLZajecia.getValueAt(SelectedRow, 4);
        values[4] = (String) jTBLZajecia.getValueAt(SelectedRow, 5);
        values[5] = (String) jTBLZajecia.getValueAt(SelectedRow, 6);

        DBEditor.updateRecord("zajęcia", jTBLZajecia, "ZAJ_CZASROZ =?, ZAJ_CZASZAK = ?, PRAC_ID = ?, SALA_ID = ?, DZIEN_ID=?, PRZ_ID = ?", "ZAJ_ID", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Zaktualizowano");
            upDateZajecia();
        }
    }//GEN-LAST:event_aktualizujprzedmiot2ActionPerformed

    private void jTBLZajeciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBLZajeciaMouseClicked

        int SelectedRow = ValuesChanger.SelectedRow(jTBLZajecia);
        String czasroz = (String) jTBLZajecia.getValueAt(SelectedRow, 1);
        String czaszak = (String) jTBLZajecia.getValueAt(SelectedRow, 2);

        JCBCzasRozp.setSelectedItem(czasroz);
        jCBCzasZak.setSelectedItem(czaszak);

        ValuesChanger.IDToOther(jTBLZajecia, jCBProwadzacy, "pracownicy", "PRAC_ID", "PRAC_NAZW", 3);
        ValuesChanger.IDToOther(jTBLZajecia, jCBSale2, "sale", "SALA_ID", "SALA_NUMER", 4);
        ValuesChanger.IDToOther(jTBLZajecia, jCBDzien, "dnitygodnia", "DZIEN_ID", "DZIEN_NAZWA", 5);
        ValuesChanger.IDToOther(jTBLZajecia, jCBPrzedmiot, "przedmioty", "PRZ_ID", "PRZ_NAZWA", 6);

    }//GEN-LAST:event_jTBLZajeciaMouseClicked

    private void dodajupranieniauzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajupranieniauzActionPerformed

        String pracownik = ValuesChanger.OtherToID(jCBPracownik, "pracownicy", "PRAC_ID", "PRAC_NAZW");
        String uprawnienie = ValuesChanger.OtherToID(jCBUprawnienia, "uprawnienia", "UPR_ID", "UPR_OPIS");

        ArrayList<String> values = new ArrayList<>();
        values.add(pracownik);
        values.add(uprawnienie);

        DBEditor.addRecord("uprawnieniaużytkowników", "PRAC_ID,UPR_ID", "(?,?)", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Dodano Uprawnienie Pracownika");
            upDateuprawnieniauzytkownikow();
        }
    }//GEN-LAST:event_dodajupranieniauzActionPerformed

    private void aktualizujuprawnieniauzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktualizujuprawnieniauzActionPerformed

        int SelectedRows = ValuesChanger.SelectedRow(jTBLUprawnieniaPrac);
        String pracownik = ValuesChanger.OtherToID(jCBPracownik, "pracownicy", "PRAC_ID", "PRAC_NAZW");
        jTBLUprawnieniaPrac.setValueAt(pracownik, SelectedRows, 1);
        String uprawnienie = ValuesChanger.OtherToID(jCBUprawnienia, "uprawnienia", "UPR_ID", "UPR_OPIS");
        jTBLUprawnieniaPrac.setValueAt(uprawnienie, SelectedRows, 2);
        
        String[] values = new String[10];
        values[0] = (String) jTBLUprawnieniaPrac.getValueAt(SelectedRows, 1);
        values[1] = (String) jTBLUprawnieniaPrac.getValueAt(SelectedRows, 2);
        
        DBEditor.updateRecord("uprawnieniaużytkowników", jTBLUprawnieniaPrac, "PRAC_ID =?, UPR_ID = ?", "UPRUZ_ID", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Zaktualizowano");
            upDateuprawnieniauzytkownikow();
        }

    }//GEN-LAST:event_aktualizujuprawnieniauzActionPerformed

    private void jTBLUprawnieniaPracMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBLUprawnieniaPracMouseClicked

        ValuesChanger.IDToOther(jTBLUprawnieniaPrac, jCBPracownik, "pracownicy", "PRAC_ID", "PRAC_NAZW", 1);
        ValuesChanger.IDToOther(jTBLUprawnieniaPrac, jCBUprawnienia, "uprawnienia", "UPR_ID", "UPR_OPIS", 2);

    }//GEN-LAST:event_jTBLUprawnieniaPracMouseClicked

    private void dodajkluczeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajkluczeActionPerformed

        String sala = ValuesChanger.OtherToID(jCBSale3, "sale", "SALA_ID", "SALA_NUMER");
        ArrayList<String> values = new ArrayList<>();
        values.add(jLBOpisKlucza.getText());
        values.add(sala);

        DBEditor.addRecord("klucze", "KLUCZ_ILOSC,SALA_ID", "(?,?)", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Dodano Klucze");
            upDateKlucze();
        }
    }//GEN-LAST:event_dodajkluczeActionPerformed

    private void aktualizujkluczeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktualizujkluczeActionPerformed

        String sala = ValuesChanger.OtherToID(jCBSale3, "sale", "SALA_ID", "SALA_NUMER");
        String[] values = new String[10];
        values[0] = (String) jLBOpisKlucza.getText();
        values[1] = sala;
        
        DBEditor.updateRecord("klucze", jTBLKlucze, "KLUCZ_ILOSC =?,SALA_ID = ?", "KLUCZ_ID", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Zaktualizowano");
            upDateKlucze();
        }
    }//GEN-LAST:event_aktualizujkluczeActionPerformed

    private void jTBLKluczeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBLKluczeMouseClicked

        int SelectedRows = ValuesChanger.SelectedRow(jTBLKlucze);
        jLBOpisKlucza.setText(jTBLKlucze.getValueAt(SelectedRows, 1).toString());
        ValuesChanger.IDToOther(jTBLKlucze, jCBSale3, "sale", "SALA_ID", "SALA_NUMER", 2);

    }//GEN-LAST:event_jTBLKluczeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(BazaDanych.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BazaDanych.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BazaDanych.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BazaDanych.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BazaDanych().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBCzasRozp;
    private javax.swing.JTextField JTFNazwaPrzedmiotu;
    private javax.swing.JTextField JTFNumerSali;
    private javax.swing.JTextField JTFOpisUprawnienia;
    private javax.swing.JTextField JTFSkrotPrzedmiotu;
    private javax.swing.JButton aktualizujklucze;
    private javax.swing.JButton aktualizujpracownika;
    private javax.swing.JButton aktualizujprzedmiot;
    private javax.swing.JButton aktualizujprzedmiot2;
    private javax.swing.JButton aktualizujuprawnieniauz;
    private javax.swing.JButton aktualizujzale;
    private javax.swing.JButton dodajklucze;
    private javax.swing.JButton dodajpracownika;
    private javax.swing.JButton dodajprzedmiot;
    private javax.swing.JButton dodajprzedmiot1;
    private javax.swing.JButton dodajprzedmiot2;
    private javax.swing.JButton dodajsale;
    private javax.swing.JButton dodajupranieniauz;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCBCzasZak;
    private javax.swing.JComboBox<String> jCBDzien;
    private javax.swing.JComboBox<String> jCBPracownik;
    private javax.swing.JComboBox<String> jCBProwadzacy;
    private javax.swing.JComboBox<String> jCBPrzedmiot;
    private javax.swing.JComboBox<String> jCBSale1;
    private javax.swing.JComboBox<String> jCBSale2;
    private javax.swing.JComboBox<String> jCBSale3;
    private javax.swing.JComboBox<String> jCBUprawnienia;
    private javax.swing.JTextField jLBOpisKlucza;
    private javax.swing.JLabel jLUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTBLKlucze;
    private javax.swing.JTable jTBLPracownicy;
    private javax.swing.JTable jTBLPrzedmioty;
    private javax.swing.JTable jTBLSale;
    private javax.swing.JTable jTBLUprawnienia;
    private javax.swing.JTable jTBLUprawnieniaPrac;
    private javax.swing.JTable jTBLZajecia;
    private javax.swing.JTextField jTFPracEmail;
    private javax.swing.JTextField jTFPracImie;
    private javax.swing.JTextField jTFPracNazwisko;
    private javax.swing.JTextField jTFPracSkrot;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton updateUprawnienia;
    private javax.swing.JButton usunpracownika;
    private javax.swing.JButton usunsale;
    // End of variables declaration//GEN-END:variables
}
