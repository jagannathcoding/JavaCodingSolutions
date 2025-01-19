2425. Bitwise XOR of All Pairings
Solved
Medium
Topics
Companies
Hint
You are given two 0-indexed arrays, nums1 and nums2, consisting of non-negative integers. There exists another array, nums3, which contains the bitwise XOR of all pairings of integers between nums1 and nums2 (every integer in nums1 is paired with every integer in nums2 exactly once).

Return the bitwise XOR of all integers in nums3.

 

Example 1:

Input: nums1 = [2,1,3], nums2 = [10,2,5,0]
Output: 13
Explanation:
A possible nums3 array is [8,0,7,2,11,3,4,1,9,1,6,3].
The bitwise XOR of all these numbers is 13, so we return 13.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 0
Explanation:
All possible pairs of bitwise XORs are nums1[0] ^ nums2[0], nums1[0] ^ nums2[1], nums1[1] ^ nums2[0],
and nums1[1] ^ nums2[1].
Thus, one possible nums3 array is [2,5,1,6].
2 ^ 5 ^ 1 ^ 6 = 0, so we return 0.

  Constraints:
 1 <= nums1.length, nums2.length <= 105
0 <= nums1[i], nums2[j] <= 109



  //*****************Approach-1****************
   //Approach-1 (Using frequency count and Xor Property)
//T.C : O(n)
//S.C : O(n)

class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:nums1)
        {
            map.put(i,map.getOrDefault(i,0)+nums2.length);
        }
        for(int i:nums2)
        {
            map.put(i,map.getOrDefault(i,0)+nums1.length);
        }

        int res=0;
        for(int i:map.keySet())
        {
            if(map.get(i)%2!=0)res^=i;
        }
        return res;
    }
}

//**************Approach-2*****************

//tc:o(n)
//sc:o(1)

class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {

        int l=nums1.length;
        int l1=nums2.length;
        int res=0;
        if(l%2!=0)
        {
            for(int i:nums2)res^=i;
        }
       if(l1%2!=0)
        {
            for(int i:nums1)res^=i;
        }
        return res;
        
    }
}
