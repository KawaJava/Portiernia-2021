package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DBEditor {

    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    public String username, password, dataConn;
    readDBConfig readDBConfig = new readDBConfig();
    boolean done = false;

    public DBEditor() {

        readDBConfig.read();
        username = readDBConfig.username;
        password = readDBConfig.password;
        dataConn = readDBConfig.dataConn;

    }

    public void upDate(String DBTable, JTable jTable, ArrayList<String> columns) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn, username, password);
            pst = sqlConn.prepareStatement("select * from " + DBTable);

            rs = pst.executeQuery();
            ResultSetMetaData StData = rs.getMetaData();

            q = StData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel) jTable.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()) {

                Vector columnData = new Vector();

                for (i = 1; i <= q; i++) {

                    for (int o = 0; o < columns.size(); o++) {

                        columnData.add(rs.getString(columns.get(o)));

                    }

                }
                RecordTable.addRow(columnData);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void updateWithAdvancedSQL(String advancedSQL, JTable jTable, ArrayList<String> columns) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn, username, password);
            pst = sqlConn.prepareStatement("" + advancedSQL);

            rs = pst.executeQuery();
            ResultSetMetaData StData = rs.getMetaData();

            q = StData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel) jTable.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()) {

                Vector columnData = new Vector();

                for (i = 1; i <= q; i++) {

                    for (int o = 0; o < columns.size(); o++) {

                        columnData.add(rs.getString(columns.get(o)));

                    }

                }
                RecordTable.addRow(columnData);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void updateWithAdvancedSQLAndWhere(String advancedSQL, JTable jTable, ArrayList<String> columns, ArrayList<String> where) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn, username, password);
            pst = sqlConn.prepareStatement(advancedSQL);
            for (int o = 0; o < where.size(); o++) {

                pst.setString((o+1), where.get(o));

            }

            rs = pst.executeQuery();
            ResultSetMetaData StData = rs.getMetaData();

            q = StData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel) jTable.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()) {

                Vector columnData = new Vector();

                for (i = 1; i <= q; i++) {

                    for (int o = 0; o < columns.size(); o++) {

                        columnData.add(rs.getString(columns.get(o)));

                    }

                }
                RecordTable.addRow(columnData);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void addRecord(String table, String columns, String valuesCounter, ArrayList<String> values) {

        done = false;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn, username, password);
            pst = sqlConn.prepareStatement("insert into " + table + "(" + columns + ") value " + valuesCounter);
            for (int ii = 0; ii < values.size(); ii++) {

                int o = ii + 1;
                pst.setString(o, values.get(ii));

            }
            pst.executeUpdate();
            done = true;

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void updateRecord(String table, JTable jTable, String columns, String IDNum, String[] values) {

        DefaultTableModel RecordTable = (DefaultTableModel) jTable.getModel();
        int SelectedRows = jTable.getSelectedRow();

        try {

            id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
            Class.forName("com.mysql.cj.jdbc.Driver");

            pst = sqlConn.prepareStatement("update " + table + " set " + columns + " where " + IDNum + " =?");
            int o = 0;

            for (int ii = 0; ii < values.length; ii++) {

                o = ii + 1;
                if (values[ii] == null) {
                    pst.setInt(o, id);
                    break;
                }
                pst.setString(o, values[ii]);

            }

            pst.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            java.util.logging.Logger.getLogger(Portiernia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    public void deleteRecord(String table, JTable jTable, String column, String IDNum) {

        DefaultTableModel RecordTable = (DefaultTableModel) jTable.getModel();
        int SelectedRows = jTable.getSelectedRow();

        try {

            id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
            Class.forName("com.mysql.cj.jdbc.Driver");

            sqlConn = DriverManager.getConnection(dataConn, username, password);
            pst = sqlConn.prepareStatement("update " + table + " set " + column + " = ? where " + IDNum + " =?");

            pst.setString(1, "0");
            pst.setInt(2, id);
            pst.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            java.util.logging.Logger.getLogger(Portiernia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    public void deleteRecordHard(String table, JTable jTable, String IDNum) {

        DefaultTableModel RecordTable = (DefaultTableModel) jTable.getModel();
        int SelectedRows = jTable.getSelectedRow();

        try {

            id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
            Class.forName("com.mysql.cj.jdbc.Driver");

            sqlConn = DriverManager.getConnection(dataConn, username, password);
            pst = sqlConn.prepareStatement("delete from " + table + " where " + IDNum + " =?");

            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            java.util.logging.Logger.getLogger(Portiernia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

}
