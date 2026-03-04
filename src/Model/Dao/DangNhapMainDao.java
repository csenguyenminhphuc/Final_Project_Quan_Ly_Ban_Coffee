package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Entity.NhanVien;

public class DangNhapMainDao {
	
	// Phương thức đăng nhập
	public NhanVien dangNhap(String tenDangNhap, String matKhau) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		NhanVien nhanVien = null;
		
		try {
			con = ConnectDB.getConnection();
			// JOIN TaiKhoan với NhanVien để lấy đầy đủ thông tin
			String sql = "SELECT tk.maTK, tk.tenDangNhap, tk.matKhau, tk.trangThai, " +
			             "nv.maNV, nv.hoTen, nv.gioiTinh, nv.namSinh, nv.diaChi, nv.sdt, nv.luong, nv.vaiTro " +
			             "FROM TaiKhoan tk " +
			             "INNER JOIN NhanVien nv ON tk.maNV = nv.maNV " +
			             "WHERE tk.tenDangNhap = ? AND tk.matKhau = ? AND tk.trangThai = 1";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tenDangNhap);
			stmt.setString(2, matKhau);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				nhanVien = new NhanVien();
				// Thông tin tài khoản
				nhanVien.setMaTK(rs.getString("maTK"));
				nhanVien.setTenDangNhap(rs.getString("tenDangNhap"));
				nhanVien.setMatKhau(rs.getString("matKhau"));
				nhanVien.setTrangThai(rs.getBoolean("trangThai"));
				
				// Thông tin nhân viên
				nhanVien.setMaNV(rs.getString("maNV"));
				nhanVien.setHoTen(rs.getString("hoTen"));
				nhanVien.setGioiTinh(rs.getBoolean("gioiTinh"));
				nhanVien.setNamSinh(rs.getInt("namSinh"));
				nhanVien.setDiaChi(rs.getString("diaChi"));
				nhanVien.setSdt(rs.getString("sdt"));
				nhanVien.setLuong(rs.getDouble("luong"));
				nhanVien.setVaiTro(rs.getString("vaiTro"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return nhanVien;
	}
	
	// Phương thức reset và lấy mật khẩu khi quên (set về 123456)
	public String layMatKhau(String tenDangNhap, String maNV, int namSinh) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String matKhauMoi = "123456";
		
		try {
			con = ConnectDB.getConnection();
			
			// Bước 1: Kiểm tra thông tin nhân viên có đúng không
			String sqlCheck = "SELECT tk.maTK " +
			                  "FROM TaiKhoan tk " +
			                  "INNER JOIN NhanVien nv ON tk.maNV = nv.maNV " +
			                  "WHERE tk.tenDangNhap = ? AND nv.maNV = ? AND nv.namSinh = ? AND tk.trangThai = 1";
			stmt = con.prepareStatement(sqlCheck);
			stmt.setString(1, tenDangNhap);
			stmt.setString(2, maNV);
			stmt.setInt(3, namSinh);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				// Bước 2: Nếu thông tin đúng, reset mật khẩu về 123456
				String maTK = rs.getString("maTK");
				rs.close();
				stmt.close();
				
				String sqlUpdate = "UPDATE TaiKhoan SET matKhau = ? WHERE maTK = ?";
				stmt = con.prepareStatement(sqlUpdate);
				stmt.setString(1, matKhauMoi);
				stmt.setString(2, maTK);
				
				int rowsAffected = stmt.executeUpdate();
				
				if (rowsAffected > 0) {
					return matKhauMoi; // Trả về mật khẩu mới
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null; // Thông tin không đúng hoặc lỗi
	}
}
