package org.coding.codingchallenge;

import java.util.Arrays;

public class DemoTask {


    public static void main(String[] args) {

    }


    public int solution(int[] A)
    {
        Arrays.sort(A);

        int smallestPositiveInteger =1;
        for(int i =0; i< A.length; i++)
        {
            if(A[i] == smallestPositiveInteger)
            {
                smallestPositiveInteger++;
            }
        }

            return smallestPositiveInteger;
    }
}
