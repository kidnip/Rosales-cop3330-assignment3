package ex43;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */
public class WebsiteGen {
    public static File indexGen(String path, String name, String author){
        File temp = new File(path +"/index.html");
        String html = "<head>\n\t<title>" +name +"</title>\n\t<meta name=\"author\" content=\"" +author +"\">\n</head>";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
            bw.write(html);
            bw.close();
            return temp;
        } catch (IOException e) {
            System.out.println("HTML file could not be created.");
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String name, author, c1, c2;
        String path = "src/main/java/ex03/website";

        System.out.print("Site name: ");
        name = input.nextLine();
        System.out.print("Author: ");
        author = input.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        c1 = input.next().toLowerCase();
        System.out.print("Do you want a folder for CSS? ");
        c2 = input.next().toLowerCase();

        path = path + "/" + name;
        File domainFile = new File(path);
        if(domainFile.mkdirs()){
            System.out.println("Created " +path);
        }
        else{
            System.out.println("Directory could not be created.");
        }

        File index = indexGen(path, name, author);
        if(index != null){
            System.out.println("Created " +path +"/index.html");
        }

        if(c1.equals("y") || c1.equals("yes")){
            File javaFile = new File(path + "/js");
            if(javaFile.mkdir()){
                System.out.println("Created " +path +"/js/");
            }
            else{
                System.out.println("Directory could not be created.");
            }
        }

        if(c2.equals("y") || c2.equals("yes")){
            File cssFile = new File(path + "/css");
            if(cssFile.mkdir()){
                System.out.println("Created " +path +"/css/");
            }
            else{
                System.out.println("Directory could not be created.");
            }
        }
    }
}
