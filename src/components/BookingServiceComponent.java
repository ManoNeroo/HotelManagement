/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.ServiceDetail;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author trinh
 */
public class BookingServiceComponent extends javax.swing.JPanel {

    private final ServiceDetail serviceDetail;

    /**
     * Creates new form BookingServiceComponent
     */
    public BookingServiceComponent(ServiceDetail serviceDetail) {
        this.serviceDetail = serviceDetail;
        initComponents();
        setupComponent();
    }

    public ServiceDetail getServiceDetail() {
        return serviceDetail;
    }

    public JLabel getLbMinusAmount() {
        return lbMinusAmount;
    }

    public JLabel getLbPlusAmount() {
        return lbPlusAmount;
    }

    public JLabel getLbRemoveServiceDetail() {
        return lbRemoveServiceDetail;
    }

    public JTextField getTxtAmount() {
        return txtAmount;
    }

    public JLabel getLbServiceImage() {
        return lbServiceImage;
    }

    public JLabel getLbServiceName() {
        return lbServiceName;
    }

    public JLabel getLbServicePrice() {
        return lbServicePrice;
    }

    public JLabel getLbServiceStatus() {
        return lbServiceStatus;
    }

    public void setLbMinusAmount(JLabel lbMinusAmount) {
        this.lbMinusAmount = lbMinusAmount;
    }

    public void setLbPlusAmount(JLabel lbPlusAmount) {
        this.lbPlusAmount = lbPlusAmount;
    }

    public void setLbRemoveServiceDetail(JLabel lbRemoveServiceDetail) {
        this.lbRemoveServiceDetail = lbRemoveServiceDetail;
    }

    public void setTxtAmount(JTextField txtAmount) {
        this.txtAmount = txtAmount;
    }

    public void setLbServiceImage(JLabel lbServiceImage) {
        this.lbServiceImage = lbServiceImage;
    }

    public void setLbServiceName(JLabel lbServiceName) {
        this.lbServiceName = lbServiceName;
    }

    public void setLbServicePrice(JLabel lbServicePrice) {
        this.lbServicePrice = lbServicePrice;
    }

    public void setLbServiceStatus(JLabel lbServiceStatus) {
        this.lbServiceStatus = lbServiceStatus;
    }

    private void setupComponent() {
        lbServiceName.setText(serviceDetail.getService().getName());
        NumberFormat formatter = NumberFormat.getInstance(new Locale("en", "US"));
        lbServicePrice.setText(formatter.format(serviceDetail.getService().getPrice()) + " vnđ");
        lbServiceStatus.setText("Còn " + serviceDetail.getService().getAmount() + " sản phẩm");
        txtAmount.setText(serviceDetail.getAmount() + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbServiceImage = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbServiceName = new javax.swing.JLabel();
        lbServicePrice = new javax.swing.JLabel();
        lbServiceStatus = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtAmount = new javax.swing.JTextField();
        lbPlusAmount = new javax.swing.JLabel();
        lbMinusAmount = new javax.swing.JLabel();
        lbRemoveServiceDetail = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        setMinimumSize(new java.awt.Dimension(470, 100));
        setPreferredSize(new java.awt.Dimension(470, 100));

        jPanel1.setPreferredSize(new java.awt.Dimension(468, 98));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 98));

        lbServiceImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbServiceImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgrounds/service (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbServiceImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbServiceImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(368, 98));

        lbServiceName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbServiceName.setText("Dịch vụ 100");

        lbServicePrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbServicePrice.setText("220,000 vnđ");

        lbServiceStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbServiceStatus.setText("Còn  14 sản phẩm");

        txtAmount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAmount.setText("10");
        txtAmount.setBorder(null);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
        );

        lbPlusAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPlusAmount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/plus20black.png"))); // NOI18N
        lbPlusAmount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPlusAmount.setPreferredSize(new java.awt.Dimension(30, 25));

        lbMinusAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMinusAmount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/minus20black.png"))); // NOI18N
        lbMinusAmount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMinusAmount.setPreferredSize(new java.awt.Dimension(30, 25));

        lbRemoveServiceDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRemoveServiceDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/closered24.png"))); // NOI18N
        lbRemoveServiceDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbRemoveServiceDetail.setMaximumSize(new java.awt.Dimension(28, 28));
        lbRemoveServiceDetail.setMinimumSize(new java.awt.Dimension(28, 28));
        lbRemoveServiceDetail.setPreferredSize(new java.awt.Dimension(28, 28));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbServiceStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(lbServicePrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbMinusAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbServiceName, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPlusAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbRemoveServiceDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbServiceName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbRemoveServiceDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbServicePrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbServiceStatus))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbMinusAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbPlusAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbMinusAmount;
    private javax.swing.JLabel lbPlusAmount;
    private javax.swing.JLabel lbRemoveServiceDetail;
    private javax.swing.JLabel lbServiceImage;
    private javax.swing.JLabel lbServiceName;
    private javax.swing.JLabel lbServicePrice;
    private javax.swing.JLabel lbServiceStatus;
    private javax.swing.JTextField txtAmount;
    // End of variables declaration//GEN-END:variables
}