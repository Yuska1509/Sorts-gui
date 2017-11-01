package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        IntStudent st1 = new IntStudent("petya");
        IntStudent st2 = new IntStudent("petya");
        Integer a = 5;
        System.out.println(st1.equals(st2));
        System.out.println(st1 == st2);
    }
}


class IntStudent {
    private String name;

    IntStudent(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (this.getClass().equals(obj.getClass())) {
            IntStudent st = (IntStudent)obj;
            return this.getName().equals(st.getName());
        }
        return false;
    }

    public void setName(String newName) {
        if (newName == "vasya") {
            return;
        }

        this.name = newName;
    }

    public String getName() {
        return name;
    }

    public static String schoolName() {
        return "123";
        //this.name = "123";
    }
}