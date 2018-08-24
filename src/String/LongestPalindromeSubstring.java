package String;

import java.util.Arrays;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        //System.out.println(findLongestPalindromeSubstring("AABCDCBA"));
        //System.out.println(findLongestPalindromeSubstring("DEFABCBAYT"));
        //System.out.println(findLongestPalindromeSubstring("qrrc"));
        System.out.println(findLongestPalindromeSubstring("fyfvladzpbfudkklrwq"));
    }

    public static String findLongestPalindromeSubstring(String input){
        int n = input.length();
        boolean[][] table = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(table[i], false);
        }

        //fill table for char size 1 and 2
        int max_size = Integer.MIN_VALUE, max_i = -1, max_j = -1;
        for(int i = 0; i < n; i++){
            table[i][i] = true; //size 1
            if((i < n - 1) && (input.charAt(i) == input.charAt(i + 1))){
                table[i][i + 1] = true;
                if(max_size < 2){
                    max_size = 2;
                    max_i = i;
                    max_j = i + 1;
                }
            }
        }

        int k = 2;
        while(k < n) {
            for (int i = 0; i + k < n; i++) {
                int j = i + k;
                if(input.charAt(i) == input.charAt(j) && table[i + 1][j - 1]){
                    table[i][j] = true;
                    if(max_size < k + 1){
                        max_size = k + 1;
                        max_i = i;
                        max_j = j;
                    }
                }
            }
            k++;
        }

        String res = input.substring(max_i, max_j + 1);
        return res;

    }
}
