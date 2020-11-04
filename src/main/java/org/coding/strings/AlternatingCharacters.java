package org.coding.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        int countDeletions =0;
        if (s.length() ==1)
        {
            return 0;
        }
        for(int i =0; i< s.length()-1; i++)
        {
            if(s.charAt(i) ==s.charAt(i+1))
            {
                countDeletions++;
            }
        }

        return countDeletions;
    }

    public static void main(String[] args) throws IOException {


            int result = alternatingCharacters(new String("ABABABAB"));
            System.out.println(result);
    }
}
