package com.TechnoCompAcademy.entities.student;

public class TechnoCompAcademy2009 {
    private static int studentCount;
    protected int studentId;
    protected String studentName;
    protected double studentFees;
    protected String studentBatch;

    static
    {
        studentCount = 0;
    }

    public TechnoCompAcademy2009()
    {
        this.studentId = 0;
        this.studentName = "N/A";
        this.studentFees = 0.00;
        studentCount++;
    }

    public TechnoCompAcademy2009(int studentId, String studentName, String studentBatch, double studentFees) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentFees = studentFees;
        this.studentBatch = studentBatch;
        studentCount++;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getStudentFees() {
        return studentFees;
    }

    public void setStudentFees(double studentFees) {
        this.studentFees = studentFees;
    }

    public String getStudentBatch() {
        return studentBatch;
    }

    public void setStudentBatch(String studentBatch) {
        this.studentBatch = studentBatch;
    }

    public void displayStudentInformation()
    {
        System.out.println("Student ID              : " + studentId);
        System.out.println("Student Name            : " + studentName);
        System.out.println("Student Batch           : " + studentBatch);
        System.out.println("Student Fees            : " + studentFees);
    }

}
