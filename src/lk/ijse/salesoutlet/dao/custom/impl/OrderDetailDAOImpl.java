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
import lk.ijse.salesoutlet.core.dto.OrderDetailDTO;
import lk.ijse.salesoutlet.dao.custom.OrderDetailDAO;
import lk.ijse.salesoutlet.db.DBConnection;

/**
 *
 * @author user
 */
public class OrderDetailDAOImpl implements OrderDetailDAO{

    @Override
    public boolean add(OrderDetailDTO dto) throws Exception {
        String SQL="INSERT INTO OrderDetail VALUES(?,?,?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getOrderId());
        stm.setObject(2, dto.getCode());
        stm.setObject(3, dto.getQty());
        stm.setObject(4, dto.getUnitPrice());
        stm.setObject(5, dto.getUnitQty());
        stm.setObject(6, dto.getDiscount());
        return stm.executeUpdate() > 0;
    }

    @Override
    public OrderDetailDTO search(OrderDetailDTO dto) throws Exception {
        String SQL="SELECT * FROM OrderDetail WHERE orderId='"+dto.getOrderId()+"' AND code='"+dto.getCode()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if(rst.next()){
            return new OrderDetailDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getDouble(4),
                    rst.getString(5),
                    rst.getDouble(6)
            );
        }
        return null;
    }

    @Override
    public boolean update(OrderDetailDTO dto) throws Exception {
        String SQL="UPDATE OrderDetail SET qty=?,unitPrice=?,unitQty=?,discount=? WHERE orderId=? AND code=?";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getQty());
        stm.setObject(2, dto.getUnitPrice());
        stm.setObject(3, dto.getUnitQty());
        stm.setObject(4, dto.getDiscount());
        stm.setObject(5, dto.getOrderId());
        stm.setObject(6, dto.getCode());
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(OrderDetailDTO dto) throws Exception {
        String SQL="DELETE FROM OrderDetail WHERE orderId='"+dto.getOrderId()+"' AND code='"+dto.getCode()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws Exception {
        String SQL="SELECT * FROM OrderDetail";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<OrderDetailDTO> orderDetail=new ArrayList<>();
        while(rst.next()){
            new OrderDetailDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getDouble(4),
                    rst.getString(5),
                    rst.getDouble(6)
            );
        }
        return orderDetail;
    }
    
}
