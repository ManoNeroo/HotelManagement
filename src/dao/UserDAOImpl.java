/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBUtilities;
import entities.Rights;
import entities.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trinh
 */
public class UserDAOImpl {
    public static User getUserById(String id) {
        User user = null;
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getUserById(?)}");
            cstmt.setString(1, id);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));
                Rights r = RightsDAOImpl.getRightsById(rs.getInt("rightsId"));
                user.setRights(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
