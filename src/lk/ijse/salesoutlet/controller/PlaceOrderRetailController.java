/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.controller;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.salesoutlet.core.dto.CustomerPaymentDTO;
import lk.ijse.salesoutlet.core.dto.OrderDetailDTO;
import lk.ijse.salesoutlet.core.dto.OrdersDTO;
import lk.ijse.salesoutlet.core.dto.ProductDTO;
import lk.ijse.salesoutlet.dao.DAOFactory;
import lk.ijse.salesoutlet.dao.custom.CustomerPaymentDAO;
import lk.ijse.salesoutlet.dao.custom.OrderDetailDAO;
import lk.ijse.salesoutlet.dao.custom.OrdersDAO;
import lk.ijse.salesoutlet.dao.custom.ProductDAO;
import lk.ijse.salesoutlet.db.DBConnection;

/**
 *
 * @author user
 */
public class PlaceOrderRetailController {

    public static String getOrderId() throws Exception {

        OrdersDAO ordersDAO = (OrdersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
        ArrayList<OrdersDTO> orders = ordersDAO.getAll();
        String newOrderId = null;
        for (OrdersDTO order : orders) {
            newOrderId = order.getOrderId();
        }
        String digits = newOrderId.substring(1);
        int number = Integer.parseInt(digits);
        newOrderId = "D" + (number + 1);

        return newOrderId;
    }

    public static String getCurrentPaymentID() throws Exception {
        
        CustomerPaymentDAO customerPayment = (CustomerPaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMERPAYMENT);
        ArrayList<CustomerPaymentDTO> paymentDetails = customerPayment.getAll();

        String paymentId = null;
        for (CustomerPaymentDTO paymentDetail : paymentDetails) {
            paymentId = paymentDetail.getCpId();
        }

        int number = Integer.parseInt(paymentId.substring(2));
        return "CP" + (number + 1);

    }

    public static boolean placeOrder(CustomerPaymentDTO payment, OrdersDTO order, ArrayList<OrderDetailDTO> orderDetails) throws Exception {

        Connection conn = DBConnection.getInstance().getConnection();

        try {
            conn.setAutoCommit(false);

            CustomerPaymentDAO customerPaymentDAO = (CustomerPaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMERPAYMENT);
            boolean isPayAdded = customerPaymentDAO.add(payment);

            if (isPayAdded) {
                OrdersDAO orderDAO = (OrdersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
                boolean isOrderAdded = orderDAO.add(order);

                if (isOrderAdded) {

                    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);
                    ProductDAO productDAO = (ProductDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PRODUCT);

                    for (OrderDetailDTO orderDetail : orderDetails) {

                        boolean isOrderDetailAdded = orderDetailDAO.add(orderDetail);

                        if (!isOrderDetailAdded) {
                            conn.rollback();
                            return false;
                        }

                        ProductDTO searchedProduct = productDAO.search(new ProductDTO(orderDetail.getCode(), null, 0, 0, 0, null, 0));

                        double newQty = searchedProduct.getQtyOnHand() - orderDetail.getQty();

                        searchedProduct.setQtyOnHand(newQty);
                        boolean isUpdated = productDAO.update(searchedProduct);

                        if (!isUpdated) {
                            conn.rollback();
                            return false;
                        }
                    }
                    conn.commit();
                    return true;
                }
            }
            conn.rollback();
            return false;
        } finally {
            conn.setAutoCommit(true);
        }
    }
}
