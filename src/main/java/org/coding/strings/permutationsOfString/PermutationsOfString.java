package org.coding.strings.permutationsOfString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

class GFG {

  private static Set<Character> characterSet= new LinkedHashSet<>();
  private static int stringLength;

  public static void main(String[] args) throws IOException {
    // code
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      String s = br.readLine().trim();
      char[] characters = s.toCharArray();
      stringLength = characters.length;
      findPermutationsOfString(characters);
      System.out.println();
    }
  }

  private static void findPermutationsOfString(char[] characters) {

    if(characterSet.size() == stringLength )
    {
      for (char c : characterSet)
      {
        System.out.print(c);
      }
      System.out.print(" ");
      return;
    }

    for(int i =0; i < characters.length; i ++)
    {
      if(!characterSet.contains(characters[i]))
      {
        characterSet.add(characters[i]);
        findPermutationsOfString(characters);
        characterSet.remove(characters[i]);
      }
    }
  }
}
