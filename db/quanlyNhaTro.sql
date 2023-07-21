CREATE DATABASE QLNhaTro
GO

USE QLNhaTro
GO

CREATE TABLE PhongTro(
	MaPhong VARCHAR(10) NOT NULL PRIMARY KEY,
	LoaiPhong NVARCHAR(15) NOT NULL,
	GiaPhong MONEY NOT NULL,
	TrangThai NVARCHAR(30) NOT NULL,
	Tang int,
	MoTa NVARCHAR(255),
	Hinh NVARCHAR(100)
);

CREATE TABLE NguoiDung(
	MaNguoiDung VARCHAR(10) NOT NULL PRIMARY KEY,
	HoTen NVARCHAR(60) NOT NULL,
	VaiTro BIT NOT NULL,
	MatKhau VARCHAR(15) NOT NULL,
	Email VARCHAR(255) NOT NULL
);

CREATE TABLE NguoiDungCuoi(
	MaNguoiDungCuoi VARCHAR(10) NOT NULL,
	Remember BIT NOT NULL
);

CREATE TABLE DichVu(
	MaDV NVARCHAR(5) NOT NULL PRIMARY KEY,
	TenDV NVARCHAR(50) NOT NULL,
	Gia MONEY NOT NULL
);

CREATE TABLE KhachThueDD(
	MaKTDD NVARCHAR(10) NOT NULL PRIMARY KEY,
	HoTen NVARCHAR(60) NOT NULL,
	NgaySinh DATE NOT NULL,
	GioiTinh BIT NOT NULL,
	SoDT NVARCHAR(11) NOT NULL,
	Email NVARCHAR(50) NOT NULL
);

CREATE TABLE KhachThueCung(
	MaKTC NVARCHAR(10) PRIMARY KEY NOT NULL,
	HoTen NVARCHAR(60) NOT NULL,
	GioiTinh BIT NOT NULL,
	SoDT NVARCHAR(11) NOT NULL,
	MaKTDD NVARCHAR(10) REFERENCES KhachThueDD(MaKTDD)
);

CREATE TABLE HopDong(
	MaHopDong INT NOT NULL IDENTITY PRIMARY KEY,
	NgayLap DATE NOT NULL,
	NgayThue DATE NOT null,
	TienCoc MONEY NOT NULL,
	MaPhong VARCHAR(10) NOT NULL REFERENCES PhongTro(MaPhong),
	MaKTDD NVARCHAR(10) NOT NULL REFERENCES KhachThueDD(MaKTDD),
	MaNguoiDung VARCHAR(10) NOT NULL REFERENCES NguoiDung(MaNguoiDung)
);

CREATE TABLE HoaDon(
	MaHD INT NOT NULL IDENTITY PRIMARY KEY,
	NgayXuatHD DATE NOT null,
	ThanhToan NVARCHAR(50) NOT NULL,
	NgayTT DATE NULL,
	TongTien MONEY NULL,
	MaPhong VARCHAR(10) NOT NULL REFERENCES PhongTro(MaPhong),
	MaKTDD NVARCHAR(10) NOT NULL REFERENCES KhachThueDD(MaKTDD)
);

CREATE TABLE HoaDonCT(
	MaHD INT NOT NULL REFERENCES HoaDon(MaHD),
	MaDV NVARCHAR(5) NOT NULL REFERENCES DichVu(MaDV),
	ChiSoCu INT NULL,
	ChiSoMoi INT NULL,
	SoLuong INT NULL,
	SuDung BIT NULL,
	PRIMARY KEY(MaHD,MaDV)
);
GO

CREATE PROC sp_DoanhThu
AS BEGIN
	SELECT
	MONTH(NgayXuatHD) thang,
	YEAR(NgayXuatHD) nam,
	SUM(TongTien) tongtien
	FROM HoaDon
	GROUP BY MONTH(NgayXuatHD), YEAR(NgayXuatHD)
