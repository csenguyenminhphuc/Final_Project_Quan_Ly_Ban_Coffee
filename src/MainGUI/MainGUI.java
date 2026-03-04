package MainGUI;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import View.DangNhapMain;
import View.LoadingLogin;
import View.TrangChuBanHangMainGUI;
import View.TrangChuQuanLyMainGUI;

public class MainGUI {
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("MenuBar.embedded", false);
        } catch (Exception e) {
            e.printStackTrace();	
        }
//
        DangNhapMain dangNhapMain = new DangNhapMain();
        dangNhapMain.setVisible(true);
		
        TrangChuQuanLyMainGUI trangChuMain = new TrangChuQuanLyMainGUI();
		
		TrangChuBanHangMainGUI trangChuBanHangMain = new TrangChuBanHangMainGUI();
		
//		LoadingLogin loadingLogin = new LoadingLogin();
//		loadingLogin.setVisible(true);
		
//		 Kết nối 2 view để đồng bộ file changes
//		 Khi Quản Lý thay đổi file -> Bán Hàng sẽ cập nhật theo
		trangChuMain.getTrangChuQuanLyGUI().addFileChangeListener(
				trangChuBanHangMain.getTrangChuBanHangGUI());

    }
}
