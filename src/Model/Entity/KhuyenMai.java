package Model.Entity;

import java.time.LocalDateTime;

public class KhuyenMai {
	private int idKM;
	private String maKM;
	private String tenKM;
	private String loaiGiam; // PHANTRAM, CODINH
	private double giaTriGiam;
	private Double giamToiDa; // Nullable
	private double apDungChoTongTien;
	private LocalDateTime ngayBatDau;
	private LocalDateTime ngayKetThuc;
	private boolean trangThai;
	
	public KhuyenMai() {
	}
	
	public KhuyenMai(int idKM, String maKM, String tenKM, String loaiGiam, double giaTriGiam,
			Double giamToiDa, double apDungChoTongTien, LocalDateTime ngayBatDau, 
			LocalDateTime ngayKetThuc, boolean trangThai) {
		this.idKM = idKM;
		this.maKM = maKM;
		this.tenKM = tenKM;
		this.loaiGiam = loaiGiam;
		this.giaTriGiam = giaTriGiam;
		this.giamToiDa = giamToiDa;
		this.apDungChoTongTien = apDungChoTongTien;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.trangThai = trangThai;
	}

	public int getIdKM() {
		return idKM;
	}

	public void setIdKM(int idKM) {
		this.idKM = idKM;
	}

	public String getMaKM() {
		return maKM;
	}

	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}

	public String getTenKM() {
		return tenKM;
	}

	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}

	public String getLoaiGiam() {
		return loaiGiam;
	}

	public void setLoaiGiam(String loaiGiam) {
		this.loaiGiam = loaiGiam;
	}

	public double getGiaTriGiam() {
		return giaTriGiam;
	}

	public void setGiaTriGiam(double giaTriGiam) {
		this.giaTriGiam = giaTriGiam;
	}

	public Double getGiamToiDa() {
		return giamToiDa;
	}

	public void setGiamToiDa(Double giamToiDa) {
		this.giamToiDa = giamToiDa;
	}

	public double getApDungChoTongTien() {
		return apDungChoTongTien;
	}

	public void setApDungChoTongTien(double apDungChoTongTien) {
		this.apDungChoTongTien = apDungChoTongTien;
	}

	public LocalDateTime getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(LocalDateTime ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public LocalDateTime getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(LocalDateTime ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "KhuyenMai [idKM=" + idKM + ", maKM=" + maKM + ", tenKM=" + tenKM + 
				", loaiGiam=" + loaiGiam + ", giaTriGiam=" + giaTriGiam + 
				", trangThai=" + trangThai + "]";
	}
}
