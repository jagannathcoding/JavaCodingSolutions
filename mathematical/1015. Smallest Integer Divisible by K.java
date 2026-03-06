1015. Smallest Integer Divisible by K

  
https://leetcode.com/problems/smallest-integer-divisible-by-k/description/

  
class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k==1) return 1;

        int x=0;
        for(int i=1;i<=k;i++)
        {
            x=(x*10+1)%k;
            if(x==0) return i;
        }
        return -1;
    }
}
