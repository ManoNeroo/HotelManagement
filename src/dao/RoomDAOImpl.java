/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.FloorDAOImpl.getFloorById;
import static dao.RoomTypeDAOImpl.getRoomTypeById;
import db.DBUtilities;
import entities.Floor;
import entities.Room;
import entities.RoomType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trinh
 */
public class RoomDAOImpl {
    public static LinkedList<Room> getUsingRooms() {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        LinkedList<Room> list = new LinkedList<>();
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getUsingRooms}");
            rs = cstmt.executeQuery();
            while(rs.next()) {
                Room r = new Room();
                r.setId(rs.getString("id"));
                r.setName(rs.getString("name"));
                RoomType roomType = RoomTypeDAOImpl.getRoomTypeById(rs.getInt("roomTypeId"));
                r.setRoomType(roomType);
                Floor floor = FloorDAOImpl.getFloorById(rs.getInt("floorId"));
                r.setFloor(floor);
                r.setStatus(rs.getShort("status"));
                r.setCreatedAt(rs.getDate("createdAt"));
                list.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static LinkedList<Room> getAllRooms() {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        LinkedList<Room> list = new LinkedList<>();
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getAllRooms}");
            rs = cstmt.executeQuery();
            while (rs.next()) {
                Room r = new Room(rs.getString("id"), rs.getString("name"), rs.getShort("status"));
                RoomType t = getRoomTypeById(rs.getInt("roomTypeId"));
                r.setRoomType(t);
                Floor f = getFloorById(rs.getInt("floorId"));
                r.setFloor(f);
                list.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static boolean insertRoom(Room room) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_insertRoom(?, ?, ?, ?, ?)}");
            cstmt.setString(1, room.getId());
            cstmt.setString(2, room.getName());
            cstmt.setShort(3, room.getStatus());
            cstmt.setInt(4, room.getFloor().getId());
            cstmt.setInt(5, room.getRoomType().getId());
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean deteleRoomById(String id) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_deleteRoomById(?)}");
            cstmt.setString(1, id);
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            DBUtilities.closeConnection(con, cstmt, null, null);
            Logger.getLogger(RoomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean updateRoom(Room room) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_updateRoom(?, ?, ?, ?, ?)}");
            cstmt.setString(1, room.getId());
            cstmt.setString(2, room.getName());
            cstmt.setInt(3, room.getRoomType().getId());
            cstmt.setInt(4, room.getFloor().getId());
            cstmt.setInt(5, room.getStatus());
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static LinkedList<Room> getEmptyRooms() {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        LinkedList<Room> list = new LinkedList<>();
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getEmptyRooms}");
            rs = cstmt.executeQuery();
            while (rs.next()) {
                Room r = new Room(rs.getString("id"), rs.getString("name"), rs.getShort("status"));
                RoomType t = getRoomTypeById(rs.getInt("roomTypeId"));
                r.setRoomType(t);
                Floor f = getFloorById(rs.getInt("floorId"));
                r.setFloor(f);
                list.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static Room getRoomById(String id) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Room room = null;
        try {
            cstmt = con.prepareCall("{call usp_getRoomById(?)}");
            cstmt.setString(1, id);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                room = new Room();
                room.setId(rs.getString("id"));
                room.setName(rs.getString("name"));
                RoomType roomType = RoomTypeDAOImpl.getRoomTypeById(rs.getInt("roomTypeId"));
                room.setRoomType(roomType);
                Floor floor = FloorDAOImpl.getFloorById(rs.getInt("floorId"));
                room.setFloor(floor);
                room.setStatus(rs.getShort("status"));
                room.setCreatedAt(rs.getDate("createdAt"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return room;
    }
}
