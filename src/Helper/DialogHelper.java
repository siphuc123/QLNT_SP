package Helper;

import java.awt.Component;
import javax.swing.JOptionPane;

public class DialogHelper {

// hiện thông báo
    public static void alert(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message);
    }

// hiện thông báo PHẢI được chấp thuận với yes = true và no = false và trả về true/false
    public static boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message, "Hệ thống quản lý nhà trọ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

// hiện thông báo cho nhập vào và trả về giá trị nhập
    public static String prompt(Component parent, String message) {
        return JOptionPane.showInputDialog(parent, message, "Hệ thống quản lý nhà trọ", JOptionPane.INFORMATION_MESSAGE);
    }
}
