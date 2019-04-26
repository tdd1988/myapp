package testcollection;

import android.support.annotation.NonNull;

/**
 * Created by tdd on 2019/2/25.
 */

public class Student implements Comparable<Student>{
    protected String id;
    protected String name;

    public Student(String id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return name.equals(student.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(@NonNull Student another) {

        return this.name.compareTo(another.name);
    }
}
