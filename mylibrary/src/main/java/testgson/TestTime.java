package testgson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tdd on 2019/1/15.
 */

public class TestTime {
    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());
        Calendar cl=Calendar.getInstance();
        System.out.println(cl.get(Calendar.DATE));
        cl.add(Calendar.DAY_OF_MONTH,-1);
        System.out.println(cl.get(Calendar.DATE));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println(df.format(now));
        System.out.println("Today is:"+df.format(Calendar.getInstance().getTime()));
        byte month=(byte)(cl.get(Calendar.MONTH)+1);
        System.out.println(month);
    }
}
