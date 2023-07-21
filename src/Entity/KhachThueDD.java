package Entity;

import java.util.Date;

public class KhachThueDD {
    private String MaKTDD;
    private String HoTen;
    private Date NgaySinh;
    private boolean GioiTinh;
    private String SoDT;
    private String Email;

    public String getMaKTDD() {
        return MaKTDD;
    }

    public void setMaKTDD(String MaKTDD) {
        this.MaKTDD = MaKTDD;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
