package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ValuesChanger {

    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    public String username, password, dataConn;
    readDBConfig readDBConfig = new readDBConfig();
    public String otherValue;

    public ValuesChanger() {

        readDBConfig.read();
        username = readDBConfig.username;
        password = readDBConfig.password;
        dataConn = readDBConfig.dataConn;

    }

    public void IDToOther(JTable jTable, JComboBox jCombobox, String table, String IDColumnName, String OtherColumnName, int col) {
        
        DefaultTableModel RecordTable = (DefaultTableModel) jTable.getModel();
        int SelectedRows = jTable.getSelectedRow();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn, username, password);
            String b = RecordTable.getValueAt(SelectedRows, col).toString();
            String sql = "select* from " + table;
            pst = sqlConn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString(IDColumnName);
                String nazwa = rs.getString(OtherColumnName);
                if (b.equals(name)) {
                    otherValue = nazwa;
                    jCombobox.setSelectedItem(otherValue);
                }
            }
            
        } catch (Exception e) {

        }
        

    }
    
    public String OtherToID(JComboBox jCombobox, String table, String IDColumnName, String OtherColumnName){
        
        String OtherToID = "";
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn, username, password);
            String b = (String) jCombobox.getSelectedItem();
            String sql = "select* from " + table;
            pst = sqlConn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString(IDColumnName);
                String nazwa = rs.getString(OtherColumnName);
                if (b.equals(nazwa)) {
                    OtherToID = name;
                }
            }
        } catch (Exception e) {

        }
        return OtherToID;
        
    }
    
    public int SelectedRow(JTable table){
        
        int SelectedRow = 0;
        
        DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
        SelectedRow = table.getSelectedRow();
        
        return SelectedRow;
        
    }
    
    public int Time(String s1){
        
        String[] hourMin = s1.split(":");
        int hour = Integer.parseInt(hourMin[0]);
        int mins = Integer.parseInt(hourMin[1]);
        int sec = Integer.parseInt(hourMin[2]);
        int hoursInSec = hour * 3600;
        int minInSec = mins * 60;
        int Time = hoursInSec + minInSec + sec;
        return Time;
        
    }

}
