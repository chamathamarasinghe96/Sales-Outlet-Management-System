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
import lk.ijse.salesoutlet.core.dto.SupplierPaymentDTO;
import lk.ijse.salesoutlet.dao.custom.SupplierPaymentDAO;
import lk.ijse.salesoutlet.db.DBConnection;

/**
 *
 * @author user
 */
public class SupplierPaymentDAOImpl implements SupplierPaymentDAO{

    @Override
    public boolean add(SupplierPaymentDTO dto) throws Exception {
        String SQL="INSERT INTO SupplierPayment VALUES(?,?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getSpId());
        stm.setObject(2, dto.getSpAmount());
        stm.setObject(3, dto.getIsPayed());
        stm.setObject(4, dto.getChequeNo());
        stm.setObject(5, dto.getPaymentDate());
        return stm.executeUpdate() > 0;
    }

    @Override
    public SupplierPaymentDTO search(SupplierPaymentDTO dto) throws Exception {
        String SQL="SELECT * FROM SupplierPayment WHERE spId='"+dto.getSpId()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return new SupplierPaymentDTO(
                    rst.getString(1),
                    rst.getDouble(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );
        }else{
            return null;
        }
    }

    @Override
    public boolean update(SupplierPaymentDTO dto) throws Exception {
        String SQL="UPDATE SupplierPayment SET spAmount=?,isPayed=?,chequeNo=?,paymentDate=? WHERE spId=?";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getSpAmount());
        stm.setObject(2, dto.getIsPayed());
        stm.setObject(3, dto.getChequeNo());
        stm.setObject(4, dto.getPaymentDate());
        stm.setObject(5, dto.getSpId());
        
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(SupplierPaymentDTO dto) throws Exception {
        String SQL="DELETE FROM SupplierPayment WHERE spId='"+dto.getSpId()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }

    @Override
    public ArrayList<SupplierPaymentDTO> getAll() throws Exception {
        String SQL="SELECT * FROM SupplierPayment";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<SupplierPaymentDTO> supplierPayments=new ArrayList<>();
        
        while(rst.next()){
            supplierPayments.add(new SupplierPaymentDTO(
                    rst.getString(1),
                    rst.getDouble(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            ));
        }
        return supplierPayments;
    }
    
}
