package GeeksForGeeks.GoldmanSachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class UniqueCharacter {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>(Arrays.asList(new String[]{"abbba", "ab", "ba", "abcd", "abdc", "adbc", "aabddc"}));
        findUniqueCharacterCount(input);
    }

    public static void findUniqueCharacterCount(ArrayList<String> list){
        HashMap<String, Integer> count = new HashMap<>();
        for(String ele : list){
            String unique = findUniqueCharacter(ele);
            if(count.get(unique) == null){
                count.put(unique, 0);
            }

            count.put(unique, count.get(unique) + 1);
        }

        for(String str : count.keySet()){
            System.out.println(str + " -> " + count.get(str));
        }
    }


    public static String findUniqueCharacter(String str){
       int[] alphabate = new int[26];
       Arrays.fill(alphabate, 0);
       for(int i = 0; i < str.length(); i++){
           int index = str.charAt(i) - 'a';
           if(alphabate[index] == 0){
               alphabate[index] = 1;
           }
       }

       StringBuilder builder = new StringBuilder();
       for(int i = 0; i < 26; i++){
           if(alphabate[i] == 1){
               builder.append((char)('a' + i));
           }
       }

       return builder.toString();
    }
}
