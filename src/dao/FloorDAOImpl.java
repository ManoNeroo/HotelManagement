/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBUtilities;
import entities.Floor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.MainView;

/**
 *
 * @author trinh
 */
public class FloorDAOImpl {

    public static LinkedList<Floor> getAllFloors() {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        LinkedList<Floor> list = new LinkedList<>();
        try {
            cstmt = con.prepareCall("{call usp_getAllFloors}");
            rs = cstmt.executeQuery();
            while (rs.next()) {
                Floor f = new Floor(rs.getInt("id"), rs.getString("name"));
                list.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static Floor getFloorById(int id) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Floor f = null;
        try {
            cstmt = con.prepareCall("{call usp_getFloorById(?)}");
            cstmt.setInt(1, id);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                f = new Floor(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }

        return f;
    }
    public static boolean deleteFloorByName(String name) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_deleteFloorByName(?)}");
            cstmt.setString(1, name);
            if(cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            DBUtilities.closeConnection(con, cstmt, null, null);
            Logger.getLogger(FloorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static boolean insertFloor(Floor f) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_insertFloor(?)}");
            cstmt.setString(1, f.getName());
            if(cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            DBUtilities.closeConnection(con, cstmt, null, null);
            Logger.getLogger(FloorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
