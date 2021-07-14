/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.controller;

import java.util.ArrayList;
import lk.ijse.salesoutlet.core.dto.CustomDTO;
import lk.ijse.salesoutlet.core.dto.SupplierPaymentDTO;
import lk.ijse.salesoutlet.dao.DAOFactory;
import lk.ijse.salesoutlet.dao.custom.QueryDAO;
import lk.ijse.salesoutlet.dao.custom.SupplierPaymentDAO;

/**
 *
 * @author user
 */
public class SupplierPaymentController {

    public static ArrayList<String> loadSupplierIDs() throws Exception {

        QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
        ArrayList<CustomDTO> supplierPaymentInfo = queryDAO.getSupplierPaymentInfo();

        ArrayList<String> orderIDs = new ArrayList<>();

        for (CustomDTO customDTO : supplierPaymentInfo) {
            orderIDs.add(customDTO.getOrderId());
        }

        return orderIDs;

    }

    public static CustomDTO getSupplierOrderData(CustomDTO dto) throws Exception {

        QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
        CustomDTO searchedSupplierOrderData = queryDAO.searchSupplierOrderData(dto);

        return searchedSupplierOrderData;

    }

    public static boolean addPayment(SupplierPaymentDTO supplierPaymentDTO) throws Exception {
        
        SupplierPaymentDAO supplierPaymentDAO=(SupplierPaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLIERPAYMENT);
        return supplierPaymentDAO.update(supplierPaymentDTO);
        
    }

}
