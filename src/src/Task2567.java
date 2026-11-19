import java.util.Arrays;

/**

You are given an integer array nums.

The low score of nums is the minimum absolute difference between any two integers.
The high score of nums is the maximum absolute difference between any two integers.
The score of nums is the sum of the high and low scores.
Return the minimum score after changing two elements of nums.
//1,4,7,8,5

 1 4 5 7 8 min 1 max 7
 4 4 5 7 7 min 0 max 3
  6,6,7,8,5

 1 4 5 5 5
 4 4 5 7 7




 [1,100,101,102,103,1000]
 1000 1

 1 100 101 102 103 1000
 100 100 101 102 103 103


 [1,2,3,4,100,101]

 1 2 3 4 1 1
 1 2 3 4 100 101
 2 2 3 4 100 100
 2 2 3 4 100 100  min 0 max 98
 1 2 3 4 4 4 min 0 max 3
 1 2 3 4 3 3




 class Solution {
 public int minimizeSum(int[] nums) {
 Arrays.sort(nums);
 int n = nums.length;
 int a = nums[n - 1] - nums[2];
 int b = nums[n - 2] - nums[1];
 int c = nums[n - 3] - nums[0];
 return Math.min(a, Math.min(b, c));
 }
 }

 WE DONT NEED TO SET NEW VALUES, JUST TO COUNT MAX SCORE
*/
public class Task2567 {
    /**
    public int minimizeSum(int[] nums) {

        Arrays.sort(nums);


        int[] firstReplace = Arrays.copyOf(nums, nums.length);
        firstReplace[0] = nums[nums.length - 1];
        firstReplace[1] = nums[nums.length - 1];
        int maxScore = Integer.MIN_VALUE;
        int newMaxScore = Integer.MIN_VALUE;


        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : firstReplace) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            maxScore = max - min;
        }
        if (maxScore == 0) {
            return 0;
        }

        int[] lastReplace = Arrays.copyOf(nums, nums.length);
        lastReplace[nums.length - 1] = nums[0];
        lastReplace[nums.length - 2] = nums[0];

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int num : lastReplace) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            newMaxScore = max - min;
        }
        maxScore = Math.min(maxScore, newMaxScore);

        if (maxScore == 0) {
            return 0;
        }


        int[] neigoborReplace = Arrays.copyOf(nums, nums.length);
        neigoborReplace[nums.length - 1] = nums[nums.length - 2];
        neigoborReplace[0] = nums[1];

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int num : neigoborReplace) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            newMaxScore = max - min;
        }
        maxScore = Math.min(maxScore, newMaxScore);
        return maxScore;
    }
*/

    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[n - 1] - nums[2];
        int b = nums[n - 2] - nums[1];
        int c = nums[n - 3] - nums[0];
        return Math.min(a, Math.min(b, c));
    }


    public static void main(String[] args) {
        System.out.println(new Task2567().minimizeSum(new int[]{1,4,3}));
        System.out.println(new Task2567().minimizeSum(new int[]{1,4,7,8,5}));
        System.out.println(new Task2567().minimizeSum(new int[]{1,2,3,100,101,102}));
        System.out.println(new Task2567().minimizeSum(new int[]{1,2,3,4,100,101}));
        System.out.println(new Task2567().minimizeSum(new int[]{1,100,101,102,103,1000}));
    }

}
