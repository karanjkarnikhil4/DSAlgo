package org.coding.dynamicProgramming.longestCommonSubString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class GFG
{
  public static void main(String args[])throws IOException
  {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while(t-- > 0)
    {
      String input[] = read.readLine().trim().split(" ");
      int n = Integer.parseInt(input[0]);
      int m = Integer.parseInt(input[1]);

      String S1 = read.readLine().trim();
      String S2 = read.readLine().trim();

      Solution ob = new Solution();
      System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
    }
  }
}// } Driver Code Ends


//User function Template for Java

class Solution{
  private static HashMap<String,Integer> hashMap = new HashMap<>();

  int longestCommonSubstr(String S1, String S2, int n, int m){

    // code here
    return lcSubr(S1.length()-1, S2.length()-1,S1.toCharArray(),S2.toCharArray(),0);
  }

  int lcSubr(int firstStringIndex, int lastStringIndex,char[] string1, char[] string2,int count)
  {
      if(firstStringIndex <0 || lastStringIndex <0)
      {
        return count;
      }

      if(!hashMap.containsKey(firstStringIndex+"-"+lastStringIndex+"-"+count))
    {
      int choice1=0;
      if(string1[firstStringIndex] == string2[lastStringIndex])
      {
         choice1 =lcSubr(firstStringIndex-1, lastStringIndex-1,string1,string2,count+1);
      }


        int choice2 =  lcSubr(firstStringIndex-1,lastStringIndex,string1,string2,0);
        int choice3=  lcSubr(firstStringIndex,lastStringIndex-1,string1,string2,0);
        hashMap.put(firstStringIndex+"-"+lastStringIndex+"-"+count,Math.max(Math.max(choice1,choice2),choice3));
        return hashMap.get(firstStringIndex+"-"+lastStringIndex+"-"+count);

      }

      else
    {
      return hashMap.get(firstStringIndex+"-"+lastStringIndex+"-"+count);
    }
  }
}