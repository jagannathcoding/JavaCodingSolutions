class Solution 
{
    public void moveZeroes(int[] nums) 
    {
        int l=nums.length;
        int z=0;
        int j=-1;
        for(int i=0;i<l;i++)
        {
            if(nums[i]==0)
            {
                j=i;
                break;
            }
        }

        if(j==-1) return ;

        for(int k=j+1;k<l;k++)
        {
            if(nums[k]!=0)
            {
                int temp=nums[j];
                nums[j]=nums[k];
                nums[k]=temp;
                j++;
            }
        }
    }
}
