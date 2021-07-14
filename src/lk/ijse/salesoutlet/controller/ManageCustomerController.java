/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.controller;

import java.util.ArrayList;
import lk.ijse.salesoutlet.core.dto.CustomerDTO;
import lk.ijse.salesoutlet.dao.DAOFactory;
import lk.ijse.salesoutlet.dao.SuperDAO;

/**
 *
 * @author user
 */
public class ManageCustomerController {
    
    public static SuperDAO customerDAO =  DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    
    public static boolean addCustomer(CustomerDTO customer) throws Exception {
        boolean result = customerDAO.add(customer);
        return result;
    }

    public static boolean deleteCustomer(CustomerDTO customer) throws Exception {
        boolean result = customerDAO.delete(customer);
        return result;
    }

    public static boolean updateCustomer(CustomerDTO customer) throws Exception {
        boolean result = customerDAO.update(customer);
        return result;
    }

    public static CustomerDTO searchCustomer(CustomerDTO customer) throws Exception {
        CustomerDTO searchedCustomer = (CustomerDTO) customerDAO.search(customer);
        return searchedCustomer;
    }

    public static ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        return customerDAO.getAll();
    }
    
    public static String getCurrentCustomerID() throws Exception{
        String customerID=null;
        
        ArrayList<CustomerDTO> customerData = customerDAO.getAll();
        for (CustomerDTO customerDTO : customerData) {
            customerID=customerDTO.getCustomerId();
        }
        
        int number=Integer.parseInt(customerID.substring(1));
        customerID="C"+(number+1);
        return customerID;
    }
    
}
