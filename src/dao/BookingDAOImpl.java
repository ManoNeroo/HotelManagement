/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBUtilities;
import entities.Booking;
import entities.Customer;
import entities.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trinh
 */
public class BookingDAOImpl {

    public static boolean deleteBookingById(String id) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_deleteBookingById(?)}");
            cstmt.setString(1, id);
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static LinkedList<Booking> getAllBookings() {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        LinkedList<Booking> list = new LinkedList<>();
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getAllBookings}");
            rs = cstmt.executeQuery();
            while (rs.next()) {
                Booking b = new Booking();
                b.setId(rs.getString("id"));
                Customer c = CustomerDAOImpl.getCustomerById(rs.getString("customerId"));
                b.setCustomer(c);
                User u = UserDAOImpl.getUserById(rs.getString("userId"));
                b.setUser(u);
                b.setCheckin(rs.getDate("checkin"));
                b.setCheckout(rs.getDate("checkout"));
                b.setStatus(rs.getShort("status"));
                list.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static Booking getBookingById(String id) {
        Booking booking = null;
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getBookingById(?)}");
            cstmt.setString(1, id);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                booking = new Booking();
                booking.setId(rs.getString("id"));
                Customer customer = CustomerDAOImpl.getCustomerById(rs.getString("customerId"));
                booking.setCustomer(customer);
                User user = UserDAOImpl.getUserById(rs.getString("userId"));
                booking.setUser(user);
                booking.setCheckin(rs.getDate("checkin"));
                booking.setCheckout(rs.getDate("checkout"));
                booking.setStatus(rs.getShort("status"));
                booking.setCreatedAt(rs.getDate("createdAt"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return booking;
    }

    public static boolean insertBooking(Booking booking) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_insertBooking(?,?,?,?,?)}");
            cstmt.setString(1, booking.getId());
            cstmt.setString(2, booking.getCustomer().getId());
            cstmt.setString(3, booking.getUser().getId());
            cstmt.setDate(4, new Date(booking.getCheckin().getTime()));
            cstmt.setShort(5, booking.getStatus());
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean updateBooking(Booking booking) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_updateBooking(?,?,?,?,?,?)}");
            cstmt.setString(1, booking.getId());
            cstmt.setString(2, booking.getCustomer().getId());
            cstmt.setString(3, booking.getUser().getId());
            cstmt.setDate(4, new Date(booking.getCheckin().getTime()));
            cstmt.setDate(5, new Date(booking.getCheckout().getTime()));
            cstmt.setShort(6, booking.getStatus());
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
