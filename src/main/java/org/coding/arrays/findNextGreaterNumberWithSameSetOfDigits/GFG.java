package org.coding.arrays.findNextGreaterNumberWithSameSetOfDigits;// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here

        int pointer1 = N-1;
        int pointer2;
        for(pointer2 = N-2; pointer2>=0 ; pointer1--, pointer2--)
        {
            if(arr[pointer2] < arr[pointer1])
            {
                break;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();

         if(pointer2 <0)
        {
            Arrays.sort(arr);
            for(int i: arr)
            {
                arrayList.add(i);
            }
            return arrayList;
        }

         if (arr[pointer2] < arr[pointer1])
        {
            int min = pointer1;
            for(int i = pointer1+1; i<N; i++)
            {
                if((arr[min] > arr[i]) && (arr[i] > arr[pointer2]))
                {
                    min = i;
                }
            }
            swap(pointer2, min, arr);
            Arrays.sort(arr,pointer2+1,N);
            for(int i: arr)
            {
                arrayList.add(i);
            }
            return arrayList;
        }

       return  null;
    }

    private static void swap(int pointer1, int pointer2, int[] arr) {

        int temp = arr[pointer1];
        arr[pointer1] = arr[pointer2];
        arr[pointer2] = temp;
    }
}