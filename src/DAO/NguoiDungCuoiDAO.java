
package DAO;

import Entity.NguoiDungCuoi;
import Helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungCuoiDAO {
    public void update(NguoiDungCuoi model) {
        String sql = "UPDATE NguoiDungCuoi SET MaNguoiDungCuoi=?, Remember=?";
        JdbcHelper.executeUpdate(sql, model.getMaNguoiDungCuoi(), model.isRemember());
    }
    
    public NguoiDungCuoi select() {
        String sql = "SELECT * FROM NguoiDungCuoi";
        List<NguoiDungCuoi> list = new ArrayList<>();       
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    NguoiDungCuoi model = readFromResultSet(rs);
                    list.add(model);
                }
                rs.close();
            } finally {
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list.size() > 0 ? list.get(0) : null;
    }
    private NguoiDungCuoi readFromResultSet(ResultSet rs) throws SQLException {
        NguoiDungCuoi model = new NguoiDungCuoi();
        model.setMaNguoiDungCuoi(rs.getString("MaNguoiDungCuoi"));
        model.setRemember(rs.getBoolean("Remember"));
        return model;
    }
}
