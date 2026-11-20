public class Task3754 {


    public long sumAndMultiply(int n) {
        int temp = 0;
        long X = 0;
        long sum = 0;
        int i = 0;
        while (n > 0) {
            temp = n % 10;
            if (temp > 0) {
                sum += temp;
                X += Math.pow(10, i) * temp;
                i++;
            }
            n = n / 10;
        }
        return X * sum;
    }


    public static void main(String[] args) {
        System.out.println(new Task3754().sumAndMultiply(65463628));
    }
}
