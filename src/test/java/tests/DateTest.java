package tests;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTest {


//            23:59.59.999
//            2018-11-30 03:09:02


    // 01.06.2023
    @Test
    public void date1() {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat pattern = new SimpleDateFormat("dd.MM.yyyy");
        String formatDate = pattern.format(date);
        System.out.println(formatDate);
     }

    //    2019-10-01
    @Test
    public void date2() {
        Date date = DateUtils.addDays(new Date(), 5);
        System.out.println(date);

        SimpleDateFormat pattern = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = pattern.format(date);
        System.out.println(formatDate);
    }

    // 1 Jun Thursday 23 18:00
    @Test
    public void date3() {
        Date date = new Date();
        System.out.println(date);
//        Locale ru = new Locale("Gr");
        SimpleDateFormat pattern = new SimpleDateFormat("d MMM EEEE yy HH:mm");
        String formatDate = pattern.format(date);
        System.out.println(formatDate);
    }


}
