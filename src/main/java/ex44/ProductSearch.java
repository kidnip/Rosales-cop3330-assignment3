package ex44;


import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */
public class ProductSearch{
    public static Products[] parseFile(String path, String arrayName){
        JSONParser jsonParser = new JSONParser();

        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));
            JSONArray jsonArray = (JSONArray) jsonObject.get(arrayName);

            Gson gson = new Gson();

            return gson.fromJson(jsonArray.toString(), Products[].class);

        } catch (IOException | ParseException e) {
            System.out.println("JSON File could not be parsed.");
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;
        int index = 0, flag = 0;


        Products[] products = parseFile("src/main/java/ex04/exercise44_input.json", "products");

        System.out.print("What is the product name? ");
        choice = input.next();
        if (products != null) {
            while (true) {
                for (int i = 0; i < products.length; i++) {
                    if (products[i].getName().equals(choice)) {
                        flag = 1;
                        index = i;
                        break;
                    }
                }
                if (flag == 1) {
                    System.out.println("Name: " + products[index].getName());
                    System.out.printf("Price: %.2f\n", products[index].getPrice());
                    System.out.println("Quantity: " + products[index].getQuantity());
                    break;
                } else {
                    System.out.println("Sorry, that product was not found in our inventory.");
                    System.out.print("What is the product name? ");
                    choice = input.next();
                }
            }
        }
    }
}
