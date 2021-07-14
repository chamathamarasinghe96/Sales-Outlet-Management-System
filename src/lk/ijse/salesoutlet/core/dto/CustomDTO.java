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
public class CustomDTO extends SuperDTO{
    private String paymentId;
    private String orderId;
    private double totalValue;
    private double netValue;
    private int productCount;
    private String code;
    private String description;
    private String unitQty;
    private double soldQty;
    
    public CustomDTO(String code, String description, String unitQty, double soldQty, double totalValue, double netValue) {
        this.code = code;
        this.description = description;
        this.unitQty = unitQty;
        this.soldQty = soldQty;
        this.totalValue = totalValue;
        this.netValue = netValue;
    }
    
    public CustomDTO(String paymentId, double totalValue, double netValue, int productCount) {
        this.paymentId = paymentId;
        this.totalValue = totalValue;
        this.netValue = netValue;
        this.productCount = productCount;
    }

    public CustomDTO(String paymentId, double totalValue, int productCount) {
        this.paymentId = paymentId;
        this.totalValue = totalValue;
        this.productCount = productCount;
    }

    public CustomDTO(String orderId) {
        this.orderId = orderId;
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
     * @return the totalValue
     */
    public double getTotalValue() {
        return totalValue;
    }

    /**
     * @param totalValue the totalValue to set
     */
    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    /**
     * @return the netValue
     */
    public double getNetValue() {
        return netValue;
    }

    /**
     * @param netValue the netValue to set
     */
    public void setNetValue(double netValue) {
        this.netValue = netValue;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return the soldQty
     */
    public double getSoldQty() {
        return soldQty;
    }

    /**
     * @param soldQty the soldQty to set
     */
    public void setSoldQty(double soldQty) {
        this.soldQty = soldQty;
    }
    
}
