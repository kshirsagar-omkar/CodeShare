package com.technocompacademy.controller;

import com.technocompacademy.view.AddStudentScreen;
import com.technocompacademy.view.DeleteStudentScreen;
import com.technocompacademy.view.DisplayStudentScreen;
import com.technocompacademy.view.UpdateStudentScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The HomeScreen class represents the main GUI home screen for the TechnoCompAcademy application.
 * <p>
 * This screen provides a menu bar with options to manage student records, including adding,
 * displaying, updating, and deleting student information.
 * <p>
 * This screen will be instantiated and called in the main method, serving as the entry point
 * for accessing other application features.
 * </p>
 *
 * @author Omkar Kshirsagar
 * @version 1.0
 * @since 1.0
 */
public class HomeScreen extends JFrame implements ActionListener {

    /**
     * The main menu bar for the TechnoCompAcademy application.
     */
    private JMenuBar menuBarMain;

    /**
     * The "Student" menu containing various student-related options.
     */
    private JMenu menuStudent;

    /**
     * Menu item for adding a new student.
     */
    private JMenuItem menuItemAddStudent;

    /**
     * Menu item for displaying student information.
     */
    private JMenuItem menuItemDisplayStudent;

    /**
     * Menu item for updating existing student details.
     */
    private JMenuItem menuItemUpdateStudent;

    /**
     * Menu item for deleting a student record.
     */
    private JMenuItem menuItemDeleteStudent;

    /**
     * Constructor for the HomeScreen class.
     * <p>
     * Initializes the main layout, creates the menu bar and student menu,
     * and configures each menu item with action listeners.
     * Sets frame properties like title, visibility, size, and close operation.
     * </p>
     */
    public HomeScreen() {
        this.setLayout(null);

        // Initialize and configure the main menu bar
        menuBarMain = new JMenuBar();
        menuBarMain.setSize(500, 30);
        menuBarMain.setLocation(0, 0);
        this.add(menuBarMain);

        // Create and add the "Student" menu to the menu bar
        menuStudent = new JMenu("Student");
        menuBarMain.add(menuStudent);

        // Initialize and add menu items for student management options
        menuItemAddStudent = new JMenuItem("Add Student");
        menuItemAddStudent.addActionListener(this);
        menuStudent.add(menuItemAddStudent);

        menuItemDisplayStudent = new JMenuItem("Display Student");
        menuItemDisplayStudent.addActionListener(this);
        menuStudent.add(menuItemDisplayStudent);

        menuItemUpdateStudent = new JMenuItem("Update Student");
        menuItemUpdateStudent.addActionListener(this);
        menuStudent.add(menuItemUpdateStudent);

        menuItemDeleteStudent = new JMenuItem("Delete Student");
        menuItemDeleteStudent.addActionListener(this);
        menuStudent.add(menuItemDeleteStudent);

        // Set frame properties
        this.setTitle("TechnoCompAcademy - Home");
        this.setVisible(true);
        this.setSize(500, 350);
        this.setLocation(730, 340);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Handles action events for menu items.
     *
     * @param e the ActionEvent triggered when a menu item is selected
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Action handling logic will be implemented here

        switch(e.getActionCommand()){
            case "Add Student":
                new AddStudentScreen();
                break;
            case "Display Student":
                new DisplayStudentScreen();
                break;
            case "Update Student":
                new UpdateStudentScreen();
                break;
            case "Delete Student":
                new DeleteStudentScreen();
                break;
            default:
                JOptionPane.showMessageDialog(null,"Invalid Input From Menu Bar!!");
        }

    }
}
