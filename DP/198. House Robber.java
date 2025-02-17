198. House Robber
Solved
Medium

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

   Company Tags                : Amazon, OYO Rooms, Paytm, Walmart, Google, Flipkart, LinkedIn, Airbnb
    Leetcode Link               : https://leetcode.com/problems/house-robber/
    GfG Link                    : https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1
    Also Famouse as             : Stickler Thief
 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400



  ******************aPPROACH1-*********sIMPLE RECURSION
  class Solution {
    int solve(int nums[],int i,int l)
    {
        if(i>=l)return 0;

        int steal=nums[i]+solve(nums,i+2,l);
        int skip=solve(nums,i+1,l);
        
        return Math.max(steal,skip);
    }
    public int rob(int[] nums) {
        int l=nums.length;
         return solve(nums,0,l);
        
    }
}


****************************Approach-2*************
  //Memoization+recursion
  class Solution {
    int[] t = new int[101];
    public int solve(int[] nums, int i, int l)
     {
        if (i >= l) {
            return 0;
        }
        if (t[i] != -1) {
            return t[i];
        }
        int take = nums[i] + solve(nums, i + 2, l); 
        int skip = solve(nums, i + 1, l); 
        return t[i] = Math.max(take, skip);
    }

    public int rob(int[] nums)
     {
        int l = nums.length;
        Arrays.fill(t, -1);
        return solve(nums, 0, l);
    }
}

*************************Approach-3*************
  ////BOTTOM UP
  
