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
import lk.ijse.salesoutlet.core.dto.CustomerPaymentDTO;
import lk.ijse.salesoutlet.dao.custom.CustomerPaymentDAO;
import lk.ijse.salesoutlet.db.DBConnection;

/**
 *
 * @author user
 */
public class CustomerPaymentDAOImpl implements CustomerPaymentDAO {

    @Override
    public boolean add(CustomerPaymentDTO dto) throws Exception {
        String SQL = "INSERT INTO CustomerPayment VALUES(?,?,?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getCpId());
        stm.setObject(2, dto.getTotalValue());
        stm.setObject(3, dto.getNetValue());
        stm.setObject(4, dto.getIsPayed());        
        stm.setObject(5, dto.getChequeNo());
        stm.setObject(6, dto.getBankBranchCode());

        return stm.executeUpdate() > 0;
    }

    @Override
    public CustomerPaymentDTO search(CustomerPaymentDTO dto) throws Exception {
        String SQL = "SELECT * FROM CustomerPayment WHERE cpId='" + dto.getCpId() + "'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return new CustomerPaymentDTO(
                    rst.getString(1),
                    rst.getDouble(2),
                    rst.getDouble(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
        }
        return null;
    }

    @Override
    public boolean update(CustomerPaymentDTO dto) throws Exception {
        String SQL = "UPDATE CustomerPayment SET totalValue=?,netValue=?,isPayed=?,chequeNo=?,bankBranchCode=? WHERE cpId=?";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getTotalValue());
        stm.setObject(2, dto.getNetValue());
        stm.setObject(3, dto.getIsPayed());
        stm.setObject(4, dto.getChequeNo());
        stm.setObject(5, dto.getBankBranchCode());
        stm.setObject(6, dto.getCpId());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(CustomerPaymentDTO dto) throws Exception {
        String SQL = "DELETE FROM CustomerPayment WHERE cpId='" + dto.getCpId() + "'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }

    @Override
    public ArrayList<CustomerPaymentDTO> getAll() throws Exception {
        String SQL = "SELECT * FROM CustomerPayment";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<CustomerPaymentDTO> paymentData = new ArrayList<>();
        while (rst.next()) {
            CustomerPaymentDTO customerPaymentDTO = new CustomerPaymentDTO(
                    rst.getString(1),
                    rst.getDouble(2),
                    rst.getDouble(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
            paymentData.add(customerPaymentDTO);
        }
        return paymentData;
    }
}
