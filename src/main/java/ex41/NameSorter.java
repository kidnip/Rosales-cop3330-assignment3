package ex41;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */
public class NameSorter {
    public static String[] sort(String[] names, int n){
        String temp;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(names[i].compareTo(names[j]) > 0){
                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        return names;
    }

    public static void main(String[] args)
    {
        File nameFile = new File("src/main/java/ex01/exercise41_input.txt");
        String[] nameArr = new String[20];
        int counter = 0;

        try {
            Scanner fInput = new Scanner(nameFile);
            while(fInput.hasNextLine())
            {
                nameArr[counter] = fInput.nextLine();
                counter++;
            }
            String[] sortedArr = sort(nameArr, counter);

            System.out.println("Total of " +counter +" names");
            System.out.println("-----------------");
            for(int i = 0; i < counter; i++)
            {
                System.out.println(sortedArr[i]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File was not readable.");
            e.printStackTrace();
        }

    }
}
