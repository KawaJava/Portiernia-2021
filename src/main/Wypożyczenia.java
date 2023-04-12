package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
//import com.email.durgesh.Email;
//import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
//import javax.mail.MessagingException;

public class Wypożyczenia extends javax.swing.JFrame {

    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem, dzien, sala, prac;
    String username, password, dataConn, emailAddress, emailPassword;
    String automatemail;
    ComboBox combobox = new ComboBox();
    readDBConfig readDBConfig = new readDBConfig();
    DBEditor DBEditor = new DBEditor();
    ValuesChanger ValuesChanger = new ValuesChanger();

    public Wypożyczenia() {
        setup();
    }

    public Wypożyczenia(String namenazw) {

        setup();
        jLBUser.setText(namenazw);

    }
    public void setup(){
                
        initComponents();
        readDBConfig.read();
        readDBConfig.readEmailAndPassword();
        username = readDBConfig.username;
        password = readDBConfig.password;
        dataConn = readDBConfig.dataConn;
        emailAddress = readDBConfig.emailAddress;
        emailPassword = readDBConfig.emailPassword;
        updateDzisiejszeZajeciaWSali();
        salepolecombii();
        pracownicypolecombii();
        showDate();
        showTime();
        upDateWyp();
        dziswyp();
        wczytemail();
    }

    public void wczytemail() {

        automatemail = readDBConfig.automatEmail();

    }

    public void dziswyp() {

        ArrayList<String> columns = new ArrayList<>();
        ArrayList<String> where = new ArrayList<>();
        where.add(jLBDate.getText());
        columns.add("PRAC_NAZW");
        columns.add("SALA_NUMER");
        columns.add("WYP_CZASWYD");
        columns.add("WYP_CZASOD");

        String advancedSQL = "SELECT WYPOŻYCZENIA.WYP_ID, PRACOWNICY.PRAC_NAZW, SALE.SALA_NUMER, WYPOŻYCZENIA.WYP_CZASWYD, WYPOŻYCZENIA.WYP_CZASOD\n"
                + "FROM PRACOWNICY INNER JOIN (SALE INNER JOIN WYPOŻYCZENIA ON SALE.SALA_ID = WYPOŻYCZENIA.SALA_ID) ON PRACOWNICY.PRAC_ID = WYPOŻYCZENIA.PRAC_ID\n"
                + "WHERE (((WYPOŻYCZENIA.WYP_DATA)=?));";
        DBEditor.updateWithAdvancedSQLAndWhere(advancedSQL, jTBLDzisiejszeWypozyczenia, columns, where);

    }

    private void salepolecombii() {

        combobox.fillWithActivity(jCBSale, "sale", "SALA_NUMER", "SALA_AKT");

    }

    private void pracownicypolecombii() {

        combobox.fillWithActivity(jCBPracownik, "pracownicy", "PRAC_NAZW", "PRAC_AKT");

    }

