package DAO;

import Entity.PhongTro;
import Entity.PhongTroCoTen;
import Helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongTroDAO {

    public void insert(PhongTro model) {
        String sql = "INSERT INTO PhongTro (MaPhong, LoaiPhong, GiaPhong, TrangThai, Tang, MoTa, Hinh) VALUES (?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaPhong(), model.getLoaiPhong(), model.getGiaPhong(), model.getTrangThai(), model.getTang(), model.getMoTa(), model.getHinhAnh());
    }

    public void update(PhongTro model) {
        String sql = "UPDATE PhongTro SET LoaiPhong=?, GiaPhong=?, TrangThai=?, Tang=?, MoTa=?, Hinh=? WHERE MaPhong=?";
        JdbcHelper.executeUpdate(sql, model.getLoaiPhong(), model.getGiaPhong(), model.getTrangThai(), model.getTang(), model.getMoTa(), model.getHinhAnh(), model.getMaPhong());

    }
    public void updateTrangThai(String tt, String mp) {
        String sql = "UPDATE PhongTro SET TrangThai = ? WHERE MaPhong = ?";
        JdbcHelper.executeUpdate(sql, tt, mp);

    }

    public void delete(String MaP) {
        String sql = "DELETE FROM PhongTro WHERE MaPhong=?";
        JdbcHelper.executeUpdate(sql, MaP);
    }

    public List<PhongTro> selectAll() {
        String sql = "SELECT * FROM PhongTro";
        return select(sql);
    } 
    public List<PhongTro> selectPhongDangThue() {
        String sql = "SELECT * FROM PhongTro WHERE TrangThai LIKE N'Đang thuê'";
        return select(sql);
    }

    public PhongTro selectByMaPhong(String maphong) {
        String sql = "SELECT * FROM PhongTro WHERE MaPhong LIKE ?";
        List<PhongTro> list = select(sql, maphong);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<PhongTroCoTen> selectWithName() {
        String sql = "SELECT PhongTro.MaPhong\n"
                + "      ,LoaiPhong\n"
                + "      ,GiaPhong\n"
                + "      ,TrangThai\n"
                + "      ,Tang\n"
                + "      ,MoTa,ktd.HoTen\n"
                + " FROM PhongTro\n"
                + " LEFT JOIN HopDong hd ON PhongTro.MaPhong = hd.MaPhong\n"
                + " LEFT JOIN KhachThueDD ktd ON hd.MaKTDD = ktd.MaKTDD";
        return selectCoTen(sql);
    }

    private List<PhongTroCoTen> selectCoTen(String sql, Object... args) {
        List<PhongTroCoTen> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhongTroCoTen model = readFromResultSetForName(rs);
                    list.add(model);
                }
                rs.close();
            } finally {
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private List<PhongTro> select(String sql, Object... args) {
        List<PhongTro> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhongTro model = readFromResultSet(rs);
                    list.add(model);
                }
                rs.close();
            } finally {
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private PhongTro readFromResultSet(ResultSet rs) throws SQLException {
        PhongTro model = new PhongTro();
        model.setMaPhong(rs.getString("MaPhong"));
        model.setLoaiPhong(rs.getString("LoaiPhong"));
        model.setGiaPhong(rs.getDouble("GiaPhong"));
        model.setTrangThai(rs.getString("TrangThai"));
        model.setTang(rs.getInt("Tang"));
        model.setMoTa(rs.getString("MoTa"));
        model.setHinhAnh(rs.getString("Hinh"));
        return model;
    }

    private PhongTroCoTen readFromResultSetForName(ResultSet rs) throws SQLException {
        PhongTroCoTen model = new PhongTroCoTen();
        model.setMaPhong(rs.getString("MaPhong"));
        model.setLoaiPhong(rs.getString("LoaiPhong"));
        model.setGiaPhong(rs.getDouble("GiaPhong"));
        model.setTrangThai(rs.getString("TrangThai"));
        model.setTang(rs.getInt("Tang"));
        model.setMoTa(rs.getString("MoTa"));
        model.setTenNguoiDD(rs.getString("HoTen") == null ? "Chưa có ai thuê" : rs.getString("HoTen"));
        return model;
    }
}
