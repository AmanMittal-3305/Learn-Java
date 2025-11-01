import java.util.*;

public class Delete_Nodes_From_Linked_List_Present_in_Array {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (temp != null) {
            while (temp != null && set.contains(temp.val)) {
                temp = temp.next;
            }
            if (temp == null) break;

            prev.next = temp;
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;

        return dummy.next;
    }


}


