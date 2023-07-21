package Views;

import DAO.KhachThueCungDAO;
import DAO.KhachThueDDDAO;
import DAO.PhongTroDAO;
import DAO.ThongKeDAO;
import Entity.KhachThueCung;
import Entity.KhachThueDD;
import Entity.PhongTro;
import Helper.ShareHelper;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class FormThongKe extends javax.swing.JPanel {

    public FormThongKe() {
        initComponents();
        init();
    }

    ThongKeDAO dao = new ThongKeDAO();
    PhongTroDAO ptdao = new PhongTroDAO();
    KhachThueDDDAO ktdao = new KhachThueDDDAO();
    KhachThueCungDAO ktcdao = new KhachThueCungDAO();
    DecimalFormat dcf = new DecimalFormat("###,### VND");
    DecimalFormat dcf1 = new DecimalFormat("###,###");

    void thongKeKhacThue() {
        int khachThue = 0;
        List<KhachThueDD> list = ktdao.selectAll();
        for (KhachThueDD kt : list) {
            khachThue++;
        }
        List<KhachThueCung> list1 = ktcdao.selectAll();
        for (KhachThueCung ktc : list1) {
            khachThue++;
        }
        lblKhachThue.setText(String.valueOf(khachThue));
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao.getDoanhThu();
        for (Object[] row : list) {
            model.addRow(row);
        }
        double tongDT = 0;
        for (int i = 0; i < tblDoanhThu.getRowCount(); i++) {
            double tt = Double.valueOf(tblDoanhThu.getValueAt(i, 2).toString().replaceAll(",", "").replace(" VND", ""));
            tongDT += tt;
        }
        lblDoanhThu.setText(dcf1.format(tongDT));
    }

    void fillTableDoanhThuTheoNam() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        int nam = 0;
        if (cboNam.getSelectedIndex() > 0) {
            nam = (int) cboNam.getSelectedItem();
        }
        if (cboNam.getSelectedIndex() == 0) {
            fillTable();
        } else {
            List<Object[]> list = dao.getDoanhThuTheoNam(nam);
            for (Object[] row : list) {
                model.addRow(row);
            }
            double tongDT = 0;
            for (int i = 0; i < tblDoanhThu.getRowCount(); i++) {
                double tt = Double.valueOf(tblDoanhThu.getValueAt(i, 2).toString().replaceAll(",", "").replace(" VND", ""));
                tongDT += tt;
            }
            lblDoanhThu.setText(dcf1.format(tongDT));
        }
    }

    void fillTableDoanhThuTheoThang() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        int thang = 0;
        if (cboThang.getSelectedIndex() > 0) {
            thang = cboThang.getSelectedIndex();
        }
        if (cboThang.getSelectedIndex() == 0) {
            fillTable();
        } else {
            List<Object[]> list = dao.getDoanhThuTheoThang(thang);
            for (Object[] row : list) {
                model.addRow(row);
            }
            double tongDT = 0;
            for (int i = 0; i < tblDoanhThu.getRowCount(); i++) {
                double tt = Double.valueOf(tblDoanhThu.getValueAt(i, 2).toString().replaceAll(",", "").replace(" VND", ""));
                tongDT += tt;
            }
            lblDoanhThu.setText(dcf1.format(tongDT));
        }

    }

    void fillTableTheoThangNam() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        int thang = 0;
        if (cboThang.getSelectedIndex() > 0) {
            thang = cboThang.getSelectedIndex();
        }
        int nam = 0;
        if (cboNam.getSelectedIndex() > 0) {
            nam = (int) cboNam.getSelectedItem();
        }
        List<Object[]> list = dao.getDoanhThuTheoThangNam(thang, nam);
        for (Object[] row : list) {
            model.addRow(row);
        }
        double tongDT = 0;
        for (int i = 0; i < tblDoanhThu.getRowCount(); i++) {
            double tt = Double.valueOf(tblDoanhThu.getValueAt(i, 2).toString().replaceAll(",", "").replace(" VND", ""));
            tongDT += tt;
        }
        lblDoanhThu.setText(dcf1.format(tongDT));
    }

    void fillComboBoxNam() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNam.getModel();
        model.removeAllElements();
        List<Integer> list = dao.selectYears();
        model.addElement("Tất cả");
        for (Integer year : list) {
            model.addElement(year);
        }
    }

    void thongKePhongTro() {
        int phongTro = 0;
        int phongTrong = 0;
        List<PhongTro> list = ptdao.selectAll();
        for (PhongTro pt : list) {
            phongTro++;
            if (pt.getTrangThai().equals("Trống")) {
                phongTrong++;
            }
        }
        lblPhongTro.setText(String.valueOf(phongTro));
        lblPhongTrong.setText(String.valueOf(phongTrong));
    }

    void init() {
        tblDoanhThu.getTableHeader().setFont(new Font("Calibri", 0, 22));
        fillComboBoxNam();
        cboNam.setSelectedItem(new Date().getYear());
        cboThang.setSelectedIndex(0);
        thongKePhongTro();
        thongKeKhacThue();
        fillTable();
        tblDoanhThu.setShowGrid(true);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        cboThang = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnlPhongTro = new javax.swing.JPanel();
        lblPhongTro = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblNenPhongTro = new javax.swing.JLabel();
        pnlKhachThue = new javax.swing.JPanel();
        lblKhachThue = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblNenKhachThue = new javax.swing.JLabel();
        pnlPhongTrong = new javax.swing.JPanel();
        lblPhongTrong = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNenPhongTrong = new javax.swing.JLabel();
        pnlDoanhThu = new javax.swing.JPanel();
        lblDoanhThu = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNenDoanhThu = new javax.swing.JLabel();

        setBackground(new java.awt.Color(227, 240, 252));
        setPreferredSize(new java.awt.Dimension(1150, 835));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ThongKe2.png"))); // NOI18N
        jLabel1.setText("THỐNG KÊ");

        jPanel1.setBackground(new java.awt.Color(227, 240, 252));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Năm");

        cboNam.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cboNam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNamItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Tháng");

        tblDoanhThu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tháng", "Năm", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoanhThu.setRowHeight(35);
        jScrollPane2.setViewportView(tblDoanhThu);

        cboThang.setEditable(true);
        cboThang.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cboThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cboThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboThangItemStateChanged(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(227, 240, 252));

        jPanel2.setBackground(new java.awt.Color(227, 240, 252));
        jPanel2.setLayout(new java.awt.GridLayout(2, 2, 30, 30));

        pnlPhongTro.setBackground(new java.awt.Color(255, 204, 204));
        pnlPhongTro.setPreferredSize(new java.awt.Dimension(400, 150));

        lblPhongTro.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        lblPhongTro.setForeground(new java.awt.Color(0, 51, 153));
        lblPhongTro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 153));
        jLabel7.setText("TỔNG SỐ PHÒNG TRỌ:");

        lblNenPhongTro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/home.png"))); // NOI18N

        javax.swing.GroupLayout pnlPhongTroLayout = new javax.swing.GroupLayout(pnlPhongTro);
        pnlPhongTro.setLayout(pnlPhongTroLayout);
        pnlPhongTroLayout.setHorizontalGroup(
            pnlPhongTroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhongTroLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addContainerGap(238, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPhongTroLayout.createSequentialGroup()
                .addComponent(lblPhongTro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlPhongTroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPhongTroLayout.createSequentialGroup()
                    .addContainerGap(341, Short.MAX_VALUE)
                    .addComponent(lblNenPhongTro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        pnlPhongTroLayout.setVerticalGroup(
            pnlPhongTroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhongTroLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblPhongTro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(pnlPhongTroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPhongTroLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblNenPhongTro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel2.add(pnlPhongTro);

        pnlKhachThue.setBackground(new java.awt.Color(0, 204, 255));
        pnlKhachThue.setPreferredSize(new java.awt.Dimension(400, 150));

        lblKhachThue.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        lblKhachThue.setForeground(new java.awt.Color(0, 51, 153));
        lblKhachThue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 153));
        jLabel10.setText("TỔNG SỐ KHÁCH THUÊ:");

        lblNenKhachThue.setBackground(new java.awt.Color(0, 204, 255));
        lblNenKhachThue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/customers.png"))); // NOI18N

        javax.swing.GroupLayout pnlKhachThueLayout = new javax.swing.GroupLayout(pnlKhachThue);
        pnlKhachThue.setLayout(pnlKhachThueLayout);
        pnlKhachThueLayout.setHorizontalGroup(
            pnlKhachThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachThueLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addContainerGap(229, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhachThueLayout.createSequentialGroup()
                .addComponent(lblKhachThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlKhachThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhachThueLayout.createSequentialGroup()
                    .addContainerGap(341, Short.MAX_VALUE)
                    .addComponent(lblNenKhachThue, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        pnlKhachThueLayout.setVerticalGroup(
            pnlKhachThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachThueLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblKhachThue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(pnlKhachThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlKhachThueLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblNenKhachThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel2.add(pnlKhachThue);

        pnlPhongTrong.setBackground(new java.awt.Color(153, 255, 153));
        pnlPhongTrong.setPreferredSize(new java.awt.Dimension(400, 150));

        lblPhongTrong.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        lblPhongTrong.setForeground(new java.awt.Color(0, 51, 153));
        lblPhongTrong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 153));
        jLabel6.setText("TỔNG SỐ PHÒNG TRỐNG:");

        lblNenPhongTrong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/home1.png"))); // NOI18N

        javax.swing.GroupLayout pnlPhongTrongLayout = new javax.swing.GroupLayout(pnlPhongTrong);
        pnlPhongTrong.setLayout(pnlPhongTrongLayout);
        pnlPhongTrongLayout.setHorizontalGroup(
            pnlPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhongTrongLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addContainerGap(207, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPhongTrongLayout.createSequentialGroup()
                .addComponent(lblPhongTrong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPhongTrongLayout.createSequentialGroup()
                    .addContainerGap(341, Short.MAX_VALUE)
                    .addComponent(lblNenPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        pnlPhongTrongLayout.setVerticalGroup(
            pnlPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhongTrongLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(pnlPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPhongTrongLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblNenPhongTrong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel2.add(pnlPhongTrong);

        pnlDoanhThu.setBackground(new java.awt.Color(255, 204, 255));
        pnlDoanhThu.setPreferredSize(new java.awt.Dimension(400, 150));

        lblDoanhThu.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        lblDoanhThu.setForeground(new java.awt.Color(0, 51, 153));
        lblDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 153));
        jLabel5.setText("TỔNG DOANH THU:");

        lblNenDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/piggy-bank.png"))); // NOI18N

        javax.swing.GroupLayout pnlDoanhThuLayout = new javax.swing.GroupLayout(pnlDoanhThu);
        pnlDoanhThu.setLayout(pnlDoanhThuLayout);
        pnlDoanhThuLayout.setHorizontalGroup(
            pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDoanhThuLayout.createSequentialGroup()
                .addComponent(lblDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDoanhThuLayout.createSequentialGroup()
                    .addContainerGap(341, Short.MAX_VALUE)
                    .addComponent(lblNenDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        pnlDoanhThuLayout.setVerticalGroup(
            pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblNenDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.add(pnlDoanhThu);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(51, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(55, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(29, 29, 29))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboThangItemStateChanged
        if (cboNam.getSelectedIndex() == 0) {
            fillTableDoanhThuTheoThang();
        } else if (cboThang.getSelectedIndex() == 0) {
            fillTableDoanhThuTheoNam();
        } else {
            fillTableTheoThangNam();
        }
    }//GEN-LAST:event_cboThangItemStateChanged

    private void cboNamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNamItemStateChanged
        if (cboNam.getSelectedIndex() == 0) {
            fillTableDoanhThuTheoThang();
        } else if (cboThang.getSelectedIndex() == 0) {
            fillTableDoanhThuTheoNam();
        } else {
            fillTableTheoThangNam();
        }
    }//GEN-LAST:event_cboNamItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JComboBox<String> cboThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDoanhThu;
    private javax.swing.JLabel lblKhachThue;
    private javax.swing.JLabel lblNenDoanhThu;
    private javax.swing.JLabel lblNenKhachThue;
    private javax.swing.JLabel lblNenPhongTro;
    private javax.swing.JLabel lblNenPhongTrong;
    private javax.swing.JLabel lblPhongTro;
    private javax.swing.JLabel lblPhongTrong;
    private javax.swing.JPanel pnlDoanhThu;
    private javax.swing.JPanel pnlKhachThue;
    private javax.swing.JPanel pnlPhongTro;
    private javax.swing.JPanel pnlPhongTrong;
    private javax.swing.JTable tblDoanhThu;
    // End of variables declaration//GEN-END:variables
}
