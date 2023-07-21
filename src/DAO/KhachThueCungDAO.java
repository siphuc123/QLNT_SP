package DAO;

import Entity.KhachThueCung;
import Helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phuc
 */
public class KhachThueCungDAO {

    public void insert(KhachThueCung model) {
        String sql = "INSERT INTO KhachThueCung VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaKTC(), model.getHoTen(), model.isGioiTinh(), model.getSoDT(), model.getMaKTDD());
    }

    public void update(KhachThueCung model) {
        String sql = "UPDATE KhachThueCung SET HoTen = ?, GioiTinh = ?, SoDT = ?, MaKTDD = ? WHERE MaKTC=?";
        JdbcHelper.executeUpdate(sql, model.getHoTen(), model.isGioiTinh(), model.getSoDT(), model.getMaKTDD(), model.getMaKTC());

    }

    public void delete(String MaKT) {
        String sql = "DELETE FROM KhachThueCung WHERE MaKTC LIKE ?";
        JdbcHelper.executeUpdate(sql, MaKT);
    }

    public List<KhachThueCung> selectAll() {
        String sql = "SELECT * FROM KhachThueCung";
        return select1(sql);
    }

    public List<KhachThueCung> selectAllWithDD() {
        String sql = "SELECT ktc.MaKTC,ktc.HoTen,ktc.GioiTinh,ktc.SoDT,ktc.MaKTDD, ktd.HoTen as HoTenDD \n"
                + "FROM KhachThueCung ktc \n"
                + "JOIN KhachThueDD ktd ON ktc.MaKTDD = ktd.MaKTDD";
        return select(sql);
    }

    public KhachThueCung selectByMaKTC(String makt) {
        String sql = "SELECT ktc.MaKTC,ktc.HoTen,ktc.GioiTinh,ktc.SoDT,ktc.MaKTDD, ktd.HoTen as HoTenDD \n"
                + "FROM KhachThueCung ktc \n"
                + "JOIN KhachThueDD ktd ON ktc.MaKTDD = ktd.MaKTDD WHERE MaKTC LIKE ?";
        List<KhachThueCung> list = select(sql, "%" + makt + "%");
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<KhachThueCung> select1(String sql, Object... args) {
        List<KhachThueCung> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    KhachThueCung model = readFromResultSet1(rs);
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

    private List<KhachThueCung> select(String sql, Object... args) {
        List<KhachThueCung> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    KhachThueCung model = readFromResultSet(rs);
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

    private KhachThueCung readFromResultSet(ResultSet rs) throws SQLException {
        KhachThueCung model = new KhachThueCung();
        model.setMaKTC(rs.getString("MaKTC"));
        model.setHoTen(rs.getString("HoTen"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setSoDT(rs.getString("SoDT"));
        model.setMaKTDD(rs.getString("MaKTDD"));
        model.setHoTen_DD(rs.getString("HoTenDD"));
        return model;
    }
        private KhachThueCung readFromResultSet1(ResultSet rs) throws SQLException {
        KhachThueCung model = new KhachThueCung();
        model.setMaKTC(rs.getString("MaKTC"));
        model.setHoTen(rs.getString("HoTen"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setSoDT(rs.getString("SoDT"));
        model.setMaKTDD(rs.getString("MaKTDD"));
        return model;
    }
}
