package testclass;

import org.json.Test;

/**
 * Created by tdd on 2019/6/4.
 */

public class test2 {
    public static void main(String[] args)throws Exception{
        Class cla=Class.forName("testclass.Test1");
        cla.newInstance();

    }
}
