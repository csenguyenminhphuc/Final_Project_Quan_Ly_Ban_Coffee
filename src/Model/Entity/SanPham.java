package Model.Entity;

public class SanPham {
	private String maSP;
	private String tenSP;
	private double giaBan;
	private boolean trangThai;
	private String maDM;
	
	// Thông tin danh mục (để hiển thị)
	private String tenDM;
	
	public SanPham() {
	}
	
	public SanPham(String maSP, String tenSP, double giaBan, boolean trangThai, String maDM) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaBan = giaBan;
		this.trangThai = trangThai;
		this.maDM = maDM;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getMaDM() {
		return maDM;
	}

	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}

	public String getTenDM() {
		return tenDM;
	}

	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
	}

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", giaBan=" + giaBan + 
				", trangThai=" + trangThai + ", maDM=" + maDM + "]";
	}
}