    public void update() {

        String s1 = jLBTime.getText();
        int czaster = ValuesChanger.Time(s1);
        
        String dzienID = ValuesChanger.OtherToID(jCBDzien, "dnitygodnia", "DZIEN_ID", "DZIEN_NAZWA");
        String pracownikID = ValuesChanger.OtherToID(jCBPracownik, "pracownicy", "PRAC_ID", "PRAC_NAZW");
        
        ArrayList<String> columns = new ArrayList<>();
        ArrayList<String> where = new ArrayList<>();
        columns.add("PRZEDMIOTY.PRZ_NAZWA");
        columns.add("ZAJĘCIA.ZAJ_CZASROZ");
        columns.add("ZAJĘCIA.ZAJ_CZASZAK");
        columns.add("SALE.SALA_NUMER");
        where.add(pracownikID);
        where.add(dzienID);

        String advancedSQL = "SELECT PRZEDMIOTY.PRZ_NAZWA, ZAJĘCIA.ZAJ_CZASROZ, ZAJĘCIA.ZAJ_CZASZAK, SALE.SALA_NUMER\n"
                    + "FROM DNITYGODNIA INNER JOIN (PRACOWNICY INNER JOIN (SALE INNER JOIN (PRZEDMIOTY INNER JOIN ZAJĘCIA ON PRZEDMIOTY.PRZ_ID = ZAJĘCIA.PRZ_ID) ON SALE.SALA_ID = ZAJĘCIA.SALA_ID) ON PRACOWNICY.PRAC_ID = ZAJĘCIA.PRAC_ID) ON DNITYGODNIA.DZIEN_ID = ZAJĘCIA.DZIEN_ID\n"
                    + "WHERE (((PRACOWNICY.PRAC_ID)=?) AND ((DNITYGODNIA.DZIEN_ID)=?));";
        DBEditor.updateWithAdvancedSQLAndWhere(advancedSQL, jTBLDzisiejszeZajeciaPrac, columns, where);

        int rowcount = jTBLDzisiejszeZajeciaPrac.getRowCount();
        DefaultTableModel model = (DefaultTableModel) jTBLDzisiejszeZajeciaPrac.getModel();
        for (int i = 0; i < rowcount; i++) {
            
            String czaszajec = (String) jTBLDzisiejszeZajeciaPrac.getValueAt(i, 1);
            int czaszaj = ValuesChanger.Time(czaszajec)-600;

            if (czaster > czaszaj) {

                model.removeRow(i);
                i--;
                rowcount--;
                
            }
        }
    }

    public void updateDzisiejszeZajeciaWSali() {

        String dzienID = ValuesChanger.OtherToID(jCBDzien, "dnitygodnia", "DZIEN_ID", "DZIEN_NAZWA");
        String salaID = ValuesChanger.OtherToID(jCBSale, "sale", "SALA_ID", "SALA_NUMER");
                
        ArrayList<String> columns = new ArrayList<>();
        ArrayList<String> where = new ArrayList<>();
        columns.add("PRZEDMIOTY.PRZ_NAZWA");
        columns.add("ZAJĘCIA.ZAJ_CZASROZ");
        columns.add("ZAJĘCIA.ZAJ_CZASZAK");
        columns.add("PRACOWNICY.PRAC_NAZW");
        where.add(dzienID);
        where.add(salaID);

        String advancedSQL = "SELECT PRZEDMIOTY.PRZ_NAZWA, ZAJĘCIA.ZAJ_CZASROZ, ZAJĘCIA.ZAJ_CZASZAK, PRACOWNICY.PRAC_NAZW, DNITYGODNIA.DZIEN_ID, SALE.SALA_ID\n"
                    + "FROM SALE INNER JOIN (PRZEDMIOTY INNER JOIN (PRACOWNICY INNER JOIN (DNITYGODNIA INNER JOIN ZAJĘCIA ON DNITYGODNIA.DZIEN_ID = ZAJĘCIA.DZIEN_ID) ON PRACOWNICY.PRAC_ID = ZAJĘCIA.PRAC_ID) ON PRZEDMIOTY.PRZ_ID = ZAJĘCIA.PRZ_ID) ON SALE.SALA_ID = ZAJĘCIA.SALA_ID\n"
                    + "WHERE (((DNITYGODNIA.DZIEN_ID)=?) AND ((SALE.SALA_ID)=?));";
        DBEditor.updateWithAdvancedSQLAndWhere(advancedSQL, jTBLDzisiejszeZajeciaWSali, columns, where);

    }

    public void uprawnieniadosalComboBox() {

        String pracownik = (String) jCBPracownik.getSelectedItem();
        String SQL = "SELECT SALE.SALA_NUMER, uprawnieniaużytkowników.UPRUZ_ID, uprawnieniaużytkowników.UPR_ID, PRACOWNICY.PRAC_NAZW\n"
                    + "FROM PRACOWNICY INNER JOIN ((SALE INNER JOIN UPRAWNIENIA ON SALE.SALA_ID = UPRAWNIENIA.SALA_ID) INNER JOIN uprawnieniaużytkowników ON UPRAWNIENIA.UPR_ID = uprawnieniaużytkowników.UPR_ID) ON PRACOWNICY.PRAC_ID = uprawnieniaużytkowników.PRAC_ID WHERE (((PRACOWNICY.PRAC_NAZW)=?));";
        combobox.fillWithAdvancedSQL(jCBSale, "SALE.SALA_NUMER", SQL, pracownik);

    }

