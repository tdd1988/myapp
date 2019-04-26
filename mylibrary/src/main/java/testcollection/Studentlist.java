package testcollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tdd on 2019/2/25.
 */

public class Studentlist {
    public List<Student> stuList;

    public Studentlist(){
        this.stuList=new ArrayList<Student>();
    }

    public void testSort1(){
        Studentlist st = new Studentlist();
        st.stuList.add(new Student(1+"","bac"));
        st.stuList.add(new Student(2+"","abc"));
        st.stuList.add(new Student(3+"","cbc"));

        System.out.println("--------排序前--------");
        for (Student stt:st.stuList
             ) {
            System.out.println(stt.id+":"+stt.name);
        }


        Collections.sort(st.stuList);

        System.out.println("--------排序后--------");

        for (Student stt2:st.stuList
                ) {
            System.out.println(stt2.id+":"+stt2.name);
        }

        System.out.println("--------------------");



    }

    public static void main(String[] args) {
        Studentlist st = new Studentlist();
        st.testSort1();

    }
}
