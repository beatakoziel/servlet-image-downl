package servlet;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TodayDate {
    private int dayOfMonth;
    private int dayOfWeek;
    private int month;
    private int year;

    public TodayDate() {
        Calendar today = new GregorianCalendar();
        this.dayOfMonth = today.get(Calendar.DAY_OF_MONTH);
        this.dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
        this.month = today.get(Calendar.MONTH);
        this.year = today.get(Calendar.YEAR);
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
