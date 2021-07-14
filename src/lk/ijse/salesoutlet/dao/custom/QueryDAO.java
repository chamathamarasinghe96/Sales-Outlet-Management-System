/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.dao.custom;

import java.util.ArrayList;
import lk.ijse.salesoutlet.core.dto.CustomDTO;
import lk.ijse.salesoutlet.dao.SuperDAO;

/**
 *
 * @author user
 */
public interface QueryDAO extends SuperDAO<CustomDTO> {

    @Override
    public default boolean add(CustomDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default boolean delete(CustomDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default ArrayList<CustomDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default CustomDTO search(CustomDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default boolean update(CustomDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<CustomDTO> getPaymentInfo() throws Exception;
    
    public CustomDTO searchOrderData(CustomDTO dto) throws Exception;

    public ArrayList<CustomDTO> getSupplierPaymentInfo() throws Exception;

    public CustomDTO searchSupplierOrderData(CustomDTO dto) throws Exception;
    
    public ArrayList<CustomDTO> getDailySales(String orderId) throws Exception;
}
