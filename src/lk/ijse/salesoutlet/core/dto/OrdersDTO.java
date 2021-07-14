/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.core.dto;

/**
 *
 * @author user
 */
public class OrdersDTO extends SuperDTO{
    private String orderId;
    private String customerId;
    private String paymentId;
    private int productCount;
    private String orderDate;

    public OrdersDTO() {
    }

    public OrdersDTO(String orderId, String customerId, String paymentId, int productCount, String orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.paymentId = paymentId;
        this.productCount = productCount;
        this.orderDate = orderDate;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the paymentId
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * @return the productCount
     */
    public int getProductCount() {
        return productCount;
    }

    /**
     * @param productCount the productCount to set
     */
    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    
}
