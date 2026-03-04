package Model.Entity;

public class TaiKhoan {
	private String maTK;
	private String tenDangNhap;
	private String matKhau;
	private boolean trangThai;
	private String maNV;
	
	// Thông tin nhân viên (để hiển thị)
	private String hoTen;
	private String vaiTro;
	
	public TaiKhoan() {
	}
	
	public TaiKhoan(String maTK, String tenDangNhap, String matKhau, boolean trangThai, String maNV) {
		this.maTK = maTK;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.trangThai = trangThai;
		this.maNV = maNV;
	}

	public String getMaTK() {
		return maTK;
	}

	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}

	@Override
	public String toString() {
		return "TaiKhoan [maTK=" + maTK + ", tenDangNhap=" + tenDangNhap + 
				", trangThai=" + trangThai + ", maNV=" + maNV + "]";
	}
}
