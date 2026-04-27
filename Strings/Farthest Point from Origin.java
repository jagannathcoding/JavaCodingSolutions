class Solution {
    public int furthestDistanceFromOrigin(String s) {
        int l=s.length();
        int left=0;
        int right=0;
        int dash=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='L')left++;
            else if(ch=='R')right++;
            else dash++;
        }
        return Math.abs(left-right)+dash;
    }
}
