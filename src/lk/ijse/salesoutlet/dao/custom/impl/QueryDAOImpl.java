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
import lk.ijse.salesoutlet.core.dto.CustomDTO;
import lk.ijse.salesoutlet.dao.custom.QueryDAO;
import lk.ijse.salesoutlet.db.DBConnection;

/**
 *
 * @author user
 */
public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList<CustomDTO> getPaymentInfo() throws Exception {

        String SQL = "SELECT Orders.orderId FROM\n"
                + "Orders INNER JOIN CustomerPayment ON Orders.paymentId=CustomerPayment.cpId\n"
                + "WHERE CustomerPayment.isPayed='NotPayed';\n"
                + "";

        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<CustomDTO> orderData = new ArrayList<>();

        while (rst.next()) {
            orderData.add(new CustomDTO(
                    rst.getString(1)
            ));
        }

        return orderData;
    }

    @Override
    public CustomDTO searchOrderData(CustomDTO dto) throws Exception {
        String SQL = "SELECT CustomerPayment.cpId,CustomerPayment.totalValue,CustomerPayment.netValue,Orders.productCount FROM\n"
                + "Orders INNER JOIN CustomerPayment ON Orders.paymentId=CustomerPayment.cpId\n"
                + "WHERE Orders.orderId='" + dto.getOrderId() + "';\n"
                + "";

        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);

        if (rst.next()) {
            return new CustomDTO(rst.getString(1), rst.getDouble(2), rst.getDouble(3), rst.getInt(4));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<CustomDTO> getSupplierPaymentInfo() throws Exception {
        String SQL = "SELECT SupplierOrder.orderId FROM\n"
                + "SupplierOrder INNER JOIN SupplierPayment ON SupplierPayment.spId=SupplierOrder.paymentId\n"
                + "WHERE SupplierPayment.isPayed='NotPayed';\n"
                + "";

        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<CustomDTO> orderDetails = new ArrayList<>();

        while (rst.next()) {
            orderDetails.add(new CustomDTO(rst.getString(1)));
        }
        return orderDetails;
    }

    @Override
    public CustomDTO searchSupplierOrderData(CustomDTO dto) throws Exception {
        String SQL = "SELECT SupplierPayment.spId,SupplierPayment.spAmount,SupplierOrder.productCount FROM\n"
                + "SupplierOrder INNER JOIN SupplierPayment ON SupplierPayment.spId=SupplierOrder.paymentId\n"
                + "WHERE SupplierOrder.orderId='" + dto.getOrderId() + "';\n"
                + "";

        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);

        if (rst.next()) {
            return new CustomDTO(rst.getString(1), rst.getDouble(2), rst.getInt(3));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<CustomDTO> getDailySales(String date) throws Exception {
        String SQL = "SELECT Product.code,Product.description,Product.unitQty,SUM(OrderDetail.qty),\n"
                + "SUM(OrderDetail.unitPrice*orderDetail.qty),\n"
                + "SUM(OrderDetail.discount),SUM(OrderDetail.unitPrice*orderDetail.qty)-SUM(OrderDetail.discount) FROM\n"
                + "Product INNER JOIN OrderDetail ON Product.code = OrderDetail.code\n"
                + "INNER JOIN Orders ON OrderDetail.orderId = Orders.orderId\n"
                + "WHERE Orders.OrderDate ='" + date + "'\n"
                + "GROUP BY Product.code\n"
                + "ORDER BY Product.code;\n"
                + "";

        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);

        ArrayList<CustomDTO> productData = new ArrayList<>();

        while (rst.next()) {
            productData.add(new CustomDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getDouble(5),
                    rst.getDouble(7)
            ));
        }
        return productData;
    }
}
