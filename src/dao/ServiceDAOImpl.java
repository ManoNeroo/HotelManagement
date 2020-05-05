/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBUtilities;
import entities.Service;
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
public class ServiceDAOImpl {

    public static Service getServiceById(String id) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        Service service = null;
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getServiceById(?)}");
            cstmt.setString(1, id);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                service = new Service();
                service.setId(rs.getString("id"));
                service.setName(rs.getString("name"));
                service.setAmount(rs.getInt("amount"));
                service.setPrice(rs.getDouble("price"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return service;
    }

    public static LinkedList<Service> getAllServices() {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        LinkedList<Service> list = new LinkedList<>();
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getAllServices}");
            rs = cstmt.executeQuery();
            while (rs.next()) {
                Service s = new Service(rs.getString("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("amount"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public static boolean insertService(Service service) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_insertService(?, ?, ?, ?)}");
            cstmt.setString(1, service.getId());
            cstmt.setString(2, service.getName());
            cstmt.setDouble(3, service.getPrice());
            cstmt.setInt(4, service.getAmount());
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean updateService(Service service) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_updateService(?, ?, ?, ?)}");
            cstmt.setString(1, service.getId());
            cstmt.setString(2, service.getName());
            cstmt.setDouble(3, service.getPrice());
            cstmt.setInt(4, service.getAmount());
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean deleteServiceById(String id) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_deleteService(?)}");
            cstmt.setString(1, id);
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            DBUtilities.closeConnection(con, cstmt, null, null);
            Logger.getLogger(ServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
