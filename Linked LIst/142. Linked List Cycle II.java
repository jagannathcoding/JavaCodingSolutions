142. Linked List Cycle II

 Company  Microsoft, Paytm, VMWare, Accolite, Amazon, OYO Rooms, Samsung
                    Snapdeal, D-E-Shaw, Hike, MakeMyTrip, Walmart, MAQ Software, Adobe, SAP Labs, 
                    Qualcomm, Veritas


//T.C : O(n)
//S.C : O(1)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode idx=head;
        ListNode slow=head;
        ListNode fast=head;
        if(head==null||head.next==null)return null;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
               break;
            }
        }
        if(slow!=fast) return null;


        while(idx!=slow)
        {
            idx=idx.next;
            slow=slow.next;
        }
        return slow;
    }
}

