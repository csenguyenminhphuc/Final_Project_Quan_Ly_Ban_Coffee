-- Tạo database (nếu chưa có)
CREATE DATABASE CoffeeManagement;
GO

USE CoffeeManagement;
GO

-- Tạo bảng NhanVien (Nhân viên)
CREATE TABLE NhanVien (
    maNhanVien VARCHAR(20) PRIMARY KEY,
    tenNhanVien NVARCHAR(100) NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    namSinh INT,
    soDienThoai VARCHAR(15),
    email VARCHAR(100),
    chucVu NVARCHAR(50),
    trangThai BIT DEFAULT 1  -- 1: Đang hoạt động, 0: Đã vô hiệu hóa
);
GO

-- Insert dữ liệu mẫu
INSERT INTO NhanVien (maNhanVien, tenNhanVien, username, password, namSinh, soDienThoai, email, chucVu, trangThai)
VALUES 
('NV001', N'Nguyễn Văn An', 'admin', '123456', 1990, '0901234567', 'admin@coffee.com', N'Quản lý', 1),
('NV002', N'Trần Thị Bình', 'binh', '123456', 1995, '0912345678', 'binh@coffee.com', N'Nhân viên', 1),
('NV003', N'Lê Văn Cường', 'cuong', '123456', 1992, '0923456789', 'cuong@coffee.com', N'Nhân viên', 1),
('NV004', N'Phạm Thị Dung', 'dung', '123456', 1998, '0934567890', 'dung@coffee.com', N'Nhân viên', 0); -- Tài khoản bị vô hiệu hóa
GO

-- Kiểm tra dữ liệu
SELECT * FROM NhanVien;
GO
