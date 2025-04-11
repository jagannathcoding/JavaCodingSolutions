//Approach-1 (Brute Force)
//T.C : O((high-low+1)*d), where d  = number of digits
//S.C : O(d) for storing string

class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt=0;
        for(int k=low;k<=high;k++)
        {
            String s=Integer.toString(k);

            int l=s.length();
            if(l%2!=0)continue;

            int s1=0;
            int s2=0;
            for(int i=0;i<l/2;i++)
            {
                s1+=s.charAt(i)-'0';
            }
             for(int i=l/2;i<l;i++)
            {
                s2+=s.charAt(i)-'0';
            }
            if(s1==s2)cnt++;
        }
        return cnt;
    }
}


//Approach-2 (Optimal using / and %)
//T.C : O(high-low+1)
//S.C : O(1)


class Solution {
    public int countSymmetricIntegers(int low, int high) {
        
        int cnt=0;
        for(int i=low;i<=high;i++)
        {
            if(i>=10&&i<=99&&i%11==0)cnt++;

            else if(i>=1000&&i<=9999)
            {
                int firstDigit=i/1000;
                int secondDigit=(i/100)%10;
                int thirdDigit=(i%100)/10;
                int fourthDigit=(i%100)%10;

                if(firstDigit+secondDigit==thirdDigit+fourthDigit)cnt++;
            }
        }
        return cnt;
    }
}
