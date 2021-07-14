/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.view;

import java.awt.Dialog;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.ijse.jasper.IJSEJasperViewer;
import lk.ijse.jasper.JasperUtil;
import lk.ijse.jasper.Report;
import lk.ijse.salesoutlet.controller.ManageProductController;
import lk.ijse.salesoutlet.controller.PlaceOrderRetailController;
import lk.ijse.salesoutlet.core.dto.CustomerPaymentDTO;
import lk.ijse.salesoutlet.core.dto.OrderDetailDTO;
import lk.ijse.salesoutlet.core.dto.OrdersDTO;
import lk.ijse.salesoutlet.core.dto.ProductDTO;
import lk.ijse.salesoutlet.db.DBConnection;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperReportsContext;

/**
 *
 * @author user
 */
@Report("lk.ijse.salesoutlet.report")
public class PlaceOrderRetail extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private double amount;
    private double totalAmount = 0;
    private double totalDiscount = 0;
    private String newOrderId;
    private String paymentId;

    /**
     * Creates new form PlaceOrderCash1
     */
    public PlaceOrderRetail() {
        initComponents();
        getCurrentDate();
        loadOrderId();
        loadProductCodes();

        getPaymentID();

        txtDiscount.setText("0.00");

        cmbProductCode.requestFocusInWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cmbProductCode = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        lblSellingUPrice = new javax.swing.JLabel();
        lblUnitQty = new javax.swing.JLabel();
        lblQtyOnHand = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnRemove = new javax.swing.JButton();
        btnAddOrder = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lblNetAmount = new javax.swing.JLabel();
        lblTotalDiscount = new javax.swing.JLabel();
        lblOrderID = new javax.swing.JLabel();
        lblOrderDate = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblTotalAmount = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblNumberOfProducts = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(790, 680));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Place Order - Retail");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 250, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Order ID");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 70, 32));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 790, 9));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Order Date");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 90, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText(" Product Code");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 33));

        cmbProductCode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProductCodeItemStateChanged(evt);
            }
        });
        cmbProductCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductCodeActionPerformed(evt);
            }
        });
        jPanel2.add(cmbProductCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 120, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Description");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 80, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Selling U/Price Rs.");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Unit Qty");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 60, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText(" Qty");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 30, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText(" Qty On Hand");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 90, 30));

        txtQty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        jPanel2.add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 70, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Discount");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, 30));

        txtDiscount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountActionPerformed(evt);
            }
        });
        jPanel2.add(txtDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 70, 30));

        lblSellingUPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSellingUPrice.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(lblSellingUPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 100, 30));

        lblUnitQty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUnitQty.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(lblUnitQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 80, 30));

        lblQtyOnHand.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblQtyOnHand.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(lblQtyOnHand, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 80, 30));

        lblDescription.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDescription.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(lblDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 210, 30));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 780, 130));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Description", "Unit Qty", "Selling U/Price", "Qty", "Amount", "Discount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProducts);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 790, 230));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("List of Products");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 20));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 790, 260));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 790, 10));

        btnRemove.setBackground(new java.awt.Color(255, 102, 102));
        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRemove.setText("Remove Item");
        btnRemove.setToolTipText("Remove Item From Above List");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 630, 136, 37));

        btnAddOrder.setBackground(new java.awt.Color(102, 255, 51));
        btnAddOrder.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddOrder.setText("Add Order");
        btnAddOrder.setToolTipText("Add Order,Order Details and Update ITemStock");
        btnAddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrderActionPerformed(evt);
            }
        });
        add(btnAddOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 630, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText(" NET AMOUNT");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 590, 90, 30));

        lblNetAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNetAmount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(lblNetAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 590, 110, 30));

        lblTotalDiscount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(lblTotalDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, 90, 30));

        lblOrderID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblOrderID.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(lblOrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 120, 30));

        lblOrderDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblOrderDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOrderDate.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(lblOrderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("-");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 570, 20, 10));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Total Amount and Total Discount");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, 190, 30));

        lblTotalAmount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(lblTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 110, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("No of Products");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 90, 30));

        lblNumberOfProducts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNumberOfProducts.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(lblNumberOfProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, 40, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderActionPerformed
        CustomerPaymentDTO payment = new CustomerPaymentDTO(
                paymentId,
                Double.parseDouble(lblTotalAmount.getText()),
                Double.parseDouble(lblNetAmount.getText()),
                "NotPayed",
                null,
                null
        );

        OrdersDTO order = new OrdersDTO(
                lblOrderID.getText(),
                null,
                paymentId,
                Integer.parseInt(lblNumberOfProducts.getText()),
                lblOrderDate.getText()
        );

        ArrayList<OrderDetailDTO> orderDetails = new ArrayList<>();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            orderDetails.add(new OrderDetailDTO(
                    lblOrderID.getText(),
                    (String) dtm.getValueAt(i, 0),
                    (double) dtm.getValueAt(i, 4),
                    (double) dtm.getValueAt(i, 3),
                    (String) dtm.getValueAt(i, 2),
                    (double) dtm.getValueAt(i, 6)
            ));
        }

        try {
            boolean isAdded = PlaceOrderRetailController.placeOrder(payment, order, orderDetails);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Order Added Successfully.");

                JasperUtil.init(PlaceOrderRetail.class);

                JasperReportsContext ctx = JasperUtil.getReportContext();

                JasperReport compiledReport = JasperUtil.getCompiledReport("PlaceOrder.jasper");

                JasperFillManager fillManager = JasperFillManager.getInstance(ctx);

                HashMap<String, Object> reportParams = new HashMap<>();
                reportParams.put("orderId", lblOrderID.getText());

                Connection connection = DBConnection.getInstance().getConnection();

                JasperPrint filledReport = fillManager.fill(compiledReport, reportParams, connection);

                IJSEJasperViewer frmViewer = new IJSEJasperViewer(filledReport);
                frmViewer.setTitle("CUSTOMER ORDER FORM FOR ORDERID " + lblOrderID.getText());
                frmViewer.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
                frmViewer.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Add Order due to Some Reasons");
            }
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrderRetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddOrderActionPerformed

    private void txtDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountActionPerformed
        dtm = (DefaultTableModel) tblProducts.getModel();
        String code = (String) cmbProductCode.getSelectedItem();
        String description = lblDescription.getText();
        String unitQty = lblUnitQty.getText();
        double sellingUPrice = Double.parseDouble(lblSellingUPrice.getText());
        double qty = Double.parseDouble(txtQty.getText());
        double discount = Double.parseDouble(txtDiscount.getText());
        amount = sellingUPrice * qty;

        totalAmount += amount;
        totalDiscount += discount;

        lblTotalAmount.setText(Double.toString(totalAmount));
        lblTotalDiscount.setText(Double.toString(totalDiscount));
        lblNetAmount.setText(Double.toString(totalAmount - totalDiscount));

        for (int i = 0; i < dtm.getRowCount(); i++) {
            if (dtm.getValueAt(i, 0) == code) {
                dtm.setValueAt((double) dtm.getValueAt(i, 4) + qty, i, 4);
                dtm.setValueAt((double) dtm.getValueAt(i, 3) * (double) dtm.getValueAt(i, 4), i, 5);
                dtm.setValueAt((double) dtm.getValueAt(i, 6) + discount, i, 6);

                lblNumberOfProducts.setText(Integer.toString(dtm.getRowCount()));
                cmbProductCode.requestFocusInWindow();
                txtQty.setText(null);
                return;
            }
        }

        dtm.addRow(new Object[]{code, description, unitQty, sellingUPrice, qty, amount, discount});

        lblNumberOfProducts.setText(Integer.toString(dtm.getRowCount()));
        cmbProductCode.requestFocusInWindow();
        txtQty.setText(null);
        txtDiscount.setText("0.00");
    }//GEN-LAST:event_txtDiscountActionPerformed

    private void cmbProductCodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProductCodeItemStateChanged
        String code = (String) cmbProductCode.getSelectedItem();
        ProductDTO product = new ProductDTO(code, null, 0, 0, 0, null, 0);
        try {
            ProductDTO searchedProduct = ManageProductController.searchProduct(product);
            lblDescription.setText(searchedProduct.getDescription());
            lblUnitQty.setText(searchedProduct.getUnitQty());
            lblSellingUPrice.setText(Double.toString(searchedProduct.getRetailUPrice()));
            lblQtyOnHand.setText(Double.toString(searchedProduct.getQtyOnHand()));
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrderRetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbProductCodeItemStateChanged

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        txtQty.selectAll();
        txtDiscount.requestFocusInWindow();
        txtDiscount.selectAll();
    }//GEN-LAST:event_txtQtyActionPerformed

    private void cmbProductCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProductCodeActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int selectedRow = tblProducts.getSelectedRow();
        if (selectedRow != -1) {
            totalAmount = totalAmount - (double) dtm.getValueAt(selectedRow, 5);
            totalDiscount = totalDiscount - (double) dtm.getValueAt(selectedRow, 6);

            dtm.removeRow(selectedRow);
            lblTotalAmount.setText(Double.toString(totalAmount));
            lblTotalDiscount.setText(Double.toString(totalDiscount));
            lblNetAmount.setText(Double.toString(totalAmount - totalDiscount));
            lblNumberOfProducts.setText(Integer.toString(dtm.getRowCount()));
        }
    }//GEN-LAST:event_btnRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddOrder;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<String> cmbProductCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblNetAmount;
    private javax.swing.JLabel lblNumberOfProducts;
    private javax.swing.JLabel lblOrderDate;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JLabel lblQtyOnHand;
    private javax.swing.JLabel lblSellingUPrice;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JLabel lblTotalDiscount;
    private javax.swing.JLabel lblUnitQty;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables

    private void getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String format = sdf.format(date);
        lblOrderDate.setText(format);
    }

    private void loadOrderId() {
        try {
            String orderId = PlaceOrderRetailController.getOrderId();
            lblOrderID.setText(orderId);
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrderRetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadProductCodes() {
        try {
            ArrayList<ProductDTO> allProducts = ManageProductController.getAllProducts();
            for (ProductDTO product : allProducts) {
                cmbProductCode.addItem(product.getCode());
            }
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrderRetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getPaymentID() {
        try{
            paymentId = PlaceOrderRetailController.getCurrentPaymentID();

        } catch (Exception ex) {
            Logger.getLogger(PlaceOrderRetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
