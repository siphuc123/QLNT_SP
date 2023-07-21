package Views;

import Helper.DialogHelper;
import Helper.ShareHelper;
import static Helper.ShareHelper.ResizeImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class mainFrame extends javax.swing.JFrame {

    public mainFrame() {
        initComponents();
        init();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        pnlLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlPhong = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblPhong = new javax.swing.JLabel();
        pnlKhachThue = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblKhachThue = new javax.swing.JLabel();
        pnlHoaDon = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        pnlHopDong = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblHopDong = new javax.swing.JLabel();
        pnlDichVu = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblDichVu = new javax.swing.JLabel();
        pnlThongKe = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lblThongKe = new javax.swing.JLabel();
        pnlThoat = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblThoat = new javax.swing.JLabel();
        pnlCaiDat = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        lblCaiDat = new javax.swing.JLabel();
        pnlHuongDan = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblHuongDan = new javax.swing.JLabel();
        pnlWindow = new javax.swing.JPanel();
        pnlMenuBar = new javax.swing.JPanel();
        btnTaiKhoan1 = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        pnlTrangThai = new javax.swing.JPanel();
        lblThongTin = new javax.swing.JLabel();
        lblThoiGian = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" QUẢN LÝ NHÀ TRỌ");
        setBackground(new java.awt.Color(0, 153, 153));
        setMaximumSize(new java.awt.Dimension(1498, 1010));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setMinimumSize(new java.awt.Dimension(1480, 960));
        jPanel1.setPreferredSize(new java.awt.Dimension(1480, 960));

        pnlMenu.setBackground(new java.awt.Color(0, 153, 153));
        pnlMenu.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlMenu.setPreferredSize(new java.awt.Dimension(330, 910));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogo.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout pnlLogoLayout = new javax.swing.GroupLayout(pnlLogo);
        pnlLogo.setLayout(pnlLogoLayout);
        pnlLogoLayout.setHorizontalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlLogoLayout.setVerticalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 150));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenu.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 330, 60));
        pnlMenu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 330, 10));

        pnlPhong.setBackground(new java.awt.Color(0, 153, 153));
        pnlPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPhongMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlPhongMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlPhongMouseExited(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(153, 0, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/house.png"))); // NOI18N

        lblPhong.setBackground(new java.awt.Color(0, 153, 153));
        lblPhong.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblPhong.setForeground(new java.awt.Color(255, 255, 255));
        lblPhong.setText("PHÒNG");

        javax.swing.GroupLayout pnlPhongLayout = new javax.swing.GroupLayout(pnlPhong);
        pnlPhong.setLayout(pnlPhongLayout);
        pnlPhongLayout.setHorizontalGroup(
            pnlPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhongLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlPhongLayout.setVerticalGroup(
            pnlPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhongLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenu.add(pnlPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 330, 60));

        pnlKhachThue.setBackground(new java.awt.Color(0, 153, 153));
        pnlKhachThue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlKhachThue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlKhachThueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlKhachThueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlKhachThueMouseExited(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(153, 0, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/rating.png"))); // NOI18N

        lblKhachThue.setBackground(new java.awt.Color(0, 153, 153));
        lblKhachThue.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblKhachThue.setForeground(new java.awt.Color(255, 255, 255));
        lblKhachThue.setText("KHÁCH THUÊ");

        javax.swing.GroupLayout pnlKhachThueLayout = new javax.swing.GroupLayout(pnlKhachThue);
        pnlKhachThue.setLayout(pnlKhachThueLayout);
        pnlKhachThueLayout.setHorizontalGroup(
            pnlKhachThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachThueLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblKhachThue, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlKhachThueLayout.setVerticalGroup(
            pnlKhachThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachThueLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlKhachThueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKhachThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenu.add(pnlKhachThue, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 330, 60));

        pnlHoaDon.setBackground(new java.awt.Color(0, 153, 153));
        pnlHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlHoaDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlHoaDonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlHoaDonMouseExited(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(153, 0, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bill.png"))); // NOI18N

        lblHoaDon.setBackground(new java.awt.Color(0, 153, 153));
        lblHoaDon.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblHoaDon.setText("HÓA ĐƠN");

        javax.swing.GroupLayout pnlHoaDonLayout = new javax.swing.GroupLayout(pnlHoaDon);
        pnlHoaDon.setLayout(pnlHoaDonLayout);
        pnlHoaDonLayout.setHorizontalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlHoaDonLayout.setVerticalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenu.add(pnlHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 330, 60));

        pnlHopDong.setBackground(new java.awt.Color(0, 153, 153));
        pnlHopDong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlHopDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlHopDongMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlHopDongMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlHopDongMouseExited(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(153, 0, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/contract.png"))); // NOI18N

        lblHopDong.setBackground(new java.awt.Color(0, 153, 153));
        lblHopDong.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblHopDong.setForeground(new java.awt.Color(255, 255, 255));
        lblHopDong.setText("HỢP ĐỒNG");

        javax.swing.GroupLayout pnlHopDongLayout = new javax.swing.GroupLayout(pnlHopDong);
        pnlHopDong.setLayout(pnlHopDongLayout);
        pnlHopDongLayout.setHorizontalGroup(
            pnlHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHopDongLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlHopDongLayout.setVerticalGroup(
            pnlHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHopDongLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlHopDongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHopDong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenu.add(pnlHopDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 330, 60));

        pnlDichVu.setBackground(new java.awt.Color(0, 153, 153));
        pnlDichVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDichVuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlDichVuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlDichVuMouseExited(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(153, 0, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/electric.png"))); // NOI18N

        lblDichVu.setBackground(new java.awt.Color(0, 153, 153));
        lblDichVu.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblDichVu.setForeground(new java.awt.Color(255, 255, 255));
        lblDichVu.setText("DỊCH VỤ");

        javax.swing.GroupLayout pnlDichVuLayout = new javax.swing.GroupLayout(pnlDichVu);
        pnlDichVu.setLayout(pnlDichVuLayout);
        pnlDichVuLayout.setHorizontalGroup(
            pnlDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDichVuLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlDichVuLayout.setVerticalGroup(
            pnlDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDichVuLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenu.add(pnlDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 330, 60));

        pnlThongKe.setBackground(new java.awt.Color(0, 153, 153));
        pnlThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlThongKeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlThongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlThongKeMouseExited(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(153, 0, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/growth.png"))); // NOI18N

        lblThongKe.setBackground(new java.awt.Color(0, 153, 153));
        lblThongKe.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lblThongKe.setText("THỐNG KÊ");

        javax.swing.GroupLayout pnlThongKeLayout = new javax.swing.GroupLayout(pnlThongKe);
        pnlThongKe.setLayout(pnlThongKeLayout);
        pnlThongKeLayout.setHorizontalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlThongKeLayout.setVerticalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenu.add(pnlThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 330, 60));

        pnlThoat.setBackground(new java.awt.Color(0, 153, 153));
        pnlThoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlThoatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlThoatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlThoatMouseExited(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(153, 0, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exit-full-screen.png"))); // NOI18N

        lblThoat.setBackground(new java.awt.Color(0, 153, 153));
        lblThoat.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblThoat.setForeground(new java.awt.Color(255, 255, 255));
        lblThoat.setText("THOÁT");

        javax.swing.GroupLayout pnlThoatLayout = new javax.swing.GroupLayout(pnlThoat);
        pnlThoat.setLayout(pnlThoatLayout);
        pnlThoatLayout.setHorizontalGroup(
            pnlThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThoatLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlThoatLayout.setVerticalGroup(
            pnlThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThoatLayout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlThoatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenu.add(pnlThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 700, 330, 60));

        pnlCaiDat.setBackground(new java.awt.Color(0, 153, 153));
        pnlCaiDat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlCaiDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCaiDatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlCaiDatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlCaiDatMouseExited(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(153, 0, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/setting (1).png"))); // NOI18N

        lblCaiDat.setBackground(new java.awt.Color(0, 153, 153));
        lblCaiDat.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblCaiDat.setForeground(new java.awt.Color(255, 255, 255));
        lblCaiDat.setText("CÀI ĐẶT");

        javax.swing.GroupLayout pnlCaiDatLayout = new javax.swing.GroupLayout(pnlCaiDat);
        pnlCaiDat.setLayout(pnlCaiDatLayout);
        pnlCaiDatLayout.setHorizontalGroup(
            pnlCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCaiDatLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblCaiDat, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlCaiDatLayout.setVerticalGroup(
            pnlCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCaiDatLayout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlCaiDatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCaiDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenu.add(pnlCaiDat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 770, 330, 60));

        pnlHuongDan.setBackground(new java.awt.Color(0, 153, 153));
        pnlHuongDan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlHuongDan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlHuongDanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlHuongDanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlHuongDanMouseExited(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(153, 0, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/info.png"))); // NOI18N

        lblHuongDan.setBackground(new java.awt.Color(0, 153, 153));
        lblHuongDan.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblHuongDan.setForeground(new java.awt.Color(255, 255, 255));
        lblHuongDan.setText("HƯỚNG DẪN");

        javax.swing.GroupLayout pnlHuongDanLayout = new javax.swing.GroupLayout(pnlHuongDan);
        pnlHuongDan.setLayout(pnlHuongDanLayout);
        pnlHuongDanLayout.setHorizontalGroup(
            pnlHuongDanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHuongDanLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHuongDan, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pnlHuongDanLayout.setVerticalGroup(
            pnlHuongDanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHuongDanLayout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHuongDanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHuongDan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenu.add(pnlHuongDan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 840, 330, 60));

        pnlWindow.setBackground(new java.awt.Color(255, 255, 255));
        pnlWindow.setAlignmentX(0.0F);
        pnlWindow.setAlignmentY(0.0F);
        pnlWindow.setPreferredSize(new java.awt.Dimension(1150, 835));
        pnlWindow.setLayout(new java.awt.BorderLayout());

        pnlMenuBar.setBackground(new java.awt.Color(176, 247, 243));
        pnlMenuBar.setAlignmentX(0.0F);
        pnlMenuBar.setAlignmentY(0.0F);
        pnlMenuBar.setPreferredSize(new java.awt.Dimension(1150, 75));

        btnTaiKhoan1.setBackground(new java.awt.Color(255, 255, 255));
        btnTaiKhoan1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnTaiKhoan1.setForeground(new java.awt.Color(0, 204, 204));
        btnTaiKhoan1.setText("TÀI KHOẢN");
        btnTaiKhoan1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaiKhoan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiKhoan1ActionPerformed(evt);
            }
        });

        btnDangXuat.setBackground(new java.awt.Color(255, 255, 255));
        btnDangXuat.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(0, 204, 204));
        btnDangXuat.setText("ĐĂNG XUẤT");
        btnDangXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuBarLayout = new javax.swing.GroupLayout(pnlMenuBar);
        pnlMenuBar.setLayout(pnlMenuBarLayout);
        pnlMenuBarLayout.setHorizontalGroup(
            pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTaiKhoan1)
                .addGap(18, 18, 18)
                .addComponent(btnDangXuat)
                .addGap(24, 24, 24))
        );
        pnlMenuBarLayout.setVerticalGroup(
            pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuBarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaiKhoan1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pnlTrangThai.setAlignmentX(0.0F);
        pnlTrangThai.setAlignmentY(0.0F);
        pnlTrangThai.setPreferredSize(new java.awt.Dimension(1480, 50));

        lblThongTin.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        lblThongTin.setForeground(new java.awt.Color(51, 51, 51));
        lblThongTin.setText("Chào mừng bạn Nguyễn Văn A - Chủ trọ");

        lblThoiGian.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lblThoiGian.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout pnlTrangThaiLayout = new javax.swing.GroupLayout(pnlTrangThai);
        pnlTrangThai.setLayout(pnlTrangThaiLayout);
        pnlTrangThaiLayout.setHorizontalGroup(
            pnlTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTrangThaiLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTrangThaiLayout.setVerticalGroup(
            pnlTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(lblThoiGian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnlMenuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(pnlTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlMenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnlWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE))
                    .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(pnlTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int selected = 1; // Biến này dùng để xác định chức năng nào dược chọn
    private void pnlPhongMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPhongMouseEntered
        if (selected != 1) {
            pnlPhong.setBackground(new java.awt.Color(204, 255, 255));
            lblPhong.setForeground(Color.black);
        }
    }//GEN-LAST:event_pnlPhongMouseEntered

    private void pnlPhongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPhongMouseExited
        if (selected != 1) {
            pnlPhong.setBackground(new java.awt.Color(0, 153, 153));
            lblPhong.setForeground(Color.white);
        }
    }//GEN-LAST:event_pnlPhongMouseExited

    private void pnlKhachThueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlKhachThueMouseEntered
        if (selected != 2) {
            pnlKhachThue.setBackground(new java.awt.Color(204, 255, 255));
            lblKhachThue.setForeground(Color.black);
        }
    }//GEN-LAST:event_pnlKhachThueMouseEntered

    private void pnlKhachThueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlKhachThueMouseExited
        if (selected != 2) {
            pnlKhachThue.setBackground(new java.awt.Color(0, 153, 153));
            lblKhachThue.setForeground(Color.white);
        }
    }//GEN-LAST:event_pnlKhachThueMouseExited

    private void pnlHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHoaDonMouseEntered
        if (selected != 3) {
            pnlHoaDon.setBackground(new java.awt.Color(204, 255, 255));
            lblHoaDon.setForeground(Color.black);
        }
    }//GEN-LAST:event_pnlHoaDonMouseEntered

    private void pnlHoaDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHoaDonMouseExited
        if (selected != 3) {
            pnlHoaDon.setBackground(new java.awt.Color(0, 153, 153));
            lblHoaDon.setForeground(Color.white);
        }
    }//GEN-LAST:event_pnlHoaDonMouseExited

    private void pnlHopDongMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHopDongMouseEntered
        if (selected != 4) {
            pnlHopDong.setBackground(new java.awt.Color(204, 255, 255));
            lblHopDong.setForeground(Color.black);
        }
    }//GEN-LAST:event_pnlHopDongMouseEntered

    private void pnlHopDongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHopDongMouseExited
        if (selected != 4) {
            pnlHopDong.setBackground(new java.awt.Color(0, 153, 153));
            lblHopDong.setForeground(Color.white);
        }
    }//GEN-LAST:event_pnlHopDongMouseExited

    private void pnlDichVuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDichVuMouseEntered
        if (selected != 5) {
            pnlDichVu.setBackground(new java.awt.Color(204, 255, 255));
            lblDichVu.setForeground(Color.black);
        }
    }//GEN-LAST:event_pnlDichVuMouseEntered

    private void pnlDichVuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDichVuMouseExited
        if (selected != 5) {
            pnlDichVu.setBackground(new java.awt.Color(0, 153, 153));
            lblDichVu.setForeground(Color.white);
        }
    }//GEN-LAST:event_pnlDichVuMouseExited

    private void pnlThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThongKeMouseEntered
        if (selected != 6) {
            pnlThongKe.setBackground(new java.awt.Color(204, 255, 255));
            lblThongKe.setForeground(Color.black);
        }
    }//GEN-LAST:event_pnlThongKeMouseEntered

    private void pnlThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThongKeMouseExited
        if (selected != 6) {
            pnlThongKe.setBackground(new java.awt.Color(0, 153, 153));
            lblThongKe.setForeground(Color.white);
        }
    }//GEN-LAST:event_pnlThongKeMouseExited

    private void pnlThoatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThoatMouseEntered
        pnlThoat.setBackground(new java.awt.Color(204, 255, 255));
        lblThoat.setForeground(Color.black);
    }//GEN-LAST:event_pnlThoatMouseEntered

    private void pnlThoatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThoatMouseExited
        pnlThoat.setBackground(new java.awt.Color(0, 153, 153));
        lblThoat.setForeground(Color.white);
    }//GEN-LAST:event_pnlThoatMouseExited

    private void pnlCaiDatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCaiDatMouseEntered
        if (selected != 7) {
            pnlCaiDat.setBackground(new java.awt.Color(204, 255, 255));
            lblCaiDat.setForeground(Color.black);
        }
    }//GEN-LAST:event_pnlCaiDatMouseEntered

    private void pnlCaiDatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCaiDatMouseExited
        if (selected != 7) {
            pnlCaiDat.setBackground(new java.awt.Color(0, 153, 153));
            lblCaiDat.setForeground(Color.white);
        }
    }//GEN-LAST:event_pnlCaiDatMouseExited

    private void pnlHuongDanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHuongDanMouseEntered
        pnlHuongDan.setBackground(new java.awt.Color(204, 255, 255));
        lblHuongDan.setForeground(Color.black);
    }//GEN-LAST:event_pnlHuongDanMouseEntered

    private void pnlHuongDanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHuongDanMouseExited
        pnlHuongDan.setBackground(new java.awt.Color(0, 153, 153));
        lblHuongDan.setForeground(Color.white);
    }//GEN-LAST:event_pnlHuongDanMouseExited

    private void pnlPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPhongMouseClicked
        selected = 1;
        showPanel(new FormQLPhong());
    }//GEN-LAST:event_pnlPhongMouseClicked

    private void pnlKhachThueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlKhachThueMouseClicked
        selected = 2;
        showPanel(new FormQLKhachThue());
    }//GEN-LAST:event_pnlKhachThueMouseClicked

    private void pnlHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHoaDonMouseClicked
        selected = 3;
        showPanel(new FormQLHoaDon());
    }//GEN-LAST:event_pnlHoaDonMouseClicked

    private void pnlHopDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHopDongMouseClicked
        selected = 4;
        showPanel(new FormQLHopDong());
    }//GEN-LAST:event_pnlHopDongMouseClicked

    private void pnlDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDichVuMouseClicked
        selected = 5;
        showPanel(new FormQLDichVu());
    }//GEN-LAST:event_pnlDichVuMouseClicked

    private void pnlThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThongKeMouseClicked
        selected = 6;
        showPanel(new FormThongKe());
    }//GEN-LAST:event_pnlThongKeMouseClicked

    private void pnlThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThoatMouseClicked
        if (DialogHelper.confirm(this, "Bạn muốn thoát khỏi ứng dụng?")) {
            System.exit(0);
        }
    }//GEN-LAST:event_pnlThoatMouseClicked

    private void pnlCaiDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCaiDatMouseClicked
        selected = 7;
        showPanel(new FormCaiDat());
    }//GEN-LAST:event_pnlCaiDatMouseClicked

    private void pnlHuongDanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHuongDanMouseClicked
        try {
            Desktop.getDesktop().browse(new File("help/index.html").toURI());
        } catch (IOException ex) {
            DialogHelper.alert(this, "Không tìm thấy file hướng dẫn!");
        }
    }//GEN-LAST:event_pnlHuongDanMouseClicked

    private void btnTaiKhoan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiKhoan1ActionPerformed
        selected = 7;
        showPanel(new FormTaiKhoan());
    }//GEN-LAST:event_btnTaiKhoan1ActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        ShareHelper.logoff();
        this.dispose();
        new LoginFrame().setVisible(true);
    }//GEN-LAST:event_btnDangXuatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }
    String ten = "";
    String vaiTro = "";

    void init() {
        this.setLocationRelativeTo(null);
        lblLogo.setIcon(ResizeImage(String.valueOf(ShareHelper.readLogo("logo.png")), lblLogo));
        setIconImage(ShareHelper.APP_ICON);
        showPanel(new FormQLPhong());
        startDongHo();
        if (ShareHelper.USER != null) {
            ten = ShareHelper.USER.getHoTen();
            if (ShareHelper.USER.isVaiTro()) {
                vaiTro = "Quản lý trọ";
            } else {
                vaiTro = "Chủ trọ";
            }
            lblThongTin.setText("Chào mừng bạn " + ten + " - " + vaiTro);
        }
        pnlTrangThai.setPreferredSize(new Dimension(1480, 50));
        this.add(pnlTrangThai, BorderLayout.PAGE_END);
        if(ShareHelper.isManager()){
            pnlThongKe.setVisible(false);
        }
    }

