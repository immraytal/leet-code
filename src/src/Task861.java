import java.util.Arrays;

public class Task861 {
    public int matrixScore(int[][] grid) {
        int tempSum = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                //System.out.println(Arrays.deepToString(grid));
                grid = moveRow(i, grid);
            }
            //System.out.println(Arrays.deepToString(grid));
            //System.out.println("after move row");
        }
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                tempSum += grid[i][j];
            }
            if (tempSum <= grid.length / 2) {
                //System.out.println("before move col");
                //System.out.println(Arrays.deepToString(grid));
                grid = moveCol(j, grid);
                //System.out.println("after move col");
                //System.out.println(Arrays.deepToString(grid));
            }
            tempSum = 0;
        }

        int sum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                stringBuilder.append(grid[i][j]);
            }
            int binary = Integer.parseInt(stringBuilder.toString(), 2);
            //System.out.println(stringBuilder.toString());
            stringBuilder.setLength(0);
            //System.out.println(binary);
            sum+=binary;
        }

        return sum;
    }

    public int[][] moveRow(int row, int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[row][i] == 0) {
                grid[row][i] = 1;
            } else {
                grid[row][i] = 0;
            }
        }
        return grid;
    }

    public int[][] moveCol(int col, int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 0) {
                grid[i][col] = 1;
            } else {
                grid[i][col] = 0;
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        Task861 task861 = new Task861();//0,0,1,1],[1,0,1,0],[1,1,0,
        System.out.println(task861.matrixScore(new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}}));
    }
}
