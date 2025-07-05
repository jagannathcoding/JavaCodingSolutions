169. Majority Element
Solved
Easy
Topics
premium lock icon
Companies
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
**********Approach-1******
  tc:o(n)
  sc:o(1)

  class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0;
        int number=0;
        for(int i:nums)
        {
            if(cnt==0)
            {
               number=i;
            }
            if(i==number)
            {
                cnt++;
            }
            else
            {
                cnt--;
            }
        }
        return number;
    }
}
