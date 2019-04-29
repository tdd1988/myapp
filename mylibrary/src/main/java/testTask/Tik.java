package testTask;

import java.util.Scanner;

/**
 * Created by tdd on 2019/2/26.
 */

public class Tik {
    static Integer a =2;

    public static  void tests(){
        Scanner SC =new Scanner(System.in);

        System.out.println(SC.next().getClass());
        System.out.println(SC.next().getClass().getName());
        System.out.println(SC.next().getClass().getSimpleName());

    }



    public static void main(String[] args) {
        Tik.tests();


    }
}
