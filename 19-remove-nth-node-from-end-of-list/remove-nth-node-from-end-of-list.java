/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=0;
        ListNode temp=head;
    while(temp!=null){
        temp=temp.next;
        len++;
    } 
    //if head is the nth node from end of the list
    if(len-n==0)return head.next;
    temp=head;
    // target index=(len-n+1), so we have to stop at index (len-n)
    //a index before the target index
    for (int i = 1; i < len - n; i++) {
    temp = temp.next;
}
//skip the target node
temp.next=temp.next.next;
    return head;
    }
}