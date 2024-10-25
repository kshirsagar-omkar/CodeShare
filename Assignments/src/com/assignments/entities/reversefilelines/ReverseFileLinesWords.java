package com.assignments.entities.reversefilelines;

import java.io.*;
import java.util.Stack;

public class ReverseFileLinesWords {

    public static void reverseFileLinesWords(String filePath) throws FileNotFoundException{
        //Checking File is Good To Do Work on it
        {
            File f = new File(filePath);
            if (!f.isFile()) {
                throw new FileNotFoundException("Given Path is Not For File!!!");
            }
            if (!f.exists()) {
                throw new FileNotFoundException("File Does Not Exist!!!");
            }
            if (f.length() <= 0) {
                throw new FileNotFoundException("Given File is Empty!!!");
            }
            if(!f.canRead()){
                throw new FileNotFoundException("Cannot Read the Given File!!!");
            }
        }

        reverseWordsInLine(filePath);

    }

    private static void reverseWordsInLine(String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line = null;
            while ((line = br.readLine()) != null)
            {
//                String line = br.readLine();
                String[] words = line.split(" ");

                Stack<String> stack = new Stack<>();
                for (String word : words) {
                    stack.push(word);
                }
                while (!stack.empty()) {
                    System.out.print(stack.pop() + " ");
                }
                System.out.println();
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String []args){
        try {
            ReverseFileLinesWords.reverseFileLinesWords("src/resources/demo.txt");
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
