package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import com.formdev.flatlaf.extras.FlatSVGIcon;

public class DangNhapMain extends JFrame{
	private JButton btnQuenMatKhau;
	private JCheckBox chkShow;
	private JButton btnLogin;
	private JButton btnExit;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPanel panelMain;
	private JPanel panelRight;
	private JPanel panelQuenMatKhau;
	private JTextField txtUsernameQuenMatKhau;
	private JTextField txtMaNhanVien;
	private JButton btnQuayLaiDangNhap;
	private JButton btnNutQuenMatKhau;
	private JPanel slideContainer;
	private JTextField txtNamSinhNhanVien;
	
	public DangNhapMain() {
		setTitle("Hệ thống Bán Cà Phê");
		setSize(1050, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		createGUI();
		
		// khai báo controller bên trong đây
		new Controller.DangNhapMainController(this);
	}
	
	public void showPanelQuenMatKhau() {

	    int width = panelMain.getWidth() - 600;

	    slideContainer = new JPanel(null);
	    slideContainer.setPreferredSize(new Dimension(width, panelMain.getHeight()));

	    panelMain.remove(panelRight);
	    panelMain.add(slideContainer, BorderLayout.CENTER);

	    panelQuenMatKhau.setBounds(width, 0, width, panelMain.getHeight());
	    slideContainer.add(panelQuenMatKhau);

	    Timer timer = new Timer(5, null);

	    timer.addActionListener(new ActionListener() {

	        int x = width;

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            x -= 15;
	            panelQuenMatKhau.setLocation(x, 0);

	            if (x <= 0) {
	                panelQuenMatKhau.setLocation(0, 0);
	                timer.stop();
	            }
	        }
	    });

	    timer.start();

	    panelMain.revalidate();
	    panelMain.repaint();
	}
	
	public void showPanelDangNhap() {

	    int width = panelMain.getWidth() - 600;

	    slideContainer.removeAll();

	    panelRight.setBounds(-width, 0, width, panelMain.getHeight());
	    slideContainer.add(panelRight);

	    Timer timer = new Timer(5, null);

	    timer.addActionListener(new ActionListener() {

	        int x = -width;

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            x += 15;
	            panelRight.setLocation(x, 0);

	            if (x >= 0) {
	                panelRight.setLocation(0, 0);
	                timer.stop();

	                panelMain.remove(slideContainer);
	                panelMain.add(panelRight, BorderLayout.CENTER);
	                panelMain.revalidate();
	                panelMain.repaint();
	            }
	        }
	    });

