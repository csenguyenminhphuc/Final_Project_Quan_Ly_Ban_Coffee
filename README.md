# ☕ Hệ Thống Quản Lý Quán Cà Phê

## 💻 Tác giả

**Nguyễn Minh Phúc**  
DevSecOps Engineer | Infrastructure Engineer  
MSSV: 22637001

---

## 📖 Giới thiệu

Ứng dụng quản lý quán cà phê được xây dựng với kiến trúc MVC, tích hợp bảo mật và phân quyền người dùng. Hệ thống hỗ trợ 2 vai trò: **Quản lý** (quản trị toàn bộ) và **Nhân viên** (bán hàng).

Môn học: Hướng sự kiện / Phát triển ứng dụng

## 🛠️ Tech Stack

- **Backend:** Java 8+, JDBC
- **Frontend:** Java Swing, FlatLaf
- **Database:** SQL Server
- **Architecture:** MVC Pattern, DAO Pattern
- **Security:** Regex validation, RBAC, Prepared statements

---

## 💾 Database

**Database:** CoffeeManagement  
**DBMS:** SQL Server  
**Script:** `SQLQueryCoffee.sql`

### Bảng chính:
- `TaiKhoan` - Thông tin đăng nhập
- `NhanVien` - Thông tin nhân viên
- `KhachHang` - Thông tin khách hàng
- `SanPham` - Sản phẩm
- `DanhMucSanPham` - Danh mục
- `HoaDon` - Hóa đơn
- `ChiTietHoaDon` - Chi tiết hóa đơn
- `KhuyenMai` - Khuyến mãi

### Cấu hình kết nối

File: `src/Model/Dao/ConnectDB.java`

```java
String url = "jdbc:sqlserver://localhost:1433;databaseName=CoffeeManagement;...";
String user = "sa";           // Thay username của bạn
String password = "sapassword"; // Thay password của bạn
```

## 📞 Contact

**Nguyễn Minh Phúc**  
DevSecOps Engineer | Infrastructure Engineer  
MSSV: 22637001Version:** 1.0.0 | **Status:** ✅ Production Ready | **Last Updated:** March 4, 2026