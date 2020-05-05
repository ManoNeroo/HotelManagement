/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBUtilities;
import entities.Rights;
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
public class RightsDAOImpl {

    public static Rights getRightsById(int id) {
        Rights rights = null;
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getRightsById(?)}");
            cstmt.setInt(1, id);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                rights = new Rights();
                rights.setId(rs.getInt("id"));
                rights.setName(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RightsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rights;
    }
}
