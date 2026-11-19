public class Task374 {
    int pick = 1;
    public int guessNumber(int n) {

        int pointerStart = 1;
        while (pointerStart <= n) {
            if (pointerStart == n) {
                return n;
            }
            int mid = pointerStart + n / 2;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            } else if (guess == 1) {
                n = mid - 1;
            } else {
                pointerStart = mid + 1;
            }
        }
        return n;
    }

    int guess(int n) {
        return Integer.compare(n, pick);
    }

    public static void main(String[] args) {
        Task374 test = new Task374();
        System.out.println(test.guessNumber(2));
    }
}
