package Views;

import DAO.NguoiDungDAO;
import Entity.NguoiDung;
import Helper.DialogHelper;
import Helper.ShareHelper;
import static Views.FormQLKhachThue.verifyEmail;
import java.awt.Font;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class FormTaiKhoan extends javax.swing.JPanel {

    public FormTaiKhoan() {
        initComponents();
        init();
    }
    NguoiDungDAO nddao = new NguoiDungDAO();
    int row = -1;
    int maHoaDon;
    int ranNum;
    int giay;
    Timer timer;
    Timer t;
    boolean show = true;
    boolean show1 = true;
    boolean show2 = true;
    boolean show3 = true;
    private TableRowSorter<TableModel> rowSorter;

    void init() {
        this.fillTable();
        this.row = -1;
        this.updateStatus();
        tblTaiKhoan.getTableHeader().setFont(new Font("Calibri", 0, 18));
        tblTaiKhoan.getColumnModel().getColumn(3).setMaxWidth(1000);
        tblTaiKhoan.getColumnModel().getColumn(3).setPreferredWidth(350);
        tblTaiKhoan.setShowGrid(true);
        btnGuiMaOTP.setEnabled(false);
        if (ShareHelper.authenticated()) {
            if (ShareHelper.USER.isVaiTro()) {
                rdoChuTro.setEnabled(false);
                rdoQLTro.setEnabled(false);
            }
        }
        rowSorter = new TableRowSorter<>(tblTaiKhoan.getModel());
        tblTaiKhoan.setRowSorter(rowSorter);
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel();
        model.setRowCount(0);
        try {
            List<NguoiDung> list = nddao.selectAll(); // Đọc dữ liệu từ database
            for (NguoiDung nd : list) {
                Object[] row = {nd.getMaNguoiDung(),
                    nd.getHoTen(),
                    nd.isVaiTro() ? "Quản lý trọ" : "Chủ trọ",
                    nd.getEmail()
                };
                model.addRow(row); // Thêm một hàng vào bảng
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }

    void insert() {
        if (check()) {
            NguoiDung nd = getForm();
            try {
                nddao.insert(nd);
                this.fillTable();
                DialogHelper.alert(this, "Thêm mới thành công!");
                row = 0;
                updateStatus();
            } catch (Exception e) {
                DialogHelper.alert(this, "Thêm mới thất bại!");
                e.printStackTrace();
            }
        }
    }

    void update() {
        if (txtHoTen.getText().isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập họ và tên!");
            txtHoTen.grabFocus();
        } else if (txtPass.getText().isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập mật khẩu!");
            txtPass.grabFocus();
        } else if (txtEmail.getText().isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập Email!");
            txtEmail.grabFocus();
        } else if (!txtEmail.getText().trim().matches("^([A-Za-z0-9]+)(\\.[A-Za-z0-9]+)*@([A-Za-z0-9]+)(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            DialogHelper.alert(this, "Email không đúng định dạng!");
            txtEmail.grabFocus();
        } else {
            NguoiDung nd = getForm();
            try {
                nddao.update(nd);
                this.fillTable();
                DialogHelper.alert(this, "Cập nhật thành công!");
                if (ShareHelper.USER.getMaNguoiDung().equals(nd.getMaNguoiDung())) {
                    ShareHelper.USER.setVaiTro(nd.isVaiTro());
                    new mainFrame().setVisible(true);
                }
            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại!");
                e.printStackTrace();
            }
        }
    }

    void updateMK() {
        String otp = txtOTP.getText().trim();
        String mk = txtMKHienTai.getText();
        String mkm = txtMKMoi.getText();
        String xnmk = txtXNMK.getText();
        String nguoidung = txtMaNguoiDung.getText();
        if (nguoidung.isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập mã người dùng!");
            txtMaNguoiDung.grabFocus();
            return;
        }
        boolean check = false;
        List<NguoiDung> list = nddao.selectAll();
        for (NguoiDung nd : list) {
            if (txtMaNguoiDung.getText().equals(nd.getMaNguoiDung())) {
                check = true;
                break;
            }
        }
        if (check == false) {
            DialogHelper.alert(this, "Mã người dùng này không tồn tại!");
            txtMaNguoiDung.grabFocus();
            return;
        }
        if (mk.isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập mật khẩu hiện tại!");
            txtMKHienTai.grabFocus();
            return;
        }
        if (!mk.equals(ShareHelper.USER.getMatKhau())) {
            DialogHelper.alert(this, "Mật khẩu hiện tại không đúng!");
            txtMKHienTai.grabFocus();
            return;
        }
        if (mkm.isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập mật khẩu mới!");
            txtMKMoi.grabFocus();
            return;
        }
        if (xnmk.isEmpty()) {
            DialogHelper.alert(this, "Vui lòng xác nhận mật khẩu mới!");
            txtXNMK.grabFocus();
            return;
        }
        if (!xnmk.equals(mkm)) {
            DialogHelper.alert(this, "Xác nhận mật khẩu không đúng!");
            txtXNMK.grabFocus();
            return;
        }
        if (otp.isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập mã OTP!");
            txtOTP.grabFocus();
            return;
        }
        if (otp.equals(String.valueOf(ranNum))) {
            nddao.updateMK(txtMaNguoiDung.getText(), mkm);
            fillTable();
            DialogHelper.alert(this, "Đổi mật khẩu thành công!");
            txtMaNguoiDung.setText("");
            txtMKHienTai.setText("");
            txtMKMoi.setText("");
            txtXNMK.setText("");
            txtOTP.setText("");
            ShareHelper.USER.setMatKhau(mkm);
            timer.stop();
            lblGiay.setText("60");
        } else {
            DialogHelper.alert(this, "Mã OTP không chính xác!");
            txtOTP.grabFocus();
        }
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
                    timer.stop();
                    t.stop();
                } else {
                    giay--;
                    lblGiay.setText(String.valueOf(giay));

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

            Session s = Session.getInstance(p, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(accountName, accountPass);
                }
            });
            String from = "vonghiep401@gmail.com";
            String to = ShareHelper.USER.getEmail();
            String subject = "Mã OTP thay đổi mật khẩu";
            String mes = "Đây là mã OTP để thay đổi mật khẩu của bạn, không được chia sẻ cho bất kì ai: " + String.valueOf(ranNum);
            Message msg = new MimeMessage(s);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setText(mes);
            Transport.send(msg);
            JOptionPane.showMessageDialog(null, "Mã OTP đã được gửi đến email của bạn", "Message", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } catch (MessagingException ex) {
            ex.printStackTrace();
        }

    }

    void delete() {
        String maND = txtMaND.getText();

        if (ShareHelper.isManager()) {
            DialogHelper.alert(this, "Bạn không có quyền xóa người dùng!");
        } else if (maND.equals(ShareHelper.USER.getMaNguoiDung())) {
            DialogHelper.alert(this, "Bạn không thể xóa chính bạn!");
        } else {
            if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa người dùng này?")) {
                try {
                    nddao.delete(maND);
                    this.fillTable();
                    this.clear();
                    DialogHelper.alert(this, "Xóa thành công!");
                } catch (Exception e) {
                    DialogHelper.alert(this, "Xóa thất bại! Hợp đồng cần dữ liệu này!");
                    //e.printStackTrace();
                }
            }
        }
    }

    void edit() {
        String maND = String.valueOf(tblTaiKhoan.getValueAt(row, 0));
        NguoiDung nd = nddao.findById(maND);
        this.setForm(nd);
        show = true;
        if (!txtMaND.getText().equalsIgnoreCase(ShareHelper.USER.getMaNguoiDung())) {
            txtPass.setEchoChar('*');
            lblHienThiMK.setIcon(ShareHelper.ResizeImage(String.valueOf(ShareHelper.readLogo("view.png")), lblShowMKM));
        }
        tabs.setSelectedIndex(0);
        this.updateStatus();
    }

    void setForm(NguoiDung nd) {
        txtMaND.setText(nd.getMaNguoiDung());
        txtHoTen.setText(nd.getHoTen());
        txtPass.setText(nd.getMatKhau());
        txtEmail.setText(nd.getEmail());
        if (nd.isVaiTro()) {
            rdoQLTro.setSelected(true);
        } else {
            rdoChuTro.setSelected(true);
        }
    }

    NguoiDung getForm() {
        NguoiDung nd = new NguoiDung();
        nd.setMaNguoiDung(txtMaND.getText());
        nd.setHoTen(txtHoTen.getText());
        nd.setMatKhau(txtPass.getText());
        if (rdoChuTro.isSelected()) {
            nd.setVaiTro(false);
        } else {
            nd.setVaiTro(true);
        }
        nd.setEmail(txtEmail.getText());
        return nd;
    }

    void clear() {
        this.row = -1;
        NguoiDung nd = new NguoiDung();
        this.setForm(nd);
        this.updateStatus();
        txtMaND.setEditable(true);
        txtPass.setEditable(true);
        txtMaND.grabFocus();
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        // Trạng thái form
        btnAdd.setEnabled(!edit);
        btnUpdate.setEnabled(edit);
        btnDelete.setEnabled(edit);
    }
// kiểm tra thông tin trước khi thêm tài khoản mới, cập nhật tài khoản

    boolean check() {
        if (txtMaND.getText().isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập mã người dùng!");
            txtMaND.grabFocus();
            return false;
        }
        boolean check = true;
        List<NguoiDung> list = nddao.selectAll();
        for (NguoiDung nd : list) {
            if (txtMaND.getText().equals(nd.getMaNguoiDung())) {
                check = false;
                break;
            }
        }
        if (check == false) {
            DialogHelper.alert(this, "Mã người dùng đã tồn tại!");
            txtMaND.grabFocus();
            return false;
        }
        if (txtHoTen.getText().isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập họ và tên!");
            txtHoTen.grabFocus();
            return false;
        }
        if (txtPass.getText().isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập mật khẩu!");
            txtPass.grabFocus();
            return false;
        }
        if (txtEmail.getText().isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập Email!");
            txtEmail.grabFocus();
            return false;
        }
        if (verifyEmail(txtEmail.getText()) == false) {
            DialogHelper.alert(this, "Email không đúng định dạng!");
            txtEmail.grabFocus();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlCaiDatTaiKhoan = new javax.swing.JPanel();
        pnlTaiKhoan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaND = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rdoChuTro = new javax.swing.JRadioButton();
        rdoQLTro = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        txtHoTen = new javax.swing.JTextField();
        lblHienThiMK = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMaNguoiDung = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMKHienTai = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        txtMKMoi = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        txtXNMK = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        txtOTP = new javax.swing.JTextField();
        btnGuiMaOTP = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblGiay = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnDoiMK = new javax.swing.JButton();
        lblShowMKHT = new javax.swing.JLabel();
        lblShowXNMK = new javax.swing.JLabel();
        lblShowMKM = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();

        setBackground(new java.awt.Color(227, 240, 252));
        setPreferredSize(new java.awt.Dimension(1150, 835));

        pnlCaiDatTaiKhoan.setLayout(new java.awt.BorderLayout());

        pnlTaiKhoan.setBackground(new java.awt.Color(227, 240, 252));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel1.setText("CÀI ĐẶT TÀI KHOẢN");

        tabs.setBackground(new java.awt.Color(227, 240, 252));
        tabs.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(227, 240, 252));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Mã người dùng");

        txtMaND.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtMaND.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Họ và tên");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Vai trò");

        rdoChuTro.setBackground(new java.awt.Color(227, 240, 252));
        buttonGroup1.add(rdoChuTro);
        rdoChuTro.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        rdoChuTro.setSelected(true);
        rdoChuTro.setText("Chủ trọ");

        rdoQLTro.setBackground(new java.awt.Color(227, 240, 252));
        buttonGroup1.add(rdoQLTro);
        rdoQLTro.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        rdoQLTro.setText("Quản lý trọ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Mật khẩu");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Email");

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 204, 204));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus.png"))); // NOI18N
        btnAdd.setText("  THÊM");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 204, 204));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete.png"))); // NOI18N
        btnDelete.setText("  XÓA");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 204, 204));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        btnUpdate.setText("CẬP NHẬT");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnNew.setBackground(new java.awt.Color(255, 255, 255));
        btnNew.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNew.setForeground(new java.awt.Color(0, 204, 204));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/refresh.png"))); // NOI18N
        btnNew.setText("  MỚI");
        btnNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtEmail.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtHoTen.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        lblHienThiMK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHienThiMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/view.png"))); // NOI18N
        lblHienThiMK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHienThiMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHienThiMKMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdoChuTro)
                                        .addGap(30, 30, 30)
                                        .addComponent(rdoQLTro)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblHienThiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaND, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdoChuTro)
                    .addComponent(rdoQLTro))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHienThiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        tabs.addTab("  TÀI KHOẢN  ", jPanel1);

        jPanel2.setBackground(new java.awt.Color(227, 240, 252));

        tblTaiKhoan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã người dùng", "Họ và tên", "Vai trò", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTaiKhoan.setRowHeight(35);
        tblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTaiKhoan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        tabs.addTab("   DANH SÁCH   ", jPanel2);

        jPanel3.setBackground(new java.awt.Color(227, 240, 252));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel4.setText("Mã người dùng");

        txtMaNguoiDung.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtMaNguoiDung.setPreferredSize(new java.awt.Dimension(6, 35));
        txtMaNguoiDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNguoiDungActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel8.setText("Mật khẩu hiện tại");

        txtMKHienTai.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtMKHienTai.setPreferredSize(new java.awt.Dimension(6, 35));
        txtMKHienTai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMKHienTaiActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel9.setText("Mật khẩu mới");

        txtMKMoi.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtMKMoi.setPreferredSize(new java.awt.Dimension(6, 35));
        txtMKMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMKMoiActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel10.setText("Xác nhận mật khẩu mới");

        txtXNMK.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtXNMK.setPreferredSize(new java.awt.Dimension(6, 35));
        txtXNMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXNMKActionPerformed(evt);
            }
        });
        txtXNMK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtXNMKKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel11.setText("Mã OTP");

        txtOTP.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtOTP.setPreferredSize(new java.awt.Dimension(6, 35));
        txtOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOTPActionPerformed(evt);
            }
        });

        btnGuiMaOTP.setBackground(new java.awt.Color(255, 255, 255));
        btnGuiMaOTP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGuiMaOTP.setForeground(new java.awt.Color(0, 204, 204));
        btnGuiMaOTP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/gmail.png"))); // NOI18N
        btnGuiMaOTP.setText("  GỬI MÃ");
        btnGuiMaOTP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuiMaOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiMaOTPActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Mã OTP sẽ hết hiệu lực sau");

        lblGiay.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblGiay.setForeground(new java.awt.Color(255, 51, 102));
        lblGiay.setText("60");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("giây");

        btnDoiMK.setBackground(new java.awt.Color(255, 255, 255));
        btnDoiMK.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDoiMK.setForeground(new java.awt.Color(0, 204, 204));
        btnDoiMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/password.png"))); // NOI18N
        btnDoiMK.setText(" ĐỔI MẬT KHẨU");
        btnDoiMK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });

        lblShowMKHT.setBackground(new java.awt.Color(227, 240, 252));
        lblShowMKHT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/view.png"))); // NOI18N
        lblShowMKHT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblShowMKHT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShowMKHTMouseClicked(evt);
            }
        });

        lblShowXNMK.setBackground(new java.awt.Color(227, 240, 252));
        lblShowXNMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/view.png"))); // NOI18N
        lblShowXNMK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblShowXNMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShowXNMKMouseClicked(evt);
            }
        });

        lblShowMKM.setBackground(new java.awt.Color(227, 240, 252));
        lblShowMKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/view.png"))); // NOI18N
        lblShowMKM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblShowMKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShowMKMMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblGiay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtOTP, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(btnGuiMaOTP))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtXNMK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMKMoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMKHienTai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblShowMKHT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblShowXNMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblShowMKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(433, 433, 433)
                        .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtMKHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblShowMKHT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblShowXNMK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtXNMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtOTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuiMaOTP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(lblGiay)
                            .addComponent(jLabel14)))
                    .addComponent(lblShowMKM, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        tabs.addTab("  ĐỔI MẬT KHẨU  ", jPanel3);

        tabs.setSelectedIndex(1);

        lblBack.setBackground(new java.awt.Color(227, 240, 252));
        lblBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        lblBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBack.setOpaque(true);
        lblBack.setPreferredSize(new java.awt.Dimension(50, 50));
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlTaiKhoanLayout = new javax.swing.GroupLayout(pnlTaiKhoan);
        pnlTaiKhoan.setLayout(pnlTaiKhoanLayout);
        pnlTaiKhoanLayout.setHorizontalGroup(
            pnlTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaiKhoanLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tabs)
                .addGap(30, 30, 30))
            .addGroup(pnlTaiKhoanLayout.createSequentialGroup()
                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(372, 372, 372)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTaiKhoanLayout.setVerticalGroup(
            pnlTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaiKhoanLayout.createSequentialGroup()
                .addGroup(pnlTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTaiKhoanLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(tabs)
                .addGap(30, 30, 30))
        );

        pnlCaiDatTaiKhoan.add(pnlTaiKhoan, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCaiDatTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCaiDatTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (check()) {
            insert();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void tblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaiKhoanMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblTaiKhoan.getSelectedRow();
            this.edit();
            txtPass.setEditable(false);
            txtMaND.setEditable(false);
        }
    }//GEN-LAST:event_tblTaiKhoanMouseClicked

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        pnlCaiDatTaiKhoan.removeAll();
        pnlCaiDatTaiKhoan.add(new FormCaiDat());
        pnlCaiDatTaiKhoan.revalidate();
        pnlCaiDatTaiKhoan.repaint();
    }//GEN-LAST:event_lblBackMouseClicked

    private void lblBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseEntered
        lblBack.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_lblBackMouseEntered

    private void lblBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseExited
        lblBack.setBackground(new java.awt.Color(227, 240, 252));
    }//GEN-LAST:event_lblBackMouseExited

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        updateMK();
    }//GEN-LAST:event_btnDoiMKActionPerformed

    private void btnGuiMaOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiMaOTPActionPerformed
        guiMaOTP();
    }//GEN-LAST:event_btnGuiMaOTPActionPerformed

    private void txtXNMKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtXNMKKeyReleased
        btnGuiMaOTP.setEnabled(true);
    }//GEN-LAST:event_txtXNMKKeyReleased

    private void txtMaNguoiDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNguoiDungActionPerformed
        txtMKHienTai.grabFocus();
    }//GEN-LAST:event_txtMaNguoiDungActionPerformed

    private void txtMKHienTaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMKHienTaiActionPerformed
        txtMKMoi.grabFocus();
    }//GEN-LAST:event_txtMKHienTaiActionPerformed

    private void txtMKMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMKMoiActionPerformed
        txtXNMK.grabFocus();
    }//GEN-LAST:event_txtMKMoiActionPerformed

    private void txtXNMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXNMKActionPerformed
        txtOTP.grabFocus();
    }//GEN-LAST:event_txtXNMKActionPerformed

    private void txtOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOTPActionPerformed
        btnDoiMKActionPerformed(evt);
    }//GEN-LAST:event_txtOTPActionPerformed

    private void lblShowMKHTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowMKHTMouseClicked
        if (show1) {
            txtMKHienTai.setEchoChar((char) 0);
            lblShowMKHT.setIcon(ShareHelper.ResizeImage(String.valueOf(ShareHelper.readLogo("hide.png")), lblShowMKHT));
            show1 = false;
        } else {
            txtMKHienTai.setEchoChar('*');
            lblShowMKHT.setIcon(ShareHelper.ResizeImage(String.valueOf(ShareHelper.readLogo("view.png")), lblShowMKHT));
            show1 = true;
        }
    }//GEN-LAST:event_lblShowMKHTMouseClicked

    private void lblShowMKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowMKMMouseClicked
        if (show2) {
            txtMKMoi.setEchoChar((char) 0);
            lblShowMKM.setIcon(ShareHelper.ResizeImage(String.valueOf(ShareHelper.readLogo("hide.png")), lblShowMKM));
            show2 = false;
        } else {
            txtMKMoi.setEchoChar('*');
            lblShowMKM.setIcon(ShareHelper.ResizeImage(String.valueOf(ShareHelper.readLogo("view.png")), lblShowMKM));
            show2 = true;
        }
    }//GEN-LAST:event_lblShowMKMMouseClicked

    private void lblShowXNMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowXNMKMouseClicked
        if (show3) {
            txtXNMK.setEchoChar((char) 0);
            lblShowXNMK.setIcon(ShareHelper.ResizeImage(String.valueOf(ShareHelper.readLogo("hide.png")), lblShowXNMK));
            show3 = false;
        } else {
            txtXNMK.setEchoChar('*');
            lblShowXNMK.setIcon(ShareHelper.ResizeImage(String.valueOf(ShareHelper.readLogo("view.png")), lblShowXNMK));
            show3 = true;
        }
    }//GEN-LAST:event_lblShowXNMKMouseClicked

    private void lblHienThiMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHienThiMKMouseClicked
        if (txtMaND.getText().equalsIgnoreCase(ShareHelper.USER.getMaNguoiDung())) {
            if (show) {
                txtPass.setEchoChar((char) 0);
                lblHienThiMK.setIcon(ShareHelper.ResizeImage(String.valueOf(ShareHelper.readLogo("hide.png")), lblShowMKM));
                show = false;
            } else {
                txtPass.setEchoChar('*');
                lblHienThiMK.setIcon(ShareHelper.ResizeImage(String.valueOf(ShareHelper.readLogo("view.png")), lblShowMKM));
                show = true;
            }
        } else {
            DialogHelper.alert(this, "Bạn không thể xem mật khẩu của người khác!");
        }

    }//GEN-LAST:event_lblHienThiMKMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JButton btnGuiMaOTP;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblGiay;
    private javax.swing.JLabel lblHienThiMK;
    private javax.swing.JLabel lblShowMKHT;
    private javax.swing.JLabel lblShowMKM;
    private javax.swing.JLabel lblShowXNMK;
    private javax.swing.JPanel pnlCaiDatTaiKhoan;
    private javax.swing.JPanel pnlTaiKhoan;
    private javax.swing.JRadioButton rdoChuTro;
    private javax.swing.JRadioButton rdoQLTro;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblTaiKhoan;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JPasswordField txtMKHienTai;
    private javax.swing.JPasswordField txtMKMoi;
    private javax.swing.JTextField txtMaND;
    private javax.swing.JTextField txtMaNguoiDung;
    private javax.swing.JTextField txtOTP;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtXNMK;
    // End of variables declaration//GEN-END:variables
}
