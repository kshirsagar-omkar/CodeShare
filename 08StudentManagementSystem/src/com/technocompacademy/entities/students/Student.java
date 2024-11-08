package com.technocompacademy.entities.students;

/**
 * TechnoComAcademy Student module.
 *
 * <p>This class represents a student with attributes such as roll number, name, and percentage.</p>
 *
 * <p>It includes constructors, getter and setter methods, and an overridden toString() method.</p>
 *
 * @author Omkar Kshirsagar
 * @version 1.0, 06/11/2024
 * @since 1.0
 */

public class Student {
    /**
     * Roll Number of The Student.
     * Represents the unique identifier for a student.
     *
     * @since 1.0
     */
    private Integer studentRollNo;

    /**
     * Name of The Student.
     * Represents the full name of the student.
     *
     * @since 1.0
     */
    private String studentName;

    /**
     * Percentage of The Student.
     * Represents the academic percentage of the student.
     *
     * @since 1.0
     */
    private Double studentPercentage;

    /**
     * Default constructor for Student.
     * Initialize a new instance of Student with default values.
     *
     * @since 1.0
     */
    public Student(){}

    /**
     * Parameterized constructor for Student.
     * Initialize a new instance of Student with Specified roll number, name, percentage.
     *
     * @param studentRollNo The roll number of the student .
     * @param studentName the name of the student.
     * @param studentPercentage The Percentage of the student.
     * @since 1.0
     */
    public Student(Integer studentRollNo, String studentName, Double studentPercentage) {
        this.studentRollNo = studentRollNo;
        this.studentName = studentName;
        this.studentPercentage = studentPercentage;
    }

    /**
     * Gets the roll number of the student.
     *
     * @return The roll number of the student.
     * @since 1.0
     */
    public Integer getStudentRollNo() {
        return studentRollNo;
    }

    /**
     * Sets the roll number for the student.
     *
     * @param studentRollNo The roll number to set.
     * @since 1.0
     */
    public void setStudentRollNo(Integer studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    /**
     * Gets the name of the student.
     *
     * @return The name of the student.
     * @since 1.0
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets the name for the student.
     *
     * @param studentName The name to set for the student.
     * @since 1.0
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Gets the percentage of the student.
     *
     * @return The percentage of the student.
     * @since 1.0
     */
    public Double getStudentPercentage() {
        return studentPercentage;
    }

    /**
     * Sets the percentage for the student.
     *
     * @param studentPercentage The percentage to set.
     * @since 1.0
     */
    public void setStudentPercentage(Double studentPercentage) {
        this.studentPercentage = studentPercentage;
    }


    /**
     * Provides a string representation of the student.
     * Overridden to return detailed string with roll number, name, percentage.
     *
     * @return A string representation of the student.
     * @since 1.0
     */
    @Override
    public String toString() {
        return "Student{" +
                "studentRollNo=" + studentRollNo +
                ", studentName='" + studentName + '\'' +
                ", studentPercentage=" + studentPercentage +
                '}';
    }
}
