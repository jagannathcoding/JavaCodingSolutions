1353. Maximum Number of Events That Can Be Attended
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startDayi <= d <= endDayi. You can only attend one event at any time d.

Return the maximum number of events you can attend.

 

Example 1:


Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.
Example 2:

Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4
 

Constraints:

1 <= events.length <= 105
events[i].length == 2
1 <= startDayi <= endDayi <= 105

*******Approach-1***********
  class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int day = events[0][0];
        int i = 0;
        int count = 0; 
        while(!pq.isEmpty() || i < n) {

            if(pq.isEmpty()) {
                day = events[i][0];
            }

           
            while(i < n && events[i][0] == day) {
                pq.add(events[i][1]);
                i++;
            }

            if(!pq.isEmpty()) {
                pq.poll(); 
                count++; 
            }

            day++;

           
            while(!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
        }

        return count;
    }
}


tc:o(N)
  
