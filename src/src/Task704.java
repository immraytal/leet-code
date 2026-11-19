public class Task704 {
    public int search(int[] nums, int target) {
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Task704 test = new Task704();
        System.out.println(test.search(new int[]{-1,0,3,5,9,12}, 13));
        System.out.println(test.search(new int[]{2,5}, 2));
        System.out.println(test.search(new int[]{-1,0,3,5,9,12}, 9));
    }

    /**
     *
     * Input: nums = [-1,0,3,5,9,12], target = 9
     * Output: 4
     * */
}
