package MainGUI;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import View.DangNhapMain;

public class MainGUI {
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        DangNhapMain dangNhapMain = new DangNhapMain();
        dangNhapMain.setVisible(true);
    }
}
