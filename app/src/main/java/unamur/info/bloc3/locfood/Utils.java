package unamur.info.bloc3.locfood;

import java.util.Calendar;

public class Utils {

    public static String getSeason() {
        Calendar now = Calendar.getInstance();

        int monthDay = now.get(Calendar.MONTH) * 100 + now.get(Calendar.DAY_OF_MONTH);
        if (monthDay <= 315) {
            return Constant.Season.WINTER;
        } else if (monthDay <= 615) {
            return Constant.Season.SPRING;
        } else if (monthDay <= 915) {
            return Constant.Season.SUMMER;
        } else if (monthDay <= 1215) {
            return Constant.Season.FALL;
        } else {
            return Constant.Season.WINTER;
        }
    }
}
