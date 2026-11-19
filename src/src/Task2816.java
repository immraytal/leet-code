import javax.swing.plaf.IconUIResource;
import java.util.HashMap;

public class Task2816 {
    public ListNode doubleIt(ListNode head) {

        HashMap<Integer, ListNode> hashMap = new HashMap<>();

        ListNode cur = head;
        int i = -1;
        while (cur != null) {
            i++;
            hashMap.put(i, cur);
            cur = cur.next;
        }

        for (int j = i; j >= 0; j--) {
            ListNode temp = hashMap.get(j);
            temp.val *= 2;
        }

        for (int j = i; j >= 0; j--) {
            ListNode temp = hashMap.get(j);
            if (temp.val>9) {
                if (j == 0) {
                    ListNode newNode = new ListNode(temp.val / 10, temp);
                    temp.val %= 10;
                    return newNode;
                } else {
                    hashMap.get(j - 1).val += temp.val / 10;
                    temp.val %= 10;
                }
            }
        }
       return head;
    }

    public static void main(String[] args) {
        Task2816 task2816 = new Task2816();
        System.out.println(task2816.doubleIt(new ListNode(1, new ListNode(8, new ListNode(9)))));
    }


    //189
    //488
    //378
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
