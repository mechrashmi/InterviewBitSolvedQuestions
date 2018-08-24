package Recursion;


import java.util.Arrays;

//For full question follow https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
public class FloodFillAlgo {

    public static void main(String[] args) {
        int[][] input = {{1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 0, 0},
        {1, 0, 0, 1, 1, 0, 1, 1},
        {1, 2, 2, 2, 2, 0, 1, 0},
        {1, 1, 1, 2, 2, 0, 1, 0},
        {1, 1, 1, 2, 2, 2, 2, 0},
        {1, 1, 1, 1, 1, 2, 1, 1},
        {1, 1, 1, 1, 1, 2, 2, 1}};

        int[][] visited = new int[input.length][input[0].length];
        for(int i = 0; i < input.length; i++){
            Arrays.fill(visited[i], -1);
        }

        int prevColor = 2;
        int newColor = 3;
        printGrid(input, 4, 4, prevColor, newColor, visited);

        for (int i = 0; i < input.length; i++){
            for(int j = 0; j < input[i].length; j++){
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void printGrid(int[][] input, int i, int j, int prevColor, int newColor, int[][] visited){
        if(i < 0 || i == input.length || j < 0 || j == input[0].length || visited[i][j] == 0 || input[i][j] != prevColor){
            return;
        }

        visited[i][j] = 0;
        input[i][j] = newColor;

        //top cell
        printGrid(input, i - 1, j, prevColor, newColor, visited);
        //top right
        printGrid(input, i - 1, j + 1, prevColor, newColor, visited);
        //top left
        printGrid(input, i - 1, j - 1, prevColor, newColor, visited);
        //left
        printGrid(input, i, j - 1, prevColor, newColor, visited);
        //right
        printGrid(input, i, j + 1, prevColor, newColor, visited);
        //down
        printGrid(input, i + 1, j, prevColor, newColor, visited);
        //down left
        printGrid(input, i + 1, j - 1, prevColor, newColor, visited);
        //down right
        printGrid(input, i + 1, j + 1, prevColor, newColor, visited);
    }
}
