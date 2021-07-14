/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.controller;

import java.util.ArrayList;
import lk.ijse.salesoutlet.core.dto.CustomDTO;
import lk.ijse.salesoutlet.core.dto.CustomerPaymentDTO;
import lk.ijse.salesoutlet.dao.DAOFactory;
import lk.ijse.salesoutlet.dao.custom.CustomerPaymentDAO;
import lk.ijse.salesoutlet.dao.custom.QueryDAO;

/**
 *
 * @author user
 */
public class CustomerPaymentController {

    public static ArrayList<String> loadOrderIDs() throws Exception {

        QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
        ArrayList<CustomDTO> paymentInfo = queryDAO.getPaymentInfo();

        ArrayList<String> paymentId = new ArrayList<>();
        for (CustomDTO customDTO : paymentInfo) {

            paymentId.add(customDTO.getOrderId());
        }
        return paymentId;
    }

    public static CustomDTO getOrderData(CustomDTO dto) throws Exception {

        QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
        CustomDTO searchedOrderData = queryDAO.searchOrderData(dto);

        return searchedOrderData;
    }

    public static boolean updatePayment(CustomerPaymentDTO dto) throws Exception {

        CustomerPaymentDAO customerPaymentDAO = (CustomerPaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMERPAYMENT);
        return customerPaymentDAO.update(dto);

    }

}
