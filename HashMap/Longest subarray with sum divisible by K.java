Longest subarray with sum divisible by K

  https://www.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1

Company Tags
Microsoft Snapdeal

import java.util.HashMap;

class Solution {
    int longestSubarrayDivK(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 

        for (int i = 0; i < n; i++) {
            sum += arr[i]; // accumulate sum

           sum =(sum % k + k) % k;; 

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i); 
            }
        }

        return maxLen;
    }
}
