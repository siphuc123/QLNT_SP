package Views;

import DAO.NguoiDungDAO;
import Entity.NguoiDung;
import Helper.DialogHelper;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.Timer;

/**
 *
 * @author Phuc
 */
public class ForgotPassword extends javax.swing.JPanel {
    
    private LoginFrame LF;
    
    public ForgotPassword(LoginFrame LF) {
        initComponents();
        this.LF = LF;
        init();
    }
    
    boolean flag = false;
    int ranNum;
    int giay;
    Timer timer;
    Timer t;
    // lấy pass cho người dùng
    NguoiDungDAO dao = new NguoiDungDAO();
    
    void init() {
        btnGuiLai.setVisible(false);
        txtOTP.setVisible(false);
    }
    
    void guiMaOTP() {
        giay = 60;
        Random rand = new Random();
        ranNum = rand.nextInt(90000000) + 10000000;
        System.out.println(ranNum);
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (giay == 0) {
                    btnGuiLai.setText("Gửi lại");
                    btnGuiLai.setEnabled(true);
                    timer.stop();
                    t.stop();
                } else {
                    giay--;
                    btnGuiLai.setText(giay + "...");
                }
            }
        });
        timer.start();
        ActionListener a = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Random rand = new Random();
                ranNum = rand.nextInt(90000000) + 10000000;
                System.out.println(ranNum);
            }
        };
        t = new Timer(60000, a);
        t.start();
        try {
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", 587);
            String accountName = "vonghiep401@gmail.com";
            String accountPass = "lyjlytrwncdlbwkd";
            //------------------------------->
            Session s = Session.getInstance(p,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(accountName, accountPass);
                }
            });
            //--------------------------------->
