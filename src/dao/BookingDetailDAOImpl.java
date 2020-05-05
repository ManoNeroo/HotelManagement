/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBUtilities;
import entities.Booking;
import entities.BookingDetail;
import entities.Room;
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
public class BookingDetailDAOImpl {

    public static LinkedList<BookingDetail> getAllBookingDetails() {
        LinkedList<BookingDetail> list = new LinkedList<>();
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getAllBookingDetails}");
            rs = cstmt.executeQuery();
            while (rs.next()) {
                BookingDetail bd = new BookingDetail();
                bd.setId(rs.getInt("id"));
                Booking b = BookingDAOImpl.getBookingById(rs.getString("bookingId"));
                bd.setBooking(b);
                Room r = RoomDAOImpl.getRoomById(rs.getString("roomId"));
                bd.setRoom(r);
                bd.setServicePrice(rs.getDouble("servicePrice"));
                bd.setCreatedAt(rs.getDate("createdAt"));
                list.add(bd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static boolean updateBookingDetail(BookingDetail bd) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_updateBookingDetail(?, ?, ?, ?)}");
            cstmt.setInt(1, bd.getId());
            cstmt.setString(2, bd.getBooking().getId());
            cstmt.setString(3, bd.getRoom().getId());
            cstmt.setDouble(4, bd.getServicePrice());
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static BookingDetail getBookingDetailByRoomId(String id) {
        BookingDetail bd = null;
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getBookingDetailByRoomId(?)}");
            cstmt.setString(1, id);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                Booking booking = BookingDAOImpl.getBookingById(rs.getString("bookingId"));
                if (booking.getStatus() == (short) 2) {
                    bd = new BookingDetail();
                    bd.setBooking(booking);
                    bd.setId(rs.getInt("id"));
                    bd.setServicePrice(rs.getDouble("servicePrice"));
                    Room room = RoomDAOImpl.getRoomById(rs.getString("roomId"));
                    bd.setRoom(room);
                    bd.setCreatedAt(rs.getDate("createdAt"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bd;
    }

    public static BookingDetail getBookingDetailById(int id) {
        BookingDetail bd = null;
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getBookingDetailById(?)}");
            cstmt.setInt(1, id);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                bd = new BookingDetail();
                Booking booking = BookingDAOImpl.getBookingById(rs.getString("bookingId"));
                bd.setBooking(booking);
                bd.setId(rs.getInt("id"));
                bd.setServicePrice(rs.getDouble("servicePrice"));
                Room room = RoomDAOImpl.getRoomById(rs.getString("roomId"));
                bd.setRoom(room);
                bd.setCreatedAt(rs.getDate("createdAt"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bd;
    }

    public static LinkedList<BookingDetail> getBookingDetailsByBookingId(String id) {
        LinkedList<BookingDetail> list = new LinkedList<>();
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getBookingDetailsByBookingId(?)}");
            cstmt.setString(1, id);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                BookingDetail bd = new BookingDetail();
                bd.setId(rs.getInt("id"));
                Room room = RoomDAOImpl.getRoomById(rs.getString("roomId"));
                bd.setRoom(room);
                Booking booking = BookingDAOImpl.getBookingById(rs.getString("bookingId"));
                bd.setBooking(booking);
                bd.setServicePrice(rs.getDouble("servicePrice"));
                bd.setCreatedAt(rs.getDate("createdAt"));
                list.add(bd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static boolean insertBookingDetail(BookingDetail bd) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_insertBookingDetail(?, ?, ?)}");
            cstmt.setString(1, bd.getBooking().getId());
            cstmt.setString(2, bd.getRoom().getId());
            cstmt.setDouble(3, bd.getServicePrice());
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean deleteBookingDetailById(int id) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_deleteBookingDetailById(?)}");
            cstmt.setInt(1, id);
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
