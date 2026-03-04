package Model.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HoaDon {
	private String maHD;
	private LocalDateTime thoiGianDat;
	private String maKH;
	private String maNV;
	private double tongTien;
	private String phuongThucThanhToan; // BANK, VIDIENTU, TIENMAT
	private Integer idKM; // Nullable
	private double tienGiam;
	private double thanhToan;
	
	// Thông tin khách hàng và nhân viên (để hiển thị)
	private String tenKH;
	private String sdtKH;
	private String tenNV;
	private String maKM;
	
	// Danh sách chi tiết hóa đơn
	private List<ChiTietHoaDon> danhSachChiTiet;
	
	public HoaDon() {
		this.danhSachChiTiet = new ArrayList<>();
	}
	
	public HoaDon(String maHD, LocalDateTime thoiGianDat, String maKH, String maNV, 
			double tongTien, String phuongThucThanhToan, Integer idKM, 
			double tienGiam, double thanhToan) {
		this.maHD = maHD;
		this.thoiGianDat = thoiGianDat;
		this.maKH = maKH;
		this.maNV = maNV;
		this.tongTien = tongTien;
		this.phuongThucThanhToan = phuongThucThanhToan;
		this.idKM = idKM;
		this.tienGiam = tienGiam;
		this.thanhToan = thanhToan;
		this.danhSachChiTiet = new ArrayList<>();
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public LocalDateTime getThoiGianDat() {
		return thoiGianDat;
	}

	public void setThoiGianDat(LocalDateTime thoiGianDat) {
		this.thoiGianDat = thoiGianDat;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public String getPhuongThucThanhToan() {
		return phuongThucThanhToan;
	}

	public void setPhuongThucThanhToan(String phuongThucThanhToan) {
		this.phuongThucThanhToan = phuongThucThanhToan;
	}

	public Integer getIdKM() {
		return idKM;
	}

	public void setIdKM(Integer idKM) {
		this.idKM = idKM;
	}

	public double getTienGiam() {
		return tienGiam;
	}

	public void setTienGiam(double tienGiam) {
		this.tienGiam = tienGiam;
	}

	public double getThanhToan() {
		return thanhToan;
	}

	public void setThanhToan(double thanhToan) {
		this.thanhToan = thanhToan;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getSdtKH() {
		return sdtKH;
	}

	public void setSdtKH(String sdtKH) {
		this.sdtKH = sdtKH;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getMaKM() {
		return maKM;
	}

	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}

	public List<ChiTietHoaDon> getDanhSachChiTiet() {
		return danhSachChiTiet;
	}

	public void setDanhSachChiTiet(List<ChiTietHoaDon> danhSachChiTiet) {
		this.danhSachChiTiet = danhSachChiTiet;
	}

	public void themChiTiet(ChiTietHoaDon chiTiet) {
		this.danhSachChiTiet.add(chiTiet);
	}

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", thoiGianDat=" + thoiGianDat + 
				", maKH=" + maKH + ", maNV=" + maNV + ", tongTien=" + tongTien + 
				", thanhToan=" + thanhToan + "]";
	}
}
