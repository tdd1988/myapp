package testgson;

import java.math.BigDecimal;

/**
 * Created by tdd on 2019/1/4.
 */

public class TestDecimal {

    public double add(double a,double b){
        BigDecimal bg1=new BigDecimal(Double.toString(a));
        BigDecimal bg2=new BigDecimal(Double.toString(b));
        return bg1.add(bg2).doubleValue();

    }

    public static void main(String[] args){
        TestDecimal td=new TestDecimal();
        System.out.println(td.add(5.2,6.3));

    }


}
