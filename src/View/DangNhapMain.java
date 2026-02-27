package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DangNhapMain extends JFrame{
	public DangNhapMain() {
		setTitle("Hệ thống Bán Cà Phê");
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		createGUI();
	}
	
	public void createGUI() {
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		add(panelMain, BorderLayout.CENTER);
		
		
	}

}
