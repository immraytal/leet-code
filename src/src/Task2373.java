import java.util.Arrays;

public class Task2373 {
    public int[][] largestLocal(int[][] grid) {
        int littleSquareSize = grid.length - 2;
        int[][] result = new int[littleSquareSize][littleSquareSize];

        for (int i = 0; i < littleSquareSize; i++) {
            for (int j = 0; j < littleSquareSize; j++) {
                result[i][j] = findMax(grid, i, j);
            }
        }

        return result;
    }

    public int findMax(int[][] grid, int k, int l) {
        int max = 0;
        for (int i = k; i < k+3; i++) {
            for (int j = l; j < l + 3; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Task2373 task = new Task2373();
        System.out.println(Arrays.deepToString(task.largestLocal(new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}})));
    }
}
