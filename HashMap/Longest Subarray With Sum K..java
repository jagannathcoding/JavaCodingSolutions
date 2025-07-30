 Longest Subarray With Sum K.


   https://www.naukri.com/code360/problems/longest-subarray-with-sum-k_5713505?leftPanelTabValue=PROBLEM


   import java.util.* ;
import java.io.*; 
public class Solution {
	public static int getLongestSubarray(int []nums, int k) {
		int sum=0;
		HashMap<Integer,Integer>map=new HashMap<>();
		int l=nums.length;
		int len=-1;
		int maxLen=0;
		map.put(0,-1);
		for(int i=0;i<l;i++)
		{
			sum+=nums[i];
			int remaining=sum-k;
			if(map.containsKey(remaining))
			{
				maxLen=Math.max(maxLen,i-map.get(remaining));
			}
			if(!map.containsKey(sum))
			{
				map.put(sum,i);
			}
		}
		return maxLen;
	}
}
