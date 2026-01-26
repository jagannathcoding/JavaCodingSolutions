//https://leetcode.com/problems/minimum-absolute-difference/

1200. Minimum Absolute Difference


class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>>alist=new ArrayList<>();
        Arrays.sort(arr);
        int l=arr.length;
       
       int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<l-1;i++)
        {
            minDiff=Math.min(minDiff,arr[i+1]-arr[i]);
        }
        for(int i=0;i<l-1;i++)
        {
            int diff=arr[i+1]-arr[i];
            if(diff==minDiff)
            {
                alist.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return alist;
    }
}
