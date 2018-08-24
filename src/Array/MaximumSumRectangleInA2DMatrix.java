package Array;

public class MaximumSumRectangleInA2DMatrix {
    public static void main(String[] args) {
        int[][] input = {
                {2, 1, -3, -4, 5},
                {0, 6, 3, 4, 1},
                {2, -2, -1, 4, -5},
                {-3, 3, 1, 0, 3}
        };

        SumInfo res = findMaxSum(input);

        System.out.println("MaxSum: " + res.maxSum + " row1: " + res.row_u + " row2: " + res.row_d + " col1: " + res.col_l  + " col2: " + res.col_r);
    }


    //Moving from top to bottom
    public static SumInfo findMaxSum(int[][] matrix){
        SumInfo max_res = new SumInfo();
        max_res.maxSum = Integer.MIN_VALUE;

        for(int u = 0; u < matrix.length; u++){
            int[] initArr = matrix[u];
            for(int d = u; d < matrix.length; d++){
                if(u != d){
                    //Adding all the elements from the new row
                    for(int k = 0; k < matrix[0].length; k++){
                        initArr[k] = initArr[k] + matrix[d][k];
                    }
                }

                SumInfo newSum = findMaxSumUsingKadaneAlgo(initArr, u, d);

                //Updating the global Array.SumInfo
                if(newSum.maxSum > max_res.maxSum){
                    max_res = newSum;
                }
            }
        }

        return max_res;

    }


    public static SumInfo findMaxSumUsingKadaneAlgo(int[] array, int row_u, int row_d){
        int global_max = 0;
        int curr_max = 0;
        int g_col_l = 0, g_col_r = 0, col_l = 0, col_r = 0;

        for(int i = 0; i < array.length; i++){
            curr_max = Math.max(array[i], array[i] + curr_max);
            if(curr_max == array[i]){
                col_l = i;
                col_r = i;
            }
            else{
                col_r = i;
            }

            if(curr_max > global_max){
                global_max = curr_max;
                g_col_l = col_l;
                g_col_r = col_r;
            }
        }

        SumInfo res = new SumInfo();
        res.col_l = g_col_l;
        res.col_r = g_col_r;
        res.row_u = row_u;
        res.row_d = row_d;
        res.maxSum = global_max;


        return res;

    }
}


class SumInfo{
    int row_u = 0;
    int row_d = 0;
    int col_l = 0;
    int col_r = 0;
    int maxSum = 0;
}
