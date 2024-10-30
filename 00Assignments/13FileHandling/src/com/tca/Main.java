package com.tca;

import com.tca.entities.WriteEvenNumberIntoFile;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Integer []arr = new Integer[args.length];

        for(int i=0; i < args.length; ++i){
            try {
                arr[i] = Integer.parseInt(args[i]);
            }
            catch (NumberFormatException e){
                System.out.println(e.getMessage() + "\nTaking Default Value arr[" + i + "] = null\n");
                arr[i] = null;
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        System.out.println("Input Array : " + Arrays.toString(arr));

        String path = "src/resources/evenNumbers.txt";


        WriteEvenNumberIntoFile ob1 = new WriteEvenNumberIntoFile();

        ob1.setFilePath(path);
        ob1.writeEvenNumbersIntoFile(arr);


    }
}