package ex45;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */
public class WordFinder {
    public static byte[] replaceFile(String path, String find, String change){
        try {
            String temp = Files.readString(Path.of(path));
            temp = temp.replace(find, change);

            return temp.getBytes();

        } catch (IOException e) {
            System.out.println("File could not be accessed");
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        String inPath = "src/main/java/ex05/exercise45_input.txt";
        Scanner input = new Scanner(System.in);

        try {
            byte[] text = replaceFile(inPath, "use", "utilize");

            if(text != null) {
                System.out.print("What is the output file name (exclude .txt)? ");
                Path outPath = Path.of("src/main/java/ex05/" + input.next() + ".txt");
                Files.write(outPath, text);
            }
        } catch (IOException e) {
            System.out.println("File could not be accessed");
            e.printStackTrace();
        }
    }
}