//            String from = "vonghiep401@gmail.com";
            String to = txtResetPass.getText();
            List<NguoiDung> email = dao.findByEmailandID(to);
            if (email != null) {
                for (NguoiDung nd : email) {
                    String chuDe = "Mình là admin của thích ở trọ, Nhận mã OTP ở đây !";
                    String noiDung = "<h1>🏡<h1/><h2>Mã OTP của bạn là: <h2/><h1 style='color: blue'>" + String.valueOf(ranNum) + "<h1/>"
                            + "\n<b>*** Lưu ý:</b> <i style='color: red'>không được chia sẻ cho bất kì ai</i><b> ***</b>";
                    Message msg = new MimeMessage(s);
                    msg.setFrom(new InternetAddress("Admin-QLNT"));
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(nd.getEmail()));
                    msg.setSubject(chuDe);
                    msg.setText(noiDung);
                    // sử dụng dạng html web
                    MimeBodyPart contentPart = new MimeBodyPart();
                    contentPart.setContent(noiDung, "text/html; charset=utf-8");
                    MimeMultipart multiPart = new MimeMultipart();
                    multiPart.addBodyPart(contentPart);
                    msg.setContent(multiPart);
                    //--------------------------------->
                    Transport.send(msg);
                    //DialogHelper.alert(this, "Đã gữi mã OTP vào email của bạn. Hãy check và nhập để xác nhận người dùng !");
                }
            } else {
                DialogHelper.alert(this, "Không tìm thấy email tài khoản này !");
                //return;
            }
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtResetPass = new javax.swing.JTextField();
        btnAction = new javax.swing.JButton();
        txtOTP = new javax.swing.JTextField();
        btnGuiLai = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 156, 175));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_secure_40px.png"))); // NOI18N
        jLabel1.setText("Quên mật khẩu?");
        jLabel1.setIconTextGap(10);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 480, 59));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 470, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nhập email hoặc tài khoản của bạn:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        txtResetPass.setBackground(new java.awt.Color(0, 156, 175));
        txtResetPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtResetPass.setForeground(new java.awt.Color(0, 51, 51));
        txtResetPass.setText("Mời bạn nhập email hoặc tài khoản vào đây.");
        txtResetPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtResetPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtResetPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtResetPassFocusLost(evt);
            }
        });
        jPanel1.add(txtResetPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 450, 40));

        btnAction.setBackground(new java.awt.Color(0, 153, 153));
        btnAction.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAction.setText("Lấy mã OTP");
        btnAction.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAction.setFocusable(false);
        btnAction.setVerifyInputWhenFocusTarget(false);
        btnAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionActionPerformed(evt);
            }
        });
        jPanel1.add(btnAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 450, 40));

        txtOTP.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtOTP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOTP.setText("Nhập mã OTP");
        txtOTP.setToolTipText("Nhập mã OTP");
        txtOTP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtOTP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOTPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOTPFocusLost(evt);
            }
        });
        jPanel1.add(txtOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 120, 40));

        btnGuiLai.setBackground(new java.awt.Color(204, 255, 255));
        btnGuiLai.setText("Gửi lại");
        btnGuiLai.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuiLai.setEnabled(false);
        btnGuiLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuiLaiMouseClicked(evt);
            }
        });
        jPanel1.add(btnGuiLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 70, 40));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Cute_Forgot_Pass_Waiting.gif"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 490, 320));

        btnBack.setBackground(new java.awt.Color(255, 153, 153));
        btnBack.setText("Trở lại");
        btnBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 70, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtResetPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtResetPassFocusGained
        if (txtResetPass.getText().equals("Mời bạn nhập email hoặc tài khoản vào đây.")) {
            txtResetPass.setText("");
        }
    }//GEN-LAST:event_txtResetPassFocusGained

    private void txtResetPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtResetPassFocusLost
        if (txtResetPass.getText().equals("")) {
            txtResetPass.setText("Mời bạn nhập email hoặc tài khoản vào đây.");
        }
    }//GEN-LAST:event_txtResetPassFocusLost

    private void txtOTPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOTPFocusGained
        if (txtOTP.getText().equals("Nhập mã OTP")) {
            txtOTP.setText("");
        }
    }//GEN-LAST:event_txtOTPFocusGained

    private void txtOTPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOTPFocusLost
        if (txtOTP.getText().equals("")) {
            txtOTP.setText("Nhập mã OTP");
        }
    }//GEN-LAST:event_txtOTPFocusLost

    private void btnGuiLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuiLaiMouseClicked
        guiMaOTP();
        btnGuiLai.setEnabled(false);
    }//GEN-LAST:event_btnGuiLaiMouseClicked

    private void btnActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionActionPerformed
        String LayMK = txtResetPass.getText();
        String name, pass;
        try {
            NguoiDung taikhoan = dao.findById(LayMK); // lấy theo tài khoản
            NguoiDung email = dao.findByEmail(LayMK); // lấy theo email
            //-------------------------------------->
            if (taikhoan != null || email != null) {
                if (btnAction.getText().trim().equalsIgnoreCase("Lấy mã OTP") && !txtResetPass.getText().equals("Mời bạn nhập email hoặc tài khoản vào đây.") && !txtResetPass.getText().equals("")) {
                    txtOTP.setVisible(true);
                    btnGuiLai.setVisible(true);
                    btnAction.setText("Lấy lại mật khẩu");
                    guiMaOTP();
                    DialogHelper.alert(this, "Đã gữi mã OTP vào email của bạn. Hãy check và nhập để xác nhận người dùng !");
                } else if (btnAction.getText().trim().equalsIgnoreCase("Lấy mã OTP") && (txtResetPass.getText().equals("") || txtResetPass.getText().equals("Mời bạn nhập email hoặc tài khoản vào đây."))) {
                    DialogHelper.alert(this, "Nhập email để bắt đầu lấy mã OTP !!.");
                    txtResetPass.requestFocus();
                    txtResetPass.setBackground(new Color(255, 255, 215, 40));
                    return;
                }
                txtResetPass.setBackground(new Color(0, 156, 175));
                //------------------->
                if (btnAction.getText().equals("Lấy lại mật khẩu")) {
                    if (email != null) {
                        name = email.getHoTen();
                        pass = email.getMatKhau();
                    } else {
                        name = taikhoan.getHoTen();
                        pass = taikhoan.getMatKhau();
                    }
                    
                    String otp = txtOTP.getText().trim();
                    if (otp.equals("Nhập mã OTP")) {
                        DialogHelper.alert(this, "Bạn có 60 giây để nhập mã OTP trước khi nó bị đổi !");
                        txtOTP.grabFocus();
                        //return;
                    } else if (otp.equals(String.valueOf(ranNum))) {
                        DialogHelper.alert(this, "- Xin chào bạn " + name + "\n"
                                + "- Đây là mật khẩu của bạn: " + pass + "\n"
                                + "*** LƯU Ý: HÃY GIỮ THẬT KĨ MẬT KHẨU CỦA BẠN VÀ ĐỪNG CHO AI BIẾT ***");
                        LF.setSize(new Dimension(800, 633));
                    } else {
                        DialogHelper.alert(this, "Mã OTP không chính xác!");
                        txtOTP.grabFocus();
                        //return;
                    }
                }
            } else {
                DialogHelper.alert(this, "Tài khoản hoặc email không tồn tại ! Hãy kiểm tra lại.");
                txtResetPass.setBackground(new Color(255, 255, 215, 40));
                txtResetPass.grabFocus();
                //return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnActionActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        txtResetPass.setText("Mời bạn nhập email hoặc tài khoản vào đây.");
        LF.setSize(new Dimension(800, 633));
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAction;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGuiLai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtOTP;
    private javax.swing.JTextField txtResetPass;
    // End of variables declaration//GEN-END:variables
}
