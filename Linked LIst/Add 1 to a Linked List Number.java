Add 1 to a Linked List Number

//https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1


class Solution {
    private Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node addOne(Node head) {
        head = reverse(head);

        Node curr = head;
        Node prev = null;
        int carry = 1;

        while (curr != null && carry > 0) {
            int sum = curr.data + carry;
            curr.data = sum % 10;
            carry = sum / 10;

            prev = curr;
            curr = curr.next;
        }

        // IMPORTANT: append carry at the END of reversed list
        if (carry > 0) {
            prev.next = new Node(carry);
        }

        head = reverse(head);
        return head;
    }
}
