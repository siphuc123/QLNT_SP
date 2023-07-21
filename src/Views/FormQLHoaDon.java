package Views;

import DAO.DichVuDAO;
import DAO.HoaDonCTDAO;
import DAO.HoaDonDAO;
import DAO.HopDongDAO;
import DAO.KhachThueDDDAO;
import DAO.PhongTroDAO;
import Entity.HoaDon;
import Entity.HoaDonCT;
import Entity.KhachThueDD;
import Entity.PhongTro;
import Helper.DateHelper;
import Helper.DialogHelper;
import Helper.ShareHelper;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class FormQLHoaDon extends javax.swing.JPanel {
    
    public FormQLHoaDon() {
        initComponents();
        init();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtHoaDon = new javax.swing.JEditorPane();
        lblHoaDon = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSLXe = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtMaKhachThue = new javax.swing.JTextField();
        dchNgayXuat = new com.toedter.calendar.JDateChooser();
        pnlDien = new javax.swing.JPanel();
        txtCSDMoi = new javax.swing.JTextField();
        txtCSDCu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSDTT = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlNuoc = new javax.swing.JPanel();
        txtCSNMoi = new javax.swing.JTextField();
        txtCSNCu = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSoKhoi = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnInvoice = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        lblThanhToan = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JButton();
        btnTop = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        chkRac = new javax.swing.JCheckBox();
        chkWifi = new javax.swing.JCheckBox();
        lblPaid = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboThang = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();

        jScrollPane1.setViewportView(txtHoaDon);

        setBackground(new java.awt.Color(227, 240, 252));
        setName("pnlHoaDon"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1150, 835));

        lblHoaDon.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        lblHoaDon.setText("QUẢN LÝ HÓA ĐƠN");

        tabs.setBackground(new java.awt.Color(227, 240, 252));
        tabs.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(227, 240, 252));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Mã phòng");

        txtMaPhong.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhongActionPerformed(evt);
            }
        });
        txtMaPhong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaPhongKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Ngày xuất");

        txtSLXe.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtSLXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSLXeActionPerformed(evt);
            }
        });
        txtSLXe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSLXeKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Số lượng xe");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Dịch vụ");

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
        btnDelete.setOpaque(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 204, 204));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        btnUpdate.setText("  CẬP NHẬT");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setOpaque(false);
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
        btnNew.setOpaque(false);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Mã khách thuê");

        txtMaKhachThue.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtMaKhachThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhachThueActionPerformed(evt);
            }
        });
        txtMaKhachThue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaKhachThueKeyReleased(evt);
            }
        });

        dchNgayXuat.setBackground(new java.awt.Color(227, 240, 252));
        dchNgayXuat.setOpaque(false);
        dchNgayXuat.setPreferredSize(new java.awt.Dimension(156, 35));

        pnlDien.setBackground(new java.awt.Color(227, 240, 252));
        pnlDien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Điện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 20))); // NOI18N

        txtCSDMoi.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtCSDMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCSDMoiActionPerformed(evt);
            }
        });
        txtCSDMoi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCSDMoiKeyReleased(evt);
            }
        });

        txtCSDCu.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Chỉ số mới");

        txtSDTT.setEditable(false);
        txtSDTT.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel13.setText("Số điện tiêu thụ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("Chỉ số cũ");

        javax.swing.GroupLayout pnlDienLayout = new javax.swing.GroupLayout(pnlDien);
        pnlDien.setLayout(pnlDienLayout);
        pnlDienLayout.setHorizontalGroup(
            pnlDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDienLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(pnlDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCSDCu)
                    .addComponent(txtCSDMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(pnlDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSDTT))
                .addGap(47, 47, 47))
        );
        pnlDienLayout.setVerticalGroup(
            pnlDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCSDCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGroup(pnlDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDienLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCSDMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDienLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txtSDTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pnlNuoc.setBackground(new java.awt.Color(227, 240, 252));
        pnlNuoc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nước", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 20))); // NOI18N

        txtCSNMoi.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtCSNMoi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCSNMoiKeyReleased(evt);
            }
        });

        txtCSNCu.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setText("Chỉ số mới");

        txtSoKhoi.setEditable(false);
        txtSoKhoi.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel14.setText("Số khối");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel15.setText("Chỉ số cũ");

        javax.swing.GroupLayout pnlNuocLayout = new javax.swing.GroupLayout(pnlNuoc);
        pnlNuoc.setLayout(pnlNuocLayout);
        pnlNuocLayout.setHorizontalGroup(
            pnlNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNuocLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(pnlNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCSNCu)
                    .addComponent(txtCSNMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(pnlNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoKhoi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );
        pnlNuocLayout.setVerticalGroup(
            pnlNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNuocLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtCSNCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGroup(pnlNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNuocLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtCSNMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlNuocLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txtSoKhoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        btnInvoice.setBackground(new java.awt.Color(255, 255, 255));
        btnInvoice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnInvoice.setForeground(new java.awt.Color(0, 204, 204));
        btnInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bill2.png"))); // NOI18N
        btnInvoice.setText("  XUẤT HÓA DƠN");
        btnInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInvoice.setOpaque(false);
        btnInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvoiceActionPerformed(evt);
            }
        });

        btnPay.setBackground(new java.awt.Color(255, 255, 255));
        btnPay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPay.setForeground(new java.awt.Color(0, 204, 204));
        btnPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/checked.png"))); // NOI18N
        btnPay.setText("  THANH TOÁN");
        btnPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPay.setOpaque(false);
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel16.setText("TỔNG TIỀN");

        txtTongTien.setEditable(false);
        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N

        lblThanhToan.setFont(new java.awt.Font("Calibri", 1, 26)); // NOI18N
        lblThanhToan.setForeground(new java.awt.Color(255, 0, 51));
        lblThanhToan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThanhToan.setText("CHƯA THANH TOÁN");

        btnPrevious.setBackground(new java.awt.Color(255, 255, 255));
        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPrevious.setForeground(new java.awt.Color(0, 204, 204));
        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/left.png"))); // NOI18N
        btnPrevious.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrevious.setOpaque(false);
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnTop.setBackground(new java.awt.Color(255, 255, 255));
        btnTop.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTop.setForeground(new java.awt.Color(0, 204, 204));
        btnTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/top-alignment.png"))); // NOI18N
        btnTop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(255, 255, 255));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNext.setForeground(new java.awt.Color(0, 204, 204));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/right-arrow.png"))); // NOI18N
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.setOpaque(false);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(255, 255, 255));
        btnLast.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLast.setForeground(new java.awt.Color(0, 204, 204));
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/last-alignment.png"))); // NOI18N
        btnLast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        chkRac.setBackground(new java.awt.Color(227, 240, 252));
        chkRac.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        chkRac.setSelected(true);
        chkRac.setText("Rác");
        chkRac.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkRacStateChanged(evt);
            }
        });

        chkWifi.setBackground(new java.awt.Color(227, 240, 252));
        chkWifi.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        chkWifi.setSelected(true);
        chkWifi.setText("Wifi");
        chkWifi.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkWifiStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaPhong)
                            .addComponent(dchNgayXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                        .addGap(154, 154, 154)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaKhachThue)
                            .addComponent(txtSLXe, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlNuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlDien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(82, 82, 82))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(52, 52, 52))
                                .addComponent(lblThanhToan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(chkRac)
                                    .addGap(25, 25, 25)
                                    .addComponent(chkWifi)
                                    .addGap(40, 40, 40)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(45, 45, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(117, 117, 117)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTop, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(dchNgayXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMaKhachThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSLXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel11))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(pnlDien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(pnlNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkRac)
                            .addComponent(chkWifi))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(lblThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTop, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        tabs.addTab("  HÓA ĐƠN  ", jPanel1);

        jPanel2.setBackground(new java.awt.Color(227, 240, 252));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Tháng");

        cboThang.setEditable(true);
        cboThang.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cboThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cboThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboThangItemStateChanged(evt);
            }
        });

        tblHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã phòng", "Khách thuê", "Ngày xuất", "Thanh toán", "Ngày thanh toán", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setRowHeight(35);
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel10.setText("Tìm kiếm");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Năm");

        cboNam.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cboNam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNamItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        tabs.addTab("   DANH SÁCH   ", jPanel2);

        tabs.setSelectedIndex(1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(451, 451, 451)
                .addComponent(lblHoaDon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tabs)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tabs)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        this.clearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        this.insert();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        this.update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        this.delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        this.pay();
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvoiceActionPerformed
        try {
            this.xuatHoaDon();
        } catch (PrinterException ex) {
            Logger.getLogger(FormQLHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInvoiceActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        this.prev();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopActionPerformed
        this.first();
    }//GEN-LAST:event_btnTopActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        this.last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        fillTable();
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblHoaDon.getSelectedRow();
            this.maHoaDon = (int) tblHoaDon.getValueAt(row, 0);
            this.edit();
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void txtCSDMoiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCSDMoiKeyReleased
        txtSDTT.setText(tinhSDTT());
        if (!txtSLXe.getText().isEmpty() && !txtSDTT.getText().isEmpty() && !txtSoKhoi.getText().isEmpty()) {
            DecimalFormat dcf = new DecimalFormat("###,### VND");
            int sdtt = Integer.valueOf(txtSDTT.getText());
            int soNuoc = Integer.valueOf(txtSoKhoi.getText());
            int soXe = Integer.valueOf(txtSLXe.getText());
            double giaDien = dvdao.selectByTenDV("Điện").getGia();
            double giaNuoc = dvdao.selectByTenDV("Nước").getGia();
            double giaXe = dvdao.selectByTenDV("Giữ xe").getGia();
            double giaRac = dvdao.selectByTenDV("Thu rác").getGia();
            double giaWifi = dvdao.selectByTenDV("WI-FI").getGia();
            double giaPhong = ptdao.selectByMaPhong(txtMaPhong.getText()).getGiaPhong();
            double tongTien = 0;
            if (chkRac.isSelected() && chkWifi.isSelected()) {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaRac + giaWifi;
            } else if (chkRac.isSelected() && !chkWifi.isSelected()) {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaRac;
            } else if (!chkRac.isSelected() && chkWifi.isSelected()) {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaWifi;
            } else {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe);
            }
            txtTongTien.setText(dcf.format(tongTien));
            txtTongTien.setToolTipText(String.valueOf(tongTien));
        }
    }//GEN-LAST:event_txtCSDMoiKeyReleased

    private void txtCSNMoiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCSNMoiKeyReleased
        txtSoKhoi.setText(tinhSoNuoc());
        if (!txtSLXe.getText().isEmpty() && !txtSDTT.getText().isEmpty() && !txtSoKhoi.getText().isEmpty()) {
            DecimalFormat dcf = new DecimalFormat("###,### VND");
            int sdtt = 0;
            int soNuoc = 0;
            int soXe = 0;
            if (txtSDTT.getText().matches("\\d+") && txtSDTT.getText().matches("\\S+") && !txtSDTT.getText().isEmpty()) {
                sdtt = Integer.valueOf(txtSDTT.getText());
            }
            if (txtSoKhoi.getText().matches("\\d+") && txtSoKhoi.getText().matches("\\S+") && !txtSoKhoi.getText().isEmpty()) {
                soNuoc = Integer.valueOf(txtSoKhoi.getText());
            }
            if (txtSLXe.getText().matches("\\d+") && txtSLXe.getText().matches("\\S+") && !txtSLXe.getText().isEmpty()) {
                soXe = Integer.valueOf(txtSLXe.getText());
            }
            
            double giaDien = dvdao.selectByTenDV("Điện").getGia();
            double giaNuoc = dvdao.selectByTenDV("Nước").getGia();
            double giaXe = dvdao.selectByTenDV("Giữ xe").getGia();
            double giaRac = dvdao.selectByTenDV("Thu rác").getGia();
            double giaWifi = dvdao.selectByTenDV("WI-FI").getGia();
            double giaPhong = ptdao.selectByMaPhong(txtMaPhong.getText()).getGiaPhong();
            double tongTien = 0;
            if (chkRac.isSelected() && chkWifi.isSelected()) {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaRac + giaWifi;
            } else if (chkRac.isSelected() && !chkWifi.isSelected()) {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaRac;
            } else if (!chkRac.isSelected() && chkWifi.isSelected()) {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaWifi;
            } else {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe);
            }
            txtTongTien.setText(dcf.format(tongTien));
            txtTongTien.setToolTipText(String.valueOf(tongTien));
        }
    }//GEN-LAST:event_txtCSNMoiKeyReleased

    private void txtMaPhongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaPhongKeyReleased
        String maphong = txtMaPhong.getText().toUpperCase();
        List<PhongTro> list = ptdao.selectPhongDangThue();
        boolean test = true;
        for (PhongTro pt : list) {
            if (maphong.equals(pt.getMaPhong())) {
                txtMaKhachThue.setText(hopdongdao.selectByMaPhong(maphong).getMaKTDD());
                txtMaKhachThue.setToolTipText(ktdao.findById(hopdongdao.selectByMaPhong(maphong).getMaKTDD()).getHoTen());
                txtCSDCu.setText(String.valueOf(hdctdao.selectHDCT(hddao.selectHDGanNhat(txtMaPhong.getText()).getMaHD(), dvdao.selectByTenDV("Điện").getMaDV()).getChiSoMoi()));
                txtCSNCu.setText(String.valueOf(hdctdao.selectHDCT(hddao.selectHDGanNhat(txtMaPhong.getText()).getMaHD(), dvdao.selectByTenDV("Nước").getMaDV()).getChiSoMoi()));
                test = false;
                break;
            }
        }
        if (test) {
            txtMaKhachThue.setText("");
            txtMaKhachThue.setToolTipText("");
            txtCSDCu.setText("");
            txtCSNCu.setText("");
        }
    }//GEN-LAST:event_txtMaPhongKeyReleased

    private void txtMaKhachThueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaKhachThueKeyReleased
        String makt = txtMaKhachThue.getText();
        boolean test = true;
        boolean test2 = true;
        List<KhachThueDD> list1 = ktdao.selectAll();
        for (KhachThueDD kt : list1) {
            if (makt.toUpperCase().equals(kt.getMaKTDD())) {
                txtMaPhong.setText(hopdongdao.selectByMaKTDD(makt).getMaPhong());
                test = false;
                break;
            }
        }
        if (test) {
            txtMaPhong.setText("");
        }
        
        String maphong = txtMaPhong.getText();
        if (!maphong.isEmpty()) {
            List<PhongTro> list = ptdao.selectPhongDangThue();
            for (PhongTro pd : list) {
                if (maphong.toUpperCase().equals(pd.getMaPhong())) {
                    txtCSDCu.setText(String.valueOf(hdctdao.selectHDCT(hddao.selectHDGanNhat(txtMaPhong.getText()).getMaHD(), dvdao.selectByTenDV("Điện").getMaDV()).getChiSoMoi()));
                    txtCSNCu.setText(String.valueOf(hdctdao.selectHDCT(hddao.selectHDGanNhat(txtMaPhong.getText()).getMaHD(), dvdao.selectByTenDV("Nước").getMaDV()).getChiSoMoi()));
                    test2 = false;
                    break;
                }
            }
            if (test2) {
                txtCSDCu.setText("");
                txtCSNCu.setText("");
            }
        }
    }//GEN-LAST:event_txtMaKhachThueKeyReleased

    private void txtMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhongActionPerformed
        txtMaKhachThue.grabFocus();
    }//GEN-LAST:event_txtMaPhongActionPerformed

    private void txtMaKhachThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhachThueActionPerformed
        txtSLXe.grabFocus();
    }//GEN-LAST:event_txtMaKhachThueActionPerformed

    private void txtSLXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSLXeActionPerformed
        txtCSDMoi.grabFocus();
    }//GEN-LAST:event_txtSLXeActionPerformed

    private void txtCSDMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCSDMoiActionPerformed
        txtCSNMoi.grabFocus();
    }//GEN-LAST:event_txtCSDMoiActionPerformed

    private void txtSLXeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSLXeKeyReleased
        if (!txtSLXe.getText().isEmpty() && !txtSDTT.getText().isEmpty() && !txtSoKhoi.getText().isEmpty()) {
            DecimalFormat dcf = new DecimalFormat("###,### VND");
            int sdtt = Integer.valueOf(txtSDTT.getText());
            int soNuoc = Integer.valueOf(txtSoKhoi.getText());
            int soXe = Integer.valueOf(txtSLXe.getText());
            double giaDien = dvdao.selectByTenDV("Điện").getGia();
            double giaNuoc = dvdao.selectByTenDV("Nước").getGia();
            double giaXe = dvdao.selectByTenDV("Giữ xe").getGia();
            double giaRac = dvdao.selectByTenDV("Thu rác").getGia();
            double giaWifi = dvdao.selectByTenDV("WI-FI").getGia();
            double giaPhong = ptdao.selectByMaPhong(txtMaPhong.getText()).getGiaPhong();
            double tongTien = 0;
            if (chkRac.isSelected() && chkWifi.isSelected()) {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaRac + giaWifi;
            } else if (chkRac.isSelected() && !chkWifi.isSelected()) {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaRac;
            } else if (!chkRac.isSelected() && chkWifi.isSelected()) {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaWifi;
            } else {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe);
            }
            txtTongTien.setText(dcf.format(tongTien));
            txtTongTien.setToolTipText(String.valueOf(tongTien));
        }
    }//GEN-LAST:event_txtSLXeKeyReleased

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        fillTable();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void cboNamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNamItemStateChanged
        fillTable();
    }//GEN-LAST:event_cboNamItemStateChanged

    private void cboThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboThangItemStateChanged
        fillTable();
    }//GEN-LAST:event_cboThangItemStateChanged

    private void chkRacStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkRacStateChanged
        if (!txtSLXe.getText().isEmpty() && !txtSDTT.getText().isEmpty() && !txtSoKhoi.getText().isEmpty()) {
            DecimalFormat dcf = new DecimalFormat("###,### VND");
            int sdtt = Integer.valueOf(txtSDTT.getText());
            int soNuoc = Integer.valueOf(txtSoKhoi.getText());
            int soXe = Integer.valueOf(txtSLXe.getText());
            double giaDien = dvdao.selectByTenDV("Điện").getGia();
            double giaNuoc = dvdao.selectByTenDV("Nước").getGia();
            double giaXe = dvdao.selectByTenDV("Giữ xe").getGia();
            double giaRac = dvdao.selectByTenDV("Thu rác").getGia();
            double giaWifi = dvdao.selectByTenDV("WI-FI").getGia();
            double giaPhong = ptdao.selectByMaPhong(txtMaPhong.getText()).getGiaPhong();
            double tongTien = 0;
            if (chkRac.isSelected() && chkWifi.isSelected()) {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaRac + giaWifi;
            } else if (chkRac.isSelected() && !chkWifi.isSelected()) {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaRac;
            } else if (!chkRac.isSelected() && chkWifi.isSelected()) {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaWifi;
            } else {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe);
            }
            txtTongTien.setText(dcf.format(tongTien));
            txtTongTien.setToolTipText(String.valueOf(tongTien));
        }
    }//GEN-LAST:event_chkRacStateChanged

    private void chkWifiStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkWifiStateChanged
        if (!txtSLXe.getText().isEmpty() && !txtSDTT.getText().isEmpty() && !txtSoKhoi.getText().isEmpty()) {
            DecimalFormat dcf = new DecimalFormat("###,### VND");
            int sdtt = Integer.valueOf(txtSDTT.getText());
            int soNuoc = Integer.valueOf(txtSoKhoi.getText());
            int soXe = Integer.valueOf(txtSLXe.getText());
            double giaDien = dvdao.selectByTenDV("Điện").getGia();
            double giaNuoc = dvdao.selectByTenDV("Nước").getGia();
            double giaXe = dvdao.selectByTenDV("Giữ xe").getGia();
            double giaRac = dvdao.selectByTenDV("Thu rác").getGia();
            double giaWifi = dvdao.selectByTenDV("WI-FI").getGia();
            double giaPhong = ptdao.selectByMaPhong(txtMaPhong.getText()).getGiaPhong();
            double tongTien = 0;
            if (chkRac.isSelected() && chkWifi.isSelected()) {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaRac + giaWifi;
            } else if (chkRac.isSelected() && !chkWifi.isSelected()) {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaRac;
            } else if (!chkRac.isSelected() && chkWifi.isSelected()) {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaWifi;
            } else {
                tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe);
            }
            txtTongTien.setText(dcf.format(tongTien));
            txtTongTien.setToolTipText(String.valueOf(tongTien));
        }
    }//GEN-LAST:event_chkWifiStateChanged
    HoaDonDAO hddao = new HoaDonDAO();
    DichVuDAO dvdao = new DichVuDAO();
    HoaDonCTDAO hdctdao = new HoaDonCTDAO();
    KhachThueDDDAO ktdao = new KhachThueDDDAO();
    PhongTroDAO ptdao = new PhongTroDAO();
    HopDongDAO hopdongdao = new HopDongDAO();
    int row = -1;
    int maHoaDon;
    private TableRowSorter<TableModel> rowSorter;
    
    void init() {
        fillComboBoxNam();
        cboThang.setSelectedIndex(0);
        cboNam.setSelectedIndex(0);
        this.row = -1;
        this.updateStatus();
        tblHoaDon.getTableHeader().setFont(new Font("Calibri", 0, 18));
        tblHoaDon.getColumnModel().getColumn(0).setMaxWidth(1000);
        tblHoaDon.getColumnModel().getColumn(1).setMaxWidth(1000);
        tblHoaDon.getColumnModel().getColumn(3).setMaxWidth(1000);
        tblHoaDon.getColumnModel().getColumn(5).setMaxWidth(1000);
        tblHoaDon.getColumnModel().getColumn(6).setMaxWidth(1000);
        tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(115);
        tblHoaDon.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblHoaDon.getColumnModel().getColumn(3).setPreferredWidth(120);
        tblHoaDon.getColumnModel().getColumn(5).setPreferredWidth(145);
        tblHoaDon.getColumnModel().getColumn(6).setPreferredWidth(150);
        tblHoaDon.setShowGrid(true);
        rowSorter = new TableRowSorter<>(tblHoaDon.getModel());
        tblHoaDon.setRowSorter(rowSorter);
    }
    
    void fillComboBoxNam() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNam.getModel();
        model.removeAllElements();
        List<Integer> list = hddao.selectYears();
        model.addElement("Tất cả");
        for (Integer year : list) {
            model.addElement(year);
        }
    }
    
    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        try {
            String keyword = txtTimKiem.getText().trim();
            int thang = cboThang.getSelectedIndex();
            int nam = 0;
            if (!cboNam.getSelectedItem().toString().equals("Tất cả")) {
                nam = (int) cboNam.getSelectedItem();
            }
            if (cboThang.getSelectedItem().toString().equals("Tất cả")) {
                if (cboNam.getSelectedItem().toString().equals("Tất cả")) {
                    List<HoaDon> list = hddao.selectByKeyword2(keyword);
                    for (HoaDon hd : list) {
                        if (hd.getThanhToan().equalsIgnoreCase("ĐÃ THANH TOÁN")) {
                            Object[] row = {hd.getMaHD(),
                                hd.getMaPhong(),
                                ktdao.findById(hd.getMaKTDD()).getHoTen(),
                                DateHelper.toString(hd.getNgayXuatHD(), "dd/MM/yyyy"),
                                hd.getThanhToan(),
                                DateHelper.toString(hd.getNgayThanhToan(), "dd/MM/yyyy"),
                                hd.getTongTien()
                            };
                            model.addRow(row); // Thêm một hàng vào bảng                  
                        } else {
                            Object[] row = {hd.getMaHD(),
                                hd.getMaPhong(),
                                ktdao.findById(hd.getMaKTDD()).getHoTen(),
                                DateHelper.toString(hd.getNgayXuatHD(), "dd/MM/yyyy"),
                                hd.getThanhToan(),
                                "",
                                hd.getTongTien()
                            };
                            model.addRow(row); // Thêm một hàng vào bảng
                        }
                    }
                } else {
                    List<HoaDon> list = hddao.selectByKeyword4(keyword, nam);
                    for (HoaDon hd : list) {
                        if (hd.getThanhToan().equalsIgnoreCase("ĐÃ THANH TOÁN")) {
                            Object[] row = {hd.getMaHD(),
                                hd.getMaPhong(),
                                ktdao.findById(hd.getMaKTDD()).getHoTen(),
                                DateHelper.toString(hd.getNgayXuatHD(), "dd/MM/yyyy"),
                                hd.getThanhToan(),
                                DateHelper.toString(hd.getNgayThanhToan(), "dd/MM/yyyy"),
                                hd.getTongTien()
                            };
                            model.addRow(row); // Thêm một hàng vào bảng                  
                        } else {
                            Object[] row = {hd.getMaHD(),
                                hd.getMaPhong(),
                                ktdao.findById(hd.getMaKTDD()).getHoTen(),
                                DateHelper.toString(hd.getNgayXuatHD(), "dd/MM/yyyy"),
                                hd.getThanhToan(),
                                "",
                                hd.getTongTien()
                            };
                            model.addRow(row); // Thêm một hàng vào bảng
                        }
                    }
                }
                
            } else {
                if (cboNam.getSelectedItem().toString().equals("Tất cả")) {
                    List<HoaDon> list = hddao.selectByKeyword(keyword, thang);
                    for (HoaDon hd : list) {
                        if (hd.getThanhToan().equalsIgnoreCase("ĐÃ THANH TOÁN")) {
                            Object[] row = {hd.getMaHD(),
                                hd.getMaPhong(),
                                ktdao.findById(hd.getMaKTDD()).getHoTen(),
                                DateHelper.toString(hd.getNgayXuatHD(), "dd/MM/yyyy"),
                                hd.getThanhToan(),
                                DateHelper.toString(hd.getNgayThanhToan(), "dd/MM/yyyy"),
                                hd.getTongTien()
                            };
                            model.addRow(row); // Thêm một hàng vào bảng                  
                        } else {
                            Object[] row = {hd.getMaHD(),
                                hd.getMaPhong(),
                                ktdao.findById(hd.getMaKTDD()).getHoTen(),
                                DateHelper.toString(hd.getNgayXuatHD(), "dd/MM/yyyy"),
                                hd.getThanhToan(),
                                "",
                                hd.getTongTien()
                            };
                            model.addRow(row); // Thêm một hàng vào bảng
                        }
                    }
                } else {
                    List<HoaDon> list = hddao.selectByKeyword3(keyword, thang, nam);
                    for (HoaDon hd : list) {
                        if (hd.getThanhToan().equalsIgnoreCase("ĐÃ THANH TOÁN")) {
                            Object[] row = {hd.getMaHD(),
                                hd.getMaPhong(),
                                ktdao.findById(hd.getMaKTDD()).getHoTen(),
                                DateHelper.toString(hd.getNgayXuatHD(), "dd/MM/yyyy"),
                                hd.getThanhToan(),
                                DateHelper.toString(hd.getNgayThanhToan(), "dd/MM/yyyy"),
                                hd.getTongTien()
                            };
                            model.addRow(row); // Thêm một hàng vào bảng                  
                        } else {
                            Object[] row = {hd.getMaHD(),
                                hd.getMaPhong(),
                                ktdao.findById(hd.getMaKTDD()).getHoTen(),
                                DateHelper.toString(hd.getNgayXuatHD(), "dd/MM/yyyy"),
                                hd.getThanhToan(),
                                "",
                                hd.getTongTien()
                            };
                            model.addRow(row); // Thêm một hàng vào bảng
                        }
                    }
                }
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }
    
    void insert() {
        if (check()) {
            HoaDon hd = getFormHD();
            try {
                hddao.insert(hd);
                lblHoaDon.setToolTipText(String.valueOf(hddao.selectHDGanNhat(txtMaPhong.getText()).getMaHD()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            HoaDonCT hdd = getFormHDDien();
            HoaDonCT hdn = getFormHDNuoc();
            HoaDonCT hdx = getFormHDXe();
            HoaDonCT hdr = getFormHDRac();
            HoaDonCT hdwf = getFormHDWifi();
            try {
                hdctdao.insertDienNuoc(hdd);
                hdctdao.insertDienNuoc(hdn);
                hdctdao.insertXe(hdx);
                hdctdao.insertRacWifi(hdr);
                hdctdao.insertRacWifi(hdwf);
                //cboThang.setSelectedIndex(dchNgayXuat.getDate().getMonth() + 1);
                this.fillTable();
                //this.clearForm();
                DialogHelper.alert(this, "Thêm mới thành công!");
                tblHoaDon.setRowSelectionInterval(tblHoaDon.getRowCount() - 1, tblHoaDon.getRowCount() - 1);
                row = tblHoaDon.getSelectedRow();
                updateStatus();
            } catch (Exception e) {
                DialogHelper.alert(this, "Thêm mới thất bại!");
                e.printStackTrace();
            }
        }
    }
    
    void update() {
        if (check()) {
            HoaDon hd = getFormHD();
            hd.setMaHD(Integer.valueOf(lblHoaDon.getToolTipText()));
            HoaDonCT hdd = getFormHDDien();
            HoaDonCT hdn = getFormHDNuoc();
            HoaDonCT hdx = getFormHDXe();
            HoaDonCT hdr = getFormHDRac();
            HoaDonCT hdwf = getFormHDWifi();
            try {
                hddao.update(hd);
                hdctdao.updateDienNuoc(hdd);
                hdctdao.updateDienNuoc(hdn);
                hdctdao.updateXe(hdx);
                hdctdao.updateRacWifi(hdr);
                hdctdao.updateRacWifi(hdwf);
                this.fillTable();
                DialogHelper.alert(this, "Cập nhật thành công!");
            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại!");
                e.printStackTrace();
            }
        }
    }
    
    void pay() {
        if (check()) {
            int mahd = Integer.valueOf(lblHoaDon.getToolTipText());
            try {
                hddao.updateTT(mahd);
                this.fillTable();
                DialogHelper.alert(this, "Thanh toán thành công!");
                lblThanhToan.setText("ĐÃ THANH TOÁN");
                lblPaid.setIcon(ShareHelper.ResizeImage(String.valueOf(ShareHelper.readLogo("paid.png")), lblPaid));
                btnPay.setEnabled(false);
            } catch (Exception e) {
                DialogHelper.alert(this, "Thanh toán thất bại!");
                e.printStackTrace();
            }
        }
    }
    
    void delete() {
        if (ShareHelper.isManager() == false) {
            maHoaDon = Integer.valueOf(lblHoaDon.getToolTipText());
            if (ShareHelper.isManager()) {
                DialogHelper.alert(this, "Bạn không có quyền xóa hóa dơn!");
            } else {
                if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa hóa đơn này?")) {
                    try {
                        hdctdao.delete(maHoaDon);
                        hddao.delete(maHoaDon);
                        this.fillTable();
                        this.clearForm();
                        DialogHelper.alert(this, "Xóa thành công!");
                    } catch (Exception e) {
                        DialogHelper.alert(this, "Xóa thất bại!");
                        e.printStackTrace();
                    }
                }
            }
        } else {
            DialogHelper.alert(this, "Bạn không có quyền xóa hóa đơn!");
        }
    }
    
    void edit() {
        maHoaDon = (int) tblHoaDon.getValueAt(row, 0);
        lblHoaDon.setToolTipText(String.valueOf(maHoaDon));
        HoaDon hd = hddao.selectById(maHoaDon);
        HoaDonCT hdd = hdctdao.selectHDCT(maHoaDon, dvdao.selectByTenDV("Điện").getMaDV());
        HoaDonCT hdn = hdctdao.selectHDCT(maHoaDon, dvdao.selectByTenDV("Nước").getMaDV());
        HoaDonCT hdx = hdctdao.selectHDCT(maHoaDon, dvdao.selectByTenDV("Giữ xe").getMaDV());
        HoaDonCT hdr = hdctdao.selectHDCT(maHoaDon, dvdao.selectByTenDV("Thu rác").getMaDV());
        HoaDonCT hdwf = hdctdao.selectHDCT(maHoaDon, dvdao.selectByTenDV("WI-FI").getMaDV());
        this.setForm(hd, hdd, hdn, hdx, hdr, hdwf);
        tabs.setSelectedIndex(0);
        this.updateStatus();
    }
    
    void first() {
        this.row = 0;
        tblHoaDon.setRowSelectionInterval(row, row);
        tblHoaDon.scrollRectToVisible(tblHoaDon.getCellRect(row, 0, true));
        this.edit();
    }
    
    void last() {
        this.row = tblHoaDon.getRowCount() - 1;
        tblHoaDon.setRowSelectionInterval(row, row);
        tblHoaDon.scrollRectToVisible(tblHoaDon.getCellRect(row, 0, true));
        this.edit();
    }
    
    void next() {
        if (this.row < tblHoaDon.getRowCount() - 1) {
            this.row++;
            tblHoaDon.setRowSelectionInterval(row, row);
            tblHoaDon.scrollRectToVisible(tblHoaDon.getCellRect(row, 0, true));
            this.edit();
        }
    }
    
    void prev() {
        if (this.row > 0) {
            this.row--;
            tblHoaDon.setRowSelectionInterval(row, row);
            tblHoaDon.scrollRectToVisible(tblHoaDon.getCellRect(row, 0, true));
            this.edit();
        }
    }
    
    void setForm(HoaDon hd, HoaDonCT hdd, HoaDonCT hdn, HoaDonCT hdx, HoaDonCT hdr, HoaDonCT hdwf) {
        DecimalFormat dcf = new DecimalFormat("###,### VND");
        int sdtt = hdd.getChiSoMoi() - hdd.getChiSoCu();
        int soNuoc = hdn.getChiSoMoi() - hdn.getChiSoCu();
        int soXe = hdx.getSoLuong();
        double giaDien = dvdao.selectByTenDV("Điện").getGia();
        double giaNuoc = dvdao.selectByTenDV("Nước").getGia();
        double giaXe = dvdao.selectByTenDV("Giữ xe").getGia();
        double giaRac = dvdao.selectByTenDV("Thu rác").getGia();
        double giaWifi = dvdao.selectByTenDV("WI-FI").getGia();
        double giaPhong = ptdao.selectByMaPhong(hd.getMaPhong()).getGiaPhong();
        if (hdr.isSuDung()) {
            chkRac.setSelected(true);
        } else {
            chkRac.setSelected(false);
        }
        if (hdwf.isSuDung()) {
            chkWifi.setSelected(true);
        } else {
            chkWifi.setSelected(false);
        }
        double tongTien = 0;
        if (chkRac.isSelected() && chkWifi.isSelected()) {
            tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaRac + giaWifi;
        } else if (chkRac.isSelected() && !chkWifi.isSelected()) {
            tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaRac;
        } else if (!chkRac.isSelected() && chkWifi.isSelected()) {
            tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe) + giaWifi;
        } else {
            tongTien = giaPhong + (giaDien * sdtt) + (giaNuoc * soNuoc) + (soXe * giaXe);
        }
        txtMaPhong.setText(hd.getMaPhong());
        txtMaKhachThue.setText(hd.getMaKTDD());
        txtMaKhachThue.setToolTipText(ktdao.findById(txtMaKhachThue.getText()).getHoTen());
        dchNgayXuat.setDate(hd.getNgayXuatHD());
        txtSLXe.setText(String.valueOf(hdx.getSoLuong()));
        txtCSDCu.setText(String.valueOf(hdd.getChiSoCu()));
        txtCSDMoi.setText(String.valueOf(hdd.getChiSoMoi()));
        txtCSNCu.setText(String.valueOf(hdn.getChiSoCu()));
        txtCSNMoi.setText(String.valueOf(hdn.getChiSoMoi()));
        txtSDTT.setText(String.valueOf(sdtt));
        txtSoKhoi.setText(String.valueOf(soNuoc));
        txtTongTien.setText(dcf.format(tongTien));
        txtTongTien.setToolTipText(String.valueOf(tongTien));
        lblThanhToan.setText(hd.getThanhToan());
        if (lblThanhToan.getText().equals("ĐÃ THANH TOÁN")) {
            lblPaid.setIcon(ShareHelper.ResizeImage(String.valueOf(ShareHelper.readLogo("paid.png")), lblPaid));
        } else {
            lblPaid.setIcon(null);
        }
    }
    
    HoaDon getFormHD() {
        HoaDon hd = new HoaDon();
        hd.setNgayXuatHD(dchNgayXuat.getDate());
        hd.setThanhToan(lblThanhToan.getText());
        hd.setTongTien(Double.valueOf(txtTongTien.getToolTipText()));
        hd.setMaPhong(txtMaPhong.getText().toUpperCase());
        hd.setMaKTDD(txtMaKhachThue.getText().toUpperCase());
        return hd;
    }
    
    HoaDonCT getFormHDDien() {
        HoaDonCT hdd = new HoaDonCT();
        hdd.setMaHD(Integer.valueOf(lblHoaDon.getToolTipText()));
        hdd.setMaDV(dvdao.selectByTenDV("Điện").getMaDV());
        hdd.setChiSoCu(Integer.valueOf(txtCSDCu.getText()));
        hdd.setChiSoMoi(Integer.valueOf(txtCSDMoi.getText()));
        hdd.setSoLuong(Integer.valueOf(txtSDTT.getText()));
        return hdd;
    }
    
    HoaDonCT getFormHDNuoc() {
        HoaDonCT hdn = new HoaDonCT();
        hdn.setMaHD(Integer.valueOf(lblHoaDon.getToolTipText()));
        hdn.setMaDV(dvdao.selectByTenDV("Nước").getMaDV());
        hdn.setChiSoCu(Integer.valueOf(txtCSNCu.getText()));
        hdn.setChiSoMoi(Integer.valueOf(txtCSNMoi.getText()));
        hdn.setSoLuong(Integer.valueOf(txtSoKhoi.getText()));
        return hdn;
    }
    
    HoaDonCT getFormHDXe() {
        HoaDonCT hdx = new HoaDonCT();
        hdx.setMaHD(Integer.valueOf(lblHoaDon.getToolTipText()));
        hdx.setMaDV(dvdao.selectByTenDV("Giữ xe").getMaDV());
        hdx.setSoLuong(Integer.valueOf(txtSLXe.getText()));
        return hdx;
    }
    
    HoaDonCT getFormHDRac() {
        HoaDonCT hdr = new HoaDonCT();
        hdr.setMaHD(Integer.valueOf(lblHoaDon.getToolTipText()));
        hdr.setMaDV(dvdao.selectByTenDV("Thu rác").getMaDV());
        if (chkRac.isSelected()) {
            hdr.setSuDung(true);
        } else {
            hdr.setSuDung(false);
        }
        return hdr;
    }
    
    HoaDonCT getFormHDWifi() {
        HoaDonCT hdwf = new HoaDonCT();
        hdwf.setMaHD(Integer.valueOf(lblHoaDon.getToolTipText()));
        hdwf.setMaDV(dvdao.selectByTenDV("WI-FI").getMaDV());
        if (chkWifi.isSelected()) {
            hdwf.setSuDung(true);
        } else {
            hdwf.setSuDung(false);
        }
        return hdwf;
    }
    
    void clearForm() {
        this.row = -1;
        txtMaPhong.setText("");
        txtMaKhachThue.setText("");
        txtSLXe.setText("");
        dchNgayXuat.setDate(new Date());
        txtCSDCu.setText("");
        txtCSDMoi.setText("");
        txtCSNCu.setText("");
        txtCSNMoi.setText("");
        txtSDTT.setText("");
        txtSoKhoi.setText("");
        txtTongTien.setText("");
        lblThanhToan.setText("CHƯA THANH TOÁN");
        lblPaid.setIcon(null);
        txtMaPhong.grabFocus();
        this.updateStatus();
    }
    
    void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblHoaDon.getRowCount() - 1);
        // Trạng thái form
        txtMaPhong.setEditable(!edit);
        txtMaKhachThue.setEditable(!edit);
        btnAdd.setEnabled(!edit);
        btnUpdate.setEnabled(edit);
        btnDelete.setEnabled(edit);
        btnInvoice.setEnabled(edit);
        btnPay.setEnabled(edit);
        if (lblThanhToan.getText().equals("ĐÃ THANH TOÁN")) {
            btnPay.setEnabled(false);
        }
        // Trạng thái điều hướng
        btnTop.setEnabled(edit && !first);
        btnPrevious.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
    }
    
    private void timKiem() {
        this.fillTable();
        this.clearForm();
        this.row = -1;
        this.updateStatus();
    }
