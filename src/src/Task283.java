public class Task283 {
    public void moveZeroes(int[] nums) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }

        for (int i = pointer; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Task283 task = new Task283();
        task.moveZeroes(new int[]{1});
        task.moveZeroes(new int[]{0,1,0,3,12});
    }
}
