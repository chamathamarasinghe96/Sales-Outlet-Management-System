/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.controller;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.salesoutlet.core.dto.GoodReceiveDetailDTO;
import lk.ijse.salesoutlet.core.dto.ProductDTO;
import lk.ijse.salesoutlet.core.dto.SupplierOrderDTO;
import lk.ijse.salesoutlet.core.dto.SupplierPaymentDTO;
import lk.ijse.salesoutlet.dao.DAOFactory;
import lk.ijse.salesoutlet.dao.custom.GoodReceiveDetailDAO;
import lk.ijse.salesoutlet.dao.custom.ProductDAO;
import lk.ijse.salesoutlet.dao.custom.SupplierOrderDAO;
import lk.ijse.salesoutlet.dao.custom.SupplierPaymentDAO;
import lk.ijse.salesoutlet.db.DBConnection;

/**
 *
 * @author user
 */
public class PlaceGoodReceiveNoteController {

    public static String getCurrentOrderID() throws Exception {

        SupplierOrderDAO supplierOrderDAO = (SupplierOrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLIERORDER);
        ArrayList<SupplierOrderDTO> orderDetails = supplierOrderDAO.getAll();

        String orderId = null;
        for (SupplierOrderDTO orderDetail : orderDetails) {
            orderId = orderDetail.getOrderId();
        }

        int number = Integer.parseInt(orderId.substring(1));
        return "D" + (number + 1);

    }

    public static String getCurrentPaymentID() throws Exception {

        SupplierPaymentDAO supplierPaymentDAO = (SupplierPaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLIERPAYMENT);
        ArrayList<SupplierPaymentDTO> paymentDetails = supplierPaymentDAO.getAll();

        String paymentId = null;
        for (SupplierPaymentDTO paymentDetail : paymentDetails) {
            paymentId = paymentDetail.getSpId();
        }

        int number = Integer.parseInt(paymentId.substring(2));
        return "SP" + (number + 1);

    }

    public static boolean placeSupplierOrder(SupplierPaymentDTO supplierPayment, SupplierOrderDTO order, ArrayList<GoodReceiveDetailDTO> goodReceiveDetails) throws Exception {

        Connection conn = DBConnection.getInstance().getConnection();

        try {
            conn.setAutoCommit(false);

            SupplierPaymentDAO supplierPaymentDAO = (SupplierPaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLIERPAYMENT);
            boolean isPaymentAdded = supplierPaymentDAO.add(supplierPayment);

            if (isPaymentAdded) {

                SupplierOrderDAO supplierOrderDAO = (SupplierOrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLIERORDER);
                boolean isOrderAdded = supplierOrderDAO.add(order);

                if (isOrderAdded) {

                    for (GoodReceiveDetailDTO goodReceiveDetail : goodReceiveDetails) {

                        GoodReceiveDetailDAO goodReceiveDetailDAO = (GoodReceiveDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GOODRECEIVEDETAIL);
                        boolean isDetailAdded = goodReceiveDetailDAO.add(goodReceiveDetail);

                        if (!isDetailAdded) {
                            conn.rollback();
                            return false;
                        }

                        ProductDAO productDAO = (ProductDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PRODUCT);
                        ProductDTO searchedProduct = productDAO.search(new ProductDTO(goodReceiveDetail.getCode(), null, 0, 0, 0, null, 0));

                        double newQty = searchedProduct.getQtyOnHand() + goodReceiveDetail.getBuyingQty();

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
