package Views;

import DAO.PhongTroDAO;
import Entity.PhongTro;
import Entity.PhongTroCoTen;
import Helper.DialogHelper;
import Helper.JdbcHelper;
import Helper.ShareHelper;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
//import org.oxbow.swingbits.table.filter.TableRowFilterSupport;

public class FormQLPhong extends javax.swing.JPanel {

    public FormQLPhong() {
        initComponents();
        init();
    }

    void init() {
        tblPhong.getTableHeader().setFont(new Font("Calibri", 0, 22));
        // đưa dữ liệu lên
//        load();
        loadName();
        // thêm combobox
        ThemComboBox();
        // lấy chỉ định text field để tìm kiếm
        rowSorter = new TableRowSorter<>(tblPhong.getModel());
        tblPhong.setRowSorter(rowSorter);
//        TableRowFilterSupport.forTable(tblPhong).searchable(true).apply();
        // thêm dữ liệu
        rdoCoc.setActionCommand("Đang cọc");
        rdoDangThue.setActionCommand("Đang thuê");
        rdoTrong.setActionCommand("Trống");
        // show Grid table
        tblPhong.setShowGrid(true);
    }

    boolean flag = false;
    int index = 0;
    PhongTroDAO dao = new PhongTroDAO();
    // thanh tìm kiếm
    RowFilter<Object, Object> rf = new RowFilter<Object, Object>() {
        @Override
        public boolean include(Entry<? extends Object, ? extends Object> entry) {
            String column1 = (String) entry.getValue(1);
            String column2 = (String) entry.getValue(2);

            if (column1.isEmpty() && column2.isEmpty()) {
                return false;
            } else {
                return true;
            }
        }
    };
    private TableRowSorter<TableModel> rowSorter;
    // Format tiền
    DecimalFormat dcf = new DecimalFormat("###,###");
    // Hình ảnh phòng trọ
    private String Path = "logos\\khonggac1.png"; // ảnh mặc định

    void check() {
        boolean check = false;
        List<PhongTro> list = dao.selectAll();
        String mapt = txtMaPhong.getText();
        for (PhongTro pt : list) {
            if (pt.getMaPhong().equals(mapt)) {
                check = true;
                break;
            }
        }
        if (txtMaPhong.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập mã phòng!");
            txtMaPhong.grabFocus();
        } else if (check) {
            DialogHelper.alert(this, "Mã Phòng này đã tồn tại!");
            txtMaPhong.grabFocus();
        } else if (txtGiaPhong.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập giá thuê phòng !");
            txtGiaPhong.grabFocus();
        } else if (!txtGiaPhong.getText().matches("[0-9]+")) {
            DialogHelper.alert(this, "Giá phòng chỉ nhập số !");
            txtGiaPhong.grabFocus();
        } else {
            flag = true;
        }
    }

