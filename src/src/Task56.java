import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task56 {
    public int[][] merge(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][0]);
        }

        int[] range = new int[max - min + 1];
        for (int i = 0; i < intervals.length; i++) {
            range[intervals[i][0] - min] = Math.max(intervals[i][1] - min, range[intervals[i][0] - min]);
        }

        int start = 0, end = 0;
        LinkedList<int[]> result = new LinkedList<>();
        for (int i = 0; i < range.length; i++) {
            if (range[i] == 0) {
                continue;
            }
            if (i <= end) {
                end = Math.max(range[i], end);
            } else {
                result.add(new int[] {start + min, end + min});
                start = i;
                end = range[i];
            }
        }
        result.add(new int[] {start + min, end + min});
        return result.toArray(new int[result.size()][]);
    }
    //[1,3],[2,6],[8,10],[15,18], [0,4]
    //[1,6],      [8,10],[15,18]

    private int[][] copyExceptOne(int[][] arr, int idx) {
        int[][] res = new int[arr.length - 1][arr.length - 1];
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (j != idx) {
             res[i] = arr[j];
             i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Task56 task56 = new Task56();
        System.out.println(Arrays.deepToString(task56.merge(new int[][]{{1, 4}, {0, 4}})));//[[1,4],[0,4]]
        System.out.println(Arrays.deepToString(task56.merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Arrays.deepToString(task56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }


    class Pair<T> {
        T first;
        T second;

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }
    }
}
