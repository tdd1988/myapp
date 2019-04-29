package testgson;

/**
 * Created by tdd on 2019/2/1.
 */

public class TestZhi {
    public int   i,j;
    public   void   test_m(TestZhi   a)
    {     TestZhi   b   =  new   TestZhi();
        b.i   =   1;
        b.j   =   2;
        a   =   b;
    }
    public   void   test_m1(TestZhi   a   )
    {     a.i   =   1;
        a.j   =   2;
    }
    public   static   void   main(String   argv[])
    {     TestZhi   t=   new   TestZhi();
        t.i   =   5;
        t.j   =   6;
        System.out.println( "t.i   =   "+   t.i   +   "   t.j=   "   +   t.j); //5,6
        t.test_m(t);
        System.out.println( "t.i   =   "+   t.i   +   "   t.j=   "   +   t.j); //5,6,a和t都指向了一个对象，而在test_m中s又指向了另一个对象，所以对象t不变！！！

        //t.test_m1(t);

        //System.out.println( "t.i   =   "+   t.i   +   "   t.j=   "   +   t.j); //1,2

    }
}
