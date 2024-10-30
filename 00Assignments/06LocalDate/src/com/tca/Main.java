package com.tca;

import com.tca.entities.student.Student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        int numberOfStudents = 0;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number Of Students : ");
        numberOfStudents = sc.nextInt();

        Student []students = new Student[numberOfStudents];

        for(int i=0; i<students.length; ++i)
        {
            students[i] = new Student();
            acceptStudentInformation(students[i]);
        }

        for(int i=0; i<students.length; ++i)
        {
            displayStudentInformation(students[i]);
        }



        sc.close();
    }

    public static void acceptStudentInformation(Student student) throws Exception {

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));

        System.out.print("Enter Student RollNumber : ");
        student.setStudentRollNumber( Integer.parseInt( br.readLine() ));

        System.out.print("Enter Student Name : ");
        student.setStudentName( br.readLine() );

        System.out.print("Enter Student Percentage : ");
        student.setStudentPercentage( Double.parseDouble(br.readLine()) );

        System.out.print("Enter Student Join Date [YYYY/MM/DD]: ");
        String[] joinDate = (br.readLine()).split("/");
        student.setStudentJoinDate( LocalDate.of(Integer.parseInt(joinDate[0]),Integer.parseInt(joinDate[1]),Integer.parseInt(joinDate[2])) );

        System.out.print("Enter Student BirthDate [YYYY/MM/DD]: ");
        String[] birthDate = (br.readLine()).split("/");
        student.setStudentBirthDate( LocalDate.of(Integer.parseInt(birthDate[0]),Integer.parseInt(birthDate[1]),Integer.parseInt(birthDate[2])) );

        student.setStudentTimeStamp( LocalDateTime.now() );

        student.setStudentAge();

        System.out.println();
    }

    public static void displayStudentInformation(Student student) {
        System.out.println("Student Roll Number             : " + student.getStudentRollNumber());
        System.out.println("Student Name                    : " + student.getStudentName());
        System.out.println("Student Percentage              : " + student.getStudentPercentage());
        System.out.println("Student Join Date               : " + student.getStudentJoinDate());
        System.out.println("Student Birth Date              : " + student.getStudentBirthDate());
        System.out.println("Student Time Stamp              : " + student.getStudentTimeStamp());
        System.out.println("Student Age                     : " + student.getStudentAge());
        System.out.println("------------------------------------------------------------------------------------------------------\n");
    }


}