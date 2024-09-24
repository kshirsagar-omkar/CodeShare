package com.TechnoCompAcademy.entities.student;

import java.time.LocalDate;

public class TechnoCompAcademy2020 extends TechnoCompAcademy2009{
    protected String studentWhatsAppNumber;
    protected String studentEmail;
    protected LocalDate studentAdmissionDate;


    public TechnoCompAcademy2020(){
        this.studentWhatsAppNumber = "N/A";
        this.studentEmail = "N/A";
        this.studentAdmissionDate = null;
    }

    public TechnoCompAcademy2020(int studentId, String studentName, String studentBatch, double studentFees, String studentWhatsAppNumber, String studentEmail, LocalDate studentAdmissionDate) {
        super(studentId, studentName, studentBatch, studentFees);
        this.studentWhatsAppNumber = studentWhatsAppNumber;
        this.studentEmail = studentEmail;
        this.studentAdmissionDate = studentAdmissionDate;
    }



    public String getStudentWhatsAppNumber() {
        return studentWhatsAppNumber;
    }

    public void setStudentWhatsAppNumber(String studentWhatsAppNumber) {
        this.studentWhatsAppNumber = studentWhatsAppNumber;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public LocalDate getStudentAdmissionDate() {
        return studentAdmissionDate;
    }

    public void setStudentAdmissionDate(LocalDate studentAdmissionDate) {
        this.studentAdmissionDate = studentAdmissionDate;
    }

    public void displayStudentInformation()
    {
        super.displayStudentInformation();
        System.out.println("Student WhatsApp Number : " + studentWhatsAppNumber);
        System.out.println("Student Email           : " + studentEmail);
        System.out.println("Student Admission Date  : " + studentAdmissionDate);
    }
}
