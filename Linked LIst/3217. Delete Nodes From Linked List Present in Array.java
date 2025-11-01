3217. Delete Nodes From Linked List Present in Array

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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums)set.add(i);

        while(head!=null && set.contains(head.val))head=head.next;

          if (head == null) return null; /// if entire head is deleted

        ListNode prev=head;
        ListNode curr=head.next;

       
        while(curr!=null)
        {
            if(!set.contains(curr.val))
            {
                prev=curr;
                //curr=curr.next;
            }
            else
            {
                prev.next=curr.next;
                //curr=curr.next;
            }
            curr=curr.next;
        }
        return head;
    }
}
