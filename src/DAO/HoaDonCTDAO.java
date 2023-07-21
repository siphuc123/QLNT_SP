
package DAO;

import Entity.HoaDonCT;
import Helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HoaDonCTDAO {
    public void insertDienNuoc(HoaDonCT model) {
        String sql = "INSERT INTO HoaDonCT (MaHD, MaDV, ChiSoCu, ChiSoMoi, SoLuong) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaHD(), model.getMaDV(), model.getChiSoCu(), model.getChiSoMoi(), model.getSoLuong());
    }
    public void insertXe(HoaDonCT model) {
        String sql = "INSERT INTO HoaDonCT (MaHD, MaDV, SoLuong) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaHD(), model.getMaDV(), model.getSoLuong());
    }
    public void insertRacWifi(HoaDonCT model) {
        String sql = "INSERT INTO HoaDonCT (MaHD, MaDV) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaHD(), model.getMaDV(), model.isSuDung());
    }

    public void updateDienNuoc(HoaDonCT model) {
        String sql = "UPDATE HoaDonCT SET ChiSoCu = ?, ChiSoMoi= ?, SoLuong = ? WHERE MaHD =? AND MaDV = ?";
        JdbcHelper.executeUpdate(sql, model.getChiSoCu(), model.getChiSoMoi(), model.getSoLuong(), model.getMaHD(), model.getMaDV());
    }
    public void updateXe(HoaDonCT model) {
        String sql = "UPDATE HoaDonCT SET SoLuong = ? WHERE MaHD =? AND MaDV = ?";
        JdbcHelper.executeUpdate(sql, model.getSoLuong(), model.getMaHD(), model.getMaDV());

    }
    public void updateRacWifi(HoaDonCT model) {
        String sql = "UPDATE HoaDonCT SET SuDung = ? WHERE MaHD =? AND MaDV = ?";
        JdbcHelper.executeUpdate(sql, model.isSuDung(), model.getMaHD(), model.getMaDV());

    }
    public void delete(int MaHD) {
        String sql = "DELETE FROM HoaDonCT WHERE MaHD = ?";
        JdbcHelper.executeUpdate(sql, MaHD);
    }    

    public HoaDonCT selectHDCT(int mahd, String madv) {
        String sql = "SELECT * FROM HoaDonCT WHERE MaHD = ? AND MaDV = ?";
        List<HoaDonCT> list = select(sql, mahd, madv);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<HoaDonCT> select(String sql, Object... args) {
        List<HoaDonCT> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDonCT model = readFromResultSet(rs);
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

    private HoaDonCT readFromResultSet(ResultSet rs) throws SQLException {
        HoaDonCT model = new HoaDonCT();
        model.setMaHD(rs.getInt("MaHD"));
        model.setMaDV(rs.getString("MaDV"));
        model.setChiSoCu(rs.getInt("ChiSoCu"));
        model.setChiSoMoi(rs.getInt("ChiSoMoi"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setSuDung(rs.getBoolean("SuDung"));
        return model;
    }
}
