package testcollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tdd on 2019/5/27.
 */

public class Castcollect {
    public static void main(String[] args) {
        List<String> ls=new ArrayList<>();
        ls.add("T");
        ls.add("D");
        String[] ar=ls.toArray(new String[0]);
        System.out.println(ar[0]);
    }


}
