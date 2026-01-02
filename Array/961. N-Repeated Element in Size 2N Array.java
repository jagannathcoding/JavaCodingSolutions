//https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description/?envType=daily-question&envId=2026-01-02

class Solution {
    public int repeatedNTimes(int[] nums) {
        
        int l=nums.length;
        int freq[]=new int[10001];
        for(int i=0;i<l;i++)
        {
            freq[nums[i]]++;
            if(freq[nums[i]]==l/2)return nums[i];
        }
        return -1;
    }
}
