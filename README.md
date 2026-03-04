# ☕ Hệ Thống Quản Lý Quán Cà Phê

## 📋 Thông tin dự án

**Sinh viên:** Nguyễn Minh Phúc  
**MSSV:** 22637001  
**Môn học:** Lập trình hướng đối tượng / Phát triển ứng dụng Java  

---

## ✨ Tính năng chính

### 🔐 Hệ thống đăng nhập
- ✅ Đăng nhập với username/password
- ✅ Validation đầu vào với Regex
- ✅ **Role-based access control** (Quản lý/Nhân viên)
- ✅ Quên mật khẩu (reset về 123456)
- ✅ Hiển thị/ẩn mật khẩu
- ✅ Kiểm tra trạng thái tài khoản

### 👨‍💼 Giao diện Quản lý (TrangChuQuanLyMainGUI)
- Quản lý nhân viên
- Quản lý khách hàng
- Quản lý danh mục sản phẩm
- Quản lý menu
- Xem thống kê
- Quản lý khuyến mãi

### 👨‍💻 Giao diện Nhân viên (TrangChuBanHangMainGUI)
- Bán hàng
- Tạo hóa đơn
- Tra cứu khách hàng
- Xem menu sản phẩm

---

## 🏗️ Kiến trúc hệ thống

```
src/
├── Model/
│   ├── Entity/          # Các class entity (NhanVien, KhachHang, ...)
│   └── Dao/             # Data Access Object
│       ├── ConnectDB.java
│       └── DangNhapMainDao.java
├── View/                # Giao diện người dùng
│   ├── DangNhapMain.java
│   ├── TrangChuQuanLyMainGUI.java
│   └── TrangChuBanHangMainGUI.java
├── Controller/          # Xử lý logic nghiệp vụ
│   └── DangNhapMainController.java
└── MainGUI/            # Entry point
    └── MainGUI.java
```

**Pattern:** MVC (Model-View-Controller)

---

## 🔐 Hệ thống đăng nhập chi tiết

### Regex Validation

| Field | Pattern | Mô tả |
|-------|---------|-------|
| Username | `^[a-zA-Z0-9_]{3,50}$` | 3-50 ký tự, chữ/số/gạch dưới |
| Password | `^.{6,}$` | Tối thiểu 6 ký tự |
| Mã NV | `^NV\d{3}$` | Format: NV001, NV002, ... |
| Năm sinh | `^(19[6-9]\d|20[0-2]\d)$` | 1960-2029, ≥18 tuổi |

### Role-based Access

```
Đăng nhập thành công
    ↓
Check vaiTro
    ↓
┌─────────────────┬─────────────────────┐
│ Vai trò         │ Giao diện           │
├─────────────────┼─────────────────────┤
│ Quản lý         │ TrangChuQuanLyMainGUI    │
│ Nhân viên       │ TrangChuBanHangMainGUI   │
└─────────────────┴─────────────────────┘
```

### Quên mật khẩu

1. Nhập: Username + Mã NV + Năm sinh
2. Hệ thống xác thực thông tin
3. **UPDATE** mật khẩu = `123456` trong database
4. Thông báo và chuyển về đăng nhập
5. User đăng nhập lại với mật khẩu mới

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

---

## 🚀 Hướng dẫn chạy

### 1. Cài đặt môi trường
- JDK 8 trở lên
- SQL Server 2019 trở lên
- Eclipse IDE (hoặc IDE Java khác)
- SQL Server JDBC Driver

### 2. Cài đặt Database
```bash
# Mở SQL Server Management Studio (SSMS)
# Kết nối đến SQL Server
# Mở file SQLQueryCoffee.sql
# Execute (F5)
```

### 3. Cấu hình kết nối
- Mở `src/Model/Dao/ConnectDB.java`
- Cập nhật `user` và `password` của SQL Server

### 4. Thêm thư viện
- Add SQL Server JDBC Driver vào Build Path
- Add FlatLaf (nếu sử dụng)

