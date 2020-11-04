package org.coding.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndValidString {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the isValid function below.
    static String isValid(String s) {

        boolean isStringValid = true;
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (countMap.containsKey(s.charAt(i))) {
                countMap.put(s.charAt(i), 1);
            } else {
                int value = countMap.get(s.charAt(i)) + 1;
                countMap.put(s.charAt(i), value);
            }
        }

        Map<Integer,Integer> mapInteger = new HashMap<>();
        Collection<Integer> integerList = countMap.values();

        for (Integer integer : integerList) {

            if(mapInteger.size() > 2)
            {
                isStringValid = false;
                break;

            }

            if(mapInteger.containsKey(integer))
            {
                int value =mapInteger.get(integer)+1;
                mapInteger.put(integer,value);
            }

            else
            {
                mapInteger.put(integer,1);
            }
        }


        if(mapInteger.size()  == 2)
        {
            for (Integer value : mapInteger.values()) {

            }
        }



        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
