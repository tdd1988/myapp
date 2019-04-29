package testgson;

/**
 * Created by tdd on 2019/1/15.
 */

public class TestString {

    public static void main(String[] args) {
        String str =new String("9");
        Integer a=Integer.parseInt(str);
        System.out.println(a);
        System.out.println(a.toString());
        if(a.toString() instanceof String){
            System.out.println("string");
        }else{
            System.out.println("buzhidao");
        }

    }
}
