package GeeksForGeeks.GoldmanSachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class GenericClassForSum{
    public static void main(String[] args) {
        Integer[] num = {2, 1, 8, 5, 3, 6};
        sum(new ArrayList<>(Arrays.asList(num)), 8);
    }

    public static void sum(ArrayList<Integer> list, Integer sum){
        Collections.sort(list);

        int i = 0, j = list.size() - 1;

        while(i < j){
            int tempSum = list.get(i) + list.get(j);
            if(tempSum == sum){
                System.out.println(list.get(i) + " " + list.get(j));
                j--;
                continue;
            }

            if(tempSum < sum){
                i++;
            }
            else{
                j--;
            }

        }
    }
}
