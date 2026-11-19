public class Task206 {
    ListNode res = new ListNode(0);
    ListNode temp = res;
    public ListNode reverseList(ListNode head) {
        dfs(head);
        return temp.next;
    }

    private void dfs(ListNode head) {
        if (head == null) {
            return;
        }
        dfs(head.next);
        res.next = new ListNode(head.val);
        res = res.next;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Task206 obj = new Task206();
        System.out.println(obj.reverseList(new ListNode( 0, new ListNode(1, new ListNode(2)))));
    }
}
