public class Task3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        long currentMax = 0;
        int currentMaxIndex = 0;
        long result = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < happiness.length; j++) {
                if (currentMax < happiness[j]) {
                    currentMax = happiness[j];
                    currentMaxIndex = j;
                }
            }
            long additional = currentMax - i;
            result += Math.max(additional, 0);
            happiness[currentMaxIndex] = -1;
            currentMax = 0;
            currentMaxIndex = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Task3075 task3075 = new Task3075();
        System.out.println(task3075.maximumHappinessSum(new int[]{2135218,73431904,92495076,77528042,82824634,3036629,28375907,65220365,40948869,58914871,57169530,89783499,19582915,19676695,11932465,21770144,49740276,22303751,80746555,97391584,95775653,43396943,47271136,43935930,59643137,64183008,8892641,39587569,85086654,5663585,82925096,24868817,95900395,48155864,74447380,7618448,63299623,91141186,33347112,81951555,52867615,92184410,7024265,85525916,29846922,59532692,47267934,6514603,1137830,97807470}, 41));
        System.out.println(task3075.maximumHappinessSum(new int[]{1, 2, 3}, 2));
        System.out.println(task3075.maximumHappinessSum(new int[]{2, 3, 4, 5}, 1));
    }
}
