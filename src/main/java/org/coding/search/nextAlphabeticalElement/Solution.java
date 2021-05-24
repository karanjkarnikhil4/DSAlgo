package org.coding.search.nextAlphabeticalElement;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextGreatestLetter(new char[]{'c','f','j'},'d'));

    }

    public char nextGreatestLetter(char[] letters, char target) {

        int start =0;
        int end = letters.length-1;
        char nextGreatestChar = '#';

        while(start <= end)
        {
            int mid = start+ ((end-start)/2);

            if(letters[mid] == target)
            {
                start = mid+1;
            }
            else if(letters[mid] < target)
            {
                start= mid+1;
            }
            else if(letters[mid] > target)
            {
                nextGreatestChar = letters[mid];
                end = mid-1;

            }
        }

        if(nextGreatestChar =='#')
        {
            return letters[((letters.length-1)+1)%letters.length];
        }

        else
        {
            return nextGreatestChar;
        }

    }
}