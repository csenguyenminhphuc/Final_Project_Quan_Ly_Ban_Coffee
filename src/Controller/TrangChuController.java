package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import View.TrangChuGUI;

public class TrangChuController {
	
	private TrangChuGUI view;
	
	public TrangChuController(TrangChuGUI view) {
		this.view = view;
		initController();
	}
	
	private void initController() {
		// Xử lý sự kiện khi click nút Load RTF
		view.getBtnLoadRTF().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chonFileRTF();
			}
		});
		
		// Xử lý sự kiện khi click nút Lưu
		view.getBtnSave().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.saveCurrentFilePath();
			}
		});
		
		// Xử lý sự kiện khi click nút Xóa
		view.getBtnClear().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.clearContent();
			}
		});
	}
	
	/**
	 * Mở hộp thoại chọn file TXT và hiển thị nội dung
	 */
	private void chonFileRTF() {
		JFileChooser fileChooser = new JFileChooser();
		
		// Chỉ hỗ trợ file TXT
		FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Text Files (*.txt)", "txt");
		fileChooser.setFileFilter(txtFilter);
		
		fileChooser.setDialogTitle("Chọn File Thông Báo");
		
		// Set thư mục mặc định là thư mục data
		File defaultDir = new File("data");
		if (defaultDir.exists()) {
			fileChooser.setCurrentDirectory(defaultDir);
		}
		
		int result = fileChooser.showOpenDialog(view);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			view.loadRTFFile(selectedFile);
		}
	}

}
