/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.dao;

import lk.ijse.salesoutlet.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.salesoutlet.dao.custom.impl.CustomerPaymentDAOImpl;
import lk.ijse.salesoutlet.dao.custom.impl.GoodReceiveDetailDAOImpl;
import lk.ijse.salesoutlet.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.salesoutlet.dao.custom.impl.OrdersDAOImpl;
import lk.ijse.salesoutlet.dao.custom.impl.ProductDAOImpl;
import lk.ijse.salesoutlet.dao.custom.impl.QueryDAOImpl;
import lk.ijse.salesoutlet.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.salesoutlet.dao.custom.impl.SupplierOrderDAOImpl;
import lk.ijse.salesoutlet.dao.custom.impl.SupplierPaymentDAOImpl;

/**
 *
 * @author user
 */
public class DAOFactory {

    public enum DAOTypes {
        CUSTOMER, PRODUCT, SUPPLIER, ORDERS, ORDERDETAIL, CUSTOMERPAYMENT, GOODRECEIVEDETAIL, SUPPLIERORDER, SUPPLIERPAYMENT, QUERY
    }
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOTypes daoType) {
        switch (daoType) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case PRODUCT:
                return new ProductDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case ORDERS:
                return new OrdersDAOImpl();
            case ORDERDETAIL:
                return new OrderDetailDAOImpl();
            case CUSTOMERPAYMENT:
                return new CustomerPaymentDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            case GOODRECEIVEDETAIL: 
                return new GoodReceiveDetailDAOImpl();
            case SUPPLIERORDER: 
                return new SupplierOrderDAOImpl();
            case SUPPLIERPAYMENT:
                return new SupplierPaymentDAOImpl();
            default:
                return null;
        }
    }
}
