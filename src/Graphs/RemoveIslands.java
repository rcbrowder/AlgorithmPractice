package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class RemoveIslands {

    public int[][] removeIslands(int[][] matrix) {
        // Vars
        // DNR List
        // Matrix height
        // Matrix width
        // Loop through edges
        // If 1,
        // Add to DNRlist
        // check adjacent values for 1, if 1, recursive call

        int height = matrix.length;
        int width = matrix[0].length;
        boolean[][] onesConnectedToBorder = new boolean[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                boolean rowIsBorder = row == 0 || row == height - 1;
                boolean colIsBorder = col == 0 || col == width - 1;
                boolean isBorder = rowIsBorder || colIsBorder;

                if (!isBorder) {
                    continue;
                }
                if (matrix[row][col] != 1) {
                    continue;
                }
                findOnesConnectedToBorder(row, col, matrix, onesConnectedToBorder);
            }
        }

        for (int row = 1; row < height; row++) {
            for (int col = 1; col < width; col++) {
                if (onesConnectedToBorder[row][col]) {
                    continue;
                }
                matrix[row][col] = 0;
            }
        }

        return matrix;
    }

    private void findOnesConnectedToBorder(int startRow, int startCol, int[][] matrix,
                                           boolean[][] onesConnectedToBorder) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {startRow,startCol});

        while (stack.size() > 0) {
            int[] currentPosition = stack.pop();
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];
            boolean alreadyVisited = onesConnectedToBorder[currentRow][currentCol];
            if (alreadyVisited) continue;
            onesConnectedToBorder[currentRow][currentCol] = true;

            int[][] neighbors = getNeighbors(matrix, currentRow, currentCol);
            for(int[] neighbor : neighbors) {
                int row = neighbor[0];
                int col = neighbor[1];

                if (matrix[row][col] != 1) {
                    continue;
                }
                stack.push(neighbor);
            }
        }


    }

    private int[][] getNeighbors(int[][] matrix, int row, int col) {
        int height = matrix.length;
        int width = matrix[0].length;
        ArrayList<int[]> temp = new ArrayList<>();

        if (row - 1 > 0) {
            temp.add(new int[] {row - 1, col});
        }
        if (row + 1 < height) {
            temp.add(new int[] {row + 1, col});
        }
        if (col - 1 >= 0) {
            temp.add(new int[] {row, col - 1});
        }
        if (col + 1 < width) {
            temp.add(new int[] {row, col + 1});
        }

        int[][] neighbors = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            neighbors[i] = temp.get(i);
        }
        return neighbors;
    }

}
