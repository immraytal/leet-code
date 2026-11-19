import java.util.Arrays;

public class Task881 {
    public int numRescueBoats(int[] people, int limit) {
        if (people.length == 0) return 0;
        Arrays.sort(people);
        int count = 0;
        int tempSum = 0;
        for (int i = 0; i < people.length; i++) {
            if (people[i] > limit / 2) {
                if (tempSum > 0) {
                    if (people[i-1 ] + people[i] >= limit) {
                        continue;
                    }
                    count++;
                    tempSum = 0;
                }
                count++;
                continue;
            }
            tempSum += people[i];
            if (tempSum >= limit) {
                tempSum = 0;
                count++;
            }
        }
        if (tempSum > 0) {
            count++;
        }

        return count;
    }


    public static void main(String[] args) {
        Task881 task = new Task881();
        System.out.println(task.numRescueBoats(new int[]{1,2}, 3));
        System.out.println(task.numRescueBoats(new int[]{3,2,2,1}, 3));
        System.out.println(task.numRescueBoats(new int[]{3,5,3,4}, 5));
        System.out.println(task.numRescueBoats(new int[]{2,4}, 5));
    }
}