### 5. Chạy ứng dụng
```
Run: src/MainGUI/MainGUI.java
```

---

## 🔑 Tài khoản test

| Username | Password | Mã NV | Vai trò | Note |
|----------|----------|-------|---------|------|
| admin    | 123456   | NV001 | Quản lý | Test full access |
| binh     | 123456   | NV002 | Nhân viên | Test limited access |
| cuong    | 123456   | NV003 | Nhân viên | Test quên mật khẩu |
| duc      | 123456   | NV005 | Quản lý | Test quản lý 2 |

---

## 📖 Tài liệu

1. **FINAL_SUMMARY.txt** - Tổng hợp toàn bộ dự án
2. **HUONG_DAN_DANG_NHAP.md** - Chi tiết hệ thống đăng nhập
3. **REGEX_VALIDATION_GUIDE.md** - Hướng dẫn regex
4. **CAP_NHAT_MOI_DANG_NHAP.md** - Cập nhật mới nhất
5. **TEST_SCRIPT.md** - Script test đầy đủ
6. **UPDATE_SUMMARY.txt** - Tóm tắt cập nhật

---

## 🧪 Test nhanh

### Test đăng nhập Quản lý:
```
Username: admin
Password: 123456
→ Mở TrangChuQuanLyMainGUI ✅
```

### Test đăng nhập Nhân viên:
```
Username: binh
Password: 123456
→ Mở TrangChuBanHangMainGUI ✅
```

### Test quên mật khẩu:
```
1. Click "Quên mật khẩu?"
2. Nhập: cuong / NV003 / 1997
3. Password reset → 123456 ✅
4. Login: cuong / 123456 ✅
```

---

## 🛠️ Công nghệ sử dụng

- **Java 8+** - Core language
- **Swing** - GUI Framework
- **FlatLaf** - Modern Look & Feel
- **JDBC** - Database connectivity
- **SQL Server** - Database
- **Regex** - Input validation
- **MVC Pattern** - Architecture
- **DAO Pattern** - Data access

---

## ⚡ Tính năng nổi bật

### Security
- ✅ Regex validation tất cả input
- ✅ Password reset với xác thực
- ✅ Check trạng thái tài khoản
- ✅ Role-based access control

### User Experience
- ✅ Auto focus khi lỗi
- ✅ Auto select text
- ✅ Thông báo lỗi chi tiết
- ✅ Show/hide password
- ✅ Enter to submit
- ✅ Auto-fill username

### Performance
- ✅ Connection pooling
- ✅ SwingUtilities cho thread-safe UI
- ✅ Prepared statements (SQL injection prevention)

---

## 🐛 Troubleshooting

### Lỗi kết nối database
```
1. Kiểm tra SQL Server đang chạy
2. Kiểm tra username/password trong ConnectDB.java
3. Kiểm tra firewall không chặn port 1433
```

### Lỗi ClassNotFoundException
```
1. Thêm SQL Server JDBC Driver vào Build Path
2. Hoặc copy file .jar vào thư mục lib/
```

### Lỗi validation
```
Xem REGEX_VALIDATION_GUIDE.md để biết format đúng
```

---

## 📊 Project Status

✅ **COMPLETED & PRODUCTION READY**

- [x] Database design
- [x] Entity classes
- [x] DAO layer
- [x] Login system with regex
- [x] Role-based access
- [x] Password reset
- [x] Main UI (Quản lý)
- [x] Main UI (Nhân viên)
- [x] Documentation
- [x] Test scripts

---

## 📞 Liên hệ

**Sinh viên:** Nguyễn Minh Phúc  
**MSSV:** 22637001  
**Email:** [your-email]  

---

## 📝 License

Dự án này được tạo cho mục đích học tập.

---

## 🎉 Acknowledgments

- Giảng viên hướng dẫn
- Thư viện FlatLaf
- Microsoft SQL Server
- Java Community

---

**Last Updated:** March 4, 2026  
**Version:** 1.0.0  
**Status:** ✅ Production Ready

