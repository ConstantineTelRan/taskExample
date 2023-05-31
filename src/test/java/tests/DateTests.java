package tests;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTests {

//    2019-10-01
//            23:59.59.999
//            2018-11-30 03:09:02
//            2016-03-01 01:20:47.999
//            2013-13-13 23:59:59.999 +0100



    @Test
    public void date1() {
        Date date = DateUtils.addDays(new Date(), 1);
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = format.format(date);
        System.out.println(strDate);
    }




}