	    timer.start();
	}
	
	public void createGUI() {
		panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		add(panelMain, BorderLayout.CENTER);
		
		// Đặt biểu tượng cho cửa sổ
		ImageIcon icon = new ImageIcon(getClass().getResource("/logo.png"));
		setIconImage(icon.getImage());
	
		
		// Panel Left
		JPanel panelLeft = new JPanel(); 
		panelLeft.setPreferredSize(new Dimension(600, 0));
		panelLeft.setLayout(new BorderLayout());
		
		JLabel lblImage = new JLabel();
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/logo.png"));
		Image image = imageIcon.getImage().getScaledInstance(550, 600, Image.SCALE_SMOOTH);
		lblImage.setIcon(new ImageIcon(image));
		
		panelLeft.add(lblImage, BorderLayout.CENTER);
		panelMain.add(panelLeft, BorderLayout.WEST);

		// Panel Right
		panelRight = new JPanel();
		panelRight.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel lblWelcome = new JLabel("ĐĂNG NHẬP HỆ THỐNG");
		lblWelcome.setFont(new Font("Arial", Font.BOLD, 23));
		lblWelcome.setBorder(BorderFactory.createEmptyBorder(100, 70, 50, 0));
		
		// username
		JPanel panelUsername = new JPanel();
		JLabel lblUsername = new JLabel("Tên đăng nhập:");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 16));
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 16));
		txtUsername.putClientProperty("JTextField.showClearButton", true);
		txtUsername.setPreferredSize(new Dimension(250, 40));
		panelUsername.add(lblUsername);
		panelUsername.add(txtUsername);
		
		// password
		JPanel panelPassword = new JPanel();
		JLabel lblPassword = new JLabel("Mật khẩu:          ");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		txtPassword.putClientProperty("JTextField.showClearButton", true);
		txtPassword.setPreferredSize(new Dimension(250, 40));
		
		panelPassword.add(lblPassword);
		panelPassword.add(txtPassword);
		
		// add panel vào panelRight
		panelRight.add(lblWelcome);
		panelRight.add(panelUsername);
		panelRight.add(panelPassword);
		panelMain.add(panelRight, BorderLayout.CENTER);
		
		JLabel lblhienthimk = new JLabel("                                    ");
		char defaultEchoChar = txtPassword.getEchoChar();

		// checkbox hiển thị mật khẩu
		chkShow = new JCheckBox("Hiện mật khẩu             ");
		chkShow.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnQuenMatKhau = new JButton("Quên mật khẩu?");
		btnQuenMatKhau.setFont(new Font(null, Font.ITALIC, 13));
		btnQuenMatKhau.setOpaque(false); 
		btnQuenMatKhau.setForeground(Color.BLUE);
		btnQuenMatKhau.setBorderPainted(false);      // bỏ viền
		btnQuenMatKhau.setContentAreaFilled(false);  // bỏ nền
		btnQuenMatKhau.setFocusPainted(false);
		btnQuenMatKhau.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelRight.add(lblhienthimk);
		panelRight.add(chkShow);
		panelRight.add(btnQuenMatKhau);
		
		// panel đăng nhập
		JPanel panelDangNhap = new JPanel();
		panelDangNhap.setLayout(new FlowLayout(FlowLayout.CENTER, 0,40));
		JLabel lblhihi = new JLabel("                                      ");
		btnLogin = new JButton("Đăng nhập");
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogin.setPreferredSize(new Dimension(250, 40));
		btnLogin.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnLogin.setBackground(Color.GREEN);
		panelDangNhap.add(lblhihi);
		panelDangNhap.add(btnLogin);
		panelRight.add(panelDangNhap);
		
		// panel thoát
		JPanel panelThoat = new JPanel();
		panelThoat.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		JLabel lblhihi2 = new JLabel("                                                                                         ");
		btnExit = new JButton("Thoát");
		btnExit.setFont(new Font("Arial", Font.BOLD, 16));
		btnExit.setForeground(Color.RED);
		btnExit.setPreferredSize(new Dimension(100, 30));
		btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnExit.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnExit.setIcon(
			    new FlatSVGIcon("logout.svg", 20, 20)
		);
		btnExit.setHorizontalTextPosition(SwingConstants.LEFT);
		panelThoat.add(lblhihi2);
		panelThoat.add(btnExit);
		panelRight.add(panelThoat);
		
		
		
		// Panel Quên mật khẩu
		panelQuenMatKhau = new JPanel();
		panelQuenMatKhau.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel lblQuenMatKhau = new JLabel("QUÊN MẬT KHẨU");
		lblQuenMatKhau.setFont(new Font("Arial", Font.BOLD, 23));
		lblQuenMatKhau.setBorder(BorderFactory.createEmptyBorder(100, 100, 50, 0));
		panelQuenMatKhau.add(lblQuenMatKhau);
		
		
		// username quên mật khẩu
		JPanel panelUsernameQuenMatKhau = new JPanel();
		JLabel lblUsernameQuenMatKhau = new JLabel("Tên đăng nhập:");
		lblUsernameQuenMatKhau.setFont(new Font("Arial", Font.PLAIN, 16));
		txtUsernameQuenMatKhau = new JTextField();
		txtUsernameQuenMatKhau.setFont(new Font("Arial", Font.PLAIN, 16));
		txtUsernameQuenMatKhau.putClientProperty("JTextField.showClearButton", true);
		txtUsernameQuenMatKhau.setPreferredSize(new Dimension(250, 40));
		panelUsernameQuenMatKhau.add(lblUsernameQuenMatKhau);
		panelUsernameQuenMatKhau.add(txtUsernameQuenMatKhau);
		panelQuenMatKhau.add(panelUsernameQuenMatKhau);
		
		// mã Nhân Viên quên mật khẩu
		JPanel panelMaNhanVien = new JPanel();
		JLabel lblMaNhanVien = new JLabel("Mã Nhân Viên: ");
		lblMaNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMaNhanVien.putClientProperty("JTextField.showClearButton", true);
		txtMaNhanVien.setPreferredSize(new Dimension(250, 40));
		panelMaNhanVien.add(lblMaNhanVien);
		panelMaNhanVien.add(txtMaNhanVien);
		panelQuenMatKhau.add(panelMaNhanVien);
		
		// Năm sinh quên mật khẩu
		JPanel panelNamSinhNhanVien = new JPanel();
		JLabel lblNamSinhNhanVien = new JLabel("Năm sinh:         ");
		lblNamSinhNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNamSinhNhanVien = new JTextField();
		txtNamSinhNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNamSinhNhanVien.putClientProperty("JTextField.showClearButton", true);
		txtNamSinhNhanVien.setPreferredSize(new Dimension(250, 40));
		panelNamSinhNhanVien.add(lblNamSinhNhanVien);
		panelNamSinhNhanVien.add(txtNamSinhNhanVien);
		panelQuenMatKhau.add(panelNamSinhNhanVien);
		
		
		// panel quên mật khẩu
		JPanel panelNutQuenMatKhau = new JPanel();
		panelNutQuenMatKhau.setLayout(new FlowLayout(FlowLayout.CENTER, 0,30));
		JLabel lblhihi01 = new JLabel("                                      ");
		btnNutQuenMatKhau = new JButton("Quên mật khẩu");
		btnNutQuenMatKhau.setFont(new Font("Arial", Font.BOLD, 16));
		btnNutQuenMatKhau.setPreferredSize(new Dimension(250, 40));
		btnNutQuenMatKhau.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnNutQuenMatKhau.setBackground(Color.GREEN);
		btnNutQuenMatKhau.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelNutQuenMatKhau.add(lblhihi01);
		panelNutQuenMatKhau.add(btnNutQuenMatKhau);
		panelQuenMatKhau.add(panelNutQuenMatKhau);
		
		
		// panel panelQuayLaiDangNhap
		JPanel panelQuayLaiDangNhap = new JPanel();
		panelQuayLaiDangNhap.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		JLabel lblhihi02 = new JLabel("                                      ");
		btnQuayLaiDangNhap = new JButton("Quay Lại Đăng Nhập");
		btnQuayLaiDangNhap.setFont(new Font("Arial", Font.BOLD, 16));
		btnQuayLaiDangNhap.setForeground(Color.RED);
		btnQuayLaiDangNhap.setPreferredSize(new Dimension(250, 40));
		btnQuayLaiDangNhap.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnQuayLaiDangNhap.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnQuayLaiDangNhap.setIcon(
			    new FlatSVGIcon("back.svg", 25, 25)
		);
		btnQuayLaiDangNhap.setHorizontalTextPosition(SwingConstants.RIGHT);
		panelQuayLaiDangNhap.add(lblhihi02);
		panelQuayLaiDangNhap.add(btnQuayLaiDangNhap);
		panelQuenMatKhau.add(panelQuayLaiDangNhap);
		
	}

	public JButton getBtnQuenMatKhau() {
		return btnQuenMatKhau;
	}

	public void setBtnQuenMatKhau(JButton btnQuenMatKhau) {
		this.btnQuenMatKhau = btnQuenMatKhau;
	}

	public JCheckBox getChkShow() {
		return chkShow;
	}

	public void setChkShow(JCheckBox chkShow) {
		this.chkShow = chkShow;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public void setTxtUsername(JTextField txtUsername) {
		this.txtUsername = txtUsername;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JPanel getPanelQuenMatKhau() {
		return panelQuenMatKhau;
	}

	public void setPanelQuenMatKhau(JPanel panelQuenMatKhau) {
		this.panelQuenMatKhau = panelQuenMatKhau;
	}

	public JPanel getPanelRight() {
		return panelRight;
	}

	public void setPanelRight(JPanel panelRight) {
		this.panelRight = panelRight;
	}

	public JButton getBtnQuayLaiDangNhap() {
		return btnQuayLaiDangNhap;
	}

	public void setBtnQuayLaiDangNhap(JButton btnQuayLaiDangNhap) {
		this.btnQuayLaiDangNhap = btnQuayLaiDangNhap;
	}

	public JButton getBtnNutQuenMatKhau() {
		return btnNutQuenMatKhau;
	}

	public void setBtnNutQuenMatKhau(JButton btnNutQuenMatKhau) {
		this.btnNutQuenMatKhau = btnNutQuenMatKhau;
	}

}
