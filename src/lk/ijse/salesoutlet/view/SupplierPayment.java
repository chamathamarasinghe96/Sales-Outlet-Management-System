/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lk.ijse.salesoutlet.controller.SupplierPaymentController;
import lk.ijse.salesoutlet.core.dto.CustomDTO;
import lk.ijse.salesoutlet.core.dto.SupplierPaymentDTO;
import lk.ijse.salesoutlet.view.util.Validator;

/**
 *
 * @author user
 */
public class SupplierPayment extends javax.swing.JPanel {

    /**
     * Creates new form SupplierPayment1
     */
    public SupplierPayment() {
        initComponents();

        loadCurrentDate();
        loadRequiredOrderIDs();

        rbtCashPayments.doClick();
        isCashPaymentSelected(true);
        isChequePaymentSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        rbtCashPayments = new javax.swing.JRadioButton();
        lblCash = new javax.swing.JLabel();
        txtCash = new javax.swing.JTextField();
        lblBalance = new javax.swing.JLabel();
        rbtChequePayments = new javax.swing.JRadioButton();
        lblAmount = new javax.swing.JLabel();
        lblChequeNo = new javax.swing.JLabel();
        txtChequeNo = new javax.swing.JTextField();
        lblTextBalance = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnPrintBill = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbGRNID = new javax.swing.JComboBox<>();
        lblPaymentID = new javax.swing.JLabel();
        lblPaymentDate = new javax.swing.JLabel();
        lblTotalBillValue = new javax.swing.JLabel();
        lblProductCount = new javax.swing.JLabel();
        lblTextAmount = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Supplier Payments");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Payment ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 80, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("GRN ID");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 60, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Payment Date");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 100, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 790, 10));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText(" No of Products");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 100, 30));

        rbtCashPayments.setBackground(new java.awt.Color(235, 233, 233));
        buttonGroup1.add(rbtCashPayments);
        rbtCashPayments.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        rbtCashPayments.setMnemonic('y');
        rbtCashPayments.setText("CASH PAYMENTS");
        rbtCashPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtCashPaymentsActionPerformed(evt);
            }
        });
        jPanel1.add(rbtCashPayments, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 130, 30));

        lblCash.setDisplayedMnemonic('h');
        lblCash.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCash.setLabelFor(txtCash);
        lblCash.setText(" Cash Rs.");
        jPanel1.add(lblCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 60, 30));

        txtCash.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCashActionPerformed(evt);
            }
        });
        jPanel1.add(txtCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 140, 30));

        lblBalance.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblBalance.setText("Balance Rs.");
        jPanel1.add(lblBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 80, 30));

        rbtChequePayments.setBackground(new java.awt.Color(235, 233, 233));
        buttonGroup1.add(rbtChequePayments);
        rbtChequePayments.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        rbtChequePayments.setMnemonic('q');
        rbtChequePayments.setText("CHEQUE PAYMENTS");
        rbtChequePayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtChequePaymentsActionPerformed(evt);
            }
        });
        jPanel1.add(rbtChequePayments, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, 30));

        lblAmount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAmount.setText("Amount Rs.");
        jPanel1.add(lblAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 500, 80, 30));

        lblChequeNo.setDisplayedMnemonic('h');
        lblChequeNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblChequeNo.setLabelFor(txtChequeNo);
        lblChequeNo.setText("  Cheque No.");
        jPanel1.add(lblChequeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 80, 30));

        txtChequeNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtChequeNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChequeNoActionPerformed(evt);
            }
        });
        jPanel1.add(txtChequeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 140, 30));

        lblTextBalance.setBackground(new java.awt.Color(255, 255, 255));
        lblTextBalance.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblTextBalance.setOpaque(true);
        jPanel1.add(lblTextBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 140, 30));

        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 255)));
        jLabel12.setOpaque(true);
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 760, 80));

        btnPrintBill.setBackground(new java.awt.Color(204, 255, 204));
        btnPrintBill.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPrintBill.setText("ACCEPT");
        btnPrintBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintBillActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrintBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 600, 120, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText(" Total Bill Value Rs.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 120, 30));

        cmbGRNID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbGRNID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGRNIDItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbGRNID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 100, 30));

        lblPaymentID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPaymentID.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lblPaymentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 80, 30));

        lblPaymentDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPaymentDate.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lblPaymentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 140, 30));

        lblTotalBillValue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotalBillValue.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lblTotalBillValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 140, 30));

        lblProductCount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblProductCount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lblProductCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 140, 30));

        lblTextAmount.setBackground(new java.awt.Color(255, 255, 255));
        lblTextAmount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTextAmount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblTextAmount.setOpaque(true);
        jPanel1.add(lblTextAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, 130, 30));

        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 255)));
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 760, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCashActionPerformed

        double cash = Double.parseDouble(txtCash.getText());

        if (!Validator.isValidPrice(txtCash.getText())) {
            JOptionPane.showMessageDialog(this, "Please enter a vaild amount");
            txtCash.selectAll();
            txtCash.requestFocusInWindow();
            return;

        } else {

            if (cash < Double.parseDouble(lblTotalBillValue.getText())) {
                JOptionPane.showMessageDialog(this, "Please enter a vaild amount");
                txtCash.selectAll();
                txtCash.requestFocusInWindow();
                return;
            }
        }

        cash -= Double.parseDouble(lblTotalBillValue.getText());
        lblBalance.setText(Double.toString(cash));
    }//GEN-LAST:event_txtCashActionPerformed

    private void rbtChequePaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtChequePaymentsActionPerformed
        if (rbtChequePayments.isSelected()) {
            isChequePaymentSelected(true);
            isCashPaymentSelected(false);
        }
    }//GEN-LAST:event_rbtChequePaymentsActionPerformed

    private void txtChequeNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChequeNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChequeNoActionPerformed

    private void cmbGRNIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGRNIDItemStateChanged

        String orderId = (String) cmbGRNID.getSelectedItem();
        try {
            CustomDTO paymentData = SupplierPaymentController.getSupplierOrderData(new CustomDTO(orderId));
            lblPaymentID.setText(paymentData.getPaymentId());
            lblTotalBillValue.setText(Double.toString(paymentData.getTotalValue()));
            lblProductCount.setText(Integer.toString(paymentData.getProductCount()));
            lblTextAmount.setText(Double.toString(paymentData.getTotalValue()));
        } catch (Exception ex) {
            Logger.getLogger(SupplierPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbGRNIDItemStateChanged

    private void rbtCashPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtCashPaymentsActionPerformed
        if (rbtCashPayments.isSelected()) {
            isCashPaymentSelected(true);
            isChequePaymentSelected(false);
        }
    }//GEN-LAST:event_rbtCashPaymentsActionPerformed

    private void btnPrintBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintBillActionPerformed

        SupplierPaymentDTO supplierPaymentDTO=null;
        if (rbtCashPayments.isSelected()) {
            double cash = Double.parseDouble(txtCash.getText());

            if (!Validator.isValidPrice(txtCash.getText())) {
                JOptionPane.showMessageDialog(this, "Please enter a vaild amount");
                txtCash.selectAll();
                txtCash.requestFocusInWindow();
                return;

            } else {

                if (cash < Double.parseDouble(lblTotalBillValue.getText())) {
                    JOptionPane.showMessageDialog(this, "Please enter a vaild amount");
                    txtCash.selectAll();
                    txtCash.requestFocusInWindow();
                    return;
                }
            }

            cash -= Double.parseDouble(lblTotalBillValue.getText());
            lblTextBalance.setText(Double.toString(cash));
            
            supplierPaymentDTO=new SupplierPaymentDTO(
                    lblPaymentID.getText(),
                    Double.parseDouble(lblTotalBillValue.getText()),
                    "Payed",
                    "",
                    lblPaymentDate.getText()
            );
        }
        
        if(rbtChequePayments.isSelected()){
            String chequeNo=txtChequeNo.getText();

            if (!Validator.isValidChequeNo(chequeNo)) {
                JOptionPane.showMessageDialog(this, "Please enter a valid Cheque No");
                txtChequeNo.selectAll();
                txtChequeNo.requestFocusInWindow();
                return;
            }
            
            supplierPaymentDTO=new SupplierPaymentDTO(
                    lblPaymentID.getText(),
                    Double.parseDouble(lblTotalBillValue.getText()),
                    "Payed",
                    txtChequeNo.getText(),
                    lblPaymentDate.getText()
            );
        }
        
        try {
            boolean isPayed=SupplierPaymentController.addPayment(supplierPaymentDTO);
            if (isPayed) {
                JOptionPane.showMessageDialog(this, "Payment was done successfully.");
                
            }else{
                JOptionPane.showMessageDialog(this, "Payment details were not successfully submitted due to some reasons.Try Again");
            }
        } catch (Exception ex) {
            Logger.getLogger(SupplierPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrintBillActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrintBill;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbGRNID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblCash;
    private javax.swing.JLabel lblChequeNo;
    private javax.swing.JLabel lblPaymentDate;
    private javax.swing.JLabel lblPaymentID;
    private javax.swing.JLabel lblProductCount;
    private javax.swing.JLabel lblTextAmount;
    private javax.swing.JLabel lblTextBalance;
    private javax.swing.JLabel lblTotalBillValue;
    private javax.swing.JRadioButton rbtCashPayments;
    private javax.swing.JRadioButton rbtChequePayments;
    private javax.swing.JTextField txtCash;
    private javax.swing.JTextField txtChequeNo;
    // End of variables declaration//GEN-END:variables

    private void loadCurrentDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String format = sdf.format(date);
        lblPaymentDate.setText(format);
    }

    private void loadRequiredOrderIDs() {
        try {
            ArrayList<String> allSupplierIDs = SupplierPaymentController.loadSupplierIDs();
            for (String orderID : allSupplierIDs) {
                cmbGRNID.addItem(orderID);
            }

        } catch (Exception ex) {
            Logger.getLogger(SupplierPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void isCashPaymentSelected(boolean value) {
        lblCash.setEnabled(value);
        txtCash.setEnabled(value);
        txtCash.setText(null);
        lblBalance.setEnabled(value);
        lblTextBalance.setEnabled(value);
        lblTextBalance.setText(null);

    }

    private void isChequePaymentSelected(boolean value) {
        lblChequeNo.setEnabled(value);
        txtChequeNo.setEnabled(value);
        txtChequeNo.setText(null);
        lblAmount.setEnabled(value);
        lblTextAmount.setEnabled(value);
    }

}
