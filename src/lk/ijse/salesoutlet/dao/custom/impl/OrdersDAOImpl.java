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
import lk.ijse.salesoutlet.core.dto.OrdersDTO;
import lk.ijse.salesoutlet.dao.custom.OrdersDAO;
import lk.ijse.salesoutlet.db.DBConnection;

/**
 *
 * @author user
 */
public class OrdersDAOImpl implements OrdersDAO{

    @Override
    public boolean add(OrdersDTO dto) throws Exception {
        String SQL="INSERT INTO Orders VALUES(?,?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getOrderId());
        stm.setObject(2, dto.getCustomerId());
        stm.setObject(3, dto.getPaymentId());
        stm.setObject(4, dto.getProductCount());
        stm.setObject(5, dto.getOrderDate());
        return stm.executeUpdate() > 0;
    }

    @Override
    public OrdersDTO search(OrdersDTO dto) throws Exception {
        String SQL="SELECT * FROM Orders WHERE orderId='"+dto.getOrderId()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if(rst.next()){
            return new OrdersDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getString(5)                    
            );
        }else{
            return null;
        }
    }

    @Override
    public boolean update(OrdersDTO dto) throws Exception {
        String SQL="UPDATE Orders SET customerId=?,paymentId=?,productCount=?,orderDate=? WHERE orderId=?";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getCustomerId());
        stm.setObject(2, dto.getPaymentId());
        stm.setObject(3, dto.getProductCount());
        stm.setObject(4, dto.getOrderDate());
        stm.setObject(5, dto.getOrderId());
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(OrdersDTO dto) throws Exception {
        String SQL="DELETE FROM Orders WHERE orderId='"+dto.getOrderId()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }

    @Override
    public ArrayList<OrdersDTO> getAll() throws Exception {
        String SQL="SELECT * FROM Orders";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<OrdersDTO> orders=new ArrayList<>();
        while(rst.next()){
            orders.add(new OrdersDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getString(5)
            ));
        }
        return orders;
    }
}
