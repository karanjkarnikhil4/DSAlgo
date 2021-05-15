package org.coding.backTracking.wordBoggle;

// { Driver Code Starts
//Initial Template for Java

import java.util.*;

class GFG
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t>0)
    {
      int N = sc.nextInt();
      String[] dictionary = new String[N];
      for(int i=0;i<N;i++)
      {
        dictionary[i] = sc.next();
      }

      int R = Integer.parseInt(sc.next());
      int C = Integer.parseInt(sc.next());

      char board[][] = new char[R][C];
      for(int i=0;i<R;i++)
      {
        for(int j=0;j<C;j++)
        {
          board[i][j] = sc.next().charAt(0);
        }
      }

      Solution obj = new Solution();
      String[] ans = obj.wordBoggle(board, dictionary);

      if(ans.length == 0) System.out.println("-1");
      else
      {
        Arrays.sort(ans);
        for(int i=0;i<ans.length;i++)
        {
          System.out.print(ans[i] + " ");
        }
        System.out.println();
      }

      t--;
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{

  private static ArrayList<String> foundList;
  Map<Character,ArrayList<String>> alphabetDictionary;

  public String[] wordBoggle(char board[][], String[] dictionary)
  {
    foundList = new ArrayList<>();
     alphabetDictionary = new HashMap<>();
    // Write your code here
    for (String s : dictionary) {
       if(alphabetDictionary.get(s.charAt(0))==null)
       {
         ArrayList<String> arrayList = new ArrayList<>();
         arrayList.add(s);
         alphabetDictionary.put(s.charAt(0),arrayList);
       }
       else
       {
         alphabetDictionary.get(s.charAt(0)).add(s);
       }
    }

    boolean[][] visited = new boolean[board.length][board[0].length];

    for(int i =0; i< board.length;i++)
    {
      for(int j=0;j<board[0].length; j++)
      {

        ArrayList<String> words =alphabetDictionary.get(board[i][j]);
        if(words!=null && words.size()>0)
        {
          Iterator<String> wordIterator =words.iterator();
        while(wordIterator.hasNext())
        {
              visited[i][j] = true;
              if(findWord(wordIterator.next().toCharArray(), i, j, visited, board, 0))
              {
                wordIterator.remove();
              }
              visited[i][j] = false;
        }
        }
      }
    }

    return foundList.toArray(new String[0]);
  }

  private boolean findWord(char[] word,int i , int j, boolean[][] visited,char[][] board, int tracedUntil)
  {
    if(tracedUntil == word.length-1)
    {
      foundList.add(new String(word));
      return true;
    }

    int[] X = {0,-1,-1,-1,0,1,1,1};
    int[] Y = {-1,-1,0,1,1,1,0,-1};

    for(int k =0; k < 8 ;k++)
    {
      int newX = i+X[k];
      int newY = j+Y[k];
      if(isValid(newX,newY,board,visited))
      {
      if(word[tracedUntil+1] == board[newX][newY])
      {
        visited[newX][newY] = true;
        if(findWord(word,newX,newY,visited,board,tracedUntil+1))
        {
          visited[newX][newY] = false;
          return true;
        }
        visited[newX][newY] = false;
      }
      }
    }
   return false;
  }

  private boolean isValid(int i , int j, char[][] board, boolean[][] visited)
  {
    if((i>=0 && i < board.length) && (j>=0 && j < board[0].length) && !visited[i][j]) return true;
    return false;
  }
}