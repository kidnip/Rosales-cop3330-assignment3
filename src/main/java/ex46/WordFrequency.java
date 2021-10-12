package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.stream.Collectors.toMap;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */
public class WordFrequency {
    public static HashMap<String, Integer> getFrequencies(String[] text){
        HashMap<String, Integer> temp = new HashMap<>();

        for (String s : text) {
            if (temp.containsKey(s)) {
                temp.put(s, temp.get(s) + 1);
            } else {
                temp.put(s, 1);
            }
        }

        temp = temp
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        return temp;
    }

    public static void main(String[] args) {
        File inFile = new File("src/main/java/ex06/exercise46_input.txt");
        ArrayList<String> textList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(inFile);
            while(scanner.hasNextLine()) {
                textList.add(scanner.next());
            }
            String[] textArray = textList.toArray(new String[0]);
            HashMap<String, Integer> freqMap = getFrequencies(textArray);

            for(Map.Entry<String,Integer> entry: freqMap.entrySet())
            {
                System.out.printf("%-10s", entry.getKey() + ":");
                for(int i = 0; i < entry.getValue(); i++){
                    System.out.print("*");
                }
                System.out.print("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be accessed.");
            e.printStackTrace();
        }

    }
}
