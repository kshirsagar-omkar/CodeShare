package com.tca;

import com.tca.reversefilelines.ReverseFileLinesWords;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String []args){
        try {
            ReverseFileLinesWords.reverseFileLinesWords("src/resources/demo.txt");
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}