/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.controller;

import java.util.ArrayList;
import lk.ijse.salesoutlet.core.dto.CustomDTO;
import lk.ijse.salesoutlet.dao.DAOFactory;
import lk.ijse.salesoutlet.dao.custom.QueryDAO;

/**
 *
 * @author user
 */
public class TransactionReportController {

    public static ArrayList<CustomDTO> getSalesDetails(String date) throws Exception {
        
        QueryDAO queryDAO=(QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
        return queryDAO.getDailySales(date);
        
    }
    
    
}
