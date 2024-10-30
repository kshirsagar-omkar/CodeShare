package com.tca;

import com.tca.entities.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

    //Code to Print details of Student class (Introspect)
        Class<Student> Cob = Student.class;

        //SuperClass of the Student
        System.out.println("Super Class of the Student Class : " + Cob.getSuperclass());
        System.out.println("=========================================================\n");

        //Data Members in class (Fields in class)
        Field []F = Cob.getDeclaredFields();
        System.out.println("No. of Fields in Student Class : " + F.length);
        System.out.println("----------------------------------------------------");

        System.out.println("Fields in Student Class ");
        for(Field val : F){
            System.out.println(val);
        }
        System.out.println("=========================================================\n");


        //Constructors
        Constructor []C = Cob.getConstructors();
        System.out.println("No. of Constructors in Student Class : " + C.length);
        System.out.println("----------------------------------------------------");

        System.out.println("Constructors in Student Class ");
        for(Constructor val : C){
            System.out.println(val);
        }
        System.out.println("=========================================================\n");


        Method []M = Cob.getMethods();
        System.out.println("No. of Methods in Student Class : " + M.length);
        System.out.println("----------------------------------------------------");

        System.out.println("Methods in Student Class ");
        for(Member val : M){
            System.out.println(val.getName());
        }
        System.out.println("=========================================================\n");
    }
}