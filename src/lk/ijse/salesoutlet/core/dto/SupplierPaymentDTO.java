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
public class SupplierPaymentDTO extends SuperDTO{
    private String spId;
    private double spAmount;
    private String isPayed;
    private String chequeNo;
    private String paymentDate;

    public SupplierPaymentDTO() {
    }

    public SupplierPaymentDTO(String spId, double spAmount, String isPayed, String chequeNo, String paymentDate) {
        this.spId = spId;
        this.spAmount = spAmount;
        this.isPayed = isPayed;
        this.chequeNo = chequeNo;
        this.paymentDate = paymentDate;
    }

    /**
     * @return the spId
     */
    public String getSpId() {
        return spId;
    }

    /**
     * @param spId the spId to set
     */
    public void setSpId(String spId) {
        this.spId = spId;
    }

    /**
     * @return the spAmount
     */
    public double getSpAmount() {
        return spAmount;
    }

    /**
     * @param spAmount the spAmount to set
     */
    public void setSpAmount(double spAmount) {
        this.spAmount = spAmount;
    }

    /**
     * @return the isPayed
     */
    public String getIsPayed() {
        return isPayed;
    }

    /**
     * @param isPayed the isPayed to set
     */
    public void setIsPayed(String isPayed) {
        this.isPayed = isPayed;
    }

    /**
     * @return the chequeNo
     */
    public String getChequeNo() {
        return chequeNo;
    }

    /**
     * @param chequeNo the chequeNo to set
     */
    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    /**
     * @return the paymentDate
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
    
}
