/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBUtilities;
import entities.RoomType;
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
public class RoomTypeDAOImpl {

    public static RoomType getRoomTypeById(int id) {
        RoomType type = null;
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getRoomTypeById(?)}");
            cstmt.setInt(1, id);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                type = new RoomType(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return type;
    }

    public static LinkedList<RoomType> getAllRoomTypes() {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        LinkedList<RoomType> list = new LinkedList<>();
        try {
            cstmt = con.prepareCall("{call usp_getAllRoomTypes}");
            rs = cstmt.executeQuery();
            while (rs.next()) {
                RoomType t = new RoomType(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
                list.add(t);
            }
        } catch (SQLException ex) {
            DBUtilities.closeConnection(con, cstmt, null, rs);
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static boolean insertRoomType(RoomType type) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_insertRoomType(?, ?)}");
            cstmt.setString(1, type.getName().toLowerCase());
            cstmt.setFloat(2, (float) type.getPrice());
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean updateRoomType(RoomType type) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_editRoomTypeByName(?, ?, ?)}");
            cstmt.setInt(1, type.getId());
            cstmt.setString(2, type.getName());
            cstmt.setFloat(3, (float) type.getPrice());
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean deleteRoomTypeByName(String name) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_deleteRoomTypeByName(?)}");
            cstmt.setString(1, name.toLowerCase());
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            DBUtilities.closeConnection(con, cstmt, null, null);
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
