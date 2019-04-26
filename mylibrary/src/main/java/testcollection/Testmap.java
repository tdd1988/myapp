package testcollection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by tdd on 2019/2/25.
 */

public class Testmap {
    private Map<String,Student> students;

    public Testmap(){
        this.students=new HashMap<String,Student>();
    }

    public void testput(){
        testcollection.Student stu1= new Student("1","tdd");
        students.put("1",stu1);
        testcollection.Student stu2= new Student("2","tddys");
        students.put("2",stu2);
    }

    public void testKeyset(){
        Set<String> keyset=students.keySet();
        for (String stuId:keyset
                ) {
            testcollection.Student st =students.get(stuId);
            System.out.println(st.name);

        }
    }

    public void testContainsValues(){
        if(students.containsValue(new Student(null,"tdd"))){
            System.out.println("有tdd");
        }else{
            System.out.println("没有");
        }
    }

    public static void main(String[] args) {
        Testmap ts=new Testmap();
        ts.testput();
        ts.testKeyset();
        ts.testContainsValues();
    }
}
