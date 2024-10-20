package com.tca.entities.loginscreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame implements ActionListener {

    //Labels for Username and Password
    JLabel userNameLabel;
    JLabel passwordLabel;

    //TextFields for Username and Password
    JTextField userNameTextField;
    JPasswordField passwordTextField;

    //Buttons for Login and Clear
    JButton loginButton;
    JButton clearButton;



    public LoginScreen(){

        this.setLayout(null);

        /*USERNAME*/
        //userNameLabel
        userNameLabel = new JLabel("UserName : ");
        userNameLabel.setSize(100,20);
        userNameLabel.setLocation(50, 30);
        this.add(userNameLabel);

        //userNameTextField
        userNameTextField = new JTextField();
        userNameTextField.setSize(200,20);
        userNameTextField.setLocation(160,30);
        this.add(userNameTextField);


        /*PASSWORD*/
        //passwordTextField
        passwordLabel = new JLabel("Password  : ");
        passwordLabel.setSize(100,20);
        passwordLabel.setLocation(50, 60);
        this.add(passwordLabel);

        //passwordTextField
        passwordTextField = new JPasswordField();
        passwordTextField.setSize(200,20);
        passwordTextField.setLocation(160,60);
        this.add(passwordTextField);


        /*BUTTONS*/

        //LoginButton
        loginButton = new JButton("Login");
        loginButton.setSize(100,30);
        loginButton.setLocation(90,100);
        loginButton.addActionListener(this);
        this.add(loginButton);

        //clearButton
        clearButton = new JButton("Clear");
        clearButton.setSize(100,30);
        clearButton.setLocation(260,100);
        clearButton.addActionListener(this);
        this.add(clearButton);


        //LoginScreen
        this.setTitle("By Omi");
        this.setSize(450,200);
        this.setLocation(750,450);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae){

        switch (ae.getActionCommand()){
            case "Login":
                validateUser(userNameTextField.getText(), passwordTextField.getText());
                break;
            case "Clear":
                userNameTextField.setText("");
                passwordTextField.setText("");

                //This set cursor to the given filed after clear the login form
                userNameTextField.requestFocus();
                break;
            default:
                System.out.println("No Button Found!!");
        }

    }

    private void validateUser(String username, String password){
        if(username.equals("om") && password.equals("123"))
        {
            System.out.println("Login Successfull!!!\n");
        }
        else {
            System.out.println("Wrong Username or Password!!!");
            passwordTextField.setText("");
            passwordTextField.requestFocus();
        }
    }


}