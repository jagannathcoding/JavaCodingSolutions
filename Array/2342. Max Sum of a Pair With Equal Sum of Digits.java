2342. Max Sum of a Pair With Equal Sum of Digits

Medium
Topics
Companies
Hint
You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

 

Example 1:

Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.
Example 2:

Input: nums = [10,12,19,14]
Output: -1
Explanation: There are no two numbers that satisfy the conditions, so we return -1.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109

  ************************Approach-1**********************(tle)
 //Approach-1 (Brute Force)
//T.C : O(n^2 * m), m = number of digits
//S.C : O(1)
  class Solution {
    int digitSum(int n)
    {
        int s=0;
        while(n>0)
        {
            int a=n%10;
            s=s+a;
            n=n/10;
        }
        return s;
    }
    public int maximumSum(int[] nums) 
    {
        int sum=-1;
        int l=nums.length;
        for(int i=0;i<l;i++)
        {
            int digitSumI=digitSum(nums[i]);
            for(int j=i+1;j<l;j++)
            {
                int digitSumJ=digitSum(nums[j]);
                if(digitSumI==digitSumJ)
                {
                    sum=Math.max(sum,nums[i]+nums[j]);
                }
            }
        }
        return sum;
    }
}

********************Approach-2******************
  //Approach-2 (Optimal using Map)
//T.C : O(n*m), m = number of digits
//S.C : O(n)
  
       class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long result = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] - i;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);

        for (int j = 1; j < n; j++) {
            int countOfNumsj = map.getOrDefault(nums[j], 0);
            int totalNumsBeforej = j;
            int badPairs = totalNumsBeforej - countOfNumsj;
            result += badPairs;
            
            map.put(nums[j], countOfNumsj + 1);
        }

        return result;
    }
}


****************Approach-3*****************
//(Optimal array as Map of constant size)
//T.C : O(n*m), m = number of digits
//S.C : O(1)

  class Solution {
    int digitSum(int n)
    {
        int s=0;
        while(n>0)
        {
            int a=n%10;
            s=s+a;
            n=n/10;
        }
        return s;
    }
    public int maximumSum(int[] nums) 
    {
        int sum=-1;
        int l=nums.length;
        int num[]=new int[82];
        for(int i=0;i<l;i++)
        {
            int res=digitSum(nums[i]);
            if(num[res]>0)
            {
                sum=Math.max(sum,nums[i]+num[res]);
            }
            num[res]=Math.max(num[res],nums[i]);
            
        }
        return sum;
    }
}
