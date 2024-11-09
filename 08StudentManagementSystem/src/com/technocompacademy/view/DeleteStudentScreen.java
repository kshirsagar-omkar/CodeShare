package com.technocompacademy.view;

import com.technocompacademy.entities.students.Student;
import com.technocompacademy.util.student.StudentOperation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The DeleteStudentScreen class provides a graphical user interface for searching and
 * deleting student information based on the entered roll number.
 * <p>
 * This class displays input fields for the roll number, and non-editable fields for
 * displaying the student's name and percentage after a search operation.
 * </p>
 * <p>
 * This screen allows users to search for and clear student information fields.
 * </p>
 *
 * @author Omkar Kshirsagar
 * @version 1.0
 * @since 1.0
 */
public class DeleteStudentScreen extends JFrame implements ActionListener {

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
     * Button to trigger the search for student information based on the roll number.
     */
    JButton buttonSave;

    /**
     * Button to clear all input fields.
     */
    JButton buttonDelete;

    /**
     * Constructor for the DeleteStudentScreen class.
     *
     * Initializes the frame layout, configures labels and text fields for roll number,
     * name, and percentage, and adds "SEARCH" and "CLEAR" buttons.
     * Sets frame properties such as size, title, and location for display.
     *
     * The roll number input field is editable, while the name and percentage
     * fields are non-editable and intended to display data after a search.
     */
    public DeleteStudentScreen() {
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

        // Initialize and configure search and clear buttons
        buttonSave = new JButton("SEARCH");
        buttonSave.setLocation(100, 220);
        buttonSave.setSize(90, 40);
        buttonSave.addActionListener(this);
        this.add(buttonSave);

        buttonDelete = new JButton("DELETE");
        buttonDelete.setLocation(300, 220);
        buttonDelete.setSize(90, 40);
        buttonDelete.addActionListener(this);
        this.add(buttonDelete);

        // Configure the frame properties
        this.setTitle("Delete Student");
        this.setVisible(true);
        this.setSize(500, 350);
        this.setLocation(730, 340);
//         this.setResizable(false); // Optional: uncomment to make the frame non-resizable
    }

    /**
     * Handles action events triggered by the "SEARCH" and "DELETE" buttons.
     * <p>
     * For the "SEARCH" action, it attempts to retrieve student details based on the roll number
     * entered in the text field. If a matching record is found, it populates the student's name
     * and percentage fields; otherwise, it displays an error message and clears the fields.
     * </p>
     * <p>
     * For the "DELETE" action, it attempts to delete the student record matching the entered roll
     * number. A success or failure message is displayed accordingly, and all fields are cleared.
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

            case "DELETE":
                try {
                    // Parse the roll number from the input field
                    Integer srno = Integer.parseInt(textFieldStudentRollNo.getText());

                    // Attempt to delete the student record
                    Boolean status = StudentOperation.deleteStudent(srno);

                    if (status) {
                        // Display success message if deletion is successful
                        JOptionPane.showMessageDialog(null, "Record Deleted Successfully : " + srno);
                    } else {
                        // Show error message if deletion fails
                        JOptionPane.showMessageDialog(null, "Unable To Delete Record : " + srno);
                    }
                    this.clearTextFields();
                } catch (Exception exception) {
                    // Handle any input or deletion errors
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
