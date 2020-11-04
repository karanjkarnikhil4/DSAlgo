package org.coding.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] nAndSum = br.readLine().split(" ");
            int n = Integer.parseInt(nAndSum[0]);
            int sum=Integer.parseInt(nAndSum[1]);
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            printSumPairs(arr, n,sum);

    }


}

    private static void printSumPairs(int[] arr, int n, int sum) {

        Map<Integer, Integer> map = new HashMap();
        boolean foundPair = false;

        for(int i =0; i< arr.length; i++)
        {
            int requiredValue =  sum -arr[i];
            if(map.containsKey(requiredValue)) {
                foundPair = true;
                System.out.println(map.get(requiredValue)+" "+i);
                break;
            }
            else
            {
                map.put(arr[i],i);
            }


        }

        if(!foundPair)
        {
            System.out.println("-1 -1");
        }

    }
    }
