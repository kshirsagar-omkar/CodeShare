package com.tca;

import com.tca.entities.Login;
import com.tca.exceptions.InvalidLogin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfUsers = 1;
        boolean userFound = false;

        Login []loginInfos = new Login[numberOfUsers];

        //Sign Up
        System.out.println("\n-- Sign Up / First Time Login --\n");
        for (int i = 0; i < loginInfos.length; i++) {
            try {
                loginInfos[i] = new Login();
                loginInfos[i].setName(getStringInput(br, "Enter Username : "));
                loginInfos[i].setPassword(getStringInput(br, "Enter Password : "));
            }
            catch (NullPointerException npe){
                System.out.println("NullPointerException Occured !!!!! " + npe.getMessage());
                // npe.printStackTrace();
            }
            catch (Exception e) {
                System.out.println("Unknown Exception Occured!!! " + e.getMessage());
                // e.printStackTrace();
            }

        }
        System.out.println("Sign Up Completed Successfully !!!\n");


        //Assignment Code starts from here
        System.out.println("--Login To Get Access--");
        String userName = getStringInput(br, "Enter UserName : ");
        String password = getStringInput(br, "Enter Password : ");

        try {
            userFound = false;
            for (int i = 0; i < loginInfos.length; i++) {
                if( loginInfos[i].getName().equals(userName) && loginInfos[i].getPassword().equals(password) ){
                    userFound = true;
                }
            }

            if(userFound == false) {
                throw new InvalidLogin("UserName & Password Does Not Match in DataBase!!!");
            }
        }
        catch (InvalidLogin il) {
            System.out.println(il.getMessage());
//            il.printStackTrace();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }

        if(userFound == true){
            System.out.println("Granted Access Successfully :)");
        }



//        displayUserInfo(loginInfos);



        try{
            br.close();
        }
        catch (IOException ioe) {
            System.out.println("IOException Occured During Closing BufferedReader!!! " + ioe.getMessage());
            // ioe.printStackTrace();
        }

    }

    public static void displayUserInfo(Login []loginInfos){
        System.out.println("\n-- User Infos --\n");
        for (int i = 0; i < loginInfos.length; i++) {
            try {
                System.out.println("UserName : " + loginInfos[i].getName());
                System.out.println("Password : " + loginInfos[i].getPassword());
            }
            catch (NullPointerException npe){
                System.out.println("NullPointerException Occured !!!!! " + npe.getMessage());
                // npe.printStackTrace();
            }
            catch (Exception e) {
                System.out.println("Unknown Exception Occured!!! " + e.getMessage());
                // e.printStackTrace();
            }
        }
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

}