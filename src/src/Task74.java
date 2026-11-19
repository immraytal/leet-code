public class Task74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        boolean neededRow = false;
        while (row < matrix.length && col >= 0) {
                if (matrix[row][col] == target) {
                    return true;
                } else if (matrix[row][col] < target) {
                    if (neededRow) {
                        return false;
                    }
                    row++;
                } else {
                    neededRow = true;
                    col--;
                }
        }
        return false;
    }

    public static void main(String[] args) {
        Task74 task74 = new Task74();
        System.out.println(task74.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 3));
    }
}
