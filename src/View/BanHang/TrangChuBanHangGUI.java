package View.BanHang;

import javax.swing.*;

import View.FileChangeListener;

import java.awt.*;
import java.io.*;
import java.util.prefs.Preferences;

public class TrangChuBanHangGUI extends JPanel implements FileChangeListener {
	
	// 3 Panel chính
	private JPanel panelNorth;   // Panel tiêu đề
	private JPanel panelCenter;  // Panel nội dung
	private JPanel panelSouth;   // Panel buttons
	
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JButton btnLoadRTF;
	private JButton btnSave;
	private JButton btnClear;
	private JLabel lblTitle;
	
	// Lưu đường dẫn file
	private static final String PREF_KEY_FILE_PATH = "last_rtf_file_path";
	private Preferences prefs;
	private String currentFilePath;

	public TrangChuBanHangGUI() {
		prefs = Preferences.userNodeForPackage(TrangChuBanHangGUI.class);
		initComponents();
		autoLoadLastFile();
	}
	
	private void initComponents() {
		// Layout chính: BorderLayout với 3 vùng NORTH, CENTER, SOUTH
		setLayout(new BorderLayout());
		// ================= PANEL NORTH - TIÊU ĐỀ =================
		panelNorth = new JPanel(new BorderLayout());
		panelNorth.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		lblTitle = new JLabel("THÔNG BÁO", SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panelNorth.add(lblTitle, BorderLayout.CENTER);
		
		// Thêm panelNorth vào vị trí NORTH
		add(panelNorth, BorderLayout.NORTH);
		
		
		// ================= PANEL CENTER - NỘI DUNG =================
		panelCenter = new JPanel(new BorderLayout());
		panelCenter.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		
		// JTextArea để hiển thị nội dung text với font lớn
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true); // Tự động xuống dòng
		textArea.setWrapStyleWord(true); // Xuống dòng theo từ
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textArea.setMargin(new Insets(15, 15, 15, 15)); // Padding cho text
		
		// Scroll Pane với chính sách cuộn
		scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		panelCenter.add(scrollPane, BorderLayout.CENTER);
		
		// Thêm panelCenter vào vị trí CENTER
		add(panelCenter, BorderLayout.CENTER);
		
		
		// ================= PANEL SOUTH - BUTTONS =================
		panelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
		panelSouth.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		
		// Button Load RTF
		btnLoadRTF = new JButton("Chọn File");
		btnLoadRTF.setFont(new Font("Arial", Font.BOLD, 14));
		btnLoadRTF.setPreferredSize(new Dimension(150, 35));
		btnLoadRTF.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		// Button Save
		btnSave = new JButton("Lưu");
		btnSave.setFont(new Font("Arial", Font.BOLD, 14));
		btnSave.setPreferredSize(new Dimension(100, 35));
		btnSave.setBackground(new Color(46, 204, 113));
		btnSave.setForeground(Color.WHITE);
		btnSave.setFocusPainted(false);
		btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		// Button Clear
		btnClear = new JButton("Xóa");
		btnClear.setFont(new Font("Arial", Font.BOLD, 14));
		btnClear.setPreferredSize(new Dimension(100, 35));
		btnClear.setBackground(new Color(231, 76, 60));
		btnClear.setForeground(Color.WHITE);
		btnClear.setFocusPainted(false);
		btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
//		panelSouth.add(btnLoadRTF);
//		panelSouth.add(btnSave);
//		panelSouth.add(btnClear);
		
		// Thêm panelSouth vào vị trí SOUTH
//		add(panelSouth, BorderLayout.SOUTH);
	}
	
	/**
	 * Tự động load file đã lưu lần trước
	 */
	private void autoLoadLastFile() {
		String lastFilePath = prefs.get(PREF_KEY_FILE_PATH, null);
		if (lastFilePath != null && !lastFilePath.isEmpty()) {
			File file = new File(lastFilePath);
			if (file.exists()) {
				loadRTFFile(file);
			}
		}
	}
	
