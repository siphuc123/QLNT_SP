package Entity;

import java.util.Date;

public class HoaDon {
    private int MaHD;
    private Date NgayXuatHD;
    private String MaPhong;
    private String MaKTDD;
    private Date NgayThanhToan;
    private String thanhToan;
    private double tongTien;

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public Date getNgayXuatHD() {
        return NgayXuatHD;
    }

    public void setNgayXuatHD(Date NgayXuatHD) {
        this.NgayXuatHD = NgayXuatHD;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getMaKTDD() {
        return MaKTDD;
    }

    public void setMaKTDD(String MaKTDD) {
        this.MaKTDD = MaKTDD;
    }

    public Date getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(Date NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public String getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(String thanhToan) {
        this.thanhToan = thanhToan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    
}
