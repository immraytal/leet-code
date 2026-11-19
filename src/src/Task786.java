import java.util.Arrays;
import java.util.HashMap;

public class Task786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int maxResultSize = arr.length * (arr.length - 1) / 2;
        double[] result = new double[maxResultSize];

        HashMap<Double, Node> map = new HashMap<>();
        int resultIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                result[resultIndex] = (double) arr[i] / arr[j];
                map.put(result[resultIndex], new Node(arr[i], arr[j]));
                resultIndex++;
            }
        }

        Arrays.sort(result);

        Node node = map.get(result[k - 1]);
        return new int[]{node.i, node.j};
    }

    public static void main(String[] args) {
        Task786 test = new Task786();
        System.out.println(Arrays.toString(test.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
        System.out.println(Arrays.toString(test.kthSmallestPrimeFraction(new int[]{1, 7}, 1)));
    }

    class Node {
        int i;
        int j;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