	/**
	 * Lấy button để controller xử lý sự kiện
	 */
	public JButton getBtnLoadRTF() {
		return btnLoadRTF;
	}
	
	public JButton getBtnSave() {
		return btnSave;
	}
	
	public JButton getBtnClear() {
		return btnClear;
	}
	
	/**
	 * Đọc và hiển thị file TXT
	 * @param file File TXT cần đọc
	 */
	public void loadRTFFile(File file) {
		try {
			String fileName = file.getName().toLowerCase();
			
			// Chỉ chấp nhận file .txt
			if (!fileName.endsWith(".txt")) {
				JOptionPane.showMessageDialog(this, 
					"Chỉ hỗ trợ file TXT!", 
					"Cảnh báo", 
					JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// Đọc file text thuần
			String content = readTextFile(file);
			
			// Hiển thị nội dung trong JTextArea
			textArea.setText(content);
			textArea.setCaretPosition(0); // Scroll to top
			
			// Lưu đường dẫn file hiện tại
			currentFilePath = file.getAbsolutePath();
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, 
				"Lỗi khi đọc file: " + ex.getMessage(), 
				"Lỗi", 
				JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}
	
	/**
	 * Đọc file text thuần
	 */
	private String readTextFile(File file) throws Exception {
		StringBuilder content = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}
		}
		return content.toString();
	}
	
	/**
	 * Đọc file từ đường dẫn
	 * @param filePath Đường dẫn đến file TXT
	 */
	public void loadRTFFile(String filePath) {
		loadRTFFile(new File(filePath));
	}
	
	/**
	 * Lưu đường dẫn file hiện tại
	 */
	public void saveCurrentFilePath() {
		if (currentFilePath != null && !currentFilePath.isEmpty()) {
			prefs.put(PREF_KEY_FILE_PATH, currentFilePath);
			int choice = JOptionPane.showConfirmDialog(this, 
				"Đã lưu đường dẫn file: " + currentFilePath + "\nBạn có muốn mở lại file này?", 
				"Thông báo", 
				JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(this, 
						"Đã lưu! File sẽ tự động load khi khởi động chương trình.", 
						"Thành công", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, 
				"Chưa có file nào được chọn!", 
				"Cảnh báo", 
				JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/**
	 * Xóa nội dung hiển thị và đường dẫn đã lưu
	 */
	public void clearContent() {
		int choice = JOptionPane.showConfirmDialog(this, 
			"Bạn có chắc muốn xóa nội dung và đường dẫn đã lưu?", 
			"Xác nhận", 
			JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			textArea.setText("");
			lblTitle.setText("THÔNG BÁO");
			currentFilePath = null;
			prefs.remove(PREF_KEY_FILE_PATH);
			
			// Refresh UI
			this.revalidate();
			this.repaint();
			
			JOptionPane.showMessageDialog(this, 
				"Đã xóa nội dung và file đã lưu!", 
				"Thông báo", 
				JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Lấy đường dẫn file hiện tại
	 */
	public String getCurrentFilePath() {
		return currentFilePath;
	}
	
	/**
	 * Được gọi khi file được thay đổi từ view khác (Quản Lý)
	 */
	@Override
	public void onFileChanged(String filePath) {
		if (filePath != null && !filePath.isEmpty()) {
			File file = new File(filePath);
			if (file.exists()) {
				loadRTFFile(file);
			}
		}
	}
	
	/**
	 * Được gọi khi file bị xóa từ view khác (Quản Lý)
	 */
	@Override
	public void onFileCleared() {
		textArea.setText("");
		lblTitle.setText("THÔNG BÁO");
		currentFilePath = null;
		prefs.remove(PREF_KEY_FILE_PATH);
		
		// Refresh UI
		this.revalidate();
		this.repaint();
	}
}

