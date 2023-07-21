package DAO;

import Entity.DichVu;
import Helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DichVuDAO {

    public void insert(DichVu model) {
        String sql = "INSERT INTO DichVu (MaDV, TenDV, Gia) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaDV(), model.getTenDV(), model.getGia());
    }

    public void update(DichVu model) {
        String sql = "UPDATE DichVu SET TenDV=?, Gia=? WHERE MaDV=?";
        JdbcHelper.executeUpdate(sql, model.getTenDV(), model.getGia(), model.getMaDV());

    }

    public void delete(String MaNV) {
        String sql = "DELETE FROM DichVu WHERE MaDV=?";
        JdbcHelper.executeUpdate(sql, MaNV);
    }

    public List<DichVu> selectAll() {
        String sql = "SELECT * FROM DichVu";
        return select(sql);
    }

    public DichVu findById(String madv) {
        String sql = "SELECT * FROM DichVu WHERE MaDV = ?";
        List<DichVu> list = select(sql, madv);
        return list.size() > 0 ? list.get(0) : null;
    }
    public DichVu selectByTenDV(String Tendv) {
        String sql = "SELECT * FROM DichVu WHERE TenDV LIKE ?";
        List<DichVu> list = select(sql, Tendv);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<DichVu> select(String sql, Object... args) {
        List<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    DichVu model = readFromResultSet(rs);
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

    private DichVu readFromResultSet(ResultSet rs) throws SQLException {
        DichVu model = new DichVu();
        model.setMaDV(rs.getString("MaDV"));
        model.setTenDV(rs.getString("TenDV"));
        model.setGia(rs.getDouble("Gia"));
        return model;
    }
}