// kiểm tra thông tin trước khi thêm hóa đơn mới, cập nhật hóa đơn

    boolean check() {
        if (txtMaPhong.getText().isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập mã phòng!");
            txtMaPhong.grabFocus();
            return false;
        }
        boolean check = false;
        List<PhongTro> list = ptdao.selectAll();
        for (PhongTro pt : list) {
            if (txtMaPhong.getText().toUpperCase().equals(pt.getMaPhong())) {
                check = true;
                break;
            }
        }
        boolean check2 = false;
        List<PhongTro> list2 = ptdao.selectPhongDangThue();
        for (PhongTro pt : list2) {
            if (txtMaPhong.getText().toUpperCase().equals(pt.getMaPhong())) {
                check2 = true;
                break;
            }
        }
        if (check == false) {
            DialogHelper.alert(this, "Mã phòng không tồn tại!");
            txtMaPhong.grabFocus();
            return false;
        }
        if (check2 == false) {
            DialogHelper.alert(this, "Mã phòng này chưa có người thuê!");
            txtMaPhong.grabFocus();
            return false;
        }
        if (txtMaKhachThue.getText().isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập mã khách thuê!");
            txtMaKhachThue.grabFocus();
            return false;
        }
        boolean check1 = false;
        List<KhachThueDD> list1 = ktdao.selectAll();
        for (KhachThueDD kt : list1) {
            if (txtMaKhachThue.getText().toUpperCase().equals(kt.getMaKTDD())) {
                check1 = true;
            }
        }
        if (check == false) {
            DialogHelper.alert(this, "Mã khách thuê không tồn tại!");
            txtMaKhachThue.grabFocus();
            return false;
        }
        if (txtSLXe.getText().isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập số lượng xe!");
            txtSLXe.grabFocus();
            return false;
        }
        if (!txtSLXe.getText().matches("\\d+") || Integer.valueOf(txtSLXe.getText()) < 0) {
            DialogHelper.alert(this, "Nhập không đúng dữ liệu!");
            txtSLXe.grabFocus();
            return false;
        }
        if (txtCSDMoi.getText().isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập chỉ số điện mới!");
            txtCSDMoi.grabFocus();
            return false;
        }
        if (!txtCSDMoi.getText().matches("\\d+") || Integer.valueOf(txtCSDMoi.getText()) < 0 || Integer.valueOf(txtCSDMoi.getText()) < Integer.valueOf(txtCSDCu.getText())) {
            DialogHelper.alert(this, "Nhập không đúng dữ liệu!");
            txtCSDMoi.grabFocus();
            return false;
        }
        if (txtCSNMoi.getText().isEmpty()) {
            DialogHelper.alert(this, "Vui lòng nhập chỉ số nước mới!");
            txtCSNMoi.grabFocus();
            return false;
        }
        if (!txtCSNMoi.getText().matches("\\d+") || Integer.valueOf(txtCSNMoi.getText()) < 0 || Integer.valueOf(txtCSNMoi.getText()) < Integer.valueOf(txtCSNCu.getText())) {
            DialogHelper.alert(this, "Nhập không đúng dữ liệu!");
            txtCSNMoi.grabFocus();
            return false;
        }
        return true;
    }

    // Tính số điện tiêu thụ
    String tinhSDTT() {
        int csm = 0;
        int csc = 0;
        if (txtCSDCu.getText().matches("\\d+") && txtCSDCu.getText().matches("\\S+") && !txtCSDCu.getText().isEmpty()) {
            csc = Integer.valueOf(txtCSDCu.getText());
        }
        if (txtCSDMoi.getText().matches("\\d+") && txtCSDMoi.getText().matches("\\S+") && !txtCSDMoi.getText().isEmpty()) {
            csm = Integer.valueOf(txtCSDMoi.getText());
        }
        int sdtt = csm - csc;
        return String.valueOf(sdtt);
    }
