package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JRadioButton;


public class readDBConfig {

    String username, password, dataConn, emailAddress, emailPassword;

    public void read() {

        BufferedReader bReader = null;

        try {

            bReader = new BufferedReader(new FileReader("textfile.txt"));
            String v[] = new String[3];

            try {
                Object[] lines = bReader.lines().toArray();

                for (int i = 0; i < lines.length; i++) {
                    v[i] = (String) lines[i];
                }

                username = v[0];
                password = v[1];
                dataConn = v[2];

            } catch (Exception ex) { }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void readEmail(JRadioButton jRBYes, JRadioButton jRBNo) {

        BufferedReader d = null;

        try {

            d = new BufferedReader(new FileReader("email.txt"));

            try {

                Object[] lines = d.lines().toArray();
                String emailsend;
                String tak = "Tak";

                emailsend = (String) lines[0];
                if (emailsend.equals(tak)) {
                    jRBYes.setSelected(true);
                } else {
                    jRBNo.setSelected(true);
                }

            } catch (Exception ex) {
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                d.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public String automatEmail() {

        String automatEmail = "";
        BufferedReader d = null;
        try {
            d = new BufferedReader(new FileReader("email.txt"));

            try {
                
                Object[] lines = d.lines().toArray();
                automatEmail = (String) lines[0];

            } catch (Exception ex) {
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                d.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return automatEmail;

    }

    public void write(String file, String text) {

        file = "email.txt";

        try {

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();
            fw.close();

        } catch (IOException ex) {
        }

    }
    public void readEmailAndPassword() {

        BufferedReader bReader = null;

        try {

            bReader = new BufferedReader(new FileReader("email-dane.txt"));
            String v[] = new String[3];

            try {
                Object[] lines = bReader.lines().toArray();

                for (int i = 0; i < lines.length; i++) {
                    v[i] = (String) lines[i];
                }

                emailAddress = v[0];
                emailPassword = v[1];

            } catch (Exception ex) { }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
