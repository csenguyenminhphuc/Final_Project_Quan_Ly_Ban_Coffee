package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.DangNhapMain;

public class DangNhapMainController implements ActionListener {
	private DangNhapMain view;
	
	public DangNhapMainController(DangNhapMain view) {
		this.view = view;
		initController();
	}

	private void initController() {
		view.getBtnLogin().addActionListener(this);
		view.getBtnExit().addActionListener(this);
		view.getBtnQuenMatKhau().addActionListener(this);
		view.getChkShow().addActionListener(this);
		view.getTxtUsername().addActionListener(this);
		view.getBtnQuayLaiDangNhap().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		// nút thoát
		if (source == view.getBtnExit()) {
			int choice = JOptionPane.showConfirmDialog(view, 
					"Bạn có chắc muốn thoát?",
					"Xác nhận", javax.swing.JOptionPane.YES_NO_OPTION);
			if (choice == javax.swing.JOptionPane.YES_OPTION) {
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
			// chuyển qua panel	quên mật khẩu
		    view.showPanelQuenMatKhau();
		}
		
		else if(source == view.getBtnQuayLaiDangNhap()) {
			// chuyển về panel đăng nhập
			view.showPanelDangNhap();
		}

		

	}
}
