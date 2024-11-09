package com.technocompacademy.view;

import com.technocompacademy.entities.students.Student;
import com.technocompacademy.util.student.StudentOperation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A GUI-based class for updating student information.
 * <p>
 * The UpdateStudentScreen class allows users to search for a student by roll number,
 * view the student's current information, and update their name and percentage.
 * Users can interact with "SEARCH" and "UPDATE" buttons to perform actions.
 * </p>
 * <p>
 * Upon a successful search, the student's details are displayed in non-editable fields.
 * If an update is required, fields become editable to allow changes to be made.
 * </p>
 *
 * @author Omkar
 * @version 1.0
 * @since 1.0
 */
public class UpdateStudentScreen extends JFrame implements ActionListener {

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
     * Text field for displaying the student's name.
     */
    JTextField textFieldStudentName;

    /**
     * Text field for displaying the student's percentage.
     */
    JTextField textFieldStudentPercentage;

    /**
     * Button to trigger the search for student information based on the roll number.
     */
    JButton buttonSave;

    /**
     * Button to update the student information.
     */
    JButton buttonDelete;

    /**
     * Constructor for the UpdateStudentScreen class.
     * <p>
     * Initializes the frame layout, configures labels and text fields for roll number,
     * name, and percentage, and adds "SEARCH" and "UPDATE" buttons.
     * Sets frame properties such as size, title, and location for display.
     * </p>
     * <p>
     * The roll number input field is editable, while the name and percentage
     * fields are used to display data after a search.
     * </p>
     */
    public UpdateStudentScreen() {
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

        // Initialize and configure search and update buttons
        buttonSave = new JButton("SEARCH");
        buttonSave.setLocation(100, 220);
        buttonSave.setSize(90, 40);
        buttonSave.addActionListener(this);
        this.add(buttonSave);

        buttonDelete = new JButton("UPDATE");
        buttonDelete.setLocation(300, 220);
        buttonDelete.setSize(90, 40);
        buttonDelete.addActionListener(this);
        this.add(buttonDelete);

        // Configure the frame properties
        this.setTitle("Update Student");
        this.setVisible(true);
        this.setSize(500, 350);
        this.setLocation(730, 340);
    }

    /**
     * Handles action events triggered by the "SEARCH" and "UPDATE" buttons.
     * <p>
     * For the "SEARCH" action, it retrieves student details based on the roll number
     * entered in the text field. If a matching record is found, it populates the name
     * and percentage fields; otherwise, it displays an error message and clears the fields.
     * </p>
     * <p>
     * For the "UPDATE" action, it attempts to update the student record with new data
     * entered in the name and percentage fields. It displays a success or failure message
     * based on the outcome and clears the fields afterward.
     * </p>
     *
     * @param e the ActionEvent triggered when a button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "SEARCH":
                try {
                    // Parse the roll number from the input field
                    Integer srno = Integer.parseInt(textFieldStudentRollNo.getText());

                    // Search for the student in the database
                    Student student = StudentOperation.searchStudent(srno);

                    if (student != null) {
                        // Display student details if found
                        textFieldStudentName.setText(student.getStudentName());
                        textFieldStudentPercentage.setText(student.getStudentPercentage().toString());
                    } else {
                        // Show message if no matching record is found
                        JOptionPane.showMessageDialog(null, "Record Not Found : " + srno);
                        this.clearTextFields();
                    }
                } catch (Exception exception) {
                    // Handle any input or search errors
                    JOptionPane.showMessageDialog(null, "Invalid Input!!");
                    exception.printStackTrace();
                }
                break;

            case "UPDATE":
                try {
                    Integer srno = Integer.parseInt(textFieldStudentRollNo.getText());
                    String sname = textFieldStudentName.getText();
                    Double sper = Double.parseDouble(textFieldStudentPercentage.getText());
                    boolean status = StudentOperation.updateStudent(new Student(srno, sname, sper));
                    if (status) {
                        JOptionPane.showMessageDialog(null, "Record Updated Successfully : " + srno);
                    } else {
                        JOptionPane.showMessageDialog(null, "Unable to Update Record : " + srno);
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Invalid Input!!");
                    exception.printStackTrace();
                }
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
