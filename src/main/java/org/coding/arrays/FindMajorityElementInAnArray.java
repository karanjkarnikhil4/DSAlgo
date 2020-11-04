package org.coding.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class FindMajorityElementInAnArray {
    public static void main(String[] args) throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int majorityElement = getMajorityElement(arr, n);

            System.out.println(majorityElement);
        }
    }

    private static int getMajorityElement(int[] arr, int n) {

        Map<Integer, Integer> map = new HashMap();
        Integer majorityElement = null;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                int elementCount = map.get(arr[i]);
                elementCount = elementCount + 1;
                map.put(arr[i], elementCount);
                if (elementCount > (n / 2)) {

                    majorityElement = arr[i];
                    break;
                }

            } else {
                map.put(arr[i], 1);
            }
        }

        if (majorityElement == null) {
            majorityElement = -1;
        }
        return majorityElement;
    }
}