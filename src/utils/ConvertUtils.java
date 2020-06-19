package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertUtils {
    public ConvertUtils() {

    }

    public static ConvertUtils getInstance() {
        return new ConvertUtils();
    }

    public String convertDateTime(int timestamp) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date(timestamp * 1000L));
    }
}
