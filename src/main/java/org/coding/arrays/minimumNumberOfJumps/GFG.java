package org.coding.arrays.minimumNumberOfJumps;// { Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}
// } Driver Code Ends



class Solution{
    static int minJumps(int[] arr){

        if(arr.length == 0 || arr.length ==1)
        {
            return 0;
        }

        int jump =1;

        int a = arr[0];
        int b = arr[0];


        for(int i =1; i < arr.length; i++)
        {
            a--;
            b--;

            if(a<0)
            {
                return -1;
            }

            if(b < arr[i])
            {
                b= arr[i];
            }
            if(a==0 && i < arr.length-1)
            {
                jump++;
                a=b;
            }
        }

        return jump;
    }


}