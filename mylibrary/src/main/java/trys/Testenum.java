package trys;

/**
 * Created by tdd on 2019/3/1.
 */

public class  Testenum {
    public  void testEnumss(Testenums s){

        switch (s){
            case spring:
                System.out.println("春暖花开，正好踏青");
                break;
            case summer:
                System.out.println("夏天");
                break;
            case fall:
                System.out.println("qiu");
                break;
            case winter:
                System.out.println("dong");
                break;
            default:
                System.out.println("sb");
        }
    }

    public static void main(String[] args) {
        for (Testenums s:Testenums.values()
             ) {
            System.out.println(s);
        }
        new Testenum().testEnumss(Testenums.summer);

    }

}
