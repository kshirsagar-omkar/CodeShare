package com.assignments.entities.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AcceptCities {

    public static void main()
    {
        ArrayList<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            while (true) {
                String choice = null;
                System.out.print("Do You Want To Enter City Name [yes/no]: ");
                choice = br.readLine();
                if(choice.equalsIgnoreCase("yes")){
                    System.out.println("Enter City Name : ");
                    list.add( br.readLine() );
                }
                else if(choice.equalsIgnoreCase("no")){
                    break;
                }
                else {
                    System.out.println("wrong choice!!!\nPleas Enter Again!!\n\n");
                }
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("City Names : " + list);
    }

}
