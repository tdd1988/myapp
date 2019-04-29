package testgson;


import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tdd on 2019/1/13.
 */

public class Student {

    public static void main(String[] args) {
        SimpleDateFormat time= new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        System.out.println(time.format(new Date()));
        System.out.println(System.currentTimeMillis());

        Calendar cl=Calendar.getInstance();
        cl.set(cl.get(Calendar.YEAR)+1,2,1);
        cl.add(Calendar.DATE,-1);
        System.out.println(cl.get(Calendar.DAY_OF_MONTH));

    }

}

class Happy {
    public static void main(String args[]){
        int a=2;
        if((a++)==2){
            System.out.println("对的");
        }

    }

}