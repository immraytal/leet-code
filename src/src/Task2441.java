import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Task2441 {
    public int findMaxK(int[] nums) {
        Set<Integer> finalSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        finalSet.add(-1);

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(-1 * nums[i])) {
                finalSet.add(Math.abs(nums[i]));
            }
            set.add(nums[i]);
        }

        return finalSet.stream().max(Integer::compareTo).get();
    }

    public static void main(String[] args) {
        Task2441 task2441 = new Task2441();
        System.out.println(task2441.findMaxK(new int[]{-1,10,6,7,-7,1}));
    }
}
