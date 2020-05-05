/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBUtilities;
import entities.BookingDetail;
import entities.Service;
import entities.ServiceDetail;
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
public class ServiceDetailDAOImpl {
    public static boolean insertServiceDetail(ServiceDetail sd) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_insertServiceDetail(?, ?, ?)}");
            cstmt.setInt(1, sd.getAmount());
            cstmt.setInt(2, sd.getBookingDetail().getId());
            cstmt.setString(3, sd.getService().getId());
            if(cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static LinkedList<ServiceDetail> getServiceDetailByBookingDetailId(int id) {
        LinkedList<ServiceDetail> list = new LinkedList<>();
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getServiceDetailByBookingDetailId(?)}");
            cstmt.setInt(1, id);
            rs = cstmt.executeQuery();
            while(rs.next()) {
                ServiceDetail sd = new ServiceDetail();
                sd.setId(rs.getInt("id"));
                sd.setAmount(rs.getInt("amount"));
                BookingDetail bookingDetail = BookingDetailDAOImpl.getBookingDetailById(rs.getInt("bookingDetailId"));
                sd.setBookingDetail(bookingDetail);
                sd.setCreatedDate(rs.getDate("createdDate"));
                Service service = ServiceDAOImpl.getServiceById(rs.getString("serviceId"));
                sd.setService(service);
                list.add(sd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
