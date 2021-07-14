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
public class CustomerPaymentDTO extends SuperDTO{
    private String cpId;
    private double totalValue;
    private double netValue;
    private String isPayed;
    private String chequeNo;
    private String bankBranchCode;

    public CustomerPaymentDTO() {
    }

    public CustomerPaymentDTO(String cpId, double totalValue, double netValue, String isPayed, String chequeNo, String bankBranchCode) {
        this.cpId = cpId;
        this.totalValue = totalValue;
        this.netValue = netValue;
        this.isPayed = isPayed;
        this.chequeNo = chequeNo;
        this.bankBranchCode = bankBranchCode;
    }

    /**
     * @return the cpId
     */
    public String getCpId() {
        return cpId;
    }

    /**
     * @param cpId the cpId to set
     */
    public void setCpId(String cpId) {
        this.cpId = cpId;
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
     * @return the bankBranchCode
     */
    public String getBankBranchCode() {
        return bankBranchCode;
    }

    /**
     * @param bankBranchCode the bankBranchCode to set
     */
    public void setBankBranchCode(String bankBranchCode) {
        this.bankBranchCode = bankBranchCode;
    }
    
}
