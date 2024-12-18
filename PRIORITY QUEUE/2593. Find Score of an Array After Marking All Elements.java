2593. Find Score of an Array After Marking All Elements
Medium
Topics
Companies :VISA , VISA
Hint
You are given an array nums consisting of positive integers.

Starting with score = 0, apply the following algorithm:

Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.
Add the value of the chosen integer to score.
Mark the chosen element and its two adjacent elements if they exist.
Repeat until all the array elements are marked.
Return the score you get after applying the above algorithm.

 

Example 1:

Input: nums = [2,1,3,4,5,2]
Output: 7
Explanation: We mark the elements as follows:
- 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,1,3,4,5,2].
- 2 is the smallest unmarked element, so we mark it and its left adjacent element: [2,1,3,4,5,2].
- 4 is the only remaining unmarked element, so we mark it: [2,1,3,4,5,2].
Our score is 1 + 2 + 4 = 7.
Example 2:

Input: nums = [2,3,5,1,3,2]
Output: 5
Explanation: We mark the elements as follows:
- 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,3,5,1,3,2].
- 2 is the smallest unmarked element, since there are two of them, we choose the left-most one, so we mark the one at index 0 and its right adjacent element: [2,3,5,1,3,2].
- 2 is the only remaining unmarked element, so we mark it: [2,3,5,1,3,2].
Our score is 1 + 2 + 2 = 5.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 106


//Approach-1 (Sorting array with indices)
//T.C : O(nlogn)
//S.C : O(n)


class Solution {
    public long findScore(int[] nums) {
        int l=nums.length;
        long score=0;
        ///pair hocchey number ar index er jonney
        int pairs[][]=new int[l][2];
        for(int i=0;i<l;i++)
        {
            pairs[i][0]=nums[i];
            pairs[i][1]=i;
        }


        Arrays.sort(pairs,(a,b)->{
            if(a[0]!=b[0])return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });

        boolean visited[]=new boolean[l];
        for(int i=0;i<l;i++)
        {
            int number = pairs[i][0];
            int index=pairs[i][1];
            if(!visited[index])
            {
                score+=number;
                visited[index]=true;



                if(index-1>=0)visited[index-1]=true;
                if(index+1<l)visited[index+1]=true;
            }
        }
        return score;
    }
}


//Approach-2 (Using min-heap)
//T.C : O(nlogn)
//S.C : O(n)


class Solution {
    public long findScore(int[] nums) {
        int l=nums.length;
        long score=0;
        ///pair hocchey number ar index er jonney
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0])return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        for(int i=0;i<l;i++)
        {
            pq.add(new int[]{nums[i],i});
        }

        boolean visited[]=new boolean[l];
        for(int i=0;i<l;i++)
        {
            int element[]=pq.poll();
            int number = element[0];
            int index=element[1];
            if(!visited[index])
            {
                score+=number;
                visited[index]=true;



                if(index-1>=0)visited[index-1]=true;
                if(index+1<l)visited[index+1]=true;
            }
        }
        return score;
    }
}


