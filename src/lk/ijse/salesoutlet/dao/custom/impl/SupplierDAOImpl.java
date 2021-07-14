/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.dao.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.salesoutlet.core.dto.SupplierDTO;
import lk.ijse.salesoutlet.dao.custom.SupplierDAO;
import lk.ijse.salesoutlet.db.DBConnection;

/**
 *
 * @author user
 */
public class SupplierDAOImpl implements SupplierDAO{

    @Override
    public boolean add(SupplierDTO dto) throws Exception {
        String SQL="INSERT INTO Supplier VALUES('"+dto.getId()+"','"+dto.getName()+"','"+dto.getAddress()+"','"+dto.getTelNo()+"')";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }

    @Override
    public SupplierDTO search(SupplierDTO dto) throws Exception {
        String SQL="SELECT * FROM Supplier WHERE id='"+dto.getId()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            SupplierDTO supplierDTO=new SupplierDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
            return supplierDTO;
        }else{
            return null;
        }
    }

    @Override
    public boolean update(SupplierDTO dto) throws Exception {
        String SQL="UPDATE Supplier SET name='"+dto.getName()+"',address='"+dto.getAddress()+"',telNo='"+dto.getTelNo()+"' WHERE id='"+dto.getId()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }

    @Override
    public boolean delete(SupplierDTO dto) throws Exception {
        String SQL="DELETE FROM Supplier WHERE id='"+dto.getId()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;        
    }

    @Override
    public ArrayList<SupplierDTO> getAll() throws Exception {
        String SQL="SELECT * FROM Supplier";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();        
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<SupplierDTO> supplierDetail=new ArrayList<>();
        while(rst.next()){
            supplierDetail.add(new SupplierDTO(
                rst.getString(1),
                rst.getString(2),
                rst.getString(3),
                rst.getString(4)
            ));
        }
        return supplierDetail;
    }
}
