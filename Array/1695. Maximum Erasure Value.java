
/////Approach-1*********
tc:o(n)
//sc:o(n)
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i=0;
        int j=0;
        int sum=0;
        int maxSum=0;
        HashSet<Integer>set=new HashSet<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        int l=nums.length;
        while(j<l)
        {
            //if(!set.contains(nums[j]))
            if(!map.containsKey(nums[j]))
            {
                sum+=nums[j];
                maxSum=Math.max(sum,maxSum);
                //set.add(nums[j]);
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                j++;
            }
            else
            {
                while(i<l&&map.containsKey(nums[j]))
                {
                    
                    sum-=nums[i];
                    map.put(nums[i],map.get(nums[i])-1);
                    if(map.get(nums[i])==0)
                    {
                        map.remove(nums[i]);
                    }
                    i++;
                }
            }

        }
return maxSum;
    }
}



?//////////////Approach-2*******
tc:o(n)
//sc:o(n)  Cumulagive sum apparoach



class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int l=nums.length;
        int i=0;
        int j=0;
        int cumSum[]=new int[l];
        cumSum[0]=nums[0];
        for(int i1=1;i1<l;i1++)
        {
            cumSum[i1]=nums[i1]+cumSum[i1-1];
        }


        int arr[]=new int[10001];
        Arrays.fill(arr,-1);

        int maxSum=0;

        while(j<l)
        {
            i= Math.max(i,arr[nums[j]]+1);
            int jSum=cumSum[j];
            int iSum=i-1<0?0:cumSum[i-1];
            int subSum=jSum-iSum;
            maxSum=Math.max(maxSum,subSum);
            arr[nums[j]]=j;
            j++;
        }
        return maxSum;
    }
}
