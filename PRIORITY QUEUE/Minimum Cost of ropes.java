class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i:arr)
        {
            pq.add(i);
        }
        int s1=0;
        while(pq.size()>1)
        {
            int f=pq.poll();
            int s=pq.poll();
            int sum=f+s;
            s1+=sum;
            pq.add(sum);
        }
        return s1;
    }
}
