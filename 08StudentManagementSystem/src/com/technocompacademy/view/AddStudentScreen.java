package com.technocompacademy.view;

import com.technocompacademy.entities.students.Student;
import com.technocompacademy.util.student.StudentOperation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Add Student Screen</p>
 *
 * This class represents the GUI screen for adding a student, which includes fields for
 * entering the student's roll number, name, and percentage. It allows users to input
 * these details and save or clear them using corresponding buttons.
 *
 * @author Omkar Kshirsagar
 * @version 1.0
 * @since 1.0
 */
public class AddStudentScreen extends JFrame implements ActionListener {

    /**
     * Label to display "Student Roll Number" text beside the roll number field.
     */
    JLabel labelStudentRollNo;

    /**
     * Label to display "Student Name" text beside the name field.
     */
    JLabel labelStudentName;

    /**
     * Label to display "Student Percentage" text beside the percentage field.
     */
    JLabel labelStudentPercentage;

    /**
     * Text field for entering the student's roll number.
     */
    JTextField textFieldStudentRollNo;

    /**
     * Text field for entering the student's name.
     */
    JTextField textFieldStudentName;

    /**
     * Text field for entering the student's percentage.
     */
    JTextField textFieldStudentPercentage;

    /**
     * Button to save the entered student information.
     */
    JButton buttonSave;

    /**
     * Button to clear all input fields.
     */
    JButton buttonClear;

    /**
     * Constructor for the AddStudentScreen class.
     *
     * This constructor initializes the frame with layout settings, sets up the
     * labels and text fields for roll number, name, and percentage, and adds
     * "Save" and "Clear" buttons. The frame properties such as size, title,
     * and location are also configured here.
     */
    public AddStudentScreen() {
        this.setLayout(null);

        // Initialize and configure roll number label and text field
        labelStudentRollNo = new JLabel("Student Roll Number : ");
        labelStudentRollNo.setLocation(50, 50);
        labelStudentRollNo.setSize(170, 30);
        this.add(labelStudentRollNo);

        textFieldStudentRollNo = new JTextField();
        textFieldStudentRollNo.setLocation(220, 50);
        textFieldStudentRollNo.setSize(200, 30);
        this.add(textFieldStudentRollNo);

        // Initialize and configure name label and text field
        labelStudentName = new JLabel("Student Name : ");
        labelStudentName.setLocation(50, 100);
        labelStudentName.setSize(170, 30);
        this.add(labelStudentName);

        textFieldStudentName = new JTextField();
        textFieldStudentName.setLocation(220, 100);
        textFieldStudentName.setSize(200, 30);
        this.add(textFieldStudentName);

        // Initialize and configure percentage label and text field
        labelStudentPercentage = new JLabel("Student Percentage : ");
        labelStudentPercentage.setLocation(50, 150);
        labelStudentPercentage.setSize(170, 30);
        this.add(labelStudentPercentage);

        textFieldStudentPercentage = new JTextField();
        textFieldStudentPercentage.setLocation(220, 150);
        textFieldStudentPercentage.setSize(200, 30);
        this.add(textFieldStudentPercentage);

        // Initialize and configure save and clear buttons
        buttonSave = new JButton("SAVE");
        buttonSave.setLocation(100, 220);
        buttonSave.setSize(90, 40);
        buttonSave.addActionListener(this);
        this.add(buttonSave);

        buttonClear = new JButton("CLEAR");
        buttonClear.setLocation(300, 220);
        buttonClear.setSize(90, 40);
        buttonClear.addActionListener(this);
        this.add(buttonClear);


        // Configure the frame properties
        this.setTitle("Add Student");
        this.setVisible(true);
        this.setSize(500, 350);
        this.setLocation(730, 340);
        // this.setResizable(false); // Optional: uncomment to make the frame non-resizable
    }

    /**
     * This method handles action events for the buttons in the AddStudentScreen.
     *
     * @param e the ActionEvent triggered when a button is pressed
     */
    public void actionPerformed(ActionEvent e) {

        switch(e.getActionCommand()){
            case "SAVE":
                System.out.println("save");
                try{
                    Integer srno = Integer.parseInt(labelStudentRollNo.getText());
                    String sname = labelStudentName.getText();
                    Double sper = Double.parseDouble( labelStudentPercentage.getText() );

                    boolean status = StudentOperation.save( new Student(srno, sname, sper) );
                    if(status) {
                        JOptionPane.showMessageDialog(null, "Record Added Successfully!!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Unable to Add Records");
                    }
                }
                catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(null, "Invalid Input !!");
                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Unable to Add Records");
                }
                break;
            case "CLEAR":
                System.out.println("clear");
                break;
        }

    }
}
