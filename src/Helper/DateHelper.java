package Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");

    // Chuyển đổi String sang Date 
    /* với String cần chuyển là định dạng thời gian và sẽ return kết quả là Date */
    public static Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0) {
                DATE_FORMATER.applyPattern(pattern[0]);
            }
            if (date == null) {
                return DateHelper.now();
            }
            System.out.println(date);
            return DATE_FORMATER.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    // Chuyển đổi Date sang String
    // Date cần chuyển đổi là định dạng thời gian và sẽ return kết quả là String 
    public static String toString(Date date, String... pattern) {
        if (pattern.length > 0) {
            DATE_FORMATER.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = DateHelper.now();
        }
        return DATE_FORMATER.format(date);
    }

// lấy khoảng thời gian hiện tại
    public static Date now() {
        return new Date();
    }

// dùng bổ sung thêm ngày vào thời gian nếu cần
    public static Date addDays(Date date, int days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

    // Bổ sung số ngày vào thời gian hiện hành đang có
    // với days số ngày cần bổ sung vào thời gian hiện tại 
    public static Date add(int days) {
        Date now = DateHelper.now();
        now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
        return now;
    }
}
