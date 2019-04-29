package jicheng;

import java.util.Arrays;

/**
 * Created by tdd on 2019/3/7.
 */

public class Demoson extends Demo {
    public void pao(){
        System.out.println("pao");
    }

    @Override
    public String zou() {
        System.out.println("儿子走");

        return "";

    }

    public static void main(String[] args) {
        int[] h={3,2,5};
        h.toString();
        System.out.println(h.toString());
        System.out.println("---------");
        System.out.println(Arrays.toString(h));
    }
}
