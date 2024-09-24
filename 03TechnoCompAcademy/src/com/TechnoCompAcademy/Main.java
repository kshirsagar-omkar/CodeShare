package com.TechnoCompAcademy;

import com.TechnoCompAcademy.entities.student.TechnoCompAcademy2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
/*
        TechnoCompAcademy2020 ob1 = new TechnoCompAcademy2020(101, "omkar", "JAVA", 5000.00, "9309272458","omkarkshirsagar@gmail.com", LocalDate.now());
        ob1.displayStudentInformation();
        System.out.println("-----------------------------------------------------");
*/

        int numberOfStudent = 0;
        Scanner sc = new Scanner( System.in );

        System.out.print("Enter How Many Student Admission : ");
        numberOfStudent = sc.nextInt();


        TechnoCompAcademy2020 Students[] = new TechnoCompAcademy2020[ numberOfStudent ];

        System.out.println("\nAccept Student Information\n-----------------------------------------------------");
        for(int i=0; i<Students.length; ++i)
        {
            Students[i] = new TechnoCompAcademy2020();
            acceptStudentInformation(Students[i]);
            System.out.println();
        }

        System.out.println("\nDisplay Student Information\n-----------------------------------------------------");
        for (TechnoCompAcademy2020 student : Students) {
            displayStudentInformation(student);
        }
    }

    public static void acceptStudentInformation(TechnoCompAcademy2020 student) throws Exception
    {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        System.out.print("Enter Student Id : ");
        student.setStudentId( Integer.parseInt( br.readLine() ) );

        System.out.print("Enter Student Name : ");
        student.setStudentName( br.readLine() );

        System.out.print("Enter Student Batch : ");
        student.setStudentBatch( br.readLine() );

        System.out.print("Enter Student Fees : ");
        student.setStudentFees( Double.parseDouble(br.readLine() ) );

        System.out.print("Enter Student WhatsApp Number : ");
        student.setStudentWhatsAppNumber( br.readLine() );

        System.out.print("Enter Student Email : ");
        student.setStudentEmail( br.readLine() );

        student.setStudentAdmissionDate( LocalDate.now() );
    }

    public static void displayStudentInformation( TechnoCompAcademy2020 student )
    {
        System.out.println( "Student ID              : " + student.getStudentId() );
        System.out.println( "Student Name            : " + student.getStudentName() );
        System.out.println( "Student Batch           : " + student.getStudentBatch() );
        System.out.println( "Student Fees            : " + student.getStudentFees() );
        System.out.println( "Student WhatsApp Number : " + student.getStudentWhatsAppNumber() );
        System.out.println( "Student Email           : " + student.getStudentEmail() );
        System.out.println( "Student Admission Date  : " + student.getStudentAdmissionDate() );
        System.out.println("-----------------------------------------------------");
    }
}