// Tính số nước tiêu thụ

    String tinhSoNuoc() {
        int csm = 0;
        int csc = 0;
        if (txtCSNCu.getText().matches("\\d+") && txtCSNCu.getText().matches("\\S+") && !txtCSNCu.getText().isEmpty()) {
            csc = Integer.valueOf(txtCSNCu.getText());
        }
        if (txtCSNMoi.getText().matches("\\d+") && txtCSNMoi.getText().matches("\\S+") && !txtCSNMoi.getText().isEmpty()) {
            csm = Integer.valueOf(txtCSNMoi.getText());
        }
        int sntt = csm - csc;
        return String.valueOf(sntt);
    }
// Xuất hóa đơn dạng PDF

    private void xuatHoaDon() throws PrinterException {
        txtHoaDon.setContentType("text/html");
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        DecimalFormat dcf = new DecimalFormat("###,### VND");
        DecimalFormat dcf1 = new DecimalFormat("###,###");
        String khachThue = ktdao.findById(txtMaKhachThue.getText()).getHoTen();
        String giaPhong = dcf.format(ptdao.selectByMaPhong(txtMaPhong.getText()).getGiaPhong());
        String giaDien = dcf.format(dvdao.selectByTenDV("Điện").getGia());
        String giaNuoc = dcf.format(dvdao.selectByTenDV("Nước").getGia());
        String giaGuiXe = dcf.format(dvdao.selectByTenDV("Giữ xe").getGia());
        String giaRac = dcf.format(dvdao.selectByTenDV("Thu rác").getGia());
        String giaWifi = dcf.format(dvdao.selectByTenDV("WI-FI").getGia());
        String tienPhong = giaPhong;
        String tienDien = dcf.format(dvdao.selectByTenDV("Điện").getGia() * Integer.valueOf(txtSDTT.getText()));
        String tienNuoc = dcf.format(dvdao.selectByTenDV("Nước").getGia() * Integer.valueOf(txtSoKhoi.getText()));
        String tienXe = dcf.format(dvdao.selectByTenDV("Giữ xe").getGia() * Integer.valueOf(txtSLXe.getText()));
        String tienRac = giaRac;
        String tienWifi = giaWifi;
        String tongTien = txtTongTien.getText();
        String hd = "<style> "
                + "table {"
                + "border: 1px solid;"
                + "border-bottom: none"
                + "}"
                + "tr {"
                + "border-bottom: 1px solid;"
                + "}"
                + "td {"
                + "padding: 8px;"
                + "}"
                + "th {"
                + "font-size:10pt"
                + "}"
                + "</style>";
        hd += "<h1 style='text-align:center;'>HÓA ĐƠN THANH TOÁN</h1>";
        hd += "Phòng: " + txtMaPhong.getText() + "<br/><br/>";
        hd += "Ngày lập: " + formater.format(dchNgayXuat.getDate()) + "<br/><br/>";
        hd += "Khách hàng: " + khachThue + "<br/><br/>";
        hd += "<div style='text-align:center;'>==========================================</div><br/>";
        hd += "<div style='text-align:center'>";
        hd += "<table style='max-width:100%'>";
        hd += "<tr>"
                + "<th>Tên dịch vụ</th>"
                + "<th>Chỉ số cũ</th>"
                + "<th>Chỉ số mới</th>"
                + "<th>Số lượng</th>"
                + "<th>Đơn giá</th>"
                + "<th>Thành tiền</th>"
                + "</tr>";
        hd += "<tr>";
        hd += "<td style='text-align:left;'>" + "Phòng" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "1" + "</td>";
        hd += "<td style='text-align:center;'>" + giaPhong + "</td>";
        hd += "<td style='text-align:center;'>" + tienPhong + "</td>";
        hd += "</tr>";
        
        hd += "<tr>";
        hd += "<td style='text-align:left;'>" + "Điện" + "</td>";
        hd += "<td style='text-align:center;'>" + txtCSDCu.getText() + "</td>";
        hd += "<td style='text-align:center;'>" + txtCSDMoi.getText() + "</td>";
        hd += "<td style='text-align:center;'>" + txtSDTT.getText() + "</td>";
        hd += "<td style='text-align:center;'>" + giaDien + "</td>";
        hd += "<td style='text-align:center;'>" + tienDien + "</td>";
        hd += "</tr>";
        
        hd += "<tr>";
        hd += "<td style='text-align:left;'>" + "Nước" + "</td>";
        hd += "<td style='text-align:center;'>" + txtCSNCu.getText() + "</td>";
        hd += "<td style='text-align:center;'>" + txtCSNMoi.getText() + "</td>";
        hd += "<td style='text-align:center;'>" + txtSoKhoi.getText() + "</td>";
        hd += "<td style='text-align:center;'>" + giaNuoc + "</td>";
        hd += "<td style='text-align:center;'>" + tienNuoc + "</td>";
        hd += "</tr>";
        
        hd += "<tr>";
        hd += "<td style='text-align:left;'>" + "Giữ xe" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + txtSLXe.getText() + "</td>";
        hd += "<td style='text-align:center;'>" + giaGuiXe + "</td>";
        hd += "<td style='text-align:center;'>" + tienXe + "</td>";
        hd += "</tr>";
        
        hd += "<tr>";
        hd += "<td style='text-align:left;'>" + "Thu rác" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + giaRac + "</td>";
        hd += "<td style='text-align:center;'>" + tienRac + "</td>";
        hd += "</tr>";
        
        hd += "<tr>";
        hd += "<td style='text-align:left;'>" + "Wifi" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + giaWifi + "</td>";
        hd += "<td style='text-align:center;'>" + tienWifi + "</td>";
        hd += "</tr>";
        
        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold'> Tổng cộng </td>";
        hd += "<td style='text-align:center;'>" + tongTien + "</td>";
        hd += "</tr>";
        
        hd += "</table>";
        hd += "</div><br/>";
        hd += "<div style='text-align:center;'>==========================================</div><br/>";
        txtHoaDon.setText(hd);
        txtHoaDon.print();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInvoice;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnTop;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JComboBox<String> cboThang;
    private javax.swing.JCheckBox chkRac;
    private javax.swing.JCheckBox chkWifi;
    private com.toedter.calendar.JDateChooser dchNgayXuat;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblPaid;
    private javax.swing.JLabel lblThanhToan;
    private javax.swing.JPanel pnlDien;
    private javax.swing.JPanel pnlNuoc;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtCSDCu;
    private javax.swing.JTextField txtCSDMoi;
    private javax.swing.JTextField txtCSNCu;
    private javax.swing.JTextField txtCSNMoi;
    private javax.swing.JEditorPane txtHoaDon;
    private javax.swing.JTextField txtMaKhachThue;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtSDTT;
    private javax.swing.JTextField txtSLXe;
    private javax.swing.JTextField txtSoKhoi;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
