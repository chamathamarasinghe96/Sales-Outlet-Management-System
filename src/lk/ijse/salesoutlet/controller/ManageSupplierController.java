/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.controller;

import java.util.ArrayList;
import lk.ijse.salesoutlet.core.dto.SupplierDTO;
import lk.ijse.salesoutlet.dao.DAOFactory;
import lk.ijse.salesoutlet.dao.custom.SupplierDAO;

/**
 *
 * @author user
 */
public class ManageSupplierController {
    public static SupplierDAO supplierDAO=(SupplierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    
    public static boolean addSupplier(SupplierDTO supplier) throws Exception{
        boolean isAdded = supplierDAO.add(supplier);
        return isAdded;
    }
    
    public static boolean deleteSupplier(SupplierDTO supplier) throws Exception{
        boolean isDeleted=supplierDAO.delete(supplier);
        return isDeleted;
    }
    
    public static boolean updateSupplier(SupplierDTO supplier) throws Exception{
        boolean isUpdated=supplierDAO.update(supplier);
        return isUpdated;
    }
    
    public static SupplierDTO searchSupplier(SupplierDTO supplier) throws Exception{
        SupplierDTO supplierDetails=supplierDAO.search(supplier);
        return supplierDetails;
    } 
    
    public static ArrayList<SupplierDTO> getAllSuppliers() throws Exception{
        return supplierDAO.getAll();
    }

    public static String getCurrentSupplierID() throws Exception {
        String supplierID=null;
        
        ArrayList<SupplierDTO> supplierData = supplierDAO.getAll();
        for (SupplierDTO supplierDTO : supplierData) {
            supplierID=supplierDTO.getId();
        }
        
        int number=Integer.parseInt(supplierID.substring(1));
        supplierID="S"+(number+1);
        return supplierID;
    }
}
