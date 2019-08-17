package xmltest;


import java.util.Calendar;


import javax.xml.crypto.Data;

/**
 * Created by tdd on 2019/6/26.
 */

public class Simpledateformatdemo {

    public static void main(String[] args) {

        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        System.out.println(year);


        //System.out.println(cal.getTimeZone());

    }

}
