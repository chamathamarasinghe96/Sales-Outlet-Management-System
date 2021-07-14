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
public class GoodReceiveDetailDTO extends SuperDTO{
    private String orderId;
    private String code;
    private double buyingQty;
    private double buyingUPrice;
    private String unitQty;

    public GoodReceiveDetailDTO() {
    }

    public GoodReceiveDetailDTO(String orderId, String code, double buyingQty, double buyingUPrice, String unitQty) {
        this.orderId = orderId;
        this.code = code;
        this.buyingQty = buyingQty;
        this.buyingUPrice = buyingUPrice;
        this.unitQty = unitQty;
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
     * @return the buyingQty
     */
    public double getBuyingQty() {
        return buyingQty;
    }

    /**
     * @param buyingQty the buyingQty to set
     */
    public void setBuyingQty(double buyingQty) {
        this.buyingQty = buyingQty;
    }

    /**
     * @return the buyingUPrice
     */
    public double getBuyingUPrice() {
        return buyingUPrice;
    }

    /**
     * @param buyingUPrice the buyingUPrice to set
     */
    public void setBuyingUPrice(double buyingUPrice) {
        this.buyingUPrice = buyingUPrice;
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
    
    
}
