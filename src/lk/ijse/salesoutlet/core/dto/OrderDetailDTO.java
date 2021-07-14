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
public class OrderDetailDTO extends SuperDTO{
    private String orderId;
    private String code;
    private double qty;
    private double unitPrice;
    private String unitQty;
    private double discount;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String orderId, String code, double qty, double unitPrice, String unitQty, double discount) {
        this.orderId = orderId;
        this.code = code;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.unitQty = unitQty;
        this.discount = discount;
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
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the qty
     */
    public double getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(double qty) {
        this.qty = qty;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the unitQty
     */
    public String getUnitQty() {
        return unitQty;
    }

    /**
     * @param unitQty the unitQty to set
     */
    public void setUnitQty(String unitQty) {
        this.unitQty = unitQty;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
}
