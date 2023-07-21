package Views;

import DAO.KhachThueCungDAO;
import DAO.KhachThueDDDAO;
import Entity.KhachThueCung;
import Entity.KhachThueDD;
import Helper.DialogHelper;
import Helper.ShareHelper;
import java.awt.Font;
import java.util.Date;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class FormQLKhachThue extends javax.swing.JPanel {

    public FormQLKhachThue() {
        initComponents();
        init();
    }

    int index = 0;
    int row = -1;
    // thanh tìm kiếm
    private TableRowSorter<TableModel> rowSorter_DD;
    private TableRowSorter<TableModel> rowSorter_KTC;
    // Thêm DAO
    KhachThueDDDAO daoDD = new KhachThueDDDAO();
    KhachThueCungDAO daoTC = new KhachThueCungDAO();

    void init() {
        tblKhachThue.getTableHeader().setFont(new Font("Calibri", 0, 18));
        tblKhachThueCung.getTableHeader().setFont(new Font("Calibri", 0, 18));
        tblKhachThue.getColumnModel().getColumn(3).setMaxWidth(100);
        tabs.setSelectedIndex(2);
        // lấy chỉ định text field để tìm kiếm
        rowSorter_DD = new TableRowSorter<>(tblKhachThue.getModel());
        tblKhachThue.setRowSorter(rowSorter_DD);
        //----//
        rowSorter_KTC = new TableRowSorter<>(tblKhachThueCung.getModel());
        tblKhachThueCung.setRowSorter(rowSorter_KTC);
        // load dữ liệu
        loadKTDD();
        loadKTC();
        tblKhachThue.setShowGrid(true);
        tblKhachThueCung.setShowGrid(true);
    }

    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean verifyEmail(String email) {
        if (email == null) {
            return false;
        }
        return email.matches(EMAIL_PATTERN);
    }

    boolean flag = false;
    boolean flag1 = false;

    void check_DD() {
        boolean check = false;
        List<KhachThueDD> list = daoDD.selectAll();
        String makt = txtMaKT.getText();
        for (KhachThueDD kt : list) {
            if (kt.getMaKTDD().equalsIgnoreCase(makt)) {
                check = true;
                break;
            }
        }

        if ((txtMaKT.getText()).equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập mã người thuê đại diện!");
            txtMaKT.grabFocus();
        } else if (check) {
            DialogHelper.alert(this, "Mã người thuê đã tồn tại!");
            txtMaKT.grabFocus();
        } else if ((txtHoTen_DD.getText()).equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập họ tên người thuê!");
            txtHoTen_DD.grabFocus();
        } else if (!txtHoTen_DD.getText().matches("^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$")) {
            DialogHelper.alert(this, "Họ tên không đúng định dạng!");
            txtHoTen_DD.grabFocus();
        } else if (txtSDT.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập số điện thoại!");
            txtSDT.grabFocus();
        } else if (txtSDT.getText().length() < 10 || txtSDT.getText().length() > 10) {
            DialogHelper.alert(this, "Số điện thoại phải nhập đủ 10 số.");
            txtSDT.grabFocus();
        } else if (!txtSDT.getText().matches("[0-9]+")) {
            DialogHelper.alert(this, "Số điện thoại chỉ nhập số !");
            txtSDT.grabFocus();
        } else if (txtEmail.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập Email!");
            txtEmail.grabFocus();
        } else if (verifyEmail(txtEmail.getText()) == false) {
            DialogHelper.alert(this, "Định dạng email bạn nhập không chính xác");
            txtEmail.grabFocus();
        } else if (dchNgaySinh.getModel().getDate() == null) {
            DialogHelper.alert(this, "Ngày được chọn có vẻ không ổn !");
        } else {
            // do hiện tại bản mới người ta đã bỏ dạng code này nên sẽ bị trừ 1900 năm ra
            int ngaySinh = dchNgaySinh.getModel().getDate().getYear() + 1900;
            int namHienTai = java.time.LocalDate.now().getYear();
            int tinhTuoi = (namHienTai - ngaySinh);
//            System.out.println(ngaySinh + "," + namHienTai + "," + tinhTuoi);
            if (tinhTuoi < 18) {
                DialogHelper.alert(this, "Người này chưa đủ tuổi để thuê !");
                dchNgaySinh.grabFocus();
            } else {
                flag = true;
            }
        }
    }

    void check_KTC() {
        boolean check = false;
        List<KhachThueCung> list = daoTC.selectAll();
        String maktc = txtMaKTC.getText();
        for (KhachThueCung ktc : list) {
            if (ktc.getMaKTC().equalsIgnoreCase(maktc)) {
                check = true;
                break;
            }
        }

        boolean check2 = false;
        List<KhachThueDD> list2 = daoDD.selectAll();
        String makt = txtMaKTDD_KTC.getText();
        for (KhachThueDD kt : list2) {
            if (kt.getMaKTDD().equals(makt)) {
                check2 = true;
                break;
            }
        }

        if ((txtMaKTC.getText()).equals("")) {
            DialogHelper.alert(this, "Mã người thuê cùng không được để trống !");
            txtMaKTC.grabFocus();
        } else if (check) {
            DialogHelper.alert(this, "Mã người thuê này đã tồn tại!");
            txtMaKTC.grabFocus();
        } else if (txtMaKTDD_KTC.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập mã người thuê đại diện!");
            txtMaKTDD_KTC.grabFocus();
        } else if (check2 == false) {
            DialogHelper.alert(this, "Không có mã người thuê đại diện này!");
            txtMaKTDD_KTC.grabFocus();
        } else if ((txtHoTenKTC.getText()).equals("")) {
            DialogHelper.alert(this, "Họ tên không được để trống!");
            txtHoTenKTC.grabFocus();
        } else if (!txtHoTenKTC.getText().matches("^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$")) {
            DialogHelper.alert(this, "Họ tên không đúng định dạng!");
            txtHoTenKTC.grabFocus();
        } else if (txtSDT_KTC.getText().equals("")) {
            DialogHelper.alert(this, "Số điện thoại không được để trống!");
            txtSDT_KTC.grabFocus();
        } else if (txtSDT_KTC.getText().length() < 10 || txtSDT.getText().length() > 10) {
            DialogHelper.alert(this, "Số điện thoại phải nhập đủ 10 số!");
            txtSDT_KTC.grabFocus();
        } else if (!txtSDT_KTC.getText().matches("[0-9]+")) {
            DialogHelper.alert(this, "Số điện thoại chỉ nhập số !");
            txtSDT_KTC.grabFocus();
        } else {
            flag1 = true;
        }
    }

    void loadKTDD() {
        DefaultTableModel model = (DefaultTableModel) tblKhachThue.getModel();
        model.setRowCount(0);
        try {
            // người đại diện
            List<KhachThueDD> list = daoDD.selectAll();
            for (KhachThueDD kt : list) {
                Object[] row = {
                    kt.getMaKTDD(),
                    kt.getHoTen(),
                    kt.getNgaySinh(),
                    kt.isGioiTinh() == true ? "Nam" : "Nữ",
                    kt.getSoDT(),
                    kt.getEmail()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void loadKTC() {
        DefaultTableModel model = (DefaultTableModel) tblKhachThueCung.getModel();
        model.setRowCount(0);
        try {
            // người thuê cùng
            List<KhachThueCung> list = daoTC.selectAllWithDD();
            for (KhachThueCung kt : list) {
                Object[] row = {
                    kt.getMaKTC(),
                    kt.getHoTen(),
                    kt.isGioiTinh() == true ? "Nam" : "Nữ",
                    kt.getSoDT(),
                    kt.getHoTen_DD()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void insert_DD() {
        KhachThueDD model = getModel_DD();
        try {
            daoDD.insert(model);
            this.loadKTDD();
            //this.clear_DD();
            DialogHelper.alert(this, "Thêm mới thành công!");
            row = 0;
            setStatus();
        } catch (Exception e) {
            DialogHelper.alert(this, "Chuyên đề này đã có!");
        }

    }

    void insert_KTC() {
        boolean check2 = false;
        List<KhachThueDD> list2 = daoDD.selectAll();
        String makt = txtMaKTDD_KTC.getText();
        for (KhachThueDD kt : list2) {
            if (kt.getMaKTDD().equals(makt)) {
                check2 = true;
                break;
            }
        }

        if ((txtMaKTC.getText()).equals("")) {
            DialogHelper.alert(this, "Mã người thuê cùng không được để trống !");
            txtMaKTC.grabFocus();
        } else if (txtMaKTDD_KTC.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập mã người thuê đại diện!");
            txtMaKTDD_KTC.grabFocus();
        } else if (check2 == false) {
            DialogHelper.alert(this, "Không có mã người thuê đại diện này!");
            txtMaKTDD_KTC.grabFocus();
        } else if ((txtHoTenKTC.getText()).equals("")) {
            DialogHelper.alert(this, "Họ tên không được để trống!");
            txtHoTenKTC.grabFocus();
        } else if (!txtHoTenKTC.getText().matches("^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$")) {
            DialogHelper.alert(this, "Họ tên không đúng định dạng!");
            txtHoTenKTC.grabFocus();
        } else if (txtSDT_KTC.getText().equals("")) {
            DialogHelper.alert(this, "Số điện thoại không được để trống!");
            txtSDT_KTC.grabFocus();
        } else if (txtSDT_KTC.getText().length() < 10 || txtSDT.getText().length() > 10) {
            DialogHelper.alert(this, "Số điện thoại phải nhập đủ 10 số!");
            txtSDT_KTC.grabFocus();
        } else if (!txtSDT_KTC.getText().matches("[0-9]+")) {
            DialogHelper.alert(this, "Số điện thoại chỉ nhập số !");
            txtSDT_KTC.grabFocus();
        } else {
            KhachThueCung model = getModel_KTC();
            try {
                daoTC.insert(model);
                this.loadKTC();
                //this.clear_KTC();
                DialogHelper.alert(this, "Thêm mới thành công!");
                row = 0;
                setStatus();
            } catch (Exception e) {
                DialogHelper.alert(this, "Chuyên đề này đã có!");
                e.printStackTrace();
            }
        }

    }

    void update_DD() {
        if ((txtMaKT.getText()).equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập mã người thuê đại diện!");
            txtMaKT.grabFocus();
        } else if ((txtHoTen_DD.getText()).equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập họ tên người thuê!");
            txtHoTen_DD.grabFocus();
        } else if (!txtHoTen_DD.getText().matches("^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$")) {
            DialogHelper.alert(this, "Họ tên không đúng định dạng!");
            txtHoTen_DD.grabFocus();
        } else if (txtSDT.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập số điện thoại!");
            txtSDT.grabFocus();
        } else if (txtSDT.getText().length() < 10 || txtSDT.getText().length() > 10) {
            DialogHelper.alert(this, "Số điện thoại phải nhập đủ 10 số.");
            txtSDT.grabFocus();
        } else if (!txtSDT.getText().matches("[0-9]+")) {
            DialogHelper.alert(this, "Số điện thoại chỉ nhập số !");
            txtSDT.grabFocus();
        } else if (txtEmail.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập Email!");
            txtEmail.grabFocus();
        } else if (verifyEmail(txtEmail.getText()) == false) {
            DialogHelper.alert(this, "Định dạng email bạn nhập không chính xác");
            txtEmail.grabFocus();
        } else if (dchNgaySinh.getModel().getDate() == null) {
            DialogHelper.alert(this, "Ngày được chọn có vẻ không ổn !");
        } else {
            // do hiện tại bản mới người ta đã bỏ dạng code này nên sẽ bị trừ 1900 năm ra
            int ngaySinh = dchNgaySinh.getModel().getDate().getYear() + 1900;
            int namHienTai = java.time.LocalDate.now().getYear();
            int tinhTuoi = (namHienTai - ngaySinh);
//            System.out.println(ngaySinh + "," + namHienTai + "," + tinhTuoi);
            if (tinhTuoi < 18) {
                DialogHelper.alert(this, "Người này chưa đủ tuổi để thuê !");
                dchNgaySinh.grabFocus();
            } else {
                KhachThueDD model = getModel_DD();
                try {
                    daoDD.update(model);
                    this.loadKTDD();
                    DialogHelper.alert(this, "Cập nhật thành công!");
                } catch (Exception e) {
                    DialogHelper.alert(this, "Cập nhật thất bại!");
                    e.printStackTrace();
                }
            }
        }

    }

    void update_KTC() {
        KhachThueCung model = getModel_KTC();
        try {
            daoTC.update(model);
            this.loadKTC();
            DialogHelper.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Cập nhật thất bại!");
            System.out.println(e);
        }
    }

    void delete_DD() {
        if (ShareHelper.isManager() == false) {
            if (DialogHelper.confirm(this, "Bạn có thực sự muốn xóa người đại diện này chứ?")) {
                String maKTDD = txtMaKT.getText();
                try {
                    daoDD.delete(maKTDD);
                    this.loadKTDD();
                    this.clear_DD();
                    DialogHelper.alert(this, "Xóa thành công!");
                } catch (Exception e) {
                    DialogHelper.alert(this, "Xóa thất bại!");
                    System.out.println(e);
                }
            }
        } else {
            DialogHelper.alert(this, "Bạn không có quyền xóa khách thuê!");
        }
    }

    void delete_KTC() {
        if (ShareHelper.isManager() == false) {
            if (DialogHelper.confirm(this, "Bạn có thực sự muốn xóa người thuê cùng này không?")) {
                String maKTC = txtMaKTC.getText();
                try {
                    daoTC.delete(maKTC);
                    this.loadKTC();
                    this.clear_KTC();
                    DialogHelper.alert(this, "Xóa thành công!");
                } catch (Exception e) {
                    DialogHelper.alert(this, "Xóa thất bại!");
                    System.out.println(e);
                }
            }
        } else {
            DialogHelper.alert(this, "Bạn không có quyền xóa khách thuê!");
        }
    }

    void clear_DD() {
        // Khách thuê DD
        row = -1;
        txtMaKT.setText(null);
        txtHoTen_DD.setText("");
        dchNgaySinh.setDate(new Date());
        rdoNam.setSelected(true);
        txtSDT.setText("");
        txtEmail.setText("");
        txtMaKT.grabFocus();
        this.setStatus();
    }

    void clear_KTC() {
        // Khách thuê cùng
        row = -1;
        txtMaKTC.setText(null);
        txtMaKTDD_KTC.setText("");
        txtHoTenKTC.setText(null);
        rdoMale.setSelected(true);
        txtSDT_KTC.setText("");
        lblNameDD.setText("");
        txtMaKTC.grabFocus();
        this.setStatus();
    }

    void edit_DD() {
        try {
            String maKT = (String) tblKhachThue.getValueAt(this.index, 0);
            KhachThueDD model = daoDD.findById(maKT);
            if (model != null) {
                this.setModel_DD(model);
                this.setStatus();
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void edit_KTC() {
        try {
            String maKTC = (String) tblKhachThueCung.getValueAt(this.index, 0);
            KhachThueCung model = daoTC.selectByMaKTC(maKTC);
            if (model != null) {
                this.setModel_KTC(model);
                this.setStatus();
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }

    void setModel_DD(KhachThueDD model) {
        txtMaKT.setText(model.getMaKTDD());
        txtHoTen_DD.setText(model.getHoTen());
        dchNgaySinh.setDate(model.getNgaySinh());
        if (model.isGioiTinh()) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtSDT.setText(model.getSoDT());
        txtEmail.setText(model.getEmail());
    }

    void setModel_KTC(KhachThueCung model) {
        txtMaKTC.setText(model.getMaKTC());
        txtMaKTDD_KTC.setText(model.getMaKTDD());
        txtHoTenKTC.setText(model.getHoTen());
        if (model.isGioiTinh()) {
            rdoMale.setSelected(true);
        } else {
            rdoFemale.setSelected(true);
        }
        txtSDT_KTC.setText(model.getSoDT());
        lblNameDD.setText("( " + model.getHoTen_DD() + " )");
    }

    KhachThueDD getModel_DD() {
        KhachThueDD model = new KhachThueDD();
        model.setMaKTDD(txtMaKT.getText());
        model.setHoTen(txtHoTen_DD.getText());
        model.setNgaySinh(dchNgaySinh.getDate());
        model.setGioiTinh(rdoNam.isSelected());
        model.setSoDT(txtSDT.getText());
        model.setEmail(txtEmail.getText());
        return model;
    }

    KhachThueCung getModel_KTC() {
        KhachThueCung model = new KhachThueCung();
        model.setMaKTC(txtMaKTC.getText());
        model.setMaKTDD(txtMaKTDD_KTC.getText());
        model.setHoTen(txtHoTenKTC.getText());
        model.setGioiTinh(rdoMale.isSelected());
        model.setSoDT(txtSDT_KTC.getText());
        return model;
    }

    void setStatus() {
        boolean edit = (this.row >= 0);
        // Trạng thái form
        btnAdd.setEnabled(!edit);
        btnAdd_KTC.setEnabled(!edit);
        txtMaKT.setEditable(!edit);
        txtMaKTC.setEditable(!edit);
        btnUpdate.setEnabled(edit);
        btnUpdate_KTC.setEnabled(edit);
        btnDelete.setEnabled(edit);
        btnDelete_KTC.setEnabled(edit);
    }

    // Tự động tìm kiếm chữ giống có trong list ( thông qua text field )
    void SortListSearching_DD() {
        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtTimKiem.getText().trim();

                if (text.trim().length() == 0) {
                    rowSorter_DD.setRowFilter(null);
                } else {
                    rowSorter_DD.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtTimKiem.getText();

                if (text.trim().length() == 0) {
                    rowSorter_DD.setRowFilter(null);
                } else {
                    rowSorter_DD.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Không hỗ trợ điều này !.");
            }
        });
    }

    // dành cho Khách thuê cùng
    void SortListSearching_KTC() {
        txtTimKiemktc.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtTimKiemktc.getText().trim();

                if (text.trim().length() == 0) {
                    rowSorter_KTC.setRowFilter(null);
                } else {
                    rowSorter_KTC.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtTimKiemktc.getText();

                if (text.trim().length() == 0) {
                    rowSorter_KTC.setRowFilter(null);
                } else {
                    rowSorter_KTC.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Không hỗ trợ điều này !.");
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpGT_KT = new javax.swing.ButtonGroup();
        grpGT_KTC = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        pnlKT = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaKT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        txtHoTen_DD = new javax.swing.JTextField();
        dchNgaySinh = new com.toedter.calendar.JDateChooser();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        pnlKTC = new javax.swing.JPanel();
        txtHoTenKTC = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnAdd_KTC = new javax.swing.JButton();
        btnDelete_KTC = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnUpdate_KTC = new javax.swing.JButton();
        txtMaKTC = new javax.swing.JTextField();
        btnClear_KTC = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtMaKTDD_KTC = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtSDT_KTC = new javax.swing.JTextField();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        lblNameDD = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachThue = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKhachThueCung = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        txtTimKiemktc = new javax.swing.JTextField();

        setBackground(new java.awt.Color(227, 240, 252));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ KHÁCH THUÊ");

        tabs.setBackground(new java.awt.Color(227, 240, 252));
        tabs.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        pnlKT.setBackground(new java.awt.Color(227, 240, 252));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Mã khách thuê");

        txtMaKT.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Họ và tên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Ngày sinh");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Giới tính");

        rdoNam.setBackground(new java.awt.Color(227, 240, 252));
        grpGT_KT.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        rdoNu.setBackground(new java.awt.Color(227, 240, 252));
        grpGT_KT.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        rdoNu.setText("Nữ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Số điện thoại");

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

        txtHoTen_DD.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        dchNgaySinh.setBackground(new java.awt.Color(227, 240, 252));
        dchNgaySinh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout pnlKTLayout = new javax.swing.GroupLayout(pnlKT);
        pnlKT.setLayout(pnlKTLayout);
        pnlKTLayout.setHorizontalGroup(
            pnlKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKTLayout.createSequentialGroup()
                .addGroup(pnlKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlKTLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(pnlKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(30, 30, 30)
                        .addGroup(pnlKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlKTLayout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(30, 30, 30)
                                .addComponent(rdoNu))
                            .addComponent(txtHoTen_DD, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dchNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKT, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlKTLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        pnlKTLayout.setVerticalGroup(
            pnlKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKTLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(pnlKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoTen_DD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(dchNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(40, 40, 40)
                .addGroup(pnlKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(pnlKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        tabs.addTab("  KHÁCH THUÊ  ", pnlKT);

        pnlKTC.setBackground(new java.awt.Color(227, 240, 252));

        txtHoTenKTC.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setText("Số điện thoại");

        btnAdd_KTC.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd_KTC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd_KTC.setForeground(new java.awt.Color(0, 204, 204));
        btnAdd_KTC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus.png"))); // NOI18N
        btnAdd_KTC.setText("  THÊM");
        btnAdd_KTC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd_KTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd_KTCActionPerformed(evt);
            }
        });

        btnDelete_KTC.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete_KTC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete_KTC.setForeground(new java.awt.Color(0, 204, 204));
        btnDelete_KTC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete.png"))); // NOI18N
        btnDelete_KTC.setText("  XÓA");
        btnDelete_KTC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete_KTC.setOpaque(false);
        btnDelete_KTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete_KTCActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setText("Mã khách thuê cùng");

        btnUpdate_KTC.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate_KTC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate_KTC.setForeground(new java.awt.Color(0, 204, 204));
        btnUpdate_KTC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        btnUpdate_KTC.setText("CẬP NHẬT");
        btnUpdate_KTC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate_KTC.setOpaque(false);
        btnUpdate_KTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate_KTCActionPerformed(evt);
            }
        });

        txtMaKTC.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnClear_KTC.setBackground(new java.awt.Color(255, 255, 255));
        btnClear_KTC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClear_KTC.setForeground(new java.awt.Color(0, 204, 204));
        btnClear_KTC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/refresh.png"))); // NOI18N
        btnClear_KTC.setText("  MỚI");
        btnClear_KTC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear_KTC.setOpaque(false);
        btnClear_KTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear_KTCActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setText("Mã khách thuê đại diện");

        txtMaKTDD_KTC.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setText("Họ và tên người thuê cùng");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setText("Giới tính");

        txtSDT_KTC.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        rdoMale.setBackground(new java.awt.Color(227, 240, 252));
        grpGT_KTC.add(rdoMale);
        rdoMale.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        rdoMale.setText("Nam");

        rdoFemale.setBackground(new java.awt.Color(227, 240, 252));
        grpGT_KTC.add(rdoFemale);
        rdoFemale.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        rdoFemale.setText("Nữ");

        lblNameDD.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout pnlKTCLayout = new javax.swing.GroupLayout(pnlKTC);
        pnlKTC.setLayout(pnlKTCLayout);
        pnlKTCLayout.setHorizontalGroup(
            pnlKTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKTCLayout.createSequentialGroup()
                .addGroup(pnlKTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlKTCLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(pnlKTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(30, 30, 30)
                        .addGroup(pnlKTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlKTCLayout.createSequentialGroup()
                                .addComponent(rdoMale)
                                .addGap(30, 30, 30)
                                .addComponent(rdoFemale))
                            .addComponent(txtSDT_KTC, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTenKTC, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlKTCLayout.createSequentialGroup()
                                .addGroup(pnlKTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMaKTDD_KTC, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaKTC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNameDD))))
                    .addGroup(pnlKTCLayout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(btnClear_KTC, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd_KTC, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate_KTC, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete_KTC, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        pnlKTCLayout.setVerticalGroup(
            pnlKTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKTCLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(pnlKTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtMaKTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlKTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtMaKTDD_KTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNameDD))
                .addGap(40, 40, 40)
                .addGroup(pnlKTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtHoTenKTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(pnlKTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(rdoMale)
                    .addComponent(rdoFemale))
                .addGap(40, 40, 40)
                .addGroup(pnlKTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtSDT_KTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addGroup(pnlKTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd_KTC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete_KTC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate_KTC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear_KTC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        tabs.addTab("  KHÁCH THUÊ CÙNG  ", pnlKTC);

        jPanel3.setBackground(new java.awt.Color(227, 240, 252));

        tblKhachThue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblKhachThue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách thuê", "Họ và tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachThue.setRowHeight(35);
        tblKhachThue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachThueMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhachThue);
        if (tblKhachThue.getColumnModel().getColumnCount() > 0) {
            tblKhachThue.getColumnModel().getColumn(2).setHeaderValue("Ngày sinh");
            tblKhachThue.getColumnModel().getColumn(5).setHeaderValue("Email");
        }

        jPanel4.setBackground(new java.awt.Color(227, 240, 252));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 24))); // NOI18N

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        tabs.addTab("  DANH SÁCH  ", jPanel3);

        jPanel5.setBackground(new java.awt.Color(227, 240, 252));

        tblKhachThueCung.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblKhachThueCung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã khách thuê cùng", "Họ và tên", "Giới tính", "Số điện thoại", "Người thuê đại diện"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachThueCung.setRowHeight(35);
        tblKhachThueCung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachThueCungMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblKhachThueCung);

        jPanel6.setBackground(new java.awt.Color(227, 240, 252));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 24))); // NOI18N

        txtTimKiemktc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTimKiemktc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemktcActionPerformed(evt);
            }
        });
        txtTimKiemktc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemktcKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiemktc)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiemktc, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        tabs.addTab("  DANH SÁCH THUÊ CÙNG", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tabs)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhachThueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachThueMouseClicked
        if (evt.getClickCount() == 2) {
            row = tblKhachThue.getSelectedRow();
            this.index = tblKhachThue.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit_DD();
                tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblKhachThueMouseClicked

    private void tblKhachThueCungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachThueCungMouseClicked
        if (evt.getClickCount() == 2) {
            row = tblKhachThueCung.getSelectedRow();
            this.index = tblKhachThueCung.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit_KTC();
                tabs.setSelectedIndex(1);
            }
        }
    }//GEN-LAST:event_tblKhachThueCungMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear_DD();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnClear_KTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear_KTCActionPerformed
        clear_KTC();
    }//GEN-LAST:event_btnClear_KTCActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        check_DD();
        if (flag == true) {
            insert_DD();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update_DD();

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete_DD();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAdd_KTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd_KTCActionPerformed
        check_KTC();
        if (flag1 == true) {
            insert_KTC();
        }
    }//GEN-LAST:event_btnAdd_KTCActionPerformed

    private void btnUpdate_KTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate_KTCActionPerformed
        update_KTC();
    }//GEN-LAST:event_btnUpdate_KTCActionPerformed

    private void btnDelete_KTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete_KTCActionPerformed
        delete_KTC();
    }//GEN-LAST:event_btnDelete_KTCActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        SortListSearching_DD();
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemktcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemktcActionPerformed
        SortListSearching_KTC();
    }//GEN-LAST:event_txtTimKiemktcActionPerformed

    private void txtTimKiemktcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemktcKeyTyped
        SortListSearching_KTC();
    }//GEN-LAST:event_txtTimKiemktcKeyTyped

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        SortListSearching_DD();
    }//GEN-LAST:event_txtTimKiemKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd_KTC;
    private javax.swing.JButton btnClear_KTC;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete_KTC;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate_KTC;
    private com.toedter.calendar.JDateChooser dchNgaySinh;
    private javax.swing.ButtonGroup grpGT_KT;
    private javax.swing.ButtonGroup grpGT_KTC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNameDD;
    private javax.swing.JPanel pnlKT;
    private javax.swing.JPanel pnlKTC;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblKhachThue;
    private javax.swing.JTable tblKhachThueCung;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTenKTC;
    private javax.swing.JTextField txtHoTen_DD;
    private javax.swing.JTextField txtMaKT;
    private javax.swing.JTextField txtMaKTC;
    private javax.swing.JTextField txtMaKTDD_KTC;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSDT_KTC;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemktc;
    // End of variables declaration//GEN-END:variables
}
