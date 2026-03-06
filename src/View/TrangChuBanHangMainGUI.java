package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import View.BanHang.TrangChuBanHangGUI;
import View.QuanLy.TrangChuQuanLyGUI;

public class TrangChuBanHangMainGUI extends JFrame {
	private JPanel panelCenter;
	private JPanel panelWest;
	private JButton btnThongTinCaNhan;
	private JTabbedPane mainTabs;
	private JPanel panelBtnThongTinCaNhan;
	private JMenuBar menuBar;
	private TrangChuQuanLyGUI trangChuQuanLyGUI;
	private TrangChuBanHangGUI trangChuBanHangGUI;
	private JMenu menuCaiDat;
	private JMenu menuChucNag;
	private JMenu menuAbout;
	private JMenuItem itemInfo;
	private JMenuItem itemHelp;
	private JMenuItem itemContact;
	private JMenuItem itemThoat;
	private JMenuItem itemCaiDatTaiKhoan;
	private JMenuItem itemChinhGiaoDienSang;
	private JMenuItem itemChinhGiaoDienToi;
	private JMenuItem itemZoomIn;
	private JMenuItem itemZoomOut;
	private JMenuItem itemDangXuat;

	public TrangChuBanHangMainGUI() {
		// đặt size chuẩn trước
		setSize(1400, 870);
		// sau đó mới maximize
		createGUI();
		CreateMenuBar();
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		// khai báo controller bên trong đây
		new Controller.TrangChuBanHangMainController(this);
	}
	

	public void createGUI() {
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		add(panelMain);
		// Đặt biểu tượng cho cửa sổ
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/logo.png"));
		setIconImage(logo.getImage());
		// Panel North
		
		JPanel panelNorth = new JPanel();
		panelMain.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout());
		JLabel lblTitle = new JLabel(
			    "<html><div style='text-align:center;'>"
			    + "<p>Hệ Thống Quản Lý Bán Coffee</p>"
			    + "<p>Chất lượng tạo nên thương hiệu</p>"
			    + "</div></html>"
			);
		lblTitle.setHorizontalAlignment(JLabel.CENTER); // Tăng kích thước font
		lblTitle.setFont(new Font("Arial", Font.BOLD,25)); // Tăng kích thước font
		panelNorth.add(lblTitle, BorderLayout.CENTER);
		JLabel lblIcon = new JLabel();
		ImageIcon icon = new ImageIcon(
			    getClass().getResource("/logo.png")
			);

		Image scaled = icon.getImage()
			        .getScaledInstance(100, 100, Image.SCALE_SMOOTH);

			lblIcon.setIcon(new ImageIcon(scaled));
		lblIcon.setBorder(
			    BorderFactory.createEmptyBorder(10, 10, 10, 10)
			);
		lblIcon.setHorizontalAlignment(JLabel.LEFT);
		panelNorth.add(lblIcon, BorderLayout.WEST);
		
		panelBtnThongTinCaNhan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
		
		btnThongTinCaNhan = new JButton("Tài Khoản");
		btnThongTinCaNhan.setFont(new Font("Arial", Font.BOLD, 14));
		btnThongTinCaNhan.setIcon( new FlatSVGIcon("user.svg", 25, 25));
		btnThongTinCaNhan.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelBtnThongTinCaNhan.add(btnThongTinCaNhan);
		panelBtnThongTinCaNhan.setBorder(
			    BorderFactory.createEmptyBorder(10, 10, 10, 10)
			);
		panelNorth.add(panelBtnThongTinCaNhan, BorderLayout.EAST);
		btnThongTinCaNhan.setPreferredSize(new java.awt.Dimension(130, 40));

		// Panel Center
		panelCenter = new JPanel();
		// ================= CENTER =================
		mainTabs = new JTabbedPane(JTabbedPane.LEFT);
		mainTabs.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mainTabs.putClientProperty("JTabbedPane.tabHeight", 67);
		mainTabs.putClientProperty("JTabbedPane.showTabSeparators", true);
		mainTabs.putClientProperty("JTabbedPane.tabAreaAlignment", "leading");
		mainTabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		// ================= Trang Chủ =================
		
