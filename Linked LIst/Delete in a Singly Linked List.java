Delete in a Singly Linked List

  //gfg

 // https://www.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1
  
/*
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        this.data = d;
        this.next = null;
    }
}
*/
class Solution {
    Node deleteNode(Node head, int x) {
        // if the list is empty
        if (head == null)
            return null;

        // if the first node is to be deleted
        if (x == 1)
            return head.next;

        Node curr = head;
        Node prev = head;
        int count = 1;

        // traverse to the (x-1)th node
        while (curr != null && count < x) {
            prev = curr;
            curr = curr.next;
            count++;
        }

        // if position is invalid
        if (curr == null)
            return head;

        // unlink the xth node
        prev.next = curr.next;

        return head;
    }
}
