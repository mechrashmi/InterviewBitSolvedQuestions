package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class LongestPalindromeSubsequence {

    public static void main(String[] args) {
        System.out.println(find("agbdba"));
        System.out.println(find("geeksforgeeks"));
        System.out.println(find("BBABCBCAB"));
    }


    public static String find(String input){
        int n = input.length();
        int[][] table = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(table[i], 0);
        }

        //fill for len = 1
        for(int i = 0; i < n; i++){
            table[i][i] = 1;
        }

        //fill for len = 2 to n;
        int k = 1;
        while(k < n){
            for(int i = 0; i + k < n; i++){
                int j = i + k;
                if(input.charAt(i) == input.charAt(j)){
                    table[i][j] = 2 + table[i+1][j - 1];
                }
                else{
                    table[i][j] = Math.max(table[i][j - 1], table[i + 1][j]);
                }

            }
            k++;
        }

        System.out.println("max length of the sub-sequence which is a palindrome is " + table[0][n - 1]);
        ArrayList<Integer> indexes = new ArrayList<>();

        int l = 0, m = n - 1;
        while(m >= l){
            if(m == l){
                indexes.add(l);
                break;
            }

            if(input.charAt(l) == input.charAt(m)){
                indexes.add(l);
                indexes.add(m);
                m--;
                l++;
            }
            else {
                if(table[l][m] == table[l + 1][m]){
                    l++;
                }
                else{
                    m--;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        Collections.sort(indexes);
        for(int i = 0; i < indexes.size(); i++){
            builder.append(input.charAt(indexes.get(i)));
        }

        return builder.toString();
    }
}
