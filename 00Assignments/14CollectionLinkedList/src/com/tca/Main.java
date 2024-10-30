package com.tca;

/*

    Q : Construct a linked list containing names of colors : red blue yellow orange. Then
    extend your program to do the following -
    1) Display the contents of the list using an itearator.
    2) Display the contents of list in reverse order using a listiterator.
    3) Create another list containing pink and green. Insert the elements of this
    list between blue and yellow.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        List<String> colors1 = new LinkedList();
        colors1.add("red");
        colors1.add("blue");
        colors1.add("yellow");
        colors1.add("orange");

        ListIterator colors1Iterator = colors1.listIterator();

        //Display the contents of the list using an itearator.
        System.out.println("Display the contents of the list using an itearator");
        while(colors1Iterator.hasNext()){
            System.out.print( colors1Iterator.next() +" ");
        }

        System.out.println("\n");


        //Display the contents of list in reverse order using a listiterator
        System.out.println("Display the contents of list in reverse order using a listiterator");
        while(colors1Iterator.hasPrevious()){
            System.out.print( colors1Iterator.previous() + " ");
        }

        System.out.println("\n");

        //Create another list containing pink and green. Insert the elements of this
        //list between blue and yellow.

        System.out.println("Elements of colors1 before inserting colors2 : " + colors1);

        List<String> colors2 = new LinkedList<>();
        colors2.add("pink");
        colors2.add("green");

        //getting index of "blue"
        int i = colors1.indexOf("blue");
        colors1.addAll(i+1, colors2);

        System.out.println("Elements of colors1 after inserting colors2 : " + colors1);









        //Below Assignment is given in notes!!
        System.out.println("\n\nBelow Assignment is given in notes!!");
        System.out.println("Write a Java Program to read 'n' names of your friends, store it into Linked list ,also display the contents of the same");

        List<String> friendsName = new LinkedList<>();
        String option = null;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            boolean flag = true;
            do {
                System.out.println("**Menu**");
                System.out.print("1.Add\t2.Display\t3.Exit[1/2/3] : ");
                option = br.readLine();

                switch (option){
                    case "1" :
                        System.out.print("Enter Name : ");
                        if(friendsName.add( br.readLine() )){
                            System.out.println("Name Added Successfully.");
                        }
                        else {
                            System.out.println("Above Name is Not Added!!!");
                        }
                        break;
                    case "2" :
                        System.out.println("Friends Name : " + friendsName);
                        break;
                    case "3" :
                        System.out.println("Exiting the Application!!");
                        flag = false;
                        break;
                    default:
                        System.out.println("Choose a Right Option !!!");

                }
                System.out.println();
            }while (flag);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }



    }
}