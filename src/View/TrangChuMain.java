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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import com.formdev.flatlaf.extras.FlatSVGIcon;

public class TrangChuMain extends JFrame {
	private JPanel panelCenter;
	private JPanel panelWest;
	private JButton btnThongTinCaNhan;
	private JTabbedPane mainTabs;
	private JPanel panelBtnThongTinCaNhan;

	public TrangChuMain() {
		setTitle("Nhân Viên Quản Lý");
		// đặt size chuẩn trước
		setSize(1400, 850);
		// sau đó mới maximize
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		createGUI();
		
		// khai báo controller bên trong đây
		new Controller.TrangChuMainController(this);
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
			    + "<p><i>Dự án được thiết kế bởi Nguyễn Minh Phúc - 22637001</i></p>"
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
		JPanel panelTrangChu = new JPanel();
		panelTrangChu.add(new JLabel("Nội dung Trang Chủ"));
		mainTabs.addTab("Trang Chủ", new FlatSVGIcon("home.svg", 22, 22), panelTrangChu);
		panelTrangChu.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// ================= BÁN HÀNG =================
		JPanel panelBanHang = new JPanel(new BorderLayout());
		panelBanHang.setCursor(new Cursor(Cursor.HAND_CURSOR));
		// ===== Tab con sản phẩm =====
		JTabbedPane productTabs = new JTabbedPane();
		productTabs.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		productTabs.putClientProperty("JTabbedPane.tabHeight", 45);
		
		productTabs.addTab("Tất cả sản phẩm", new JPanel());
		productTabs.addTab("Coffee", new JPanel());
		productTabs.addTab("ICE Blended", new JPanel());
		productTabs.addTab("Fruit Tea", new JPanel());
		productTabs.addTab("Milk Tea", new JPanel());
		
		// ===== Panel thanh toán bên phải =====
		JPanel panelThanhToan = new JPanel();
		panelThanhToan.setPreferredSize(new java.awt.Dimension(550, 0));
		panelThanhToan.setBorder(BorderFactory.createTitledBorder("Thanh Toán"));
		panelThanhToan.add(new JLabel("Giỏ hàng / Thanh toán tại đây"));

		// ===== Ghép lại =====
		panelBanHang.add(productTabs, BorderLayout.CENTER);
		panelBanHang.add(panelThanhToan, BorderLayout.EAST);

		mainTabs.addTab("Bán Hàng", new FlatSVGIcon("Banhang.svg", 22, 22), panelBanHang);


		// ================= Hóa Đơn =================
		JPanel panelHoaDon = new JPanel();
		panelHoaDon.add(new JLabel("Nội dung Hóa Đơn"));
		mainTabs.addTab("Hóa Đơn", new FlatSVGIcon("bill.svg", 22, 22), panelHoaDon);


		// ================= Danh Mục =================
		JPanel panelDanhMuc = new JPanel();
		panelDanhMuc.add(new JLabel("Nội dung Danh Mục"));
		mainTabs.addTab("Danh Mục", new FlatSVGIcon("Danhmuc.svg", 22, 22), panelDanhMuc);


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
		mainTabs.addTab("Nhân Viên", new FlatSVGIcon("Nhanvien.svg", 22, 22), panelNhanVien);


		// ================= Thống Kê =================
		JPanel panelThongKe = new JPanel();
		panelThongKe.add(new JLabel("Nội dung Thống Kê"));
		mainTabs.addTab("Thống Kê", new FlatSVGIcon("Thongke.svg", 22, 22), panelThongKe);
		
		// ================= Thống Kê =================
		JPanel panelAI = new JPanel();
		panelAI.add(new JLabel("Nội dung AI"));
		mainTabs.addTab("Chat AI", new FlatSVGIcon("AI.svg", 22, 22), panelAI);

		// ================= Thoát =================
		JPanel panelThoat = new JPanel();
		mainTabs.addTab("Thoát", new FlatSVGIcon("logout.svg", 22, 22), panelThoat);
		
		// ===== Add vào CENTER =====
		// 1️⃣ Tạo JScrollPane chứa tab
		JScrollPane scrollTabs = new JScrollPane(mainTabs);

		// 2️⃣ Chỉ cho scroll theo chiều dọc
		scrollTabs.setVerticalScrollBarPolicy(
		        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTabs.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		// 4️⃣ Đặt vào WEST (không đặt CENTER)
		panelMain.add(scrollTabs, BorderLayout.CENTER);
		
		
	}

}
