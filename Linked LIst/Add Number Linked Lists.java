Add Number Linked Lists

  https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1


Difficulty: MediumAccuracy: 34.52%Submissions: 348K+Points: 4Average Time: 30m
Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Examples:

Input: num1 = 4 - > 5, num2 = 3 -> 4 -> 5
Output:  3 -> 9 -> 0
 
Explanation: Given numbers are 45 and 345. There sum is 390.
Input: num1 = 0 -> 0 -> 6 -> 3, num2 = 0 -> 7 
Output: 7 -> 0 

Explanation: Given numbers are 63 and 7. There sum is 70.
Constraints:
1 <= size of both linked lists <= 106
0 <= elements of both linked lists <= 9



  /* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/


    
    
    class Solution {
    // Function to reverse a linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static Node addTwoLists(Node l1, Node l2) {
        // Step 1: Reverse both lists
        l1 = reverse(l1);
        l2 = reverse(l2);

        // Step 2: Add numbers
        Node dummy = new Node(-1);
        Node temp = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
        }

        // Step 3: Reverse result
        Node result = reverse(dummy.next);

        
        while (result != null && result.data == 0 && result.next != null) {
            result = result.next;
        }

        return result;
    }
}
