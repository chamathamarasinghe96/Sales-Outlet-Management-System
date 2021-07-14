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
public class ProductDTO extends SuperDTO {

    private String code;
    private String description;
    private double retailUPrice;
    private double wholeSaleUPrice;
    private double buyingUPrice;
    private String unitQty;
    private double qtyOnHand;

    public ProductDTO() {
    }

    public ProductDTO(String code, String description, double retailUPrice, double wholeSaleUPrice, double buyingUPrice, String unitQty, double qtyOnHand) {
        this.code = code;
        this.description = description;
        this.retailUPrice = retailUPrice;
        this.wholeSaleUPrice = wholeSaleUPrice;
        this.buyingUPrice = buyingUPrice;
        this.unitQty = unitQty;
        this.qtyOnHand = qtyOnHand;
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
     * @return the retailUPrice
     */
    public double getRetailUPrice() {
        return retailUPrice;
    }

    /**
     * @param retailUPrice the retailUPrice to set
     */
    public void setRetailUPrice(double retailUPrice) {
        this.retailUPrice = retailUPrice;
    }

    /**
     * @return the wholeSaleUPrice
     */
    public double getWholeSaleUPrice() {
        return wholeSaleUPrice;
    }

    /**
     * @param wholeSaleUPrice the wholeSaleUPrice to set
     */
    public void setWholeSaleUPrice(double wholeSaleUPrice) {
        this.wholeSaleUPrice = wholeSaleUPrice;
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

    /**
     * @return the qtyOnHand
     */
    public double getQtyOnHand() {
        return qtyOnHand;
    }

    /**
     * @param qtyOnHand the qtyOnHand to set
     */
    public void setQtyOnHand(double qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }
    
}
