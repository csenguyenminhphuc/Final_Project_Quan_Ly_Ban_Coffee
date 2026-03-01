package MainGUI;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import View.DangNhapMain;
import View.TrangChuMain;

public class MainGUI {
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("MenuBar.embedded", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
//
//        DangNhapMain dangNhapMain = new DangNhapMain();
//        dangNhapMain.setVisible(true);
		TrangChuMain trangChuMain = new TrangChuMain();
		trangChuMain.setVisible(true);

    }
}
