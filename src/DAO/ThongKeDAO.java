package DAO;

import Helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDAO {

    DecimalFormat dcf = new DecimalFormat("###,### VND");

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    if (i == 2) {
                        vals[i] = dcf.format(rs.getObject(cols[i]));
                    } else {
                        vals[i] = rs.getObject(cols[i]);
                    }
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getDoanhThu() {
        String sql = "{CALL sp_DoanhThu}";
        String[] cols = {"Thang", "Nam", "TongTien"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getDoanhThuTheoNam(int nam) {
        String sql = "{CALL sp_DoanhThuTheoNam (?)}";
        String[] cols = {"Thang", "Nam", "TongTien"};
        return this.getListOfArray(sql, cols, nam);
    }

    public List<Object[]> getDoanhThuTheoThang(int thang) {
        String sql = "{CALL sp_DoanhThuTheoThang (?)}";
        String[] cols = {"Thang", "Nam", "TongTien"};
        return this.getListOfArray(sql, cols, thang);
    }

    public List<Object[]> getDoanhThuTheoThangNam(int thang, int nam) {
        String sql = "{CALL sp_DoanhThuTheoThangNam (?, ?)}";
        String[] cols = {"Thang", "Nam", "TongTien"};
        return this.getListOfArray(sql, cols, thang, nam);
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
}
