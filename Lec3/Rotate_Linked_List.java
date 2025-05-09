package AB.Lec3;


public class Rotate_Linked_List {
    public  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)return head;

        ListNode curr = head;
        int size = 1;
        while(curr.next != null){
            curr = curr.next;
            size++;
        }

        curr.next = head;
        ListNode first = head;
        ListNode newhead =  head;
        int m = k%size;
        for(int i = 1 ;i <size - m;i++){
            first = first.next;
        }
        newhead = first.next;
        first.next = null;
        return newhead;
    }
}