		trangChuQuanLyGUI = new TrangChuQuanLyGUI();
		mainTabs.addTab("Trang Chủ", new FlatSVGIcon("home.svg", 22, 22), trangChuQuanLyGUI);
		trangChuQuanLyGUI.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		// Khởi tạo controller cho TrangChuGUI
		new Controller.QuanLy.TrangChuQuanLyController(trangChuQuanLyGUI);

		// ================= BÁN HÀNG =================
		trangChuBanHangGUI = new TrangChuBanHangGUI();
		mainTabs.addTab("Bán Hàng", new FlatSVGIcon("Banhang.svg", 22, 22), trangChuBanHangGUI);


		// ================= Hóa Đơn =================
		JPanel panelHoaDon = new JPanel();
		panelHoaDon.add(new JLabel("Nội dung Hóa Đơn"));
		mainTabs.addTab("Hóa Đơn", new FlatSVGIcon("bill.svg", 22, 22), panelHoaDon);


		// ================= DANH MỤC =================
		JPanel panelDanhMuc = new JPanel(new BorderLayout());

		// Tạo tab con
		JTabbedPane danhMucTabs = new JTabbedPane();
		danhMucTabs.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		danhMucTabs.putClientProperty("JTabbedPane.tabHeight", 45);

		// ===== Tab Sản Phẩm =====
		JPanel panelSanPham = new JPanel();
		panelSanPham.add(new JLabel("Quản lý Sản Phẩm tại đây"));

		danhMucTabs.addTab("Sản Phẩm", panelSanPham);

		// ===== Tab Voucher =====
		JPanel panelVoucher = new JPanel();
		panelVoucher.add(new JLabel("Quản lý Voucher tại đây"));

		danhMucTabs.addTab("Voucher", panelVoucher);

		// Add tab con vào panel cha
		panelDanhMuc.add(danhMucTabs, BorderLayout.CENTER);

		// Add vào sidebar
		mainTabs.addTab("Danh Mục", 
		        new FlatSVGIcon("Danhmuc.svg", 22, 22), 
		        panelDanhMuc);

		// ================= Menu =================
		JPanel panelMenu = new JPanel();
		panelMenu.add(new JLabel("Nội dung Menu"));
		mainTabs.addTab("Menu", new FlatSVGIcon("menu.svg", 22, 22), panelMenu);


		// ================= Khách Hàng =================
		JPanel panelKhachHang = new JPanel();
		panelKhachHang.add(new JLabel("Nội dung Khách Hàng"));
		mainTabs.addTab("Khách Hàng", new FlatSVGIcon("Khachhang.svg", 22, 22), panelKhachHang);


		// ================= Nhân Viên =================
		JPanel panelNhanVien = new JPanel();
		panelNhanVien.add(new JLabel("Nội dung Nhân Viên"));
		//mainTabs.addTab("Nhân Viên", new FlatSVGIcon("Nhanvien.svg", 22, 22), panelNhanVien);


		// ================= Thống Kê =================
		JPanel panelThongKe = new JPanel();
		panelThongKe.add(new JLabel("Nội dung Thống Kê"));
		//mainTabs.addTab("Thống Kê", new FlatSVGIcon("Thongke.svg", 22, 22), panelThongKe);
		
		// ================= Thống Kê =================
		JPanel panelAI = new JPanel();
		panelAI.add(new JLabel("Nội dung AI"));
		mainTabs.addTab("Chat AI", new FlatSVGIcon("AI.svg", 22, 22), panelAI);

		// ================= Đăng Xuất =================
		JPanel panelDangXuat = new JPanel();
		mainTabs.addTab("Đăng Xuất", new FlatSVGIcon("logout.svg", 22, 22), panelDangXuat);
		
