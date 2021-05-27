package org.coding.arrays.CandyDistributionProblem;

class Solution {
    public int candy(int[] ratings) {

        int min =0;
        int n = ratings.length;
        int[] right = new int[n];
        int[] left  = new int[n];

        left[0] =1;

        for(int i =1; i<n; i++)
        {
            if(ratings[i] > ratings[i-1])
            {
                left[i] = left[i-1] +1;

            }
            else
            {
                left[i] =1;
            }
        }

        right[n-1] =1;

        for(int i =n-2; i>=0; i--)
        {
            if(ratings[i] > ratings[i+1])
            {
                right[i] = right[i+1] +1;

            }
            else
            {
                right[i] =1;
            }
        }

        for(int i =0; i<n; i++)
        {
            min += Math.max(right[i],left[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.candy(new int[]{1,2,2}));
    }

}