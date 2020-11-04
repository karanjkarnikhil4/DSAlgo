package org.coding.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Anagrams {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

       int  numberOfRemovals = 0;

        char[] charArrayA = a.toCharArray();
        char[] charArrayB = b.toCharArray();

        int pointerA =0;
        int pointerB =0;

        int pointerBMinSearchIndex = 0;

        while(pointerA <= (charArrayA.length -1) && pointerB <=(charArrayB.length-1))
        {
            if(charArrayA[pointerA]== charArrayB[pointerB])
            {
                pointerA++;
                pointerB++;
            }

            else
            {
                pointerBMinSearchIndex = pointerB;
                boolean valueFound =findIfPresent(charArrayA, charArrayB, pointerA, pointerB, pointerBMinSearchIndex);

                if(valueFound) {
                    pointerA++; pointerB++;
                }
                else
                {
                    numberOfRemovals++;
                    pointerA++;
                }
            }


        }
        numberOfRemovals = numberOfRemovals + (charArrayA.length-pointerA )+(charArrayB.length - pointerB) ;
        return numberOfRemovals;

    }

    private static boolean findIfPresent(char[] charArrayA, char[] charArrayB, int pointerA, int pointerB, int pointerBMinSearchIndex) {
        boolean valueFound = false;
        while (pointerBMinSearchIndex <=(charArrayB.length-1))
        {
            if(charArrayA[pointerA] == charArrayB[pointerBMinSearchIndex])
            {
                swap(charArrayB,pointerB,pointerBMinSearchIndex);
                valueFound = true;
                break;
            }

            pointerBMinSearchIndex++;
        }

        return valueFound;
    }

    private static void swap(char[] c, int firstIndex, int secondIndex) {
        char tempVariable = c[firstIndex];

        c[firstIndex] =c[secondIndex];
        c[secondIndex] = tempVariable;
    }

    public static void main(String[] args) throws IOException {
        int res = makeAnagram( new String("cde"), new String("abc"));
        System.out.println(res);
    }
}
