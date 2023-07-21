package DAO;

import Entity.HoaDon;
import Helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoaDonDAO {

    public void insert(HoaDon model) {
        String sql = "INSERT INTO HoaDon (NgayXuatHD, ThanhToan, TongTien, MaPhong, MaKTDD) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getNgayXuatHD(), "CHƯA THANH TOÁN", model.getTongTien(), model.getMaPhong(), model.getMaKTDD());
    }

    public void update(HoaDon model) {
        String sql = "UPDATE HoaDon SET NgayXuatHD = ?, TongTien = ?, MaPhong = ?, MaKTDD = ? WHERE MaHD = ?";
        JdbcHelper.executeUpdate(sql, model.getNgayXuatHD(), model.getTongTien(), model.getMaPhong(), model.getMaKTDD(), model.getMaHD());

    }

    public void updateTT(int MaHD) {
        String sql = "UPDATE HoaDon SET ThanhToan = ?, NgayTT = ? WHERE MaHD = ?";
        JdbcHelper.executeUpdate(sql, "ĐÃ THANH TOÁN", new Date(), MaHD);

    }

    public void delete(int MaHD) {
        String sql = "DELETE FROM HoaDon WHERE MaHD = ?";
        JdbcHelper.executeUpdate(sql, MaHD);
    }

    public List<HoaDon> selectThang(int thang) {
        String sql = "SELECT MaHD, MaPhong, MaKTDD, NgayXuatHD, ThanhToan, NgayTT, TongTien"
                + " FROM HoaDon"
                + " WHERE MONTH(NgayXuatHD) = ?";
        return select(sql, thang);
    }

    public List<HoaDon> selectAll() {
        String sql = "SELECT * FROM HoaDon";
        return select(sql);
    }

    public List<HoaDon> selectByKeyword(String keyword, int thang) {
        String sql = "SELECT MaHD, MaPhong, HoaDon.MaKTDD, NgayXuatHD, ThanhToan, NgayTT, TongTien"
                + " FROM HoaDon INNER JOIN KhachThueDD ON HoaDon.MaKTDD = KhachThueDD.MaKTDD"
                + " WHERE (MONTH(NgayXuatHD) = ? AND ThanhToan LIKE ?)"
                + " OR (MONTH(NgayXuatHD) = ? AND MaPhong LIKE ?)"
                + " OR (MONTH(NgayXuatHD) = ? AND HoTen LIKE ?)";
        return this.select(sql, thang, "%" + keyword + "%", thang, "%" + keyword + "%", thang, "%" + keyword + "%");
    }

    public List<HoaDon> selectByKeyword2(String keyword) {
        String sql = "SELECT MaHD, MaPhong, HoaDon.MaKTDD, NgayXuatHD, ThanhToan, NgayTT, TongTien"
                + " FROM HoaDon INNER JOIN KhachThueDD ON HoaDon.MaKTDD = KhachThueDD.MaKTDD"
                + " WHERE ThanhToan LIKE ?"
                + " OR MaPhong LIKE ?"
                + " OR HoTen LIKE ?";
        return this.select(sql, "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%");
    }

    public List<HoaDon> selectByKeyword3(String keyword, int thang, int nam) {
        String sql = "SELECT MaHD, MaPhong, HoaDon.MaKTDD, NgayXuatHD, ThanhToan, NgayTT, TongTien"
                + " FROM HoaDon INNER JOIN KhachThueDD ON HoaDon.MaKTDD = KhachThueDD.MaKTDD"
                + " WHERE (MONTH(NgayXuatHD) = ? AND YEAR(NgayXuatHD) = ? AND ThanhToan LIKE ?)"
                + " OR (MONTH(NgayXuatHD) = ? AND YEAR(NgayXuatHD) = ? AND MaPhong LIKE ?)"
                + " OR (MONTH(NgayXuatHD) = ? AND YEAR(NgayXuatHD) = ? AND HoTen LIKE ?)";
        return this.select(sql, thang, nam, "%" + keyword + "%", thang, nam, "%" + keyword + "%", thang, nam, "%" + keyword + "%");
    }

    public List<HoaDon> selectByKeyword4(String keyword, int nam) {
        String sql = "SELECT MaHD, MaPhong, HoaDon.MaKTDD, NgayXuatHD, ThanhToan, NgayTT, TongTien"
                + " FROM HoaDon INNER JOIN KhachThueDD ON HoaDon.MaKTDD = KhachThueDD.MaKTDD"
                + " WHERE (YEAR(NgayXuatHD) = ? AND ThanhToan LIKE ?)"
                + " OR (YEAR(NgayXuatHD) = ? AND MaPhong LIKE ?)"
                + " OR (YEAR(NgayXuatHD) = ? AND HoTen LIKE ?)";
        return this.select(sql, nam, "%" + keyword + "%", nam, "%" + keyword + "%", nam, "%" + keyword + "%");
    }

    public List<Integer> selectYears() {
        String sql = "SELECT DISTINCT year(NgayXuatHD) Year FROM HOADON ORDER BY Year DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public HoaDon selectHDGanNhat(String maphong) {
        String sql = "SELECT * FROM HoaDon \n"
                + "WHERE MaHD = (SELECT MAX(MaHD) FROM HoaDon WHERE MaPhong LIKE ?)\n"
                + "AND MaPhong LIKE ?";
        List<HoaDon> list = select(sql, maphong, maphong);
        return list.size() > 0 ? list.get(0) : null;
    }

    public HoaDon selectById(int mahd) {
        String sql = "SELECT * FROM HoaDon WHERE MaHD=?";
        List<HoaDon> list = select(sql, mahd);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<HoaDon> select(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDon model = readFromResultSet(rs);
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

    private HoaDon readFromResultSet(ResultSet rs) throws SQLException {
        HoaDon model = new HoaDon();
        model.setMaHD(rs.getInt("MaHD"));
        model.setNgayXuatHD(rs.getDate("NgayXuatHD"));
        model.setMaPhong(rs.getString("MaPhong"));
        model.setMaKTDD(rs.getString("MaKTDD"));
        model.setThanhToan(rs.getString("ThanhToan"));
        model.setNgayThanhToan(rs.getDate("NgayTT"));
        model.setTongTien(rs.getDouble("TongTien"));
        return model;
    }
}
