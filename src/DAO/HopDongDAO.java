package DAO;

import Entity.HopDong;
import Helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HopDongDAO {
     public void insert(HopDong model) {
        String sql = "INSERT INTO HopDong (NgayLap, NgayThue, TienCoc, MaPhong, MaKTDD, MaNguoiDung) VALUES ( ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getNgayLap(), model.getNgayThue(), model.getTienCoc(), model.getMaPhong(), model.getMaKTDD(), model.getMaNguoiDung());
    }

    public void update(HopDong model) {
        String sql = "UPDATE HopDong SET NgayLap=?, NgayThue=?, TienCoc = ?, MaPhong=?, MaKTDD=?, MaNguoiDung=? WHERE MaHopDong=?";
        JdbcHelper.executeUpdate(sql, model.getNgayLap(), model.getNgayThue(), model.getTienCoc(), model.getMaPhong(), model.getMaKTDD(), model.getMaNguoiDung(), model.getMaHopDong());

    }

    public void delete(String MaPhong) {
        String sql = "DELETE FROM HopDong WHERE MaPhong=?";
        JdbcHelper.executeUpdate(sql, MaPhong);
    }

    public List<HopDong> selectAll() {
        String sql = "SELECT * FROM HopDong";
        return select(sql);
    }
    
    public HopDong selectByMaPhong(String mahd) {
        String sql = "SELECT * FROM HopDong WHERE MaPhong LIKE ?";
        List<HopDong> list = select(sql, "%" + mahd + "%");
        return list.size() > 0 ? list.get(0) : null;
    }
    public HopDong selectByMaKTDD(String mahd) {
        String sql = "SELECT * FROM HopDong WHERE MaKTDD LIKE ?";
        List<HopDong> list = select(sql,"%" + mahd + "%");
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<HopDong> select(String sql, Object... args) {
        List<HopDong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HopDong model = readFromResultSet(rs);
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

    private HopDong readFromResultSet(ResultSet rs) throws SQLException {
        HopDong model = new HopDong();
        model.setMaHopDong(rs.getInt("MaHopDong"));
        model.setNgayLap(rs.getDate("NgayLap"));
        model.setNgayThue(rs.getDate("NgayThue"));
        model.setTienCoc(rs.getDouble("TienCoc"));
        model.setMaPhong(rs.getString("MaPhong"));
        model.setMaKTDD(rs.getString("MaKTDD"));
        model.setMaNguoiDung(rs.getString("MaNguoiDung"));
        return model;
    }
}
