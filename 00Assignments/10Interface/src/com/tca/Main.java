package com.tca;

import com.tca.entities.Circle;
import com.tca.entities.Rectangle;
import com.tca.entities.Triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner( System.in );
        boolean flag = true;
        while(flag){
            int choice=0;
            System.out.print("Find Area of \n1.Circle\n2.Rectangle\n3.Triangle\n4.Exit\nEnter Choice : ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    Circle C = new Circle();

                    System.out.print("Enter Radius of Circle : ");
                    C.setRadius( sc.nextDouble() );

                    C.area();

                    break;
                case 2:
                    Rectangle R = new Rectangle();

                    System.out.print("Enter Length of Rectangle : ");
                    R.setLength( sc.nextDouble() );

                    System.out.print("Enter Length of Rectangle : ");
                    R.setWidth( sc.nextDouble() );

                    R.area();

                    break;
                case 3:
                    Triangle T = new Triangle();

                    System.out.print("Enter Base of Triangle : ");
                    T.setBase( sc.nextDouble() );

                    System.out.print("Enter Height of Triangle : ");
                    T.setHeight( sc.nextDouble() );

                    T.area();
                    break;
                case 4:
                    System.out.println("Ending Application....");
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong Choice Please Try Again!!!");
            }
            System.out.println("\n");
        }

    }
}