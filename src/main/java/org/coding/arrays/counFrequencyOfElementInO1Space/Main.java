package org.coding.arrays.counFrequencyOfElementInO1Space;

public class Main {
 
    //Function to find counts of all elements present in arr[0..n-1]. The array  elements must be range from 1 to n
    public static void countfrequenciesEfficient(int input[]) {
 
         //Practise Yourself : Write your code Here
         int n =input.length;
         int freq =0;
         for(int i =0; i<n; i++)
         {
             input[i] = input[i] -1;
         }

         for(int i =0; i<n ;i++)
        {
            if(input[i] > n-1)
            {
                input[input[i]%n] = input[input[i]%n]+n;
            }

            else
            {
                input[input[i]] =  input[input[i]]+n;
            }
        }

         for(int i =0; i <n; i++)
         {
             int number = i+1;
             int frequency =input[i]/n;
             System.out.println( number +" " + frequency);
         }
         
    }
 
    public static void main(String[] args) {
        int[] input = { 2, 3, 3, 2, 5 };
        countfrequenciesEfficient(input);
    }
}

/* Try more Inputs
case 1: 
actual = countfrequenciesEfficient([1, 2, 2, 1, 1, 2, 3, 2])
expected = [[1 3],[2 4],[3  1]]

case2: 
 actual = countfrequenciesEfficient([1, 2, 2])
 expected = [[1 1],[2 2]]
 
case3: 
actual = countfrequenciesEfficient([4, 4, 4, 4}])
expected = [[4 4]]
*/