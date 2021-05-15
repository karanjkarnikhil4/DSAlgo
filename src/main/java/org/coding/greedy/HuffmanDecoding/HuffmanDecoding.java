package org.coding.greedy.HuffmanDecoding;

// { Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class minHeapNode {
  char data;
  int freq;
  minHeapNode left, right;

  minHeapNode(char data, int freq) {
    left = right = null;
    this.data = data;
    this.freq = freq;
  }
}

class heapComparator implements Comparator<minHeapNode> {
  public int compare(minHeapNode h1, minHeapNode h2) {
    if (h1.freq < h2.freq) {
      return 1;
    } else if (h1.freq > h2.freq) {
      return -1;
    }
    return 0;
  }
}

class driverClass {

  static PriorityQueue<minHeapNode> heapq;
  static HashMap<Character, Integer> freqMap;
  static HashMap<Character, String> codes;

  static void storeCodes(minHeapNode root, String str) {
    if (root == null) return;
    if (root.data != '$') codes.put(root.data, str);
    storeCodes(root.left, str + "0");
    storeCodes(root.right, str + "1");
  }

  static void encodeString() {
    minHeapNode left, right, top;
    for (Map.Entry<Character, Integer> val : freqMap.entrySet()) {
      heapq.add(new minHeapNode(val.getKey(), val.getValue()));
    }
    while (heapq.size() != 1) {
      left = heapq.poll();
      right = heapq.poll();
      top = new minHeapNode('$', left.freq + right.freq);
      top.left = left;
      top.right = right;
      heapq.add(top);
    }
    storeCodes(heapq.peek(), "");
  }

  static void calcFreq(String str) {
    for (int i = 0; i < str.length(); i++) {
      Integer j = freqMap.get(str.charAt(i));
      freqMap.put(str.charAt(i), (j == null) ? 1 : j + 1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      String str = br.readLine().trim();
      heapq = new PriorityQueue<minHeapNode>(new heapComparator());
      codes = new HashMap<Character, String>();
      freqMap = new HashMap<Character, Integer>();
      String encodedString = "";
      calcFreq(str);
      encodeString();
      for (int i = 0; i < str.length(); i++) {
        encodedString += codes.get(str.charAt(i));
      }
      GfG g = new GfG();
      System.out.println(g.decodeString(heapq.peek(), encodedString));
    }
  }
}

// } Driver Code Ends

// User function Template for Java
class GfG {

  // your required to complete this function
  // this function should return the encoded string
  // see the main function for the minHeapNode reference
  String decodeString(minHeapNode root, String encodedStr) {
    // Code here
    int index =0;
    minHeapNode mainRoot = root;
    StringBuilder stringBuilder = new StringBuilder();

    while(index <encodedStr.length())
    {
      mainRoot =root;
      DecodedCharacterLength decodedCharacterLength =decodeStringCharacter(mainRoot,encodedStr,index);
      stringBuilder.append(decodedCharacterLength.c);
      index = decodedCharacterLength.length;


    }

    return stringBuilder.toString();
  }

  DecodedCharacterLength decodeStringCharacter(minHeapNode root, String encodedStr, int index) {
    if (root == null) {
      return null;
    }

    if (index == encodedStr.length()) {
      return new DecodedCharacterLength(root.data, index);
    }

    if (encodedStr.charAt(index) == '1') {
      DecodedCharacterLength decodedCharacterLength =
          decodeStringCharacter(root.right, encodedStr, index + 1);
      if (decodedCharacterLength == null) {
        return new DecodedCharacterLength(root.data, index);
      }
      return decodedCharacterLength;
    }

    else {
      DecodedCharacterLength decodedCharacterLength =
          decodeStringCharacter(root.left, encodedStr, index + 1);
      if (decodedCharacterLength == null) {
        return new DecodedCharacterLength(root.data, index);
      }
      return decodedCharacterLength;
    }
  }

  class DecodedCharacterLength {
    Character c;
    int length;

    public DecodedCharacterLength(Character c, int length) {
      this.c = c;
      this.length = length;
    }

    public Character getC() {
      return c;
    }

    public int getLength() {
      return length;
    }
  }
}
