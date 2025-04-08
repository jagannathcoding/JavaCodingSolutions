1911. Maximum Alternating Subsequence Sum
Attempted
Medium
Topics
Companies :  : META, GOOGLE, AMAZON
Hint
The alternating sum of a 0-indexed array is defined as the sum of the elements at even indices minus the sum of the elements at odd indices.

For example, the alternating sum of [4,2,5,3] is (4 + 5) - (2 + 3) = 4.
Given an array nums, return the maximum alternating sum of any subsequence of nums (after reindexing the elements of the subsequence).

A subsequence of an array is a new array generated from the original array by deleting some elements (possibly none) without changing the remaining elements' relative order. For example, [2,7,4] is a subsequence of [4,2,3,7,2,1,4] (the underlined elements), while [2,4,2] is not.

 

Example 1:

Input: nums = [4,2,5,3]
Output: 7
Explanation: It is optimal to choose the subsequence [4,2,5] with alternating sum (4 + 5) - 2 = 7.
Example 2:

Input: nums = [5,6,7,8]
Output: 8
Explanation: It is optimal to choose the subsequence [8] with alternating sum 8.
Example 3:

Input: nums = [6,2,1,2,4,5]
Output: 10
Explanation: It is optimal to choose the subsequence [6,1,5] with alternating sum (6 + 5) - 1 = 10.
 

Constraints:

1 <= nums.length <= 105
  
1 <= nums[i] <= 105



  //Approach-1 (Recursion + Memo) (Time Complexity - n*2 : We visit all states of t once)

///tle


  class Solution {
    int l;
     long[][] t = new long[1000001][2];
     long solve(int index,int nums[],boolean iseven)
     {
        if(index>=l)return 0;

        if(t[index][iseven ? 1 : 0] != -1) 
        {
            return t[index][iseven ? 1 : 0];
        }

        long val = nums[index];
        if (!iseven) 
        {
            val = -val;
        }


        long take = solve(index + 1, nums, !iseven) + val;
        
        long skip = solve(index + 1, nums, iseven);

        
        
      

        return t[index][iseven ? 1 : 0] = Math.max(skip, take);
    }



    public long maxAlternatingSum(int[] nums) {
        l=nums.length;
        for(int i=0;i<1000001;i++)
        {
            t[i][0] = -1;
            t[i][1] = -1;
        }
        return solve(0,nums,true);
        
        
    }
}


/////////////Approach -2 *********
