package org.coding.heap.sortElementsByFrequency;/*package whatever //do not write package name here */


import javax.lang.model.type.IntersectionType;
import java.lang.*;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class GFG {
    public static void main(String[] args) throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }


            int[] ans = new Solution().frequencySort(arr, n);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

class Solution {

    public int[] frequencySort(int[] arr, int n) {

        int[] returnableArray = new int[n];
        int returnableArrayIndex = 0;

        HashMap<Integer, NumberFrequency> numberFrequencyHashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (numberFrequencyHashMap.containsKey(arr[i])) {
                numberFrequencyHashMap.get(arr[i]).frequency = numberFrequencyHashMap.get(arr[i]).frequency + 1;
            } else {
                numberFrequencyHashMap.put(arr[i], new NumberFrequency(arr[i], 1));
            }
        }

        NumberFrequency[] resultArray = new NumberFrequency[numberFrequencyHashMap.size()];

        int resultArrayIndex = 0;
        for(NumberFrequency numberFrequency : numberFrequencyHashMap.values())
        {
            resultArray[resultArrayIndex++] = numberFrequency;
        }

        resultArray = (NumberFrequency[]) Arrays.stream(resultArray).sorted((o1, o2) -> {
            if(o1.frequency > o2.frequency)
            {
                return -1;
            }

            else if(o1.frequency < o2.frequency)
            {
                return 1;
            }
            else
            {
                if(o1.number > o2.number)
                {
                    return 1;
                }
                else if ( o1.number < o2.number){
                    return -1;
                }
                else
                {
                    return 0;
                }
            }
        }).toArray(NumberFrequency[]::new);

        for(int i =0; i< resultArray.length; i++)
        {
            NumberFrequency numberFrequency =  resultArray[i];
            for(int j =0 ; j < numberFrequency.frequency; j++)
            {
                returnableArray[returnableArrayIndex++] =  numberFrequency.number;
            }
        }

        return returnableArray;
    }
}

class NumberFrequency {
    public NumberFrequency(int number, int frequency) {
        this.number = number;
        this.frequency = frequency;
    }

    public int number;
    public int frequency;
}