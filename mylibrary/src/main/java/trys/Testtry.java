package trys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by tdd on 2019/2/20.
 */

public class Testtry {
    int a =1;
    BufferedReader document1;
    File fr1=new File("q");
    public static void main(String[] args) {
        Testtry b=new Testtry();
        b.testTrys();
    }

    public void testTrys(){
        while(a<3){
            try {
                a++;
                System.out.println("我是try1");
                document1 = new BufferedReader(new InputStreamReader(new FileInputStream(fr1), "utf-8"));
                //System.out.println("我是try2");
                //break;
            } catch (Exception e){
                System.out.println("我是catch1");
                continue;
            }
            finally {System.out.println("我是finaly");}
            System.out.println("while结束");

        }

        System.out.println("testTrys方法结束");
    }
}
