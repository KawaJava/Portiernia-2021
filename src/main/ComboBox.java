package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;

public class ComboBox {

    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    String username, password, dataConn;
    readDBConfig readDBConfig = new readDBConfig();
    
    public ComboBox(){
        
        readDBConfig.read();
        username = readDBConfig.username;
        password = readDBConfig.password;
        dataConn = readDBConfig.dataConn;
        
    }
    

    public void fill(JComboBox combobox, String tableName, String col) {
        
        combobox.removeAllItems();
        
        try {

            sqlConn = DriverManager.getConnection(dataConn, username, password);
            String sql = "select* from " + tableName;
            pst = sqlConn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                String name = rs.getString(col);
                combobox.addItem(name);
            }
            
        } catch (Exception e) {

        }
    }
    
    public void fillWithActivity(JComboBox combobox, String tableName, String col, String colWithActivity) {
        
        combobox.removeAllItems();
        
        try {

            sqlConn = DriverManager.getConnection(dataConn, username, password);
            String sql = "select* from " + tableName + " where " + colWithActivity + " = 1";
            pst = sqlConn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                String name = rs.getString(col);
                combobox.addItem(name);
            }
            
        } catch (Exception e) {

        }
        
    }
    
    public void fillWithAdvancedSQL(JComboBox combobox, String col, String AdvancedSQL, String where){
        
        combobox.removeAllItems();
       
        try {
            pst = sqlConn.prepareStatement(AdvancedSQL);
            pst.setString(1, where);

            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString(col);
                combobox.addItem(name);
            }
        } catch (Exception e) {

        }
        
    }

}
