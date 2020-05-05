/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entities.Rights;
import entities.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
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
public class Auth {

    private User user;

    public Auth() {
        this.user = getUserByConfig();
    }

    private User getUserByConfig() {
        Connection con = DBUtilities.openConnection();
        User u = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        if (con != null) {
            String userId = getUserIdFromConfig();
            if (userId != null) {
                try {
                    cstmt = con.prepareCall("{call usp_getUserById(?)}");
                    cstmt.setString(1, userId);
                    rs = cstmt.executeQuery();
                    int rightsId = 0;
                    while (rs.next()) {
                        u = new User(rs.getString("id"), rs.getString("userName"), rs.getString("password"), rs.getString("fullName"));
                        rightsId = rs.getInt("rightsId");
                    }
                    if (rightsId != 0) {
                        cstmt = con.prepareCall("{call usp_getRightsById(?)}");
                        cstmt.setInt(1, rightsId);
                        rs = cstmt.executeQuery();
                        while (rs.next()) {
                            Rights r = new Rights(rs.getInt("id"), rs.getString("name"));
                            u.setRights(r);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
                    DBUtilities.closeConnection(con, cstmt, null, rs);
                }
            }
        }
        return u;
    }

    private String getUserIdFromConfig() {
        String id = null;
        try {
            File dir = new File("config");
            if (dir.exists()) {
                File f = new File("config\\config.properties");
                if (f.exists()) {
                    Properties p = new Properties();
                    FileInputStream fin = new FileInputStream(f);
                    p.load(fin);
                    if (p.containsKey("userId")) {
                        id = p.getProperty("userId");
                    }
                    fin.close();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public User getUser() {
        return user;
    }
}
