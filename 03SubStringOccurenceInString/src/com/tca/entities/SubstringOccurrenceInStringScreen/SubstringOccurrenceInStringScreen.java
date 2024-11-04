package com.tca.entities.SubstringOccurrenceInStringScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubstringOccurrenceInStringScreen extends JFrame implements ActionListener {

    private JLabel stringLabel;
    private JLabel subStringLabel;
    private JLabel occurrenceLabel;

    private JTextField stringTextField;
    private JTextField subStringTextField;
    private JTextField occurrenceTextField;

    private JButton searchButton;


    public SubstringOccurrenceInStringScreen(){
        this.setLayout(null);

        //stringLabel
        stringLabel = new JLabel("String          :");
        stringLabel.setSize(100,20);
        stringLabel.setLocation(50, 30);
        this.add(stringLabel);

        //stringTextField
        stringTextField = new JTextField();
        stringTextField.setSize(200,20);
        stringTextField.setLocation(160,30);
        this.add(stringTextField);


        //subStringLabel
        subStringLabel = new JLabel("Sub String  : ");
        subStringLabel.setSize(100,20);
        subStringLabel.setLocation(50, 60);
        this.add(subStringLabel);

        //subStringTextField
        subStringTextField = new JTextField();
        subStringTextField.setSize(200,20);
        subStringTextField.setLocation(160,60);
        this.add(subStringTextField);


        //occurrenceLabel
        occurrenceLabel = new JLabel("Occurrence");
        occurrenceLabel.setSize(100,20);
        occurrenceLabel.setLocation(175, 100);
        this.add(occurrenceLabel);

        //occurrenceTextField
        occurrenceTextField = new JTextField();
        occurrenceTextField.setSize(70,20);
        occurrenceTextField.setLocation(180,130);
        occurrenceTextField.setEditable(false);
        this.add(occurrenceTextField);


        //Search Button
        searchButton = new JButton("Search");
        searchButton.setSize(90,20);
        searchButton.setLocation(170,170);
        searchButton.addActionListener(this);
        this.add(searchButton);


        this.setTitle("SubstringOccurrenceInStringScreen");
        this.setSize(450,300);
        this.setLocation(750,450);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    @Override
    public void actionPerformed(ActionEvent ae){
        switch (ae.getActionCommand()){
            case "Search":
                Integer n = getOccurrence( stringTextField.getText(), subStringTextField.getText() );
                occurrenceTextField.setText(n.toString());
                subStringTextField.requestFocus();
                break;
            default:
                JOptionPane.showMessageDialog(null, "NoButton Found!!");
        }
    }

    public Integer getOccurrence(String source, String target ){

        if(source.isEmpty()){
            this.dispose();
            JOptionPane.showMessageDialog(null,"String is Empty!!!");
            System.exit(0);
        }
        else if (target.isEmpty()){
            this.dispose();
            JOptionPane.showMessageDialog(null,"Sub String is Empty!!!");
            System.exit(0);
        }

        int start = 0;
        Integer cnt = 0;
        while(true){
            start = source.indexOf(target, start);
            if(start == -1) break;

            ++start;
            ++cnt;
        }

        return cnt;
    }
}
