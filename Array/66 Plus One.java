\\   https://leetcode.com/problems/plus-one/?envType=daily-question&envId=2026-01-01
class Solution {
    public int[] plusOne(int[] digits) {
        int l=digits.length;
        int i=l-1;
        while(i>=0)
        {
            if(digits[i]<=8)
            {
                digits[i]+=1;
                return digits;
            }
            digits[i]=0;
            i--;

        }
        int[] result = new int[l + 1];
        result[0] = 1;
        return result;
    }
}
