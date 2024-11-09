package com.technocompacademy.view;

import com.technocompacademy.entities.students.Student;
import com.technocompacademy.util.student.StudentOperation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The DisplayStudentScreen class provides a graphical interface for displaying
 * student information based on the entered roll number.
 *
 * This interface allows users to input a student roll number to search for,
 * display the student's name and percentage if found, or clear all fields.
 * It uses Swing components for the GUI and integrates with the StudentOperation
 * class to access and manage student data.
 *
 * @author Omkar Kshirsagar
 * @version 1.0
 * @since 1.0
 */
public class DisplayStudentScreen extends JFrame implements ActionListener {

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
     * Text field for displaying the student's name. This field is non-editable.
     */
    JTextField textFieldStudentName;

    /**
     * Text field for displaying the student's percentage. This field is non-editable.
     */
    JTextField textFieldStudentPercentage;

    /**
     * Button to trigger the display of student information based on the roll number.
     */
    JButton buttonSave;

    /**
     * Button to clear all input fields.
     */
    JButton buttonClear;

    /**
     * Constructor for the DisplayStudentScreen class.
     *
     * Initializes and sets up the frame layout, labels, text fields, and buttons.
     * Configures the display properties of the frame and prepares it for user interaction.
     * The roll number field is editable for input, while the name and percentage fields
     * are non-editable and intended for display only.
     */
    public DisplayStudentScreen() {
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
        textFieldStudentName.setEditable(false);
        this.add(textFieldStudentName);

        // Initialize and configure percentage label and text field
        labelStudentPercentage = new JLabel("Student Percentage : ");
        labelStudentPercentage.setLocation(50, 150);
        labelStudentPercentage.setSize(170, 30);
        this.add(labelStudentPercentage);

        textFieldStudentPercentage = new JTextField();
        textFieldStudentPercentage.setLocation(220, 150);
        textFieldStudentPercentage.setSize(200, 30);
        textFieldStudentPercentage.setEditable(false);
        this.add(textFieldStudentPercentage);

        // Initialize and configure show and clear buttons
        buttonSave = new JButton("SHOW");
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
        this.setTitle("Display Student");
        this.setVisible(true);
        this.setSize(500, 350);
        this.setLocation(730, 340);
        // this.setResizable(false); // Optional: uncomment to make the frame non-resizable
    }

    /**
     * Handles action events for the "SHOW" and "CLEAR" buttons.
     *
     * If "SHOW" is clicked, retrieves and displays student information based
     * on the entered roll number. If the student is not found, shows an error message.
     * If "CLEAR" is clicked, clears all input fields.
     *
     * @param e the ActionEvent triggered when a button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "SHOW":
                try {
                    Integer srno = Integer.parseInt(textFieldStudentRollNo.getText());
                    Student student = StudentOperation.searchStudent(srno);
                    if (student != null) {
                        textFieldStudentName.setText(student.getStudentName());
                        textFieldStudentPercentage.setText(student.getStudentPercentage().toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Record Not Found : " + srno);
                        this.clearTextFields();
                    }
                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Invalid Input!!");
                    exception.printStackTrace();
                }
                break;
            case "CLEAR":
                this.clearTextFields();
                break;
        }
    }

    /**
     * Clears the input fields for student roll number, name, and percentage.
     * Sets the focus back to the roll number input field to streamline user input.
     */
    private void clearTextFields() {
        textFieldStudentRollNo.setText("");
        textFieldStudentName.setText("");
        textFieldStudentPercentage.setText("");
        textFieldStudentRollNo.requestFocus();
    }
}
