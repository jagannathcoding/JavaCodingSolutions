86. Partition List
Solved
Medium
Topics
premium lock icon
Companies : Microsoft
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200

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

  ////tc:o(n) we visit each node only once
  //sc:o(1)
  
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(0);
        ListNode large=new ListNode(0);

        ListNode smallPointer=small;
        ListNode largePointer=large;

        while(head!=null)
        {
            if(head.val<x)
            {
                smallPointer.next=head;
                smallPointer=smallPointer.next;
            }
            else
            {
                largePointer.next=head;
                largePointer=largePointer.next;   
            }
                   head = head.next;
        }
        smallPointer.next=large.next;
        largePointer.next=null;

        return small.next;
    }
}
     
