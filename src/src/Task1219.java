import java.util.Arrays;

public class Task1219 {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    System.out.println("============");
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    public int[][] copyGrid(int[][] grid) {
        int[][] copy = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return 0;
        }
        if (grid[x][y] == 0) {
            return 0;
        }
        int temp = grid[x][y];
        int max = 0;
        grid[x][y] = 0;
        max = Math.max(max, dfs(grid, x + 1, y));
        max = Math.max(max, dfs(grid, x, y + 1));
        max = Math.max(max, dfs(grid, x, y - 1));
        max = Math.max(max, dfs(grid, x - 1, y));
        grid[x][y] = temp;
        System.out.println("x = " + x + ", y = " + y + ", max = " + max + ", temp = " + temp);
        return temp + max;
    }

    public static void main(String[] args) {
        Task1219 t = new Task1219();
        System.out.println(t.getMaximumGold(new int[][]{{0,1,6,20,0},{0,0,3,0,0},{16,9,16,8,0},{14,0,4,20,9}}));
        System.out.println(t.getMaximumGold(new int[][]{{0,6,0},{5,8,7},{0,9,0}}));
    }
}

/**
 * 30 - 20 - 21 - 22- 23 - 33 - 34
 * x = 3, y = 4, max = 0, temp = 9
 * x = 2, y = 3, max = 0, temp = 8
 * x = 3, y = 3, max = 9, temp = 20
 * x = 3, y = 2, max = 29, temp = 4
 * x = 0, y = 3, max = 0, temp = 20
 * x = 0, y = 1, max = 0, temp = 1
 * x = 0, y = 2, max = 20, temp = 6
 * x = 1, y = 2, max = 26, temp = 3
 * x = 2, y = 2, max = 33, temp = 16
 * x = 2, y = 1, max = 49, temp = 9
 * x = 2, y = 0, max = 58, temp = 16
 * x = 3, y = 0, max = 74, temp = 14
 *
 * Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 * Output: 24
 * Explanation:
 * [[0,6,0],
 *  [5,8,7],
 *  [0,9,0]]
 * Path to get the maximum gold, 9 -> 8 -> 7.
 *
 *
 *
 *
 * [0 ,1 ,6, 20,0],
 * [0 ,0 ,3, 0, 0],
 * [16,9 ,16,8, 0],
 * [14,0 ,4, 20,9]
 * */
//