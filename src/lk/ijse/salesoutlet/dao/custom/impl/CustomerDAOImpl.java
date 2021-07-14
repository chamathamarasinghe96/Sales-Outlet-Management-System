/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.salesoutlet.core.dto.CustomerDTO;
import lk.ijse.salesoutlet.dao.custom.CustomerDAO;
import lk.ijse.salesoutlet.db.DBConnection;

/**
 *
 * @author user
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(CustomerDTO dto) throws Exception {
        String SQL = "INSERT INTO Customer VALUES('" + dto.getCustomerId() + "','" + dto.getCustomerName() + "','" + dto.getAddress() + "','" + dto.getTelNo() + "')";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;

    }

    @Override
    public CustomerDTO search(CustomerDTO dto) throws Exception {
        String SQL = "SELECT * FROM Customer WHERE id='" + dto.getCustomerId() + "'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
            return customerDTO;
        } else {
            return null;
        }
    }

    @Override
    public boolean update(CustomerDTO dto) throws Exception {
        String SQL = "UPDATE Customer SET name=?,address=?,telNo=? WHERE id=?";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getCustomerName());
        stm.setObject(2, dto.getAddress());
        stm.setObject(3, dto.getTelNo());
        stm.setObject(4, dto.getCustomerId());
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(CustomerDTO dto) throws Exception {
        String SQL = "DELETE FROM Customer WHERE id='"+dto.getCustomerId()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
        String SQL="SELECT * FROM Customer";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<CustomerDTO> customerIds=new ArrayList<>();
        while(rst.next()){
            CustomerDTO customerDTO=new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
            customerIds.add(customerDTO);
        }
        return customerIds;
    }

}