END
GO

CREATE PROC sp_DoanhThuTheoNam (@Year INT)
AS BEGIN
	SELECT
	MONTH(NgayXuatHD) thang,
	YEAR(NgayXuatHD) nam,
	SUM(TongTien) tongtien
	FROM HoaDon
	WHERE YEAR(NgayXuatHD) = @Year 
	GROUP BY MONTH(NgayXuatHD), YEAR(NgayXuatHD)
END

GO
CREATE PROC sp_DoanhThuTheoThang (@Month INT)
AS BEGIN
	SELECT
	MONTH(NgayXuatHD) thang,
	YEAR(NgayXuatHD) nam,
	SUM(TongTien) tongtien
	FROM HoaDon
	WHERE MONTH(NgayXuatHD) = @Month
	GROUP BY MONTH(NgayXuatHD), YEAR(NgayXuatHD)
END

GO

CREATE PROC sp_DoanhThuTheoThangNam (@Month INT, @Year INT)
AS BEGIN
	SELECT
	MONTH(NgayXuatHD) thang,
	YEAR(NgayXuatHD) nam,
	SUM(TongTien) tongtien
	FROM HoaDon
	WHERE MONTH(NgayXuatHD) = @Month AND YEAR(NgayXuatHD) = @Year
	GROUP BY MONTH(NgayXuatHD), YEAR(NgayXuatHD)
END

