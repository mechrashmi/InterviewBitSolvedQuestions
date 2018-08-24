package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

/*


Given an array of integers, find the length of longest subsequence which is first increasing then decreasing.

**Example: **

For the given array [1 11 2 10 4 5 2 1]

Longest subsequence is [1 2 10 4 2 1]

Return value 6

 */

public class LongestIncreasingAndThenDecreasingSubSequence {
    public int longestSubsequenceLength(final List<Integer> A) {
        int n = A.size();
        int[] longestLtoR = new int[A.size()];
        Arrays.fill(longestLtoR, 1);
        int[] longestRtoL = new int[A.size()];
        Arrays.fill(longestRtoL, 1);

        //Find longest sub-sequence from left to right
        for(int i = 1; i < n; i++){
            int j = 0;
            while(j < i){
                if(A.get(j) < A.get(i)){
                    longestLtoR[i] = Math.max(longestLtoR[i], longestLtoR[j] + 1);
                }
                j++;
            }
        }


        //Find longest sub-sequence from right to left
        for(int i = n - 2; i >= 0; i--){
            int j = n - 1;
            while(j > i){
                if(A.get(j) < A.get(i)){
                    longestRtoL[i] = Math.max(longestRtoL[i], longestRtoL[j] + 1);
                }
                j--;
            }

        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(max, longestLtoR[i] + longestRtoL[i] - 1);
        }


        return max == Integer.MIN_VALUE ? 0 : max;

    }
}