    public void termin() {
//        String s1 = jLBTime.getText();
//        String[] hourMin = s1.split(":");
//        int hour = Integer.parseInt(hourMin[0]);
//        int mins = Integer.parseInt(hourMin[1]);
//        int sec = Integer.parseInt(hourMin[2]);
//        int hoursInSec = hour * 3600;
//        int minInSec = mins * 60;
//        int czaster = hoursInSec + minInSec + sec;
//        if (sec == 00) {
//            try {
//
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                sqlConn = DriverManager.getConnection(dataConn, username, password);
//                pst = sqlConn.prepareStatement("SELECT WYPOŻYCZENIA.WYP_ID, WYPOŻYCZENIA.WYP_TERMIN, PRACOWNICY.PRAC_NAZW, SALE.SALA_NUMER, PRACOWNICY.PRAC_EMAIL\n"
//                        + "FROM SALE INNER JOIN (PRACOWNICY INNER JOIN WYPOŻYCZENIA ON PRACOWNICY.PRAC_ID = WYPOŻYCZENIA.PRAC_ID) ON SALE.SALA_ID = WYPOŻYCZENIA.SALA_ID\n"
//                        + "WHERE (((WYPOŻYCZENIA.WYP_CZASOD) Is Null) AND ((WYPOŻYCZENIA.WYP_POW)=0));");
//
//                rs = pst.executeQuery();
//                ResultSetMetaData StData = rs.getMetaData();
//
//                q = StData.getColumnCount();
//
//                while (rs.next()) {
//
//                    Vector columnData = new Vector();
//
//                    String czasoddania = rs.getString("WYP_TERMIN");
//                    String[] hourMin1 = czasoddania.split(":");
//                    int hour1 = Integer.parseInt(hourMin1[0]);
//                    int mins1 = Integer.parseInt(hourMin1[1]);
//                    int sec1 = Integer.parseInt(hourMin1[2]);
//                    int hoursInSec1 = hour1 * 3600;
//                    int minInSec1 = mins1 * 60;
//                    int czasnaoddanie = hoursInSec1 + minInSec1 + sec1;
//                    String tak = "Tak";
//                    if (czasnaoddanie <= czaster && automatemail.equalsIgnoreCase(tak)) {
//                        //sendemail
//                        try {
//                            String adres = rs.getString("PRAC_EMAIL");
//                            String prac = rs.getString("PRAC_NAZW");
//                            String sala = rs.getString("SALA_NUMER");
//                            Email email = new Email(emailAddress, emailPassword);
//                            email.setFrom("portierniatest@gmail.com", "portiernia");
//                            email.setSubject("Prośba o oddanie kluczy");
//                            email.setContent("Witamy," + "<br>" + "<br>" + "Uprzejmie prosimy o oddanie kluczy do sali " + sala + "." + "<br>" + "<br>"
//                                    + "Pozdrawiamy," + "<br>" + "Portiernia", "text/html");
//                            String od7 = adres;
//                            email.addRecipient(adres);
//                            email.send();
//                            String id = rs.getString("WYP_ID");
//                            sqlConn = DriverManager.getConnection(dataConn, username, password);
//                            pst = sqlConn.prepareStatement("update wypożyczenia set WYP_POW =1 where WYP_ID =?");
//
//                            pst.setString(1, id);
//                            pst.executeUpdate();
//                            JOptionPane.showMessageDialog(this, "Wysłano powiadomienie do "+ prac+ " z prośbą o oddanie kluczy do sali " + sala);
//
//                        } catch (UnsupportedEncodingException ex) {
//                            ex.printStackTrace();
//                        }
//
//                    }
//                    upDateWyp();
//
//                }
//
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, ex);
//            }
//        }
    }

    public void upDateWyp() {

        ArrayList<String> columns = new ArrayList<>();
        ArrayList<String> where = new ArrayList<>();
        columns.add("WYP_ID");
        columns.add("PRAC_NAZW");
        columns.add("SALA_NUMER");
        columns.add("WYP_DATA");
        columns.add("WYP_CZASWYD");
        columns.add("WYP_CZASOD");
        columns.add("WYP_TERMIN");
        columns.add("WYP_POW");
        where.add((String) jCBPracownik.getSelectedItem());

        String advancedSQL = "SELECT WYPOŻYCZENIA.WYP_ID, PRACOWNICY.PRAC_NAZW, SALE.SALA_NUMER, WYPOŻYCZENIA.WYP_DATA, WYPOŻYCZENIA.WYP_CZASWYD, WYPOŻYCZENIA.WYP_CZASOD, WYPOŻYCZENIA.WYP_TERMIN, WYPOŻYCZENIA.WYP_POW\n"
                + "FROM SALE INNER JOIN (PRACOWNICY INNER JOIN WYPOŻYCZENIA ON PRACOWNICY.PRAC_ID = WYPOŻYCZENIA.PRAC_ID) ON SALE.SALA_ID = WYPOŻYCZENIA.SALA_ID\n"
                + "WHERE (((PRACOWNICY.PRAC_NAZW)=?) AND ((WYPOŻYCZENIA.WYP_CZASOD) Is Null) );";
        DBEditor.updateWithAdvancedSQLAndWhere(advancedSQL, jTBLAktualnieWypozyczoneKlucze, columns, where);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTBLDzisiejszeZajeciaPrac = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jBTNWydajKluczNaZajecia = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTBLDzisiejszeZajeciaWSali = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCBSale = new javax.swing.JComboBox<>();
        jBTNWydajKluczDoSali = new javax.swing.JButton();
        jBTNWczytajZajecia = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jBTNOdbierzKlucz = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTBLAktualnieWypozyczoneKlucze = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jBTNDrukuj = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTBLDzisiejszeWypozyczenia = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLBDate = new javax.swing.JLabel();
        jLBTime = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLBUser = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCBDzien = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jCBPracownik = new javax.swing.JComboBox<>();
        JBTNWczytajUprawnieniaPracownika = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1200, 550));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTBLDzisiejszeZajeciaPrac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Przedmiot", "Czas ropoczęcia", "Czas zakończenia", "Sala"
            }
        ));
        jScrollPane1.setViewportView(jTBLDzisiejszeZajeciaPrac);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Dzisiejsze zajęcia pracownika:");

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jBTNWydajKluczNaZajecia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBTNWydajKluczNaZajecia.setText("Wydaj klucz na najbliższe zajęcia");
        jBTNWydajKluczNaZajecia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNWydajKluczNaZajeciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBTNWydajKluczNaZajecia)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBTNWydajKluczNaZajecia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Wydawanie kluczy na zajęcia", jPanel6);

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTBLDzisiejszeZajeciaWSali.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Przedmiot", "Czas rozpoczęcia", "Czas zakończenia", "Prowadzący"
            }
        ));
        jScrollPane2.setViewportView(jTBLDzisiejszeZajeciaWSali);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Dzisiejsze zajęcia w tej sali:");

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Sala:");

        jCBSale.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCBSale.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBSale.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBSaleItemStateChanged(evt);
            }
        });
        jCBSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCBSaleMouseClicked(evt);
            }
        });
        jCBSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBSaleActionPerformed(evt);
            }
        });

        jBTNWydajKluczDoSali.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBTNWydajKluczDoSali.setText("Wydaj klucz do sali");
        jBTNWydajKluczDoSali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNWydajKluczDoSaliActionPerformed(evt);
            }
        });

        jBTNWczytajZajecia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBTNWczytajZajecia.setText("Wczytaj zajęcia w wybranej sali");
        jBTNWczytajZajecia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNWczytajZajeciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jBTNWczytajZajecia)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jCBSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBTNWydajKluczDoSali))
                        .addContainerGap())))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addComponent(jBTNWczytajZajecia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jBTNWydajKluczDoSali)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(72, 72, 72))))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Wydawanie kluczy do sal", jPanel7);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Wydawanie kluczy", jPanel1);

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jBTNOdbierzKlucz.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBTNOdbierzKlucz.setText("Odbierz klucz");
        jBTNOdbierzKlucz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNOdbierzKluczActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBTNOdbierzKlucz)
                .addGap(222, 222, 222))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBTNOdbierzKlucz)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTBLAktualnieWypozyczoneKlucze.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID WYPOŻYCZENIA", "PRACOWNIK", "NUMER SALI", "DATA WYDANIA", "CZAS WYDANIA", "CZAS ODDANIA", "TERMIN", "POWIADOMIENIE"
            }
        ));
        jScrollPane3.setViewportView(jTBLAktualnieWypozyczoneKlucze);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 314, Short.MAX_VALUE))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Odbieranie kluczy", jPanel2);

        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jBTNDrukuj.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBTNDrukuj.setText("Drukuj");
        jBTNDrukuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNDrukujActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBTNDrukuj)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBTNDrukuj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jTBLDzisiejszeWypozyczenia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRACOWNIK", "NUMER_SALI", "CZAS_WYDANIA", "CZAS_ODDANIA"
            }
        ));
        jScrollPane4.setViewportView(jTBLDzisiejszeWypozyczenia);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(295, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 194, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dzisiejsze wypożyczenia", jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jLBDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLBTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Zalogowany jako:");

        jLBUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Wyloguj");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLBUser, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLBDate, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLBTime, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLBUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLBDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLBTime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 8));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Dzisiaj mamy zajęcia wg. planu z dnia:");

        jCBDzien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCBDzien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela" }));
        jCBDzien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBDzienActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Pracownik:");

        jCBPracownik.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCBPracownik.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBPracownik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBPracownikActionPerformed(evt);
            }
        });

        JBTNWczytajUprawnieniaPracownika.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JBTNWczytajUprawnieniaPracownika.setText("Wczytaj zajęcia");
        JBTNWczytajUprawnieniaPracownika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNWczytajUprawnieniaPracownikaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBDzien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jCBPracownik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(JBTNWczytajUprawnieniaPracownika)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCBPracownik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(JBTNWczytajUprawnieniaPracownika))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jCBDzien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCBDzienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDzienActionPerformed

    }//GEN-LAST:event_jCBDzienActionPerformed

    private void jCBPracownikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBPracownikActionPerformed

    }//GEN-LAST:event_jCBPracownikActionPerformed

    private void JBTNWczytajUprawnieniaPracownikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNWczytajUprawnieniaPracownikaActionPerformed

        uprawnieniadosalComboBox();
        update();
        updateDzisiejszeZajeciaWSali();
        uprawnieniadosalComboBox();
        upDateWyp();

    }//GEN-LAST:event_JBTNWczytajUprawnieniaPracownikaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBTNWydajKluczNaZajeciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNWydajKluczNaZajeciaActionPerformed

        String pracID = ValuesChanger.OtherToID(jCBPracownik, "pracownicy", "PRAC_ID", "PRAC_NAZW");
        String salaID = ValuesChanger.OtherToID(jCBSale, "sale", "SALA_ID", "SALA_NUMER");
        ArrayList<String> values = new ArrayList<>();
        values.add(pracID);
        values.add(salaID);
        values.add(jLBDate.getText());
        values.add(jLBTime.getText());
        values.add(null);
        values.add((String) jTBLDzisiejszeZajeciaPrac.getValueAt(0, 2));
        values.add("0");
        DBEditor.addRecord("wypożyczenia", "PRAC_ID,SALA_ID, WYP_DATA,WYP_CZASWYD,WYP_CZASOD,WYP_TERMIN,WYP_POW", "(?,?,?,?,?,?,?)", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Wypożyczono klucze");
            upDateWyp();
            dziswyp();
        }

    }//GEN-LAST:event_jBTNWydajKluczNaZajeciaActionPerformed

    private void jBTNWczytajZajeciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNWczytajZajeciaActionPerformed

        updateDzisiejszeZajeciaWSali();
    }//GEN-LAST:event_jBTNWczytajZajeciaActionPerformed

    private void jBTNOdbierzKluczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNOdbierzKluczActionPerformed

        int SelectedRow = ValuesChanger.SelectedRow(jTBLAktualnieWypozyczoneKlucze);
        String pracownik = (String) jTBLAktualnieWypozyczoneKlucze.getValueAt(SelectedRow, 1);
        String numersali = (String) jTBLAktualnieWypozyczoneKlucze.getValueAt(SelectedRow, 2);
        
        String[] values = new String[10];
        values[0] = jLBTime.getText();

        DBEditor.updateRecord("wypożyczenia", jTBLAktualnieWypozyczoneKlucze, "WYP_CZASOD =?", " WYP_ID ", values);
        if (DBEditor.done = true) {
            JOptionPane.showMessageDialog(this, "Odebrano klucze od: " + pracownik + " do sali: " + numersali);
            upDateWyp();
            dziswyp();
        }

    }//GEN-LAST:event_jBTNOdbierzKluczActionPerformed

    private void jBTNDrukujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNDrukujActionPerformed

        MessageFormat header = new MessageFormat("WYPOŻYCZENIA Z DNIA: " + dzien);
        MessageFormat footer = new MessageFormat("Page {0, number, integer}");

        try {
            jTBLDzisiejszeWypozyczenia.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (java.awt.print.PrinterException e) {
            java.lang.System.err.format("No Printer found", e.getMessage());
        }
    }//GEN-LAST:event_jBTNDrukujActionPerformed

    private void jBTNWydajKluczDoSaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNWydajKluczDoSaliActionPerformed

        String pracID = ValuesChanger.OtherToID(jCBPracownik, "pracownicy", "PRAC_ID", "PRAC_NAZW");
        String salaID = ValuesChanger.OtherToID(jCBSale, "sale", "SALA_ID", "SALA_NUMER");

        String czasnazwrot = "20:00:00";

        int rowcount = jTBLDzisiejszeZajeciaWSali.getRowCount();
        if (rowcount > 0) {
            czasnazwrot = (String) jTBLDzisiejszeZajeciaWSali.getValueAt(0, 1);
        }

        ArrayList<String> values = new ArrayList<>();
        values.add(pracID);
        values.add(salaID);
        values.add(jLBDate.getText());
        values.add(jLBTime.getText());
        values.add(null);
        values.add(czasnazwrot);
        values.add("0");

        DBEditor.addRecord("wypożyczenia", "PRAC_ID,SALA_ID, WYP_DATA,WYP_CZASWYD,WYP_CZASOD,WYP_TERMIN,WYP_POW", "(?,?,?,?,?,?,?)", values);
        JOptionPane.showMessageDialog(this, "Wypożyczono klucze");
        upDateWyp();
        dziswyp();
    }//GEN-LAST:event_jBTNWydajKluczDoSaliActionPerformed

    private void jCBSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBSaleActionPerformed

    }//GEN-LAST:event_jCBSaleActionPerformed

    private void jCBSaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBSaleMouseClicked

    }//GEN-LAST:event_jCBSaleMouseClicked

    private void jCBSaleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBSaleItemStateChanged

    }//GEN-LAST:event_jCBSaleItemStateChanged

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
            java.util.logging.Logger.getLogger(Wypożyczenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wypożyczenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wypożyczenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wypożyczenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wypożyczenia().setVisible(true);
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
                //termin();

            }
        }
        ).start();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNWczytajUprawnieniaPracownika;
    private javax.swing.JButton jBTNDrukuj;
    private javax.swing.JButton jBTNOdbierzKlucz;
    private javax.swing.JButton jBTNWczytajZajecia;
    private javax.swing.JButton jBTNWydajKluczDoSali;
    private javax.swing.JButton jBTNWydajKluczNaZajecia;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCBDzien;
    private javax.swing.JComboBox<String> jCBPracownik;
    private javax.swing.JComboBox<String> jCBSale;
    private javax.swing.JLabel jLBDate;
    private javax.swing.JLabel jLBTime;
    private javax.swing.JLabel jLBUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JTable jTBLAktualnieWypozyczoneKlucze;
    private javax.swing.JTable jTBLDzisiejszeWypozyczenia;
    private javax.swing.JTable jTBLDzisiejszeZajeciaPrac;
    private javax.swing.JTable jTBLDzisiejszeZajeciaWSali;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