GO
/*
exec sp_DoanhThuTheoNam @Year = 2022
exec sp_DoanhThuTheoThang @Month = 10
exec sp_DoanhThuTheoThangNam @Month = 10, @Year = 2022
*/
INSERT INTO PhongTro VALUES
('T1.01',N'Có gác','2500000',N'Đang thuê',1,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac1.png'),
('T1.02',N'Có gác','2500000',N'Đang thuê',1,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png'),
('T1.03',N'Không gác','2000000',N'Đang thuê',1,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac1.png'),
('T1.04',N'Có gác','2500000',N'Trống',1,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac1.png'),
('T1.05',N'Có gác','2500000',N'Trống',1,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png'),
('T1.06',N'Không gác','2000000',N'Đang cọc',1,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac2.png'),
('T1.07',N'Không gác','2000000',N'Trống',1,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac1.png'),
('T1.08',N'Có gác','2500000',N'Trống',1,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png'),
('T1.09',N'Không gác','2000000',N'Trống',1,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac2.png'),
('T1.10',N'Có gác','2500000',N'Đang thuê',1,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac1.png'),
('T2.01',N'Có gác','2500000',N'Đang thuê',2,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png'),
('T2.02',N'Có gác','2500000',N'Đang thuê',2,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac1.png'),
('T2.03',N'Không gác','2000000',N'Đang cọc',2,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac1.png'),
('T2.04',N'Có gác','2500000',N'Trống',2,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac1.png'),
('T2.05',N'Có gác','2500000',N'Trống',2,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png'),
('T2.06',N'Không gác','2000000',N'Đang cọc',2,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac1.png'),
('T2.07',N'Không gác','2000000',N'Trống',2,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac2.png'),
('T2.08',N'Có gác','2500000',N'Đang thuê',2,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac1.png'),
('T2.09',N'Không gác','2000000',N'Trống',2,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac2.png'),
('T2.10',N'Có gác','2500000',N'Đang cọc',2,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png'),
('T3.01',N'Có gác','2500000',N'Đang thuê',3,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac1.png'),
('T3.02',N'Có gác','2500000',N'Đang thuê',3,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png'),
('T3.03',N'Không gác','2000000',N'Trống',3,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac1.png'),
('T3.04',N'Có gác','2500000',N'Trống',3,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png'),
('T3.05',N'Có gác','2500000',N'Đang thuê',3,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac1.png'),
('T3.06',N'Không gác','2000000',N'Đang cọc',3,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac1.png'),
('T3.07',N'Không gác','2000000',N'Trống',3,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac2.png'),
('T3.08',N'Có gác','2500000',N'Trống',3,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac1.png'),
('T3.09',N'Không gác','2000000',N'Trống',3,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac1.png'),
('T3.10',N'Có gác','2500000',N'Trống',3,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png'),
('T4.01',N'Có gác','2500000',N'Trống',4,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac1.png'),
('T4.02',N'Có gác','2500000',N'Trống',4,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png'),
('T4.03',N'Không gác','2000000',N'Đang cọc',4,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac1.png'),
('T4.04',N'Có gác','2500000',N'Trống',4,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac1.png'),
('T4.05',N'Có gác','2500000',N'Trống',4,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png'),
('T4.06',N'Không gác','2000000',N'Đang cọc',4,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac2.png'),
('T4.07',N'Không gác','2000000',N'Trống',4,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac1.png'),
('T4.08',N'Có gác','2500000',N'Trống',4,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png'),
('T4.09',N'Không gác','2000000',N'Trống',4,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac2.png'),
('T4.10',N'Có gác','2500000',N'Đang cọc',4,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac1.png'),
('T5.01',N'Có gác','2500000',N'Trống',5,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png'),
('T5.02',N'Có gác','2500000',N'Trống',5,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac1.png'),
('T5.03',N'Không gác','2000000',N'Đang cọc',5,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac1.png'),
('T5.04',N'Có gác','2500000',N'Trống',5,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png'),
('T5.05',N'Có gác','2500000',N'Trống',5,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac1.png'),
('T5.06',N'Không gác','2000000',N'Trống',5,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac1.png'),
('T5.07',N'Không gác','2000000',N'Trống',5,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac2.png'),
('T5.08',N'Có gác','2500000',N'Trống',5,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png'),
('T5.09',N'Không gác','2000000',N'Trống',5,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','khonggac1.png'),
('T5.10',N'Có gác','2500000',N'Đang cọc',5,N'Rộng 25m2, có nhà vệ sinh riêng, thoáng mát, sạch sẽ','cogac2.png');
GO

INSERT INTO NguoiDung (MaNguoiDung,HoTen,VaiTro,MatKhau, Email)VALUES
('ps20362',N'Nguyễn Sĩ Trọng Phúc',0,'123', 'phucnstps20362@fpt.edu.vn'),
('ps20385',N'Đồng Võ Nghiệp',0,'123', 'nghiepdvps20385@fpt.edu.vn'),
('ps20931',N'Đặng Văn Chí Trung',1,'0000', 'trungdvcps20931@fpt.edu.vn'),
('ps23951',N'Trần Minh Quốc Doanh',1,'0000', 'doanhtmqps23951@fpt.edu.vn'),
('ps20891',N'Nguyễn Anh Tuấn',1,'0000', 'tuannaps20891@fpt.edu.vn');
GO

INSERT INTO DichVu VALUES
('DV1',N'Nước',8000),
('DV2',N'Điện',3000),
('DV3',N'Giữ xe',100000),
('DV4',N'WI-FI',80000),
('DV5',N'Thu rác',20000);
GO

insert into KhachThueDD values
(N'KT001', N'Đồng Võ Nghiệp', '2003-01-04',1, N'0123456789', N'nghiepdvps20385@fpt.edu.vn'),
(N'KT002', N'Nguyễn Sĩ Trọng Phúc', '2003-11-11',1, N'0123456789', N'trongphuc@gmail.com'),
(N'KT003', N'Đặng Văn Chí Trung', '2003-09-10',1, N'0123456789', N'chitrung@gmail.com'),
(N'KT004', N'Nguyễn Anh Tuấn', '2003-04-04',1, N'0123456789', N'anhtuan@gmail.com'),
(N'KT005', N'Trần Minh Quốc Doanh', '2003-11-12',1, N'0123456789', N'quocdoanh@gmail.com'),
(N'KT006', N'Nguyễn Văn Minh', '2000-10-04',1, N'0123456789', N'vanminh@gmail.com'),
(N'KT007', N'Đặng Quốc Anh', '1999-01-08',1, N'0123456789', N'quocanh@gmail.com'),
(N'KT008', N'Nguyễn Thị Hà', '1998-01-14',0, N'0123456789', N'ha@gmail.com'),
(N'KT009', N'Nguyễn Nhật Hạ', '2000-08-04',0, N'0123456789', N'nhatha@gmail.com'),
(N'KT010', N'Trần Thái An', '2001-10-10',1, N'0123456789', N'thaian@gmail.com'),
(N'KT011', N'Lê Anh Tài', '2002-03-05',1, N'0123456789', N'anhtai@gmail.com'),
(N'KT012', N'Nguyễn Ngọc Lan', '1999-09-15',0, N'0123456789', N'ngoclan@gmail.com'),
(N'KT013', N'Võ Văn Nam', '1995-08-08',1, N'0123456789', N'vannam@gmail.com'),
(N'KT014', N'Nguyễn Xuân Tú', '1997-01-01',1, N'0123456789', N'xuantu@gmail.com'),
(N'KT015', N'Lê Nguyễn Nhật Anh', '1999-11-20',0, N'0123456789', N'nhatanh@gmail.com'),
(N'KT016', N'Lê Nhật Thiện', '2002-03-13',1, N'0123456789', N'nhatthien@gmail.com'),
(N'KT017', N'Nguyễn Ngọc Anh Thư', '1999-09-25',0, N'0123456789', N'anhthu@gmail.com'),
(N'KT018', N'Võ Văn Việt', '1995-08-12',1, N'0123456789', N'vanviet@gmail.com'),
(N'KT019', N'Nguyễn Anh Kiệt', '1997-01-30',1, N'0123456789', N'anhkiet@gmail.com'),
(N'KT020', N'Lê Ngọc Khánh Linh', '1999-11-22',0, N'0123456789', N'khanhlinh@gmail.com');

insert into KhachThueCung values
(N'KTC01', N'Đồng Quốc Thành', 1, N'0123456789', N'KT001'),
(N'KTC02', N'Nguyễn Nhật Trường', 1, N'0123456789', N'KT002'),
(N'KTC03', N'Đặng Văn Vũ', 1, N'0123456789', N'KT003'),
(N'KTC04', N'Nguyễn Anh Tiến', 1, N'0123456789', N'KT004'),
(N'KTC05', N'Trần Minh Quốc Đạt', 1, N'0123456789', N'KT004'),
(N'KTC06', N'Nguyễn Văn Bình', 1, N'0123456789', N'KT005'),
(N'KTC07', N'Đặng Quốc Sơn', 1, N'0123456789', N'KT005'),
(N'KTC08', N'Nguyễn Thị Thu', 0, N'0123456789', N'KT006'),
(N'KTC09', N'Nguyễn Nhật Đông', 1, N'0123456789', N'KT007'),
(N'KTC10', N'Trần Ngọc', 0, N'0123456789', N'KT008');
GO

INSERT INTO HopDong (NgayLap, NgayThue, TienCoc, MaPhong, MaKTDD, MaNguoiDung) VALUES 
('2022-10-08','2022-10-09',500000,'T1.01', N'KT001','ps20931'),
('2021-11-08','2021-11-10',400000,'T1.02', N'KT002','ps20385'),
('2021-07-20','2021-07-20',400000,'T1.03', N'KT003','ps20931'),
('2020-08-21','2020-08-21',700000,'T1.10', N'KT004','ps20385'),
('2020-08-19','2020-08-21',700000,'T2.01', N'KT005','ps20385'),
('2020-08-30','2020-09-01',800000,'T2.02', N'KT006','ps23951'),
('2019-11-03','2019-11-03',800000,'T2.08', N'KT007','ps23951'),
('2019-01-04','2019-01-04',900000,'T3.01', N'KT008','ps20891'),
('2019-12-05','2019-12-07',900000,'T3.02', N'KT009','ps20891'),
('2020-02-08','2020-02-08',900000,'T3.05', N'KT010','ps20891'),
('2020-03-08','2020-03-08',100000,'T5.10', N'KT011','ps20362'),
('2020-04-08','2020-04-09',500000,'T5.03', N'KT012','ps20362'),
('2019-04-08','2019-04-09',900000,'T4.10', N'KT013','ps20362'),
('2018-05-22','2018-05-22',400000,'T1.06', N'KT014','ps20931'),
('2018-12-23','2018-12-23',400000,'T4.06', N'KT015','ps20362'),
('2018-12-19','2018-12-23',400000,'T4.03', N'KT016','ps20385'),
('2021-10-11','2021-10-11',600000,'T3.06', N'KT017','ps20385'),
('2021-11-08','2021-11-15',500000,'T2.10', N'KT018','ps20385'),
('2022-11-08','2022-11-16',500000,'T2.06', N'KT019','ps20891'),
('2019-01-18','2019-01-18',500000,'T2.03', N'KT020','ps20362');
GO

INSERT INTO HoaDon (NgayXuatHD, MaPhong, MaKTDD, ThanhToan, NgayTT, TongTien) VALUES
('2021-01-10','T1.01',N'KT001',N'ĐÃ THANH TOÁN','2021-01-11', 2859000),
('2021-02-10','T1.02',N'KT002',N'ĐÃ THANH TOÁN','2021-02-11', 2866000),
('2021-03-10','T1.03',N'KT003',N'ĐÃ THANH TOÁN','2021-03-11', 2353000),
('2021-04-10','T1.10',N'KT004',N'ĐÃ THANH TOÁN','2021-04-11', 2859000),
('2021-05-10','T2.01',N'KT005',N'ĐÃ THANH TOÁN','2021-05-11', 2905000),
('2021-06-10','T2.02',N'KT006',N'ĐÃ THANH TOÁN','2021-06-11', 2901000),
('2021-07-10','T2.08',N'KT007',N'ĐÃ THANH TOÁN','2021-07-11', 2875000),
('2021-08-10','T3.01',N'KT008',N'CHƯA THANH TOÁN',NULL,2867000),
('2021-09-10','T3.02',N'KT009',N'ĐÃ THANH TOÁN','2021-09-11',2889000),
('2021-10-10','T3.05',N'KT010',N'CHƯA THANH TOÁN',NULL,2858000),
('2021-11-10','T1.05',N'KT015',N'ĐÃ THANH TOÁN','2021-11-11',2859000),
('2022-01-10','T1.01',N'KT001',N'ĐÃ THANH TOÁN','2022-01-11', 2871000),
('2022-02-10','T1.02',N'KT002',N'ĐÃ THANH TOÁN','2022-02-11', 2878000),
('2022-03-10','T1.03',N'KT003',N'ĐÃ THANH TOÁN','2022-03-11', 2396000),
('2022-04-10','T1.10',N'KT004',N'ĐÃ THANH TOÁN','2022-04-11', 2889000),
('2022-05-10','T2.01',N'KT005',N'ĐÃ THANH TOÁN','2022-05-11', 2873000),
('2022-06-10','T2.02',N'KT006',N'ĐÃ THANH TOÁN','2022-06-11', 2892000),
('2022-07-10','T2.08',N'KT007',N'ĐÃ THANH TOÁN','2022-07-11', 2932000),
('2022-08-10','T3.01',N'KT008',N'CHƯA THANH TOÁN',NULL,2944000),
('2022-09-10','T3.02',N'KT009',N'ĐÃ THANH TOÁN','2022-09-11',2885000),
('2022-10-10','T3.05',N'KT010',N'CHƯA THANH TOÁN',NULL,2870000),
('2022-11-10','T1.05',N'KT015',N'ĐÃ THANH TOÁN','2022-11-11',2916000);
GO

INSERT INTO HoaDonCT VALUES
(1,N'DV1',1,10,NULL,NULL),
(1,N'DV2',1,30,NULL,NULL),
(1,N'DV3',NULL,NULL,1,NULL),
(1,N'DV4',NULL,NULL,NULL,1),
(1,N'DV5',NULL,NULL,NULL,1),
(2,N'DV1',1,9,NULL,NULL),
(2,N'DV2',1,35,NULL,NULL),
(2,N'DV3',NULL,NULL,1,NULL),
(2,N'DV4',NULL,NULL,NULL,1),
(2,N'DV5',NULL,NULL,NULL,1),
(3,N'DV1',1,13,NULL,NULL),
(3,N'DV2',1,20,NULL,NULL),
(3,N'DV3',NULL,NULL,1,NULL),
(3,N'DV4',NULL,NULL,NULL,1),
(3,N'DV5',NULL,NULL,NULL,1),
(4,N'DV1',1,10,NULL,NULL),
(4,N'DV2',1,30,NULL,NULL),
(4,N'DV3',NULL,NULL,1,NULL),
(4,N'DV4',NULL,NULL,NULL,1),
(4,N'DV5',NULL,NULL,NULL,1),
(5,N'DV1',1,15,NULL,NULL),
(5,N'DV2',1,32,NULL,NULL),
(5,N'DV3',NULL,NULL,1,NULL),
(5,N'DV4',NULL,NULL,NULL,1),
(5,N'DV5',NULL,NULL,NULL,1),
(6,N'DV1',1,16,NULL,NULL),
(6,N'DV2',1,28,NULL,NULL),
(6,N'DV3',NULL,NULL,1,NULL),
(6,N'DV4',NULL,NULL,NULL,1),
(6,N'DV5',NULL,NULL,NULL,1),
(7,N'DV1',1,12,NULL,NULL),
(7,N'DV2',1,30,NULL,NULL),
(7,N'DV3',NULL,NULL,1,NULL),
(7,N'DV4',NULL,NULL,NULL,1),
(7,N'DV5',NULL,NULL,NULL,1),
(8,N'DV1',1,11,NULL,NULL),
(8,N'DV2',1,30,NULL,NULL),
(8,N'DV3',NULL,NULL,1,NULL),
(8,N'DV4',NULL,NULL,NULL,1),
(8,N'DV5',NULL,NULL,NULL,1),
(9,N'DV1',1,10,NULL,NULL),
(9,N'DV2',1,40,NULL,NULL),
(9,N'DV3',NULL,NULL,1,NULL),
(9,N'DV4',NULL,NULL,NULL,1),
(9,N'DV5',NULL,NULL,NULL,1),
(10,N'DV1',1,8,NULL,NULL),
(10,N'DV2',1,35,NULL,NULL),
(10,N'DV3',NULL,NULL,1,NULL),
(10,N'DV4',NULL,NULL,NULL,1),
(10,N'DV5',NULL,NULL,NULL,1),
(11,N'DV1',1,10,NULL,NULL),
(11,N'DV2',1,30,NULL,NULL),
(11,N'DV3',NULL,NULL,1,NULL),
(11,N'DV4',NULL,NULL,NULL,1),
(11,N'DV5',NULL,NULL,NULL,1),
(12,N'DV1',10,22,NULL,NULL),
(12,N'DV2',30,55,NULL,NULL),
(12,N'DV3',NULL,NULL,1,NULL),
(12,N'DV4',NULL,NULL,NULL,1),
(12,N'DV5',NULL,NULL,NULL,1),
(13,N'DV1',9,20,NULL,NULL),
(13,N'DV2',35,65,NULL,NULL),
(13,N'DV3',NULL,NULL,1,NULL),
(13,N'DV4',NULL,NULL,NULL,1),
(13,N'DV5',NULL,NULL,NULL,1),
(14,N'DV1',13,27,NULL,NULL),
(14,N'DV2',20,48,NULL,NULL),
(14,N'DV3',NULL,NULL,1,NULL),
(14,N'DV4',NULL,NULL,NULL,1),
(14,N'DV5',NULL,NULL,NULL,1),
(15,N'DV1',10,22,NULL,NULL),
(15,N'DV2',30,61,NULL,NULL),
(15,N'DV3',NULL,NULL,1,NULL),
(15,N'DV4',NULL,NULL,NULL,1),
(15,N'DV5',NULL,NULL,NULL,1),
(16,N'DV1',15,28,NULL,NULL),
(16,N'DV2',32,55,NULL,NULL),
(16,N'DV3',NULL,NULL,1,NULL),
(16,N'DV4',NULL,NULL,NULL,1),
(16,N'DV5',NULL,NULL,NULL,1),
(17,N'DV1',16,28,NULL,NULL),
(17,N'DV2',28,60,NULL,NULL),
(17,N'DV3',NULL,NULL,1,NULL),
(17,N'DV4',NULL,NULL,NULL,1),
(17,N'DV5',NULL,NULL,NULL,1),
(18,N'DV1',12,29,NULL,NULL),
(18,N'DV2',30,62,NULL,NULL),
(18,N'DV3',NULL,NULL,1,NULL),
(18,N'DV4',NULL,NULL,NULL,1),
(18,N'DV5',NULL,NULL,NULL,1),
(19,N'DV1',11,28,NULL,NULL),
(19,N'DV2',30,66,NULL,NULL),
(19,N'DV3',NULL,NULL,1,NULL),
(19,N'DV4',NULL,NULL,NULL,1),
(19,N'DV5',NULL,NULL,NULL,1),
(20,N'DV1',10,20,NULL,NULL),
(20,N'DV2',40,75,NULL,NULL),
(20,N'DV3',NULL,NULL,1,NULL),
(20,N'DV4',NULL,NULL,NULL,1),
(20,N'DV5',NULL,NULL,NULL,1),
(21,N'DV1',8,18,NULL,NULL),
(21,N'DV2',35,65,NULL,NULL),
(21,N'DV3',NULL,NULL,1,NULL),
(21,N'DV4',NULL,NULL,NULL,1),
(21,N'DV5',NULL,NULL,NULL,1),
(22,N'DV1',10,25,NULL,NULL),
(22,N'DV2',30,62,NULL,NULL),
(22,N'DV3',NULL,NULL,1,NULL),
(22,N'DV4',NULL,NULL,NULL,1),
(22,N'DV5',NULL,NULL,NULL,1);
GO

INSERT INTO NguoiDungCuoi VALUES
('ps20385', 0);
GO
/*
USE QLNhaTro
SELECT * FROM PhongTro WHERE TrangThai LIKE N'Đang thuê'
go
SELECT MaHD, MaPhong, KhachThueDD.HoTen, NgayXuatHD, ThanhToan, NgayTT, TongTien
FROM HoaDon INNER JOIN KhachThueDD ON HoaDon.MaKTDD = KhachThueDD.MaKTDD
WHERE MONTH(NgayXuatHD) = 10
go
SELECT MaHD, MaPhong, KhachThueDD.HoTen, NgayXuatHD, ThanhToan, NgayTT FROM HoaDon JOIN KhachThueDD ON HoaDon.MaKTDD = KhachThueDD.MaKTDD WHERE (MONTH(NgayXuatHD) = 10 AND HoTen LIKE N'Đồng Võ Nghiệp')
go
SELECT * FROM HoaDon 
WHERE MaHD = (SELECT MAX(MaHD) FROM HoaDon WHERE MaPhong LIKE 'T1.01'  )
AND MaPhong LIKE 'T1.01'*/
