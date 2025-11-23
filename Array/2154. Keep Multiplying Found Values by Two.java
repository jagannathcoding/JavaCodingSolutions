class Solution {
    public int findFinalValue(int[] nums, int original) 
    {
       int l=nums.length;
      int arr[]=new int[1001];
      for(int i:nums)
      {
        arr[i]++;
      }
      int j=0;
      while(original<=1000 && arr[original]!=0)
      {
            original=2*original;
      }
      return original;
    }
}
