package Helper;

//import Model.NhanVien;
import Entity.NguoiDung;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

public class ShareHelper {

    public static final Image APP_ICON;
    public static boolean theme = true;
    public static String mand = null;
    public static String mk = null;

    //Ảnh biểu tượng của ứng dụng, xuất hiện trên mọi cửa sổ
    static {
        String file = "/Icons/logo1.png";
        APP_ICON = new ImageIcon(ShareHelper.class.getResource(file)).getImage();
    }

    // Hàm này dùng để điều chỉnh kích thước hình ảnh sao cho phù hợp với label
    public static ImageIcon ResizeImage(String IMGPath, Component com) {
        Image img = new ImageIcon(IMGPath).getImage();
        Image newImg = img.getScaledInstance(com.getWidth(), com.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    //Sao chép file logo chuyên đề vào thư mục logo
    public static boolean saveLogo(File file) {
        File dir = new File("logos");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {
            Path source = Paths.get(file.getAbsolutePath());
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // fileName là tên truyền vào, sau đó sẽ return ảnh mới
    public static ImageIcon readLogo(String fileName) {
        File path = new File("logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

// đối tượng chứa thông tin người dùng sau khi đăng nhập (login) vào
    public static NguoiDung USER = null;
// xóa thông tin, chuyển về null khi có yêu cầu đăng xuất (logoff)

    public static void logoff() {
        ShareHelper.USER = null;
    }

// kiểm tra phần đăng nhập xem đã đăng nhập hay chưa ( true = đã đăng nhập và ngược lại)
    public static boolean authenticated() {
        return ShareHelper.USER != null;
    }

    // Kiểm tra có phải chủ trọ không
    public static boolean isManager() {
        return ShareHelper.authenticated() && USER.isVaiTro();
    }

}