// Hàm này để hiển thị thời gian ở thanh trạng thái
    void startDongHo() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy     hh:mm:ss a");
        new Timer(100, (ActionEvent e) -> {
            lblThoiGian.setText(formater.format(new Date()));
        }).start();
    }
// Hàm này để hiển thị form chức năng được chọn, thay đổi nền và chữ của menu được chọn

    public void showPanel(Component com) {
        pnlWindow.removeAll();
        pnlWindow.add(com);
        pnlWindow.revalidate();
        pnlWindow.repaint();
        switch (selected) {
            case 1:
                lblPhong.setForeground(Color.black);
                pnlPhong.setBackground(new java.awt.Color(227, 240, 252));
                lblKhachThue.setForeground(Color.white);
                pnlKhachThue.setBackground(new java.awt.Color(0, 153, 153));
                lblHoaDon.setForeground(Color.white);
                pnlHoaDon.setBackground(new java.awt.Color(0, 153, 153));
                lblHopDong.setForeground(Color.white);
                pnlHopDong.setBackground(new java.awt.Color(0, 153, 153));
                lblDichVu.setForeground(Color.white);
                pnlDichVu.setBackground(new java.awt.Color(0, 153, 153));
                lblThongKe.setForeground(Color.white);
                pnlThongKe.setBackground(new java.awt.Color(0, 153, 153));
                lblCaiDat.setForeground(Color.white);
                pnlCaiDat.setBackground(new java.awt.Color(0, 153, 153));
                break;
            case 2:
                lblKhachThue.setForeground(Color.black);
                pnlKhachThue.setBackground(new java.awt.Color(227, 240, 252));
                lblPhong.setForeground(Color.white);
                pnlPhong.setBackground(new java.awt.Color(0, 153, 153));
                lblHoaDon.setForeground(Color.white);
                pnlHoaDon.setBackground(new java.awt.Color(0, 153, 153));
                lblHopDong.setForeground(Color.white);
                pnlHopDong.setBackground(new java.awt.Color(0, 153, 153));
                lblDichVu.setForeground(Color.white);
                pnlDichVu.setBackground(new java.awt.Color(0, 153, 153));
                lblThongKe.setForeground(Color.white);
                pnlThongKe.setBackground(new java.awt.Color(0, 153, 153));
                lblCaiDat.setForeground(Color.white);
                pnlCaiDat.setBackground(new java.awt.Color(0, 153, 153));
                break;
            case 3:
                lblHoaDon.setForeground(Color.black);
                pnlHoaDon.setBackground(new java.awt.Color(227, 240, 252));
                lblPhong.setForeground(Color.white);
                pnlPhong.setBackground(new java.awt.Color(0, 153, 153));
                lblKhachThue.setForeground(Color.white);
                pnlKhachThue.setBackground(new java.awt.Color(0, 153, 153));
                lblHopDong.setForeground(Color.white);
                pnlHopDong.setBackground(new java.awt.Color(0, 153, 153));
                lblDichVu.setForeground(Color.white);
                pnlDichVu.setBackground(new java.awt.Color(0, 153, 153));
                lblThongKe.setForeground(Color.white);
                pnlThongKe.setBackground(new java.awt.Color(0, 153, 153));
                lblCaiDat.setForeground(Color.white);
                pnlCaiDat.setBackground(new java.awt.Color(0, 153, 153));
                break;
            case 4:
                lblHopDong.setForeground(Color.black);
                pnlHopDong.setBackground(new java.awt.Color(227, 240, 252));
                lblPhong.setForeground(Color.white);
                pnlPhong.setBackground(new java.awt.Color(0, 153, 153));
                lblKhachThue.setForeground(Color.white);
                pnlKhachThue.setBackground(new java.awt.Color(0, 153, 153));
                lblHoaDon.setForeground(Color.white);
                pnlHoaDon.setBackground(new java.awt.Color(0, 153, 153));
                lblDichVu.setForeground(Color.white);
                pnlDichVu.setBackground(new java.awt.Color(0, 153, 153));
                lblThongKe.setForeground(Color.white);
                pnlThongKe.setBackground(new java.awt.Color(0, 153, 153));
                lblCaiDat.setForeground(Color.white);
                pnlCaiDat.setBackground(new java.awt.Color(0, 153, 153));
                break;
            case 5:
                lblDichVu.setForeground(Color.black);
                pnlDichVu.setBackground(new java.awt.Color(227, 240, 252));
                lblPhong.setForeground(Color.white);
                pnlPhong.setBackground(new java.awt.Color(0, 153, 153));
                lblKhachThue.setForeground(Color.white);
                pnlKhachThue.setBackground(new java.awt.Color(0, 153, 153));
                lblHoaDon.setForeground(Color.white);
                pnlHoaDon.setBackground(new java.awt.Color(0, 153, 153));
                lblHopDong.setForeground(Color.white);
                pnlHopDong.setBackground(new java.awt.Color(0, 153, 153));
                lblThongKe.setForeground(Color.white);
                pnlThongKe.setBackground(new java.awt.Color(0, 153, 153));
                lblCaiDat.setForeground(Color.white);
                pnlCaiDat.setBackground(new java.awt.Color(0, 153, 153));
                break;
            case 6:
                lblThongKe.setForeground(Color.black);
                pnlThongKe.setBackground(new java.awt.Color(227, 240, 252));
                lblPhong.setForeground(Color.white);
                pnlPhong.setBackground(new java.awt.Color(0, 153, 153));
                lblKhachThue.setForeground(Color.white);
                pnlKhachThue.setBackground(new java.awt.Color(0, 153, 153));
                lblHoaDon.setForeground(Color.white);
                pnlHoaDon.setBackground(new java.awt.Color(0, 153, 153));
                lblHopDong.setForeground(Color.white);
                pnlHopDong.setBackground(new java.awt.Color(0, 153, 153));
                lblDichVu.setForeground(Color.white);
                pnlDichVu.setBackground(new java.awt.Color(0, 153, 153));
                lblCaiDat.setForeground(Color.white);
                pnlCaiDat.setBackground(new java.awt.Color(0, 153, 153));
                break;
            case 7:
                lblCaiDat.setForeground(Color.black);
                pnlCaiDat.setBackground(new java.awt.Color(227, 240, 252));
                lblPhong.setForeground(Color.white);
                pnlPhong.setBackground(new java.awt.Color(0, 153, 153));
                lblKhachThue.setForeground(Color.white);
                pnlKhachThue.setBackground(new java.awt.Color(0, 153, 153));
                lblHoaDon.setForeground(Color.white);
                pnlHoaDon.setBackground(new java.awt.Color(0, 153, 153));
                lblHopDong.setForeground(Color.white);
                pnlHopDong.setBackground(new java.awt.Color(0, 153, 153));
                lblDichVu.setForeground(Color.white);
                pnlDichVu.setBackground(new java.awt.Color(0, 153, 153));
                lblThongKe.setForeground(Color.white);
                pnlThongKe.setBackground(new java.awt.Color(0, 153, 153));
                break;
            default:
                break;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnTaiKhoan1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCaiDat;
    private javax.swing.JLabel lblDichVu;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblHopDong;
    private javax.swing.JLabel lblHuongDan;
    private javax.swing.JLabel lblKhachThue;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPhong;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblThoiGian;
    private javax.swing.JLabel lblThongKe;
    private javax.swing.JLabel lblThongTin;
    private javax.swing.JPanel pnlCaiDat;
    private javax.swing.JPanel pnlDichVu;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlHopDong;
    private javax.swing.JPanel pnlHuongDan;
    private javax.swing.JPanel pnlKhachThue;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenuBar;
    private javax.swing.JPanel pnlPhong;
    private javax.swing.JPanel pnlThoat;
    private javax.swing.JPanel pnlThongKe;
    private javax.swing.JPanel pnlTrangThai;
    private javax.swing.JPanel pnlWindow;
    // End of variables declaration//GEN-END:variables
}
