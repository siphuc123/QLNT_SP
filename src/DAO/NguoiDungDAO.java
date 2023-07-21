package DAO;

import Entity.NguoiDung;
import Helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {

    public void insert(NguoiDung model) {
        String sql = "INSERT INTO NguoiDung (MaNguoiDung, HoTen, VaiTro, MatKhau, Email) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaNguoiDung(), model.getHoTen(), model.isVaiTro(), model.getMatKhau(), model.getEmail());
    }

    public void update(NguoiDung model) {
        String sql = "UPDATE NguoiDung SET MatKhau=?, HoTen=?, VaiTro=?, Email = ? WHERE MaNguoiDung=?";
        JdbcHelper.executeUpdate(sql, model.getMatKhau(), model.getHoTen(), model.isVaiTro(), model.getEmail(), model.getMaNguoiDung());

    }

    public void updateMK(String maND, String MK) {
        String sql = "UPDATE NguoiDung SET MatKhau = ? WHERE MaNguoiDung=?";
        JdbcHelper.executeUpdate(sql, MK, maND);

    }

    public void delete(String MaNV) {
        String sql = "DELETE FROM NguoiDung WHERE MaNguoiDung=?";
        JdbcHelper.executeUpdate(sql, MaNV);
    }

    public List<NguoiDung> selectAll() {
        String sql = "SELECT * FROM NguoiDung";
        return select(sql);
    }

    public NguoiDung findById(String mand) {
        String sql = "SELECT * FROM NguoiDung WHERE MaNguoiDung=?";
        List<NguoiDung> list = select(sql, mand);
        return list.size() > 0 ? list.get(0) : null;
    }

    public NguoiDung findByEmail(String email) {
        String sql = "SELECT * FROM NguoiDung WHERE email=?";
        List<NguoiDung> list = select(sql, email);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<NguoiDung> findByEmailandID(String keyword) {
        String sql = "SELECT * FROM NguoiDung WHERE Email LIKE ? or MaNguoiDung LIKE ?";
        return this.select(sql, "%" + keyword + "%", "%" + keyword + "%");
    }

    private List<NguoiDung> select(String sql, Object... args) {
        List<NguoiDung> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NguoiDung model = readFromResultSet(rs);
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

    private NguoiDung readFromResultSet(ResultSet rs) throws SQLException {
        NguoiDung model = new NguoiDung();
        model.setMaNguoiDung(rs.getString("MaNguoiDung"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setHoTen(rs.getString("HoTen"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        model.setEmail(rs.getString("Email"));
        return model;
    }

}
