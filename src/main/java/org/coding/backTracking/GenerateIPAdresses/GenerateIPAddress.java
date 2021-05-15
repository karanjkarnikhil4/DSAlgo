package org.coding.backTracking.GenerateIPAdresses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class GenIP {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s = sc.next();
      Solution sln = new Solution();
      ArrayList<String> str = sln.genIp(s);
      Collections.sort(str);
      for (String u : str) {
        System.out.println(u);
      }
    }
  }
}// } Driver Code Ends


/*complete the Function*/

class Solution {


  public ArrayList<String> genIp(String s) {
    ArrayList<String> arrayList;
    // code here
    arrayList = new ArrayList<>();
    generateIPAddress(s,3,new ArrayList<String>(),arrayList);
    return arrayList;
  }

  private void generateIPAddress(
      String s, int remainingDots, ArrayList<String> ip, ArrayList<String> arrayList) {
    if (remainingDots == 0) {

      if(isStringValid(s))
      {

        ip.add(s);
        arrayList.add(String.join("",ip));
        ip.remove(ip.size()-1);
      }
      return ;
    }

    int value = Math.min(s.length()-1,3);

    for(int i =0; i < value; i++)
    {
      String subString =s.substring(0,i+1);
          if(isStringValid(subString)&& (s.length()-value) >=1)
          {
            ip.add(subString+".");
            generateIPAddress(s.substring(i+1),remainingDots-1,ip,arrayList);
            ip.remove(ip.size()-1);
          }
    }
  }

  private boolean isStringValid(String s) {
    long parsedString = Long.parseLong(s);
    if ((parsedString >= 0 && parsedString <= 255) ) {
      if(parsedString>0)
      {
        if(s.charAt(0) != '0')
        {
          return true;
        }
      }
      else if(parsedString ==0 && s.length() ==1)
      {
        return true;
      }
    }
    return false;
  }
}