public class Rotate_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int size(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;  // ✅ move forward
        }
        return count;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int n = size(head);
        k = k % n; // ✅ reduce unnecessary rotations
        if (k == 0) return head;

        // ✅ find the (n - k - 1)th node
        ListNode temp = head;
        for (int i = 1; i < n - k; i++) {
            temp = temp.next;
        }

        // new head
        ListNode newHead = temp.next;
        temp.next = null; // break

        // go to end of new head part
        ListNode tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }

        // connect tail to old head
        tail.next = head;

        return newHead;
    }
}
