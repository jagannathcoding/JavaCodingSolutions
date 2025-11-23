class Solution {
    public int minimumOperations(int[] nums) {
        int operations=0;
        for(int i:nums)
        {
            if(i%3!=0)operations++;
        }
        return operations;
    }
}
