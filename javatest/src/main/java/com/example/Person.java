package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by tdd on 2019/4/15.
 */

public class Person implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        try {
            FileOutputStream op = new FileOutputStream("/Users/tdd/Desktop/a.txt");

            ObjectOutputStream ops = new ObjectOutputStream(op);
            ops.writeObject(new Person("vae",1));

            ops.close();

            FileInputStream fs=new FileInputStream("/Users/tdd/Desktop/a.txt");
            ObjectInputStream OBS =new ObjectInputStream(fs);
            Person ps=(Person)OBS.readObject();
            System.out.println(ps.toString());

        }catch (Exception E){

        }

    }
}
