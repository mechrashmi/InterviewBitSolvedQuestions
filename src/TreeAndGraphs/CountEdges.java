package TreeAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountEdges {
    public static void main(String[] args) {
        Integer[][] matrix = new Integer[][]{{1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 0, 1}};
        ArrayList<List<Integer>> input = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            input.add(Arrays.asList((matrix[i])));
        }
        System.out.println(count(input));
    }

    public static int count(ArrayList<List<Integer>> matrix){
        int[][] edges = new int[matrix.size()][matrix.get(0).size()];
        int r = matrix.size();
        int c = matrix.get(0).size();

        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.get(i).size(); j++){
                if(matrix.get(i).get(j) == 0){
                    edges[i][j] = 0;
                    continue;
                }
                int max = 0;
                if(i - 1 >= 0 && j - 1 >= 0 && matrix.get(i - 1).get(j - 1) == 1){
                    max++;
                }
                if(i - 1 >= 0 && matrix.get(i - 1).get(j) == 1){
                    max++;
                }
                if(i - 1 >= 0 && j + 1 < c && matrix.get(i - 1).get(j + 1) == 1){
                    max++;
                }
                if(j - 1 >= 0 && matrix.get(i).get(j - 1) == 1){
                    max++;
                }
                if(j + 1 < c && matrix.get(i).get(j + 1) == 1){
                    max++;
                }
                if(i + 1 < r && j - 1 >= 0 && matrix.get(i + 1).get(j - 1) == 1){
                    max++;
                }
                if(i + 1 < r && matrix.get(i + 1).get(j) == 1){
                    max++;
                }
                if(i + 1 < r && j + 1 < c && matrix.get(i + 1).get(j + 1) == 1){
                    max++;
                }

                edges[i][j] = max;

            }
        }

        int total = 0;
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < c; j++){
                total += edges[i][j];
            }
        }

        return total/2;
    }
}

