package trys;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tdd on 2019/2/27.
 */

public class Fanxing {

    public <T> Fanxing(T o){
        System.out.println(o);
    }

    public void testG(){
        new Fanxing("TDD");
        new Fanxing(5.0f);


    }
    public static void testFx(List<?> c){
        for(int i=0;i<c.size();i++){
            System.out.println(c.get(i));


        }
    }

    public static void creatList(){
        //List<Integer> ls =new ArrayList<>();
        //List<Number> ls2 =ls;
        Integer[] ls3 =new Integer[2];
        Number[] ls4=ls3;
        ls4[0]=0.5;


    }

    public static void main(String[] args) {
        List<String> ls =new ArrayList<>();
        ls.add("5");
        String sd="2";

        //Fanxing.creatList();
        Fanxing.testFx(ls);
    }
}
