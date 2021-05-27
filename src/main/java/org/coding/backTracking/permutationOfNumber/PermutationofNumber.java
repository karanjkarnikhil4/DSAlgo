package org.coding.backTracking.permutationOfNumber;

import java.util.HashSet;
import java.util.Set;

public class PermutationofNumber {

    void printPermutationOfNumber(int position, int[] arr, Set<Integer> usedNumbers, int number)
    {
        if(position > arr.length-1)
        {
            printArray(arr);
            return;
        }

        else
        {
            for(int i =1; i<=number; i++)
            {
                if(!usedNumbers.contains(i))
                {
                    arr[position] = i;
                    usedNumbers.add(i);
                    printPermutationOfNumber(position+1,arr,usedNumbers,number);
                    usedNumbers.remove(i);
                }
            }
        }

    }

    private void printArray(int[] array)
    {
        for(int i=0; i<array.length;i++)
        {
            System.out.print(array[i]);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        PermutationofNumber permutationofNumber = new PermutationofNumber();
        int[] array = new int[3];
        Set<Integer> usedNumbers = new HashSet<>();
        permutationofNumber.printPermutationOfNumber(0,array,usedNumbers,3 );
    }
}
