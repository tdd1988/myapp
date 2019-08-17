package jicheng;

import android.util.Log;

/**
 * Created by tdd on 2019/2/12.
 */

public class Demo<T extends String>{
    private T first;

    public String zou(){
        //System.out.println("zou");
        return "zou";
    }

    public T getFirst(){
        return first;
    }

    public void setFirst(T first){
        this.first=first;
    }


    public static void main(String[] args) {
       Demo dd= new Demo<>();
        dd.setFirst("5");


        System.out.println(dd.getFirst());
    }
}


