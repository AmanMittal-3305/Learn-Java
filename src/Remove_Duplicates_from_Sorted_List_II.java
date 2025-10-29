public class Remove_Duplicates_from_Sorted_List_II {

    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode curr = head;
        while(curr != null){
            while(temp != null && temp.val == curr.val){
                temp = temp.next;
            }
            curr.next = temp;
            curr = temp;
        }

        return head;
    }
}
