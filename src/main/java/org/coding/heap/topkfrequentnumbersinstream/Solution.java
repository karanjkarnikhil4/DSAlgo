package org.coding.heap.topkfrequentnumbersinstream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args)
    {
        Solution solution = new Solution();
       int[] result = solution.topKFrequent(new int[]{3,0,1,0},1);
       for(int i =0;i<result.length;i++)
       {
           System.out.println(result[i]);
       }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, NumberFrequency> numberFrequencyMap = new HashMap<>();
        int[] result = new int[k];

        PriorityQueue<NumberFrequency> numberFrequencyPriorityQueue = new PriorityQueue<>(new Comparator<NumberFrequency>() {
            @Override
            public int compare(NumberFrequency o1, NumberFrequency o2) {
                if (o1.frequency > o2.frequency) {
                    return -1;
                } else if (o1.frequency < o2.frequency) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < nums.length; i++) {
            if (numberFrequencyMap.containsKey(nums[i])) {
                numberFrequencyMap.get(nums[i]).frequency = numberFrequencyMap.get(nums[i]).frequency + 1;
            } else {
                NumberFrequency numberFrequency = new NumberFrequency(nums[i], 1);
                numberFrequencyMap.put(nums[i], numberFrequency);

            }
        }

        for(NumberFrequency numberFrequency: numberFrequencyMap.values())
        {
            numberFrequencyPriorityQueue.add(numberFrequency);
        }
        for (int i = 0, j = 0; i<k; i++,j++) {
            result[j] = numberFrequencyPriorityQueue.poll().number;
        }

        return result;
    }
}

class NumberFrequency {
    public NumberFrequency(int number, int frequency) {
        this.number = number;
        this.frequency = frequency;
    }

    public int number;
    public int frequency;
}