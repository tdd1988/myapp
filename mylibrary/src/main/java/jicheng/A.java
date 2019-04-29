package jicheng;

/**
 * Created by tdd on 2019/1/16.
 */

public class A {

    public void write(){
        System.out.println("我是a");
    }
    public void show(A a){
        System.out.println("ds");
    }
}

class B extends A{

    public void writes(){
        System.out.println("我是b");
    }

    public void show(A a){
        System.out.println("dssd");
    }

    public void show(B a){
        System.out.println("dssdD");
    }
}

class C extends B{
    public void writess(){
        super.write();
        System.out.println("我是c");
    }

    public static void main(String[] args) {

        A a= new B();
        B b =new B();
        a.show(b);

    }


}