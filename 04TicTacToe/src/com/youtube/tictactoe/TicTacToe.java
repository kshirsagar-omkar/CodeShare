package com.youtube.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JFrame implements ActionListener {

    //Whose turn is decide randomly
    Random random = new Random();

    //Panel to Hold the title
    JPanel titlePanel;

    //Panel to Hold all Buttons we Have
    JPanel buttonPanel;

    //Text Field To Display some message
    JTextField textField;

    //Array of JButtons
    JButton [][]buttons = new JButton[3][3];

    //To Choose Who is Player 1
    Boolean playerOneTurn;
    //If Player 1 is false then basically its player 2


    public TicTacToe() {
        this.setLayout(new BorderLayout());



        /*TextField
            Add this in TitlePanel
        */
        textField = new JTextField();
        textField.setText("Tic Tac Toe");
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setEditable(false);

        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setOpaque(true);
//        this.add(textField);


        /*
         *  Add TextField into Title Panel And then Add Title Panel into JFrame
         */
        titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);
        titlePanel.add(textField);
        //Add titlePanel in JFrame
        this.add(titlePanel,BorderLayout.NORTH);



        /*
        *   Button Panel
        * */
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,3));
        //Just to if it is actually appearing
        buttonPanel.setBackground(new Color(10,150,150));
        this.add(buttonPanel);


        /*
         * Creating 9 Buttons
         * AND
         * buttons[i][j] Adding to buttonPanel
         * */
        for(byte i=0; i<3; ++i) {
            for(byte j=0; j<3; ++j) {
                buttons[i][j] = new JButton();
                buttonPanel.add(buttons[i][j]);
                buttons[i][j].setFont(new Font("MV Boli", Font.BOLD, 120));
                buttons[i][j].setFocusable(false);
                buttons[i][j].setBackground(new Color(25, 25, 25));
                buttons[i][j].addActionListener(this);
            }
        }






        this.setTitle("Tic Tac Toe Game");
        this.setSize(800, 800);
        this.setLocation(620,180);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().setBackground( new Color(50,50,50) );


        //This Will Decide Who will Start The Game
        this.fistTurn();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //This Loop will Run 9 Times When Button is Pressed
        for (byte i=0; i<3; ++i){
            //returns the object of which button is pressed
            //Check which button is clicked
            for(byte j=0; j<3; ++j){
                if (ae.getSource() == buttons[i][j]) {
                    //Successfully got the button which is pressed. Now check who pressed the Button
                    if (playerOneTurn) {
                        //Check if button is having some value or not
                        if (buttons[i][j].getText().equals("")) {
                            //Set the Foreground color to the pressed button
                            buttons[i][j].setForeground(new Color(225, 0, 0));
                            buttons[i][j].setText("X");
                            playerOneTurn = false;
                            textField.setText("O Turns");
                            this.check();
                        }
                    }
                    //if player2 pressed button
                    else {
                        if (buttons[i][j].getText().equals("")) {
                            //Set the Foreground color to the pressed button
                            buttons[i][j].setForeground(new Color(10, 133, 225));
                            buttons[i][j].setText("O");
                            playerOneTurn = true;
                            textField.setText("X Turns");
                            this.check();
                        }
                    }
                }
            }
        }

    }


    //Randomly first player will choosen
    public void fistTurn(){
        /*
            Sleep the program for 2 sec then we can see the Title "Tic Tac Toe" before it Show us Player Turn

            Random Class Will Generate Number 0-1
            if it is 0 then player1 will Play First
            otherwise player2
        */

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2) == 0){
            //set Player1 is having first chance to play
            playerOneTurn = true;
            //set text to panel whose turn is now
            textField.setText("X Turns");
        }
        else {
            //set Player1 is not having first chance to play
            playerOneTurn = false;
            //set text to panel whose turn is now
            textField.setText("O Turns");
        }
    }


    //Check if some player is win or not
    public void check() {
        //check if X wins

        this.checkXWins();
        this.checkOWins();

        this.checkTie();
    }

    
    //Helper Function
    public void checkXWins() {
        //Check for Row And Columns
        for(byte i=0; i<3; ++i){
            if( (buttons[i][0].getText()=="X") && (buttons[i][1].getText()=="X") && (buttons[i][2].getText()=="X") ){
                xWins(i,0,i,1,i,2);
            }
            if( (buttons[0][i].getText()=="X") && (buttons[1][i].getText()=="X") && (buttons[2][i].getText()=="X") ){
                xWins(0,i,1,i,2,i);
            }
        }

        //Check For Diagonals
        if( (buttons[0][0].getText()=="X") && (buttons[1][1].getText()=="X") && (buttons[2][2].getText()=="X") ){
            xWins(0,0,1,1,2,2);
        }
        if( (buttons[0][2].getText()=="X") && (buttons[1][1].getText()=="X") && (buttons[2][0].getText()=="X") ){
            xWins(0,2,1,1,2,0);
        }
    }


    
    //Helper Function
    public void checkOWins() {
        //Check for Row And Columns
        for(byte i=0; i<3; ++i){
            if( (buttons[i][0].getText()=="O") && (buttons[i][1].getText()=="O") && (buttons[i][2].getText()=="O") ){
                oWins(i,0,i,1,i,2);
            }
            if( (buttons[0][i].getText()=="O") && (buttons[1][i].getText()=="O") && (buttons[2][i].getText()=="O") ){
                oWins(0,i,1,i,2,i);
            }
        }

        //Check For Diagonals
        if( (buttons[0][0].getText()=="O") && (buttons[1][1].getText()=="O") && (buttons[2][2].getText()=="O") ){
            oWins(0,0,1,1,2,2);
        }
        if( (buttons[0][2].getText()=="O") && (buttons[1][1].getText()=="O") && (buttons[2][0].getText()=="O") ){
            oWins(0,2,1,1,2,0);
        }
    }
    
    //Check if it is tie
    public void checkTie(){
        boolean tie = true;
        for(byte i=0; i<3; ++i){
            for (byte j=0; j<3; ++j){
                if(buttons[i][j].getText().isEmpty()){
                    tie = false;
                    break;
                }
            }
        }
        if(tie){
            textField.setForeground(new Color(225, 0, 0));
            textField.setText("Match Ties!!!");
            this.disableAllButtons();
        }
    }
    
    
    
    
    
    //if O Wins
    //Indices [[],[],[]]
    public void oWins(int a1, int a2, int b1, int b2, int c1, int c2){
        
        
        buttons[a1][a2].setBackground(Color.GREEN);
        buttons[b1][b2].setBackground(Color.GREEN);
        buttons[c1][c2].setBackground(Color.GREEN);
        this.disableAllButtons();
        textField.setText("O Wins!!!");
    }

    //if X Wins
    //Indices [[],[],[]]
    public void xWins(int a1, int a2, int b1, int b2, int c1, int c2){


        buttons[a1][a2].setBackground(Color.GREEN);
        buttons[b1][b2].setBackground(Color.GREEN);
        buttons[c1][c2].setBackground(Color.GREEN);
        this.disableAllButtons();
        textField.setText("X Wins!!!");
    }


    public void disableAllButtons() {
        for (byte i = 0; i < 3; ++i) {
            for (byte j = 0; j < 3; ++j) {
                buttons[i][j].setEnabled(false);
            }
        }
    }
}