    // load có lấy họ tên người thuê đại diện
    void loadName() {
        DefaultTableModel model = (DefaultTableModel) tblPhong.getModel();
        model.setRowCount(0);
        try {
            List<PhongTroCoTen> list = dao.selectWithName();
            for (PhongTroCoTen pt : list) {
                Object[] row = {
                    pt.getMaPhong(),
                    pt.getLoaiPhong(),
                    dcf.format(pt.getGiaPhong()),
                    pt.getTrangThai(),
                    pt.getTang(),
                    pt.getMoTa(),
                    pt.getTenNguoiDD()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    // load bảng phòng trọ bình thường
    void load() {
        DefaultTableModel model = (DefaultTableModel) tblPhong.getModel();
        model.setRowCount(0);
        try {
            List<PhongTro> list = dao.selectAll();
            for (PhongTro pt : list) {
                Object[] row = {
                    pt.getMaPhong(),
                    pt.getLoaiPhong(),
                    dcf.format(pt.getGiaPhong()),
                    pt.getTrangThai(),
                    pt.getTang(),
                    pt.getMoTa(),
                    pt.getHinhAnh()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void insert() {
        PhongTro model = getModel();
        try {
            dao.insert(model);
            this.load();
            //this.clear();
            DialogHelper.alert(this, "Thêm mới thành công!");
            setStatus(false);
        } catch (Exception e) {
            DialogHelper.alert(this, "Chuyên đề này đã có!");
        }

    }

    void update() {
        PhongTro model = getModel();
        try {
            dao.update(model);
            this.load();
            DialogHelper.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Cập nhật thất bại!");
            System.out.println(e);
        }

    }

    void delete() {
        if (ShareHelper.isManager() == false) {
            if (DialogHelper.confirm(this, "Bạn có thực sự muốn xóa phòng không?")) {
                String maP = txtMaPhong.getText();
                try {
                    dao.delete(maP);
                    this.load();
                    this.clear();
                    DialogHelper.alert(this, "Xóa thành công!");
                } catch (Exception e) {
                    DialogHelper.alert(this, "Xóa thất bại!");
                    System.out.println(e);
                }
            }
        } else {
            DialogHelper.alert(this, "Bạn không có quyền xóa phòng trọ!");
        }
    }

    void clear() {
        txtMaPhong.setText(null);
        txtGiaPhong.setText(null);
        txtMoTa.setText("");
        cboLoai.setSelectedIndex(0);
        cboTang.setSelectedIndex(0);
        txtMaPhong.grabFocus();
        lblPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add-button.png")));
        this.setStatus(true);
    }

    void edit() {
        try {
            String maP = (String) tblPhong.getValueAt(this.index, 0);
            PhongTro model = dao.selectByMaPhong(maP);
            if (model != null) {
                this.setModel(model);
                this.setStatus(false);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void setModel(PhongTro model) {
        txtMaPhong.setText(model.getMaPhong());
        cboLoai.setSelectedItem(model.getLoaiPhong());
        txtGiaPhong.setText(dcf.format(Double.valueOf(model.getGiaPhong())));
        if (model.getTrangThai().equalsIgnoreCase("Trống")) {
            rdoTrong.setSelected(true);
        } else if (model.getTrangThai().equalsIgnoreCase("Đang cọc")) {
            rdoCoc.setSelected(true);
        } else {
            rdoDangThue.setSelected(true);
        }
        cboTang.setSelectedItem(model.getTang());
        txtMoTa.setText(model.getMoTa());
        lblPicture.setToolTipText(model.getHinhAnh());
        if (model.getHinhAnh() != null) {
            lblPicture.setIcon(ShareHelper.ResizeImage(String.valueOf(ShareHelper.readLogo(model.getHinhAnh())), pnlIMG));
        } else {
            System.out.println("null");
        }
    }

    PhongTro getModel() {
        PhongTro model = new PhongTro();
        model.setMaPhong(txtMaPhong.getText());
        model.setLoaiPhong(String.valueOf(cboLoai.getSelectedItem()));
        model.setGiaPhong(Double.valueOf(txtGiaPhong.getText().replaceAll(",", "")));
        model.setTrangThai(grpTrangThai.getSelection().getActionCommand());
        model.setTang(Integer.valueOf(cboTang.getSelectedItem().toString()));
        model.setMoTa(txtMoTa.getText());
        model.setHinhAnh(lblPicture.getToolTipText()); // lấy tên sẽ set ẩn
        return model;
    }

    void setStatus(boolean insertable) {
        txtMaPhong.setEditable(insertable);
        btnAdd.setEnabled(insertable);
        btnUpdate.setEnabled(!insertable);
        btnDelete.setEnabled(!insertable);
    }

    // để tự động thêm vào combo box như sql
    void ThemComboBox() {
        // 2 combo box ở tab quản lí
        DefaultComboBoxModel modelLoai = (DefaultComboBoxModel) cboLoai.getModel();
        modelLoai.removeAllElements();
        DefaultComboBoxModel modelTang = (DefaultComboBoxModel) cboTang.getModel();
        modelTang.removeAllElements();
        // 2 combo box tìm kiếm ở tab danh sách
        DefaultComboBoxModel modelTimLoai = (DefaultComboBoxModel) cboTKLoaiP.getModel();
        DefaultComboBoxModel modelTimTang = (DefaultComboBoxModel) cboTKTang.getModel();
        // tạo arraylist
        List<PhongTro> listTang = new ArrayList<>();
        List<PhongTro> listLoai = new ArrayList<>();
        try {
            ResultSet rs = null;
            // Thêm tầng
            try {
                String sql = "  SELECT pt.Tang FROM PhongTro pt GROUP BY pt.Tang";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    modelTang.addElement(rs.getInt("Tang"));
                    modelTimTang.addElement(rs.getInt("Tang"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Thêm Loại
            try {
                String sql = "  SELECT pt.LoaiPhong FROM PhongTro pt GROUP BY pt.loaiphong";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    modelLoai.addElement(rs.getString("LoaiPhong"));
                    modelTimLoai.addElement(rs.getString("LoaiPhong"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    // Tự động tìm kiếm chữ giống có trong list ( thông qua text field )
    void SortListSearching() {
        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtTimKiem.getText().trim();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtTimKiem.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Không hỗ trợ điều này !.");
            }
        });
    }

    // tìm kiếm thông qua 2 nút phân loại, tầng
    void SortListCategories() {
//        txtTimKiem.setText("");
        if (!cboTKTang.getSelectedItem().toString().equals("Tất cả")) {
            int tang = Integer.valueOf(cboTKTang.getSelectedItem().toString());
            // xóa tất cả
            rowSorter.setRowFilter(null);
            DefaultTableModel model = (DefaultTableModel) tblPhong.getModel();
            model.setRowCount(0);
            // tìm kiếm theo tầng
            List<PhongTroCoTen> list = dao.selectWithName();
            for (PhongTroCoTen pt : list) {
                if (pt.getTang() == tang) {
                    Object[] row = {
                        pt.getMaPhong(),
                        pt.getLoaiPhong(),
                        pt.getGiaPhong(),
                        pt.getTrangThai(),
                        pt.getTang(),
                        pt.getMoTa(),
                        pt.getTenNguoiDD()
                    };
                    model.addRow(row);
                }
            }
            // tìm kiếm loại nếu chọn tầng trước
            if (!cboTKLoaiP.getSelectedItem().toString().equals("Tất cả")) {
                String loai = cboTKLoaiP.getSelectedItem().toString();
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + loai));
            }
        } else if (!cboTKLoaiP.getSelectedItem().toString().equals("Tất cả")) {
            String loai = cboTKLoaiP.getSelectedItem().toString();
            // xóa tất cả
            rowSorter.setRowFilter(null);
            DefaultTableModel model = (DefaultTableModel) tblPhong.getModel();
            model.setRowCount(0);
            // tìm kiếm theo tầng
            List<PhongTroCoTen> list = dao.selectWithName();
            for (PhongTroCoTen pt : list) {
                if (pt.getLoaiPhong().equals(loai)) {
                    Object[] row = {
                        pt.getMaPhong(),
                        pt.getLoaiPhong(),
                        pt.getGiaPhong(),
                        pt.getTrangThai(),
                        pt.getTang(),
                        pt.getMoTa(),
                        pt.getTenNguoiDD()
                    };
                    model.addRow(row);
                }
            }
            // tìm kiếm tầng nếu chọn loại trước
            if (!cboTKTang.getSelectedItem().toString().equals("Tất cả")) {
                int tang = Integer.valueOf(cboTKTang.getSelectedItem().toString());
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + tang + "."));
            }
        } else {
            loadName();
        }
    }

    // Chọn Ảnh minh họa cho nhà trọ
    void selectImage() {
        try {
//            JFileChooser file = new JFileChooser();
//            file.setDialogTitle(""); // đặt title
            if (FileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File fileIMG = FileChooser.getSelectedFile();
                if (ShareHelper.saveLogo(fileIMG)) {
                    // Hiển thị hình lên form 
                    lblPicture.setIcon(ShareHelper.ResizeImage(String.valueOf((fileIMG.getAbsoluteFile())), pnlIMG));
                    lblPicture.setToolTipText(FileChooser.getName());
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Hãy chọn 1 tấm ảnh.", "IMGError", JOptionPane.INFORMATION_MESSAGE);
            ex.printStackTrace(); // check lỗi
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpTrangThai = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        panelPhongTro = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGiaPhong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboLoai = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        rdoTrong = new javax.swing.JRadioButton();
        rdoCoc = new javax.swing.JRadioButton();
        rdoDangThue = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        cboTang = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        pnlIMG = new javax.swing.JPanel();
        lblPicture = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        FileChooser = new javax.swing.JFileChooser();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboTKTang = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cboTKLoaiP = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPhong = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(227, 240, 252));
        setPreferredSize(new java.awt.Dimension(1150, 835));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ PHÒNG");

        panelPhongTro.setBackground(new java.awt.Color(227, 240, 252));
        panelPhongTro.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(227, 240, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Mã phòng");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 36, -1, -1));

        txtMaPhong.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtMaPhong.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(txtMaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 33, 378, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Loại phòng");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 108, -1, -1));

        txtGiaPhong.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtGiaPhong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiaPhongKeyReleased(evt);
            }
        });
        jPanel1.add(txtGiaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 180, 378, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Giá phòng");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 183, -1, -1));

        cboLoai.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel1.add(cboLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 109, 180, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Trạng thái");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 255, -1, -1));

        rdoTrong.setBackground(new java.awt.Color(227, 240, 252));
        grpTrangThai.add(rdoTrong);
        rdoTrong.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        rdoTrong.setSelected(true);
        rdoTrong.setText("Trống");
        jPanel1.add(rdoTrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 255, -1, -1));

        rdoCoc.setBackground(new java.awt.Color(227, 240, 252));
        grpTrangThai.add(rdoCoc);
        rdoCoc.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        rdoCoc.setText("Đang cọc");
        jPanel1.add(rdoCoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 255, -1, -1));

        rdoDangThue.setBackground(new java.awt.Color(227, 240, 252));
        grpTrangThai.add(rdoDangThue);
        rdoDangThue.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        rdoDangThue.setText("Đang thuê");
        jPanel1.add(rdoDangThue, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 255, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Tầng");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 328, -1, -1));

        cboTang.setEditable(true);
        cboTang.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel1.add(cboTang, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 329, 81, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Mô tả");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 400, -1, -1));

        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 400, 778, 117));

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
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 562, 160, 50));

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
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 562, 160, 50));

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
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 562, 160, 50));

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
        jPanel1.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 562, 160, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("VNĐ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 183, 54, -1));

        pnlIMG.setBackground(new java.awt.Color(255, 255, 255));
        pnlIMG.setBorder(new javax.swing.border.MatteBorder(null));

        lblPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add-button.png"))); // NOI18N
        lblPicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPictureMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlIMGLayout = new javax.swing.GroupLayout(pnlIMG);
        pnlIMG.setLayout(pnlIMGLayout);
        pnlIMGLayout.setHorizontalGroup(
            pnlIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPicture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
        );
        pnlIMGLayout.setVerticalGroup(
            pnlIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPicture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(pnlIMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 62, -1, 248));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Hình ảnh");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 22, 286, -1));

        FileChooser.setDialogTitle("Thay ảnh phòng trọ");
        jPanel1.add(FileChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(757, 320, 27, 0));

        panelPhongTro.addTab("   PHÒNG   ", jPanel1);

        jPanel2.setBackground(new java.awt.Color(227, 240, 252));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Tầng");

        cboTKTang.setEditable(true);
        cboTKTang.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cboTKTang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cboTKTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTKTangActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Loại phòng");

        cboTKLoaiP.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cboTKLoaiP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cboTKLoaiP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTKLoaiPActionPerformed(evt);
            }
        });

        tblPhong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phòng", "Loại phòng", "Giá phòng", "Trạng thái", "Tầng", "Mô tả", "Người thuê"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhong.setRowHeight(35);
        tblPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPhong);
        if (tblPhong.getColumnModel().getColumnCount() > 0) {
            tblPhong.getColumnModel().getColumn(4).setMaxWidth(60);
            tblPhong.getColumnModel().getColumn(6).setMinWidth(140);
        }

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboTKTang, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboTKLoaiP, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE))
                        .addGap(30, 30, 30))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboTKTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cboTKLoaiP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        panelPhongTro.addTab("   DANH SÁCH   ", jPanel2);

        panelPhongTro.setSelectedIndex(1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPhongTro)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelPhongTro)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        check();
        if (flag == true) {
            insert();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhongMouseClicked
        if (evt.getClickCount() == 2) {
            this.index = tblPhong.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
                panelPhongTro.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblPhongMouseClicked

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        SortListSearching();
    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void cboTKTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTKTangActionPerformed
        SortListCategories();
//        if (!txtTimKiem.equals("")) {
//            txtTimKiem.setText(txtTimKiem.getText());
//            SortListSearching();
//        }
    }//GEN-LAST:event_cboTKTangActionPerformed

    private void cboTKLoaiPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTKLoaiPActionPerformed
        SortListCategories();
//        if (!txtTimKiem.equals("")) {
//            txtTimKiem.setText(txtTimKiem.getText());
//            SortListSearching();
//        }
    }//GEN-LAST:event_cboTKLoaiPActionPerformed

    private void txtGiaPhongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaPhongKeyReleased
        if (txtGiaPhong.getText().contains(",")) {
            txtGiaPhong.setText(txtGiaPhong.getText().replaceAll(",", ""));
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (!txtGiaPhong.getText().equals("")) {
                txtGiaPhong.setText(dcf.format(Double.parseDouble(txtGiaPhong.getText())));
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (!txtGiaPhong.getText().equals("")) {
                txtGiaPhong.setText(dcf.format(Double.parseDouble(txtGiaPhong.getText())));
            }
        } else if (txtGiaPhong.getText().contains(" ")) {
            txtGiaPhong.setText(txtGiaPhong.getText().replaceAll(" ", ""));
            if (!txtGiaPhong.getText().equals("")) {
                txtGiaPhong.setText(dcf.format(Double.parseDouble(txtGiaPhong.getText())));
            }
        } else if (!txtGiaPhong.getText().replaceAll(",", "").matches("[0-9]+")) {
            DialogHelper.alert(this, "Giá phòng chỉ nhập số !");
            txtGiaPhong.setText("");
        } else {
            txtGiaPhong.setText(dcf.format(Double.parseDouble(txtGiaPhong.getText())));
        }
    }//GEN-LAST:event_txtGiaPhongKeyReleased

    private void lblPictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPictureMouseClicked
        this.selectImage();
    }//GEN-LAST:event_lblPictureMouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        SortListSearching();
    }//GEN-LAST:event_txtTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboLoai;
    private javax.swing.JComboBox<String> cboTKLoaiP;
    private javax.swing.JComboBox<String> cboTKTang;
    private javax.swing.JComboBox<String> cboTang;
    private javax.swing.ButtonGroup grpTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel lblPicture;
    private javax.swing.JTabbedPane panelPhongTro;
    private javax.swing.JPanel pnlIMG;
    private javax.swing.JRadioButton rdoCoc;
    private javax.swing.JRadioButton rdoDangThue;
    private javax.swing.JRadioButton rdoTrong;
    private javax.swing.JTable tblPhong;
    private javax.swing.JTextField txtGiaPhong;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
