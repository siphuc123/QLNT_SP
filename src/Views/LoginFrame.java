package Views;

import DAO.NguoiDungCuoiDAO;
import DAO.NguoiDungDAO;
import Entity.NguoiDung;
import Entity.NguoiDungCuoi;
import Helper.DialogHelper;
import Helper.ShareHelper;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;

public class LoginFrame extends javax.swing.JFrame {

    public LoginFrame() {
        initComponents();
        init();
        this.setSize(new Dimension(800, 633));
    }

    NguoiDungDAO dao = new NguoiDungDAO();
    NguoiDungCuoiDAO NDC = new NguoiDungCuoiDAO();
    // lấy panel đổi mk

    // lệnh cài đặt cơ bản
    private void init() {
        setIconImage(ShareHelper.APP_ICON);
        setLocationRelativeTo(null);
        pnlLogin.setBackground(new Color(0, 152, 152, 110));
        txtTaiKhoan.setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 15));
        txtPass.setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 15));
        remember();
        pack();
    }

    // Tự động điền thông tin khi Remember Me được chọn
    void remember() {
        NguoiDungCuoi nguoiDungCuoi = NDC.select();
        NguoiDung nguoiDung = dao.findById(nguoiDungCuoi.getMaNguoiDungCuoi());
        if (nguoiDungCuoi.isRemember()) {
            chkNhoMK.setSelected(true);
            txtTaiKhoan.setText(nguoiDungCuoi.getMaNguoiDungCuoi());
            txtPass.setText(nguoiDung.getMatKhau());
        } else {
            chkNhoMK.setSelected(false);
        }
    }

    private void login() {
        String mand = txtTaiKhoan.getText();
        String matKhau = new String(txtPass.getPassword());
        if (!mand.equals("")) {
            if (!matKhau.equals("")) {
                try {
                    NguoiDung nguoiDung = dao.findById(mand);

                    if (nguoiDung != null) {
                        String matKhau2 = nguoiDung.getMatKhau();
                        if (matKhau.equals(matKhau2)) {
                            ShareHelper.USER = nguoiDung;
                            if (chkNhoMK.isSelected() && !txtTaiKhoan.getText().isEmpty() && !txtPass.getText().isEmpty()) {
                                NguoiDungCuoi ndc = new NguoiDungCuoi();
                                ndc.setMaNguoiDungCuoi(txtTaiKhoan.getText());
                                ndc.setRemember(true);
                                NDC.update(ndc);
                            } else {
                                NguoiDungCuoi ndc = new NguoiDungCuoi();
                                ndc.setMaNguoiDungCuoi(txtTaiKhoan.getText());
                                ndc.setRemember(false);
                                NDC.update(ndc);
                            }
                            new LoadingFrame().setVisible(true);
                            this.dispose();
                        } else {
                            DialogHelper.alert(this, "Sai mật khẩu!");
                            txtPass.grabFocus();
                        }
                    } else {
                        DialogHelper.alert(this, "Sai tên đăng nhập!");
                        txtTaiKhoan.grabFocus();
                    }
                } catch (Exception e) {
                    DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
                    System.out.println(e);
                }
            } else {
                DialogHelper.alert(this, "Mật khẩu đang bị trống. Vui lòng nhập !");
                txtPass.grabFocus();
            }
        } else {
            DialogHelper.alert(this, "Tài khoản không được để trống !");
            txtTaiKhoan.grabFocus();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlQuenMK = new javax.swing.JPanel();
        pnlMainLogin = new javax.swing.JPanel();
        pnlLogin = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        chkNhoMK = new javax.swing.JCheckBox();
        lblQuenMK = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtTaiKhoan = new Swing_palette.TextField();
        txtPass = new Swing_palette.PasswordField();
        pnlChe = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblQRCode = new javax.swing.JLabel();
        lblTheme = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập vào hệ thống");
        setResizable(false);

        pnlQuenMK.setBackground(new java.awt.Color(0, 156, 175));
        pnlQuenMK.setLayout(new java.awt.CardLayout());

        pnlMainLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogin.setBackground(new java.awt.Color(0, 156, 175));
        pnlLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_house_100px_2.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ NHÀ TRỌ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlLogin.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 490, -1));

        chkNhoMK.setBackground(new java.awt.Color(0, 152, 152));
        chkNhoMK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkNhoMK.setForeground(new java.awt.Color(255, 255, 255));
        chkNhoMK.setText("Remember me?");
        chkNhoMK.setContentAreaFilled(false);
        chkNhoMK.setFocusPainted(false);
        chkNhoMK.setIconTextGap(5);
        chkNhoMK.setRolloverEnabled(false);
        chkNhoMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkNhoMKActionPerformed(evt);
            }
        });
        pnlLogin.add(chkNhoMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        lblQuenMK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQuenMK.setForeground(new java.awt.Color(255, 255, 255));
        lblQuenMK.setText("Quên mật khẩu?");
        lblQuenMK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuenMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMKMouseClicked(evt);
            }
        });
        pnlLogin.add(lblQuenMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, 20));

        btnLogin.setBackground(new java.awt.Color(0, 153, 153));
        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 47, 88));
        btnLogin.setText("ĐĂNG NHẬP");
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 6));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 330, 50));

        txtTaiKhoan.setBackground(new java.awt.Color(0, 156, 175));
        txtTaiKhoan.setForeground(new java.awt.Color(204, 255, 255));
        txtTaiKhoan.setToolTipText("Nhập tài khoản");
        txtTaiKhoan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtTaiKhoan.setLabelText("Tài khoản");
        txtTaiKhoan.setLineColor(new java.awt.Color(255, 255, 255));
        txtTaiKhoan.setOpaque(false);
        txtTaiKhoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTaiKhoanKeyPressed(evt);
            }
        });
        pnlLogin.add(txtTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 109, 400, 62));

        txtPass.setBackground(new java.awt.Color(0, 156, 175));
        txtPass.setForeground(new java.awt.Color(204, 255, 255));
        txtPass.setToolTipText("Nhập mật khẩu");
        txtPass.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtPass.setLabelText("Mật khẩu");
        txtPass.setLineColor(new java.awt.Color(255, 255, 255));
        txtPass.setOpaque(false);
        txtPass.setShowAndHide(true);
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });
        pnlLogin.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 400, 62));

        pnlChe.setBackground(new java.awt.Color(0, 152, 150));

        javax.swing.GroupLayout pnlCheLayout = new javax.swing.GroupLayout(pnlChe);
        pnlChe.setLayout(pnlCheLayout);
        pnlCheLayout.setHorizontalGroup(
            pnlCheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );
        pnlCheLayout.setVerticalGroup(
            pnlCheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pnlLogin.add(pnlChe, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 125, 20));

        jPanel1.setBackground(new java.awt.Color(0, 156, 175));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        pnlLogin.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 400, 70));

        jPanel2.setBackground(new java.awt.Color(0, 156, 175));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        pnlLogin.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 400, 70));

        lblQRCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQRCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/qr-code.png"))); // NOI18N
        lblQRCode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQRCode.setOpaque(true);
        lblQRCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQRCodeMouseClicked(evt);
            }
        });
        pnlLogin.add(lblQRCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 50, 50));

        pnlMainLogin.add(pnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 495, 410));

        lblTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logintheme.jpg"))); // NOI18N
        pnlMainLogin.add(lblTheme, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMainLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlQuenMK, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlQuenMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkNhoMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkNhoMKActionPerformed
        if (chkNhoMK.isSelected() && !txtTaiKhoan.getText().isEmpty() && !txtPass.getText().isEmpty()) {
            NguoiDungCuoi ndc = new NguoiDungCuoi();
            ndc.setMaNguoiDungCuoi(txtTaiKhoan.getText());
            ndc.setRemember(true);
            NDC.update(ndc);
        } else {
            NguoiDungCuoi ndc = new NguoiDungCuoi();
            ndc.setMaNguoiDungCuoi(txtTaiKhoan.getText());
            ndc.setRemember(false);
            NDC.update(ndc);
        }
    }//GEN-LAST:event_chkNhoMKActionPerformed

    private void lblQuenMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMKMouseClicked
        if (this.getSize().getWidth() < 1000) {
            ForgotPassword fp = new ForgotPassword(this);
            fp.setVisible(true);
            pnlQuenMK.add(fp, BorderLayout.EAST);
            this.setSize(new Dimension(1300, 633));
        } else {
            pnlQuenMK.removeAll();
            this.setSize(new Dimension(800, 633));
        }
    }//GEN-LAST:event_lblQuenMKMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtTaiKhoanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTaiKhoanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPass.grabFocus();
        }
    }//GEN-LAST:event_txtTaiKhoanKeyPressed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_txtPassKeyPressed

    private void lblQRCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQRCodeMouseClicked
        txtTaiKhoan.setText("");
        txtPass.setText("");
        chkNhoMK.setSelected(false);
        new ReadQRCodeJDialog(this, true).setVisible(true);
        if (ShareHelper.mand != null) {
            txtTaiKhoan.setText(ShareHelper.mand);
        }

        if (ShareHelper.mand != null) {
            txtPass.setText(ShareHelper.mk);
        }

        login();
    }//GEN-LAST:event_lblQRCodeMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox chkNhoMK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblQRCode;
    private javax.swing.JLabel lblQuenMK;
    private javax.swing.JLabel lblTheme;
    private javax.swing.JPanel pnlChe;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlMainLogin;
    private javax.swing.JPanel pnlQuenMK;
    private Swing_palette.PasswordField txtPass;
    private Swing_palette.TextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
