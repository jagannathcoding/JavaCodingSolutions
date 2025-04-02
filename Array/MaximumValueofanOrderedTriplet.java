/*Approach 2*/


class Solution {
    public long maximumTripletValue(int[] nums) {
        
        int l=nums.length;
        int leftMax[]=new int[l];
        int rightMax[]=new int[l];


        for(int i=1;i<l;i++)
        {
            leftMax[i]=Math.max(leftMax[i-1],nums[i-1]);
        }

        for(int j=l-2;j>=0;j--)
        {
            rightMax[j]=Math.max(rightMax[j+1],nums[j+1]);
        }

        long result=0;
        for(int j=1;j<l-1;j++)
        {
            result=Math.max(result,(long)(leftMax[j]-nums[j])*rightMax[j]);
        }
        return result;
    }
}