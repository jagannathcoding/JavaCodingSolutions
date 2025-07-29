Maximum Sub Array
Difficulty: MediumAccuracy: 15.84%Submissions: 113K+Points: 4
Given an array of integers arr[], find the contiguous subarray with the maximum sum that contains only non-negative numbers. If multiple subarrays have the same sum, return the one with the smallest starting index. If the array contains only negative numbers, return -1.

Note: A subarray is a contiguous non-empty sequence of elements within an array.

Examples:

Input: arr[] = [1, 2, 3]
Output: [1, 2, 3]
Explanation: In the given array, every element is non-negative, so the entire array [1, 2, 3] is the valid subarray with the maximum sum.
Input: arr[] = [-1, 2]
Output: [2]
Explanation: The only valid non-negative subarray is [2], so the output is [2].
Input: arr[] = [1, 2, 5, -7, 2, 6]
Output: [1, 2, 5]
Explanation: The valid non-negative subarrays are [1, 2, 5] and [2, 6]. Both have the same sum of 8, but [1, 2, 5] starts earlier, so it is the preferred subarray.
Constraints:
1 ≤ arr.size() ≤ 106
-105 ≤ arr[i] ≤ 105





  // User function Template for Java

class Solution {
    public ArrayList<Integer> findSubarray(int nums[]) {
        // code here
        int l=nums.length;
        long maxSum=-1;
        
        int start=0;
        int end=0;
        ArrayList<Integer>alist=new ArrayList<>();
        long sum=0;
        int currentStart=0;
        
        for(int i=0;i<l;i++)
        {
            if(nums[i]<0)
            {
                currentStart=i+1;
                sum=0;
            }
            else
            {
                sum+=nums[i];
                if(sum>maxSum|| sum==maxSum&&
                i-currentStart>end-start)
                {
                    maxSum=sum;
                    start=currentStart;
                    end=i;
                }
            }
            
        }
        if(maxSum==-1){alist.add(-1);
        return alist;
        }
        
        for(int i=start;i<=end;i++)alist.add(nums[i]);
        
        return alist;
        
        
    }
}
