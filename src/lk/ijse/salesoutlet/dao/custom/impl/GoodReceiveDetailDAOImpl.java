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
import lk.ijse.salesoutlet.core.dto.GoodReceiveDetailDTO;
import lk.ijse.salesoutlet.dao.custom.GoodReceiveDetailDAO;
import lk.ijse.salesoutlet.db.DBConnection;

/**
 *
 * @author user
 */
public class GoodReceiveDetailDAOImpl implements GoodReceiveDetailDAO{

    @Override
    public boolean add(GoodReceiveDetailDTO dto) throws Exception {
        String SQL="INSERT INTO GoodReceiveDetail VALUES(?,?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getOrderId());
        stm.setObject(2, dto.getCode());
        stm.setObject(3, dto.getBuyingQty());
        stm.setObject(4, dto.getBuyingUPrice());
        stm.setObject(5, dto.getUnitQty());
        return stm.executeUpdate() > 0;
    }

    @Override
    public GoodReceiveDetailDTO search(GoodReceiveDetailDTO dto) throws Exception {
        String SQL="SELECT * FROM GoodReceiveDetail WHERE orderId='"+dto.getOrderId()+"' AND code='"+dto.getCode()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return new GoodReceiveDetailDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getDouble(4),
                    rst.getString(5)
            );
        }else{
            return null;
        }
    }

    @Override
    public boolean update(GoodReceiveDetailDTO dto) throws Exception {
        String SQL="UPDATE GoodReceiveDetail SET buyingQty=?,buyingUPrice=?,unitQty=? WHERE orderId=? AND code=?";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getBuyingQty());
        stm.setObject(2, dto.getBuyingUPrice());
        stm.setObject(3, dto.getUnitQty());
        stm.setObject(4, dto.getOrderId());
        stm.setObject(5, dto.getCode());
        
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(GoodReceiveDetailDTO dto) throws Exception {
        String SQL="DELETE FROM GoodReceiveDetail WHERE orderId='"+dto.getOrderId()+"' AND code='"+dto.getCode()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }

    @Override
    public ArrayList<GoodReceiveDetailDTO> getAll() throws Exception {
        String SQL="SELECT * FROM GoodReceiveDetail";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<GoodReceiveDetailDTO> goodReceiveDetails=new ArrayList<>();
        
        while(rst.next()){
            goodReceiveDetails.add(new GoodReceiveDetailDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getDouble(4),
                    rst.getString(5)
            ));
        }
        return goodReceiveDetails;
    }
    
}
