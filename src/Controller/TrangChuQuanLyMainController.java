package Controller;


import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import View.DangNhapMain;
import View.TrangChuQuanLyMainGUI;

public class TrangChuQuanLyMainController implements ActionListener, MouseListener {
	private TrangChuQuanLyMainGUI view;
	
	public TrangChuQuanLyMainController(View.TrangChuQuanLyMainGUI view) {
		this.view = view;
		initController();
	}
	
	private void initController() {
		// TODO Auto-generated method stub
		view.getItemThoat().addActionListener(this);
		view.getMainTabs().addMouseListener(this);
		view.getItemContact().addActionListener(this);
		view.getItemHelp().addActionListener(this);
		view.getItemInfo().addActionListener(this);
		view.getItemZoomIn().addActionListener(this);
		view.getItemZoomOut().addActionListener(this);
		view.getItemChinhGiaoDienSang().addActionListener(this);
		view.getItemChinhGiaoDienToi().addActionListener(this);
		view.getItemDangXuat().addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if (source == view.getItemThoat()) {
			int choice = javax.swing.JOptionPane.showConfirmDialog(view, 
					"Bạn có chắc muốn thoát?",
					"Xác nhận", javax.swing.JOptionPane.YES_NO_OPTION);
			if (choice == javax.swing.JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		
		else if (source == view.getItemDangXuat()) {
			int choice = javax.swing.JOptionPane.showConfirmDialog(view, 
					"Bạn có chắc muốn Đăng Xuất không?",
					"Xác nhận", javax.swing.JOptionPane.YES_NO_OPTION);
			if (choice == javax.swing.JOptionPane.YES_OPTION) {
				view.dispose();
				// hoặc nếu có form login thì mở form login ở đây
				DangNhapMain dangNhapMain = new DangNhapMain();
		        dangNhapMain.setVisible(true);
			}
		}
		else if (source == view.getItemContact()) {
			JOptionPane.showMessageDialog(view, 
					"Liên hệ hỗ trợ:\nEmail: csephuc@gmail.com"
					+ "\nSĐT: 0363590169\nĐịa chỉ: 12 Nguyễn Văn Bảo, Phường Hạnh Thông, TP.HCM",
					"Thông tin liên hệ", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else if (source == view.getItemHelp()) {
			JOptionPane.showMessageDialog(view, 
					"Truy cập tài liệu hướng dẫn sử dụng tại:\nhttps://github.com/csenguyenminhphucphuc/Final_Project_Quan_Ly_Ban_Coffee",
					"Hướng dẫn sử dụng", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (source == view.getItemInfo()) {
			JOptionPane.showMessageDialog(view, 
					"Phần mềm quản lý bán cà phê\nPhiên bản 1.0\nĐược phát triển bởi Nguyễn Minh Phúc và các cộng sự\n© 2026 All rights reserved.",
					"Thông tin phần mềm", JOptionPane.INFORMATION_MESSAGE);
		}
		 else if (source == view.getItemChinhGiaoDienSang()) {
			 view.setLightTheme(); 
		 }
		 else if (source == view.getItemChinhGiaoDienToi()) {
			 view.setDarkTheme(); 
		 }
		 else if (source == view.getItemZoomIn()) {
			 view.zoomIn();
		 }
		 else if (source == view.getItemZoomOut()) {
			 view.zoomOut();
		 }

		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		// set nút thoát lắng nghe sự kiện 
		int index = view.getMainTabs().getSelectedIndex();
		String tabName = view.getMainTabs().getTitleAt(index);
		if("Đăng Xuất".equals(tabName)) {
			int choice = javax.swing.JOptionPane.showConfirmDialog(view, 
					"Bạn có chắc muốn Đăng Xuất không?",
					"Xác nhận", javax.swing.JOptionPane.YES_NO_OPTION);
			if (choice == javax.swing.JOptionPane.YES_OPTION) {
				view.dispose();
				// hoặc nếu có form login thì mở form login ở đây
				DangNhapMain dangNhapMain = new DangNhapMain();
		        dangNhapMain.setVisible(true);
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
