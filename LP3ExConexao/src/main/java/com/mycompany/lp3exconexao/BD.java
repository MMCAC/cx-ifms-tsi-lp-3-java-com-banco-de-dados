package com.mycompany.lp3exconexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BD {
    public Connection connection = null;
    final String DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DBNAME = "bancoMySQL";
    final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
    final String LOGIN = "root";
    final String SENHA = "1234";

    public boolean getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, LOGIN, SENHA);
            return true;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado.\n"
                    + ex.toString());
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema com o BD: "
                    + ex.toString());
            return false;
        }
    }
    
    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema no fechamento da Conexão "
                    + ex.toString());
        }
    }
}
