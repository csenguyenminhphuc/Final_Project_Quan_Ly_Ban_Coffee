package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import com.formdev.flatlaf.extras.FlatSVGIcon;

public class LoadingLogin extends JFrame {
	private JProgressBar progressBar;
	private JLabel lblLoading;

	// THÊM: biến để chứa hành động mở form sau khi load xong
	private Runnable onFinish;

	public LoadingLogin() {
		setTitle("Loading...");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		createGUI();
		startLoading();
	}

	// THÊM: constructor mới để truyền hành động cần chạy sau khi loading xong
	public LoadingLogin(Runnable onFinish) {
		this.onFinish = onFinish;

		setTitle("Loading...");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		createGUI();
		startLoading();
	}

	public void createGUI() {
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		add(panelMain);

		lblLoading = new JLabel("Đang tải dữ liệu, vui lòng chờ...", SwingConstants.CENTER);
		lblLoading.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panelMain.add(lblLoading, BorderLayout.NORTH);
		
		JLabel lblImg = new JLabel();
		lblImg.setIcon(new FlatSVGIcon("loading.svg", 150, 150));
		panelMain.add(lblImg);
		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true); // hiện % trên thanh
		progressBar.setPreferredSize(new java.awt.Dimension(400, 30));
		progressBar.setFont(new Font("Times New Roman", Font.BOLD, 19));

		panelMain.add(progressBar);
	}

	public void startLoading() {
		Timer timer = new Timer(50, e -> {
			int value = progressBar.getValue();

			if (value < 100) {
				value += 3;

				// THÊM: tránh vượt quá 100
				if (value > 100) {
					value = 100;
				}

				progressBar.setValue(value);
			} else {
				((Timer) e.getSource()).stop();
				lblLoading.setText("Thành Công, Chúc bạn làm việc hiệu quả!");

				// Nếu muốn tự đóng sau 1.5 giây thì mở đoạn này
				new Timer(2000, ev -> {
					((Timer) ev.getSource()).stop();
					dispose();

					// THÊM: nếu có hành động sau khi load xong thì chạy
					if (onFinish != null) {
						onFinish.run();
					}

					// Mở form login hoặc trang chủ ở đây
					// new LoginGUI().setVisible(true);
				}).start();
			}
		});

		timer.start();
	}
}