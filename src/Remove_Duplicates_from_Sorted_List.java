import java.util.*;


public class Remove_Duplicates_from_Sorted_List {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;

        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;  // Skip the duplicate node
            } else {
                temp = temp.next;  // Move forward
            }
        }

        return head;
    }
}
