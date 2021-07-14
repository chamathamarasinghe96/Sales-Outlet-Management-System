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
import lk.ijse.salesoutlet.core.dto.ProductDTO;
import lk.ijse.salesoutlet.dao.custom.ProductDAO;
import lk.ijse.salesoutlet.db.DBConnection;

/**
 *
 * @author user
 */
public class ProductDAOImpl implements ProductDAO{

    @Override
    public boolean add(ProductDTO dto) throws Exception {
        String SQL="INSERT INTO Product VALUES(?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getCode());
        stm.setObject(2, dto.getDescription());
        stm.setObject(3, dto.getRetailUPrice());
        stm.setObject(4, dto.getWholeSaleUPrice());
        stm.setObject(5, dto.getBuyingUPrice());
        stm.setObject(6, dto.getUnitQty());
        stm.setObject(7, dto.getQtyOnHand());
        
        return stm.executeUpdate() > 0;
    }

    @Override
    public ProductDTO search(ProductDTO dto) throws Exception {
        String SQL="SELECT * FROM Product WHERE code='"+dto.getCode()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if(rst.next()){
            ProductDTO productDTO=new ProductDTO(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getDouble(4),rst.getDouble(5),rst.getString(6),rst.getDouble(7));
            return productDTO;
        }
        return null;
    }

    @Override
    public boolean update(ProductDTO dto) throws Exception {
        String SQL="UPDATE Product SET description=?,retailUPrice=?,wholeSaleUPrice=?,buyingUPrice=?,unitQty=?,qtyOnHand=? WHERE code=?";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getDescription());
        stm.setObject(2, dto.getRetailUPrice());
        stm.setObject(3, dto.getWholeSaleUPrice());
        stm.setObject(4, dto.getBuyingUPrice());
        stm.setObject(5, dto.getUnitQty());
        stm.setObject(6, dto.getQtyOnHand());
        stm.setObject(7, dto.getCode());
        
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(ProductDTO dto) throws Exception {
        String SQL="DELETE FROM Product WHERE code='"+dto.getCode()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }

    @Override
    public ArrayList<ProductDTO> getAll() throws Exception {
        String SQL="SELECT * FROM Product";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<ProductDTO> productData=new ArrayList<>();
        while(rst.next()){
            ProductDTO productDTO=new ProductDTO(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getDouble(4),rst.getDouble(5),rst.getString(6),rst.getDouble(7));
            productData.add(productDTO);
        }
        return productData;
    }
    
}
