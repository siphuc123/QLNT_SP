package Views;

import DAO.DichVuDAO;
import Entity.DichVu;
import Helper.DialogHelper;
import Helper.ShareHelper;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class FormQLDichVu extends javax.swing.JPanel {

    DichVuDAO dao = new DichVuDAO();
    DecimalFormat dcf = new DecimalFormat("###,###");
    DecimalFormat dcf1 = new DecimalFormat("###,### VND");
    int row = -1;
    private TableRowSorter<TableModel> rowSorter;

    public FormQLDichVu() {
        initComponents();
        init();
    }

    void init() {
        tblDichVu.getTableHeader().setFont(new Font("Calibri", 0, 22));
        load();
        tblDichVu.setShowGrid(true);
        updateStatus();
        rowSorter = new TableRowSorter<>(tblDichVu.getModel());
        tblDichVu.setRowSorter(rowSorter);
    }

    void load() {
        DefaultTableModel model = (DefaultTableModel) tblDichVu.getModel();
        model.setRowCount(0);
        try {
            List<DichVu> list = dao.selectAll();
            for (DichVu dv : list) {
                Object[] row = {
                    dv.getMaDV(),
                    dv.getTenDV(),
                    dcf1.format(dv.getGia())
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void setModel(DichVu model) {
        txtmadv.setText(model.getMaDV());
        txttendv.setText(model.getTenDV());
        txtgia.setText(dcf.format(Double.valueOf(model.getGia())));
    }

    DichVu getModel() {
        DichVu model = new DichVu();
        model.setMaDV(txtmadv.getText());
        model.setTenDV(txttendv.getText());
        model.setGia(Double.valueOf(txtgia.getText().replaceAll(",", "")));
        return model;
    }

    void edit() {
        try {
            String maDV = (String) tblDichVu.getValueAt(row, 0);
            DichVu model = dao.findById(maDV);
            if (model != null) {
                this.setModel(model);
                this.updateStatus();
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        btnAdd.setEnabled(!edit);
        btnUpdate.setEnabled(edit);
        btnDelete.setEnabled(edit);
        txtmadv.setEditable(!edit);
    }

    void insert() {
        check();
        if (flag == true) {
            DichVu model = getModel();
            try {
                dao.insert(model);
                this.load();
                DialogHelper.alert(this, "Thêm mới thành công!");
                row = 0;
                updateStatus();
            } catch (Exception e) {
                DialogHelper.alert(this, "Dịch vụ này đã có!");
            }
        }
    }

    void update() {
        if (txtmadv.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập mã dịch vụ!");
            txtmadv.grabFocus();
        } else if (txttendv.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập tên dịch vụ!");
            txttendv.grabFocus();
        } else if (txtgia.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập giá dịch vụ!");
            txtgia.grabFocus();
        } else if (!txtgia.getText().matches("[0-9,]+")) {
            DialogHelper.alert(this, "Giá chỉ được nhập số !");
            txtgia.grabFocus();
        } else {
            DichVu model = getModel();
            try {
                dao.update(model);
                this.load();
                DialogHelper.alert(this, "Cập nhật thành công!");
            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại!");
                System.out.println(e);
            }
        }
    }

    void delete() {
        if (ShareHelper.isManager() == false) {
            if (DialogHelper.confirm(this, "Bạn có thực sự muốn xóa dịch vụ này không?")) {
                String maDV = txtmadv.getText();
                try {
                    dao.delete(maDV);
                    this.load();
                    this.clear();
                    DialogHelper.alert(this, "Xóa thành công!");
                } catch (Exception e) {
                    DialogHelper.alert(this, "Xóa thất bại! Hóa đơn cần dữ liệu này!");
                    //System.out.println(e);
                }
            }
        } else {
            DialogHelper.alert(this, "Bạn không có quyền xóa dịch vụ!");
        }
    }

    void clear() {
        row = -1;
        txtmadv.setText(null);
        txttendv.setText(null);
        txtgia.setText(null);
        txtmadv.grabFocus();
        this.updateStatus();
    }

    boolean flag = false;

    void check() {
        boolean check = false;
        List<DichVu> list = dao.selectAll();
        String madv = txtmadv.getText();
        for (DichVu dv : list) {
            if (dv.getMaDV().equalsIgnoreCase(madv)) {
                check = true;
                break;
            }
        }
        if (txtmadv.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập mã dịch vụ!");
            txtmadv.grabFocus();
        } else if (check) {
            DialogHelper.alert(this, "Mã dịch vụ đã tồn tại!");
            txtmadv.grabFocus();
        } else if (txttendv.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập tên dịch vụ!");
            txttendv.grabFocus();
        } else if (txtgia.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập giá dịch vụ!");
            txtgia.grabFocus();
        } else if (!txtgia.getText().matches("[0-9,]+")) {
            DialogHelper.alert(this, "Giá chỉ được nhập số !");
            txtgia.grabFocus();
        } else {
            flag = true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelDichVu = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        txtmadv = new javax.swing.JTextField();
        txtgia = new javax.swing.JTextField();
        txttendv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();

        setBackground(new java.awt.Color(227, 240, 252));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel1.setText("QUẢN LÝ DỊCH VỤ");

        panelDichVu.setBackground(new java.awt.Color(227, 240, 252));
        panelDichVu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(227, 240, 252));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Mã dịch vụ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Tên dịch vụ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Giá");

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
        btnUpdate.setText("CẬP NHẬT");
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

        txtmadv.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtgia.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtgia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtgiaKeyReleased(evt);
            }
        });

        txttendv.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("VND");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtmadv, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txttendv, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmadv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttendv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(122, 122, 122)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        panelDichVu.addTab("  DỊCH VỤ", jPanel1);

        jPanel2.setBackground(new java.awt.Color(227, 240, 252));

        tblDichVu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDichVu.setRowHeight(35);
        tblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDichVu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        panelDichVu.addTab("   DANH SÁCH   ", jPanel2);

        panelDichVu.setSelectedIndex(1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(466, 466, 466)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panelDichVu)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelDichVu)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        if (evt.getClickCount() == 2) {
            row = tblDichVu.getSelectedRow();
            if (this.row >= 0) {
                this.edit();
                panelDichVu.setSelectedIndex(0);
            }

        }

    }//GEN-LAST:event_tblDichVuMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        insert();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtgiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgiaKeyReleased
        if (txtgia.getText().contains(",")) {
            txtgia.setText(txtgia.getText().replaceAll(",", ""));
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (!txtgia.getText().equals("")) {
                txtgia.setText(dcf.format(Double.parseDouble(txtgia.getText())));
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (!txtgia.getText().equals("")) {
                txtgia.setText(dcf.format(Double.parseDouble(txtgia.getText())));
            }
        } else if (txtgia.getText().contains(" ")) {
            txtgia.setText(txtgia.getText().replaceAll(" ", ""));
            if (!txtgia.getText().equals("")) {
                txtgia.setText(dcf.format(Double.parseDouble(txtgia.getText())));
            }
        } else if (!txtgia.getText().replaceAll(",", "").matches("[0-9]+")) {
            DialogHelper.alert(this, "Giá phòng chỉ nhập số !");
            txtgia.setText("");
        } else {
            txtgia.setText(dcf.format(Double.parseDouble(txtgia.getText())));
        }
    }//GEN-LAST:event_txtgiaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane panelDichVu;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTextField txtgia;
    private javax.swing.JTextField txtmadv;
    private javax.swing.JTextField txttendv;
    // End of variables declaration//GEN-END:variables
}
