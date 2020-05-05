/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBUtilities;
import entities.Customer;
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
public class CustomerDAOImpl {

    public static LinkedList<Customer> getAllCustomers() {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        LinkedList<Customer> list = new LinkedList<>();
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getAllCustomers}");
            rs = cstmt.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getString("id"));
                c.setIdentityCardNumber(rs.getString("identityCardNumber"));
                c.setName(rs.getString("name"));
                c.setGender(rs.getShort("gender"));
                c.setBirthday(rs.getDate("birthday"));
                c.setPhone(rs.getString("phone"));
                c.setEmail(rs.getString("email"));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static boolean insertCustomer(Customer customer) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_insertCustomer(?, ?, ?, ?, ?, ?, ?)}");
            cstmt.setString(1, customer.getId());
            cstmt.setString(2, customer.getIdentityCardNumber());
            cstmt.setString(3, customer.getName());
            cstmt.setDate(4, new Date(customer.getBirthday().getTime()));
            cstmt.setString(5, customer.getPhone());
            cstmt.setShort(6, customer.getGender());
            cstmt.setString(7, customer.getEmail());
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Customer getCustomerByIdentityCard(String identityCard) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Customer customer = null;
        try {
            cstmt = con.prepareCall("{call usp_getCustomerByIdentityCard(?)}");
            cstmt.setString(1, identityCard);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                customer = new Customer(rs.getString("id"), rs.getString("identityCardNumber"), rs.getString("name"), rs.getString("phone"), rs.getDate("birthday"), rs.getShort("gender"));
                customer.setEmail(rs.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    public static boolean updateCustomer(Customer customer) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_updateCustomer(?, ?, ?, ?, ?, ?, ?)}");
            cstmt.setString(1, customer.getId());
            cstmt.setString(2, customer.getIdentityCardNumber());
            cstmt.setString(3, customer.getName());
            cstmt.setDate(4, new Date(customer.getBirthday().getTime()));
            cstmt.setString(5, customer.getPhone());
            cstmt.setShort(6, customer.getGender());
            cstmt.setString(7, customer.getEmail());
            if (cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Customer getCustomerById(String id) {
        Customer customer = null;
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            cstmt = con.prepareCall("{call usp_getCustomerById(?)}");
            cstmt.setString(1, id);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getString("id"));
                customer.setIdentityCardNumber(rs.getString("identityCardNumber"));
                customer.setName(rs.getString("name"));
                customer.setPhone(rs.getString("phone"));
                customer.setBirthday(rs.getDate("birthday"));
                customer.setGender(rs.getShort("gender"));
                customer.setEmail(rs.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    public static boolean deleteCustomerById(String id) {
        Connection con = DBUtilities.openConnection();
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{call usp_deleteCustomerById(?)}");
            cstmt.setString(1, id);
            if(cstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            DBUtilities.closeConnection(con, cstmt, null, null);
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
