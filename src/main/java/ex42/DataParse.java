package ex42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */
public class DataParse {
    public static String[][] parse(String[] input, int n){
        String[][] parseArr = new String[input.length][];
        for(int i = 0; i < n; i++)
            parseArr[i] = input[i].split(",");

        return parseArr;
    }

    public static void main(String[] args)
    {
        File nameFile = new File("src/main/java/ex02/exercise42_input.txt");
        String[] inputArray = new String[100];
        int counter = 0, i, j;

        try
        {
            Scanner input = new Scanner(nameFile);
            while(input.hasNextLine()){
                inputArray[counter] = input.next();
                counter++;
            }

            String[][] parseArray = parse(inputArray, counter);
            System.out.println("Last      First     Salary");
            System.out.println("--------------------------");
            for(i = 0; i < counter; i++){
                for(j = 0; j < parseArray[i].length - 1; j++){
                    System.out.printf("%-10s", parseArray[i][j]);
                }
                System.out.printf("%-6s\n", parseArray[i][j]);
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("File could not be accessed.");
            e.printStackTrace();
        }


    }
}
