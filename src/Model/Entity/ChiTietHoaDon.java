package Model.Entity;

public class ChiTietHoaDon {
	private String maCTHD;
	private String maHD;
	private String maSP;
	private double gia;
	private int soLuong;
	private double thanhTien;
	
	// Thông tin sản phẩm (để hiển thị)
	private String tenSP;
	
	public ChiTietHoaDon() {
	}
	
	public ChiTietHoaDon(String maCTHD, String maHD, String maSP, double gia, 
			int soLuong, double thanhTien) {
		this.maCTHD = maCTHD;
		this.maHD = maHD;
		this.maSP = maSP;
		this.gia = gia;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

	public String getMaCTHD() {
		return maCTHD;
	}

	public void setMaCTHD(String maCTHD) {
		this.maCTHD = maCTHD;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [maCTHD=" + maCTHD + ", maHD=" + maHD + ", maSP=" + maSP + 
				", gia=" + gia + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + "]";
	}
}
