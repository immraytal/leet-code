import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Task2487 {
        public ListNode removeNodes(ListNode head) {
            ListNode prev = null, curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode dummyHead = new ListNode(-1);
            ListNode tempPrev = dummyHead;
            curr = prev;

            while (curr != null) {
                if (curr.val >= tempPrev.val) {
                    tempPrev.next = curr;
                    tempPrev = curr;
                    curr = curr.next;
                } else {
                    curr = curr.next;
                }
            }
            tempPrev.next = null;

            ListNode newPrev = null, newCurr = dummyHead.next;
            while (newCurr != null) {
                ListNode next = newCurr.next;
                newCurr.next = newPrev;
                newPrev = newCurr;
                newCurr = next;
            }

            return newPrev;
        }


    public static void main(String[] args) {
        Task2487 task = new Task2487();
        System.out.println(task.removeNodes(new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8, null)))))));
    }

    private static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
