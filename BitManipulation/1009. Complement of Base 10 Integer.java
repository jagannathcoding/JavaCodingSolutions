



*************Approach-1*********
  class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1-n;
        int cnt=0;
        int res=0;
        while(n>0)
        {
            int r=n%2;
            res+=Math.pow(2,cnt)*(1-r);
            cnt++;
            n=n/2; 
        }
       
        return res;
    }
}


********Approach-2**********
class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1-n;
        int mask=1;
        while(mask<n)
        {
            mask=(mask<<1)|1;
        }
        return mask^n;
    }
}
