package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Model.Dao.DangNhapMainDao;
import Model.Entity.NhanVien;
import View.DangNhapMain;
import View.TrangChuBanHangMainGUI;
import View.TrangChuQuanLyMainGUI;
import View.LoadingLogin;
public class DangNhapMainController implements ActionListener {
	private DangNhapMain view;
	private DangNhapMainDao dao;
	
	// Các pattern regex cho validation
	private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{3,50}$");
	private static final Pattern PASSWORD_PATTERN = Pattern.compile("^.{6,}$");
	// định dạng mã nhân viên là 2 chữ cái đầu là NV
	private static final Pattern MANV_PATTERN = Pattern.compile("^NV\\d*$");
	private static final Pattern YEAR_PATTERN = Pattern.compile("^(19[6-9]\\d|20[0-2]\\d)$");
	
	public DangNhapMainController(DangNhapMain view) {
		this.view = view;
		this.dao = new DangNhapMainDao();
		initController();
	}

	private void initController() {
		view.getBtnLogin().addActionListener(this);
		view.getBtnExit().addActionListener(this);
		view.getBtnQuenMatKhau().addActionListener(this);
		view.getChkShow().addActionListener(this);
		view.getTxtUsername().addActionListener(this);
		view.getTxtPassword().addActionListener(this);
		view.getBtnQuayLaiDangNhap().addActionListener(this);
		view.getBtnNutQuenMatKhau().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		// nút đăng nhập
		if (source == view.getBtnLogin() || source == view.getTxtPassword()) {
			xuLyDangNhap();
		}
		
		// nút thoát
		else if (source == view.getBtnExit()) {
			int choice = JOptionPane.showConfirmDialog(view, 
					"Bạn có chắc muốn thoát?",
					"Xác nhận", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		
		// nút check hiển thị mật khẩu
		else if(source == view.getChkShow()) {
			if (view.getChkShow().isSelected()) {
				view.getTxtPassword().setEchoChar((char) 0);
			} else {
				view.getTxtPassword().setEchoChar('•');
			}
		}
		
		// nút quên mật khẩu
		else if(source == view.getBtnQuenMatKhau()) {
			// chuyển qua panel quên mật khẩu
		    view.showPanelQuenMatKhau();
		}
		
		// nút quay lại đăng nhập
		else if(source == view.getBtnQuayLaiDangNhap()) {
			// chuyển về panel đăng nhập
			view.showPanelDangNhap();
			// xóa dữ liệu panel quên mật khẩu
			view.getTxtUsernameQuenMatKhau().setText("");
			view.getTxtMaNhanVien().setText("");
			view.getTxtNamSinhNhanVien().setText("");
		}
		
		// nút xử lý quên mật khẩu
		else if(source == view.getBtnNutQuenMatKhau()) {
			xuLyQuenMatKhau();
		}
	}
	
	// Xử lý đăng nhập
	private void xuLyDangNhap() {
		String tenDangNhap = view.getTxtUsername().getText().trim();
		String matKhau = new String(view.getTxtPassword().getPassword()).trim();
		
		// Kiểm tra rỗng
		if (tenDangNhap.isEmpty()) {
			JOptionPane.showMessageDialog(view, 
					"Vui lòng nhập tên đăng nhập!",
					"Lỗi", JOptionPane.WARNING_MESSAGE);
			view.getTxtUsername().requestFocus();
			return;
		}
		
		if (matKhau.isEmpty()) {
			JOptionPane.showMessageDialog(view, 
					"Vui lòng nhập mật khẩu!",
					"Lỗi", JOptionPane.WARNING_MESSAGE);
			view.getTxtPassword().requestFocus();
			return;
		}
		
		// Validate username với regex
		if (!USERNAME_PATTERN.matcher(tenDangNhap).matches()) {
			JOptionPane.showMessageDialog(view, 
					"Tên đăng nhập không hợp lệ!\n" +
					"- Chỉ được chứa chữ cái, số và dấu gạch dưới\n" +
					"- Độ dài từ 3-50 ký tự",
					"Lỗi", JOptionPane.ERROR_MESSAGE);
			view.getTxtUsername().requestFocus();
			view.getTxtUsername().selectAll();
			return;
		}
		
		// Validate password với regex
		if (!PASSWORD_PATTERN.matcher(matKhau).matches()) {
			JOptionPane.showMessageDialog(view, 
					"Mật khẩu phải có ít nhất 6 ký tự!",
					"Lỗi", JOptionPane.ERROR_MESSAGE);
			view.getTxtPassword().requestFocus();
			view.getTxtPassword().selectAll();
			return;
		}
		
		// Thực hiện đăng nhập
		NhanVien nhanVien = dao.dangNhap(tenDangNhap, matKhau);
		
		if (nhanVien != null) {
			// Đăng nhập thành công
			String vaiTro = nhanVien.getVaiTro().trim();
			
			JOptionPane.showMessageDialog(view, 
					"Đăng nhập thành công!\n" +
					"Xin chào: " + nhanVien.getHoTen() + "\n" +
					"Vai trò: " + vaiTro,
					"Thông báo", JOptionPane.INFORMATION_MESSAGE);
			
			// Đóng form đăng nhập
			view.dispose();

			// hiệu ứng loading
			if ("Quản lý".equalsIgnoreCase(vaiTro) || "Quan ly".equalsIgnoreCase(vaiTro)) {
				SwingUtilities.invokeLater(() -> {
					LoadingLogin loading = new LoadingLogin(() -> {
						TrangChuQuanLyMainGUI trangChuQuanLy = new TrangChuQuanLyMainGUI();
						trangChuQuanLy.setVisible(true);
					});
					loading.setVisible(true);
				});
			} else {
				SwingUtilities.invokeLater(() -> {
					LoadingLogin loading = new LoadingLogin(() -> {
						TrangChuBanHangMainGUI trangChuBanHang = new TrangChuBanHangMainGUI();
						trangChuBanHang.setVisible(true);
					});
					loading.setVisible(true);
				});
			}
			
		} else {
			JOptionPane.showMessageDialog(view, 
					"Tên đăng nhập hoặc mật khẩu không đúng!\n" +
					"Hoặc tài khoản đã bị vô hiệu hóa.",
					"Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
			// Xóa mật khẩu và focus
			view.getTxtPassword().setText("");
			view.getTxtPassword().requestFocus();
		}
	}
	
	// Xử lý quên mật khẩu
	private void xuLyQuenMatKhau() {
		String tenDangNhap = view.getTxtUsernameQuenMatKhau().getText().trim();
		String maNV = view.getTxtMaNhanVien().getText().trim();
		String namSinhStr = view.getTxtNamSinhNhanVien().getText().trim();
		
		// Kiểm tra rỗng
		if (tenDangNhap.isEmpty()) {
			JOptionPane.showMessageDialog(view, 
					"Vui lòng nhập tên đăng nhập!",
					"Lỗi", JOptionPane.WARNING_MESSAGE);
			view.getTxtUsernameQuenMatKhau().requestFocus();
			return;
		}
		
		if (maNV.isEmpty()) {
			JOptionPane.showMessageDialog(view, 
					"Vui lòng nhập mã nhân viên!",
					"Lỗi", JOptionPane.WARNING_MESSAGE);
			view.getTxtMaNhanVien().requestFocus();
			return;
		}
		
		if (namSinhStr.isEmpty()) {
			JOptionPane.showMessageDialog(view, 
					"Vui lòng nhập năm sinh!",
					"Lỗi", JOptionPane.WARNING_MESSAGE);
			view.getTxtNamSinhNhanVien().requestFocus();
			return;
		}
		
		// Validate username với regex
		if (!USERNAME_PATTERN.matcher(tenDangNhap).matches()) {
			JOptionPane.showMessageDialog(view, 
					"Tên đăng nhập không hợp lệ!\n" +
					"- Chỉ được chứa chữ cái, số và dấu gạch dưới\n" +
					"- Độ dài từ 3-50 ký tự",
					"Lỗi", JOptionPane.ERROR_MESSAGE);
			view.getTxtUsernameQuenMatKhau().requestFocus();
			view.getTxtUsernameQuenMatKhau().selectAll();
			return;
		}
		
		// Validate mã nhân viên với regex (định dạng NV, ...)
		if (!MANV_PATTERN.matcher(maNV).matches()) {
			JOptionPane.showMessageDialog(view, 
					"Mã nhân viên không hợp lệ!\n" +
					"Định dạng đúng: NV",
					"Lỗi", JOptionPane.ERROR_MESSAGE);
			view.getTxtMaNhanVien().requestFocus();
			view.getTxtMaNhanVien().selectAll();
			return;
		}
		
		// Validate năm sinh với regex
		if (!YEAR_PATTERN.matcher(namSinhStr).matches()) {
			JOptionPane.showMessageDialog(view, 
					"Năm sinh không hợp lệ!\n" +
					"Năm sinh hợp lệ: 1965 - 2029",
					"Lỗi", JOptionPane.ERROR_MESSAGE);
			view.getTxtNamSinhNhanVien().requestFocus();
			view.getTxtNamSinhNhanVien().selectAll();
			return;
		}
		
		// Parse năm sinh
		int namSinh = Integer.parseInt(namSinhStr);
//		
//		// Kiểm tra năm sinh phải đủ 18 tuổi
//		int namHienTai = java.time.Year.now().getValue();
//		if (namHienTai - namSinh < 18) {
//			JOptionPane.showMessageDialog(view, 
//					"Nhân viên phải từ 18 tuổi trở lên!",
//					"Lỗi", JOptionPane.ERROR_MESSAGE);
//			view.getTxtNamSinhNhanVien().requestFocus();
//			view.getTxtNamSinhNhanVien().selectAll();
//			return;
//		}
		
		// Lấy mật khẩu từ database (đồng thời reset về 123456)
		String matKhau = dao.layMatKhau(tenDangNhap, maNV, namSinh);
		
		if (matKhau != null) {
			JOptionPane.showMessageDialog(view, 
					"✅ Xác thực thành công!\n\n" +
					"Mật khẩu của bạn đã được đặt lại thành: " + matKhau + "\n\n" +
					"⚠️ Vui lòng đăng nhập và đổi mật khẩu mới để bảo mật!",
					"Khôi phục mật khẩu thành công", JOptionPane.INFORMATION_MESSAGE);
			
			// Quay lại màn hình đăng nhập và điền sẵn thông tin
			view.showPanelDangNhap();
			view.getTxtUsername().setText(tenDangNhap);
			view.getTxtPassword().setText("");
			view.getTxtPassword().requestFocus();
			
			// Xóa dữ liệu panel quên mật khẩu
			view.getTxtUsernameQuenMatKhau().setText("");
			view.getTxtMaNhanVien().setText("");
			view.getTxtNamSinhNhanVien().setText("");
		} else {
			JOptionPane.showMessageDialog(view, 
					"Thông tin không chính xác!\n" +
					"Vui lòng kiểm tra lại:\n" +
					"- Tên đăng nhập\n" +
					"- Mã nhân viên (VD: NV)\n" +
					"- Năm sinh",
					"Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}
}