		// ===== Add vào CENTER =====
		// 1️⃣ Tạo JScrollPane chứa tab
//		JScrollPane scrollTabs = new JScrollPane(mainTabs);
//
//		// 2️⃣ Chỉ cho scroll theo chiều dọc
//		scrollTabs.setVerticalScrollBarPolicy(
//		        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollTabs.setHorizontalScrollBarPolicy(
//				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelCenter.setLayout(new BorderLayout());
		
		panelCenter.add(mainTabs, BorderLayout.CENTER);
		// 4️⃣ Đặt vào WEST (không đặt CENTER)
		panelMain.add(panelCenter, BorderLayout.CENTER);
		
		
		// ================= PANEL SOUTH - THÔNG TIN BẢN QUYỀN =================
		JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JLabel lblCopyright = new JLabel(
			    "© 2026 Nguyễn Minh Phúc - 22637001. All rights reserved."
			);
		lblCopyright.setFont(new Font("Arial", Font.PLAIN, 12));
		panelSouth.add(lblCopyright);
		panelMain.add(panelSouth, BorderLayout.SOUTH);
		
		panelCenter.setBorder(BorderFactory.createLineBorder( new java.awt.Color(200, 200, 200), 1));
		
	}
	
	public void CreateMenuBar() {
	    menuBar = new JMenuBar();

	    // Menu "About"
	    menuAbout = new JMenu("About");
	    menuAbout.setFont(new Font("Arial", Font.BOLD, 14));
	    itemInfo = new JMenuItem("Thông tin");
	    itemHelp = new JMenuItem("Hướng dẫn sử dụng");
	    itemContact = new JMenuItem("Liên hệ hỗ trợ");
	    itemDangXuat = new JMenuItem("Đăng Xuất");
	    itemThoat = new JMenuItem("Thoát");
	    
	    menuAbout.add(itemInfo);
	    menuAbout.add(itemHelp);
	    menuAbout.add(itemContact);
	    menuAbout.add(itemDangXuat);
	    menuAbout.addSeparator(); // Thêm đường phân cách
	    menuAbout.add(itemThoat);
	    // Menu "Cài Đặt"
	    menuCaiDat = new JMenu("Cài Đặt");
	    menuCaiDat.setFont(new Font("Arial", Font.BOLD, 14));
	    itemCaiDatTaiKhoan = new JMenuItem("Cài Đặt Tài Khoản");
	    itemChinhGiaoDienSang = new JMenuItem("Chỉnh Giao Diện Sáng");
	    itemChinhGiaoDienToi = new JMenuItem("Chỉnh Giao Diện Tối");
	    menuCaiDat.add(itemCaiDatTaiKhoan);
	    menuCaiDat.add(itemChinhGiaoDienSang);
	    menuCaiDat.add(itemChinhGiaoDienToi);
	    
	    // Zoom
	    JMenu menuZoom = new JMenu("Zoom");
	    menuZoom.setFont(new Font("Arial", Font.BOLD, 14));
	    itemZoomIn = new JMenuItem("Zoom In");
	    itemZoomOut = new JMenuItem("Zoom Out");
	    menuZoom.add(itemZoomIn);
	    menuZoom.add(itemZoomOut);
	    
	    
	    // menubar add
	    menuBar.add(menuZoom);
	    menuBar.add(menuCaiDat);
	    menuBar.add(menuAbout);

	    setJMenuBar(menuBar);
	    
	}


	public JButton getBtnThongTinCaNhan() {
		return btnThongTinCaNhan;
	}


	public void setBtnThongTinCaNhan(JButton btnThongTinCaNhan) {
		this.btnThongTinCaNhan = btnThongTinCaNhan;
	}



	public JMenu getMenuCaiDat() {
		return menuCaiDat;
	}


	public void setMenuCaiDat(JMenu menuCaiDat) {
		this.menuCaiDat = menuCaiDat;
	}


	public JMenu getMenuChucNag() {
		return menuChucNag;
	}


	public void setMenuChucNag(JMenu menuChucNag) {
		this.menuChucNag = menuChucNag;
	}


	public JMenu getMenuAbout() {
		return menuAbout;
	}


	public void setMenuAbout(JMenu menuAbout) {
		this.menuAbout = menuAbout;
	}


	public JMenuItem getItemInfo() {
		return itemInfo;
	}


	public void setItemInfo(JMenuItem itemInfo) {
		this.itemInfo = itemInfo;
	}


	public JMenuItem getItemHelp() {
		return itemHelp;
	}


	public void setItemHelp(JMenuItem itemHelp) {
		this.itemHelp = itemHelp;
	}


	public JMenuItem getItemContact() {
		return itemContact;
	}


	public void setItemContact(JMenuItem itemContact) {
		this.itemContact = itemContact;
	}
	public JMenuItem getItemDangXuat() {
		return itemDangXuat;
	}

	public void setItemDangXuat(JMenuItem itemDangXuat) {
		this.itemDangXuat = itemDangXuat;
	}

	public JMenuItem getItemThoat() {
		return itemThoat;
	}


	public void setItemThoat(JMenuItem itemThoat) {
		this.itemThoat = itemThoat;
	}


	public JMenuItem getItemCaiDatTaiKhoan() {
		return itemCaiDatTaiKhoan;
	}


	public void setItemCaiDatTaiKhoan(JMenuItem itemCaiDatTaiKhoan) {
		this.itemCaiDatTaiKhoan = itemCaiDatTaiKhoan;
	}


	public JMenuItem getItemChinhGiaoDienSang() {
		return itemChinhGiaoDienSang;
	}


	public void setItemChinhGiaoDienSang(JMenuItem itemChinhGiaoDienSang) {
		this.itemChinhGiaoDienSang = itemChinhGiaoDienSang;
	}


	public JMenuItem getItemChinhGiaoDienToi() {
		return itemChinhGiaoDienToi;
	}


	public void setItemChinhGiaoDienToi(JMenuItem itemChinhGiaoDienToi) {
		this.itemChinhGiaoDienToi = itemChinhGiaoDienToi;
	}


	public JMenuItem getItemZoomIn() {
		return itemZoomIn;
	}


	public void setItemZoomIn(JMenuItem itemZoomIn) {
		this.itemZoomIn = itemZoomIn;
	}


	public JMenuItem getItemZoomOut() {
		return itemZoomOut;
	}


	public void setItemZoomOut(JMenuItem itemZoomOut) {
		this.itemZoomOut = itemZoomOut;
	}
	
	/**
	 * Lấy TrangChuQuanLyGUI để kết nối với các view khác
	 */
	public TrangChuQuanLyGUI getTrangChuQuanLyGUI() {
		return trangChuQuanLyGUI;
	}
	
	public JTabbedPane getMainTabs() {
		return mainTabs;
	}

	public void setMainTabs(JTabbedPane mainTabs) {
		this.mainTabs = mainTabs;
	}
	
	
	// ================= THEME =================
	public void setLightTheme() {
	    try {
	        UIManager.setLookAndFeel(new FlatLightLaf());
	        SwingUtilities.updateComponentTreeUI(this);
	        this.repaint();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void setDarkTheme() {
	    try {
	        UIManager.setLookAndFeel(new FlatDarkLaf());
	        SwingUtilities.updateComponentTreeUI(this);
	        this.repaint();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void zoomIn() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public void zoomOut() {
		
		setExtendedState(JFrame.NORMAL);
		setSize(1400, 870);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	

	
	/**
	 * Lấy TrangChuBanHangGUI để kết nối với các view khác
	 */
	public TrangChuBanHangGUI getTrangChuBanHangGUI() {
		return trangChuBanHangGUI;
	}

}
