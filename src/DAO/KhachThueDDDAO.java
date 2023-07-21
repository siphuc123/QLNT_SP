package DAO;

import Entity.KhachThueDD;
import Helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhachThueDDDAO {
    public void insert(KhachThueDD model) {
        String sql = "INSERT INTO KhachThueDD VALUES (?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaKTDD(), model.getHoTen(), model.getNgaySinh(), model.isGioiTinh(), model.getSoDT(), model.getEmail());
    }

    public void update(KhachThueDD model) {
        String sql = "UPDATE KhachThueDD SET HoTen = ?, NgaySinh = ?, GioiTinh = ?, SoDT = ?, Email = ? WHERE MaKTDD = ?";
        JdbcHelper.executeUpdate(sql, model.getHoTen(), model.getNgaySinh(), model.isGioiTinh(), model.getSoDT(), model.getEmail(), model.getMaKTDD());

    }

    public void delete(String MaKT) {
        String sql = "DELETE FROM KhachThueDD WHERE MaKTDD LIKE ?";
        JdbcHelper.executeUpdate(sql, MaKT);
    }

    public List<KhachThueDD> selectAll() {
        String sql = "SELECT * FROM KhachThueDD";
        return select(sql);
    }

    public KhachThueDD findById(String makt) {
        String sql = "SELECT * FROM KhachThueDD WHERE MaKTDD LIKE ?";
        List<KhachThueDD> list = select(sql,"%" + makt + "%");
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<KhachThueDD> select(String sql, Object... args) {
        List<KhachThueDD> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    KhachThueDD model = readFromResultSet(rs);
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

    private KhachThueDD readFromResultSet(ResultSet rs) throws SQLException {
        KhachThueDD model = new KhachThueDD();
        model.setMaKTDD(rs.getString("MaKTDD"));
        model.setHoTen(rs.getString("HoTen"));
        model.setNgaySinh(rs.getDate("NgaySinh"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setSoDT(rs.getString("SoDT"));
        model.setEmail(rs.getString("Email"));
        return model;
    }
}
