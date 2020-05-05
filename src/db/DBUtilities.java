/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.Welcome;

/**
 *
 * @author trinh
 */
public class DBUtilities {

    public static String readUrlFromFileConfig() {
        String url = null;
        try {
            File dir = new File("config");
            if (dir.exists()) {
                File f = new File("config\\config.properties");
                if (f.exists()) {
                    Properties p = new Properties();
                    FileInputStream fin = new FileInputStream(f);
                    p.load(fin);
                    url = p.getProperty("url");
                    fin.close();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
        return url;
    }

    public static Connection openConnection() {
        String url = readUrlFromFileConfig();
        if (url != null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                return DriverManager.getConnection(url);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public static boolean testConnection(String url) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            if (DriverManager.getConnection(url) != null) {
                return true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void closeConnection(Connection con, CallableStatement cstmt, PreparedStatement pstmt, ResultSet rs) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (cstmt != null) {
            try {
                cstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
