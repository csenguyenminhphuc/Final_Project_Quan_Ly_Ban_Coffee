package Model.Entity;

public class DanhMucSanPham {
	private String maDM;
	private String tenDM;
	
	public DanhMucSanPham() {
	}
	
	public DanhMucSanPham(String maDM, String tenDM) {
		this.maDM = maDM;
		this.tenDM = tenDM;
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
		return "DanhMucSanPham [maDM=" + maDM + ", tenDM=" + tenDM + "]";
	}
}
