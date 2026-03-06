1784. Check if Binary String Has at Most One Segment of Ones

  https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/description/?envType=daily-question&envId=2026-03-06

  class Solution {
    public boolean checkOnesSegment(String s) {
        int cnt=0;
        int l=s.length();
        int i=0;
        while(i<l)
        {
            if(s.charAt(i)=='1')
            {
                cnt++;
                while(i<l&&s.charAt(i)=='1')
                i++;
            }
            else
            {
                i++;
            }
            if(cnt>1)return false;
        }
        return true;
    }
}

//////////Approach -2 **************

class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
