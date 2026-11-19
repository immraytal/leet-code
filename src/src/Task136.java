public class Task136 {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0; i<nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Task136 obj = new Task136();
        System.out.println(obj.singleNumber(new int[]{2,3,2,4,3}));
    }
}
