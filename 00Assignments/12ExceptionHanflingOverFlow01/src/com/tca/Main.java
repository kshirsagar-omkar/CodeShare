package com.tca;

import com.tca.entities.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Item ob = new Item();
        ob.setItemCode( getIntegerInput(br, "Enter Item Code : ") );
        ob.setItemName( getStringInput(br, "Enter Item Name : ") );
        ob.setItemPrice( getDoubleInput(br, "Enter Item Price : ") );


        System.out.println("Item Info : " + ob);

    }


    public static String getStringInput(BufferedReader br, String msg) {
        while(true) {
            try{
                System.out.print(msg);
                return br.readLine();
            }
            catch (IOException ioe) {
                System.out.println("IOException Occured During Reading Input!!! " + ioe.getMessage());
                // ioe.printStackTrace();
            }
            catch (Exception e) {
                System.out.println("Unknown Exception Occured!!! " + e.getMessage());
                // e.printStackTrace();
            }
        }
    }

    public static double getDoubleInput(BufferedReader br, String msg){
        while(true){
            try{
                System.out.print(msg);
                return Double.parseDouble( br.readLine() );
            }
            catch (IOException ioe){
                System.out.println("IOException Occurred Reading Input! :" + ioe.getMessage());
            }
            catch (NumberFormatException nfe){
                System.out.println("NumberFormatException Enter A valid number! :" + nfe.getMessage());
            }
            catch (Exception e){
                System.out.println("Unknown Exception at :" + e.getMessage());
//                e.printStackTrace();
            }
        }
    }

    public static int getIntegerInput(BufferedReader br, String msg){
        while(true){
            try{
                System.out.print(msg);
                return Integer.parseInt( br.readLine() );
            }
            catch (IOException ioe) {
                System.out.println("IOException Occurred While Reading Input :" + ioe.getMessage());
            }
            catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException Enter A Valid Number! :" + nfe.getMessage());
            }
            catch (Exception e) {
                System.out.println("Unknown Error :" + e.getMessage());
//                e.printStackTrace();
            }
        }
    }
}