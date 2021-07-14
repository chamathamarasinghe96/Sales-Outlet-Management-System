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
import lk.ijse.salesoutlet.core.dto.SupplierOrderDTO;
import lk.ijse.salesoutlet.dao.custom.SupplierOrderDAO;
import lk.ijse.salesoutlet.db.DBConnection;

/**
 *
 * @author user
 */
public class SupplierOrderDAOImpl implements SupplierOrderDAO{

    @Override
    public boolean add(SupplierOrderDTO dto) throws Exception {
        String SQL="INSERT INTO SupplierOrder VALUES(?,?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getOrderId());
        stm.setObject(2, dto.getPaymentId());
        stm.setObject(3, dto.getSupplierId());
        stm.setObject(4, dto.getProductCount());
        stm.setObject(5, dto.getDate());
        
        return stm.executeUpdate() > 0;
    }

    @Override
    public SupplierOrderDTO search(SupplierOrderDTO dto) throws Exception {
        String SQL="SELECT * FROM SupplierOrder WHERE orderId='"+dto.getOrderId()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if(rst.next()){
            SupplierOrderDTO supplierOrderDTO=new SupplierOrderDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5));
            return supplierOrderDTO;
        }
        return null;
    }

    @Override
    public boolean update(SupplierOrderDTO dto) throws Exception {
        String SQL="UPDATE SupplierOrder SET paymentId=?,supplierId=?,productCount=?,date=? WHERE orderId=?";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getPaymentId());
        stm.setObject(2, dto.getSupplierId());
        stm.setObject(3, dto.getProductCount());
        stm.setObject(4, dto.getDate());
        stm.setObject(5, dto.getOrderId());
        
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(SupplierOrderDTO dto) throws Exception {
        String SQL="DELETE FROM SupplierOrder WHERE orderId='"+dto.getOrderId()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }

    @Override
    public ArrayList<SupplierOrderDTO> getAll() throws Exception {
        String SQL="SELECT * FROM SupplierOrder";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<SupplierOrderDTO> supplierOrders=new ArrayList<>();
        while(rst.next()){            
            supplierOrders.add(new SupplierOrderDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getString(5)
            ));
        }
        return supplierOrders;
    }
    
}
