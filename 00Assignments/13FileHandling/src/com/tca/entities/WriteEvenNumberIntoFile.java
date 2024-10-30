package com.tca.entities;

import com.tca.exceptions.InvalidFileException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteEvenNumberIntoFile {

    private String filePath=null;


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    public void validateFile() throws InvalidFileException{
        File f = new File(this.filePath);

        if( !f.exists() ){
                try {
                    if( !f.createNewFile() ){
                        throw new InvalidFileException("Failed to create file!!");
                    }
                }catch (IOException e){
                    throw new InvalidFileException("IOException While Creating file : " + e.getMessage());
                }
        }
        if( !f.isFile() ){
            throw new InvalidFileException("The given path does not point to a file!");
        }
        if( !f.canWrite() ){
            throw new InvalidFileException("Write permission is denied for the file!");
        }
    }

    public void writeEvenNumbersIntoFile(Integer []nums) throws InvalidFileException{

        validateFile();

        StringBuilder str = new StringBuilder();
        for (Integer num : nums) {
            if (num != null && num % 2 == 0) {
                str.append(num).append(" ");
            }
        }

        try (FileWriter fw = new FileWriter(this.filePath)){
            fw.write(str.toString());
            System.out.println("Even Numbers Written into file successfully!!");
        }
        catch (IOException e){
            System.out.println("IOException while writing to the file : " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Exception while writing to the file : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
