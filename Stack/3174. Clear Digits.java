3174. Clear Digits
Solved
Easy
Topics
Companies
Hint
You are given a string s.

Your task is to remove all digits by doing this operation repeatedly:

Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.

 

Example 1:

Input: s = "abc"

Output: "abc"

Explanation:

There is no digit in the string.

Example 2:

Input: s = "cb34"

Output: ""

Explanation:

First, we apply the operation on s[2], and s becomes "c4".

Then we apply the operation on s[1], and s becomes "".

 

Constraints:

1 <= s.length <= 100
s consists only of lowercase English letters and digits.
The input is generated such that it is possible to delete all digits.


  ***************Approach-1*****************
  // T.C : O(n^2)  
// S.C : O(1)  
  
  class Solution {
    public String clearDigits(String s) {
        StringBuilder sb=new StringBuilder(s);
        int i=0;
        int l=sb.length();
        while(i<sb.length())
        {
            if(Character.isDigit(sb.charAt(i)))
            {
                sb.deleteCharAt(i);
                if(i>0)
                {
                    sb.deleteCharAt(i-1);
                    i--;
                }
            }
            else
            {
                i++;
            }
        }
        return sb.toString();
    }
}


  ***************Approach-2*****************
    //tc:o(n)
    //sc;o(n)

    class Solution {
    public String clearDigits(String s) {
       Stack<Character>st=new Stack<>();
       int l=s.length();
       for(char ch:s.toCharArray())
       {
            if(ch>='a'&&ch<='z')
            {
                st.push(ch);
            }
            else
            {
                st.pop();
            }
       }
       StringBuilder sb=new StringBuilder();
       while(!st.isEmpty())
       {
        sb.append(st.pop());
       }
       return sb.reverse().toString();
    }
}

 ***************Approach-3*****************
    //tc:o(n)
    //sc;o(1)//or o(1)
   class Solution {
    public String clearDigits(String s)
     {
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray())
        {
            if(ch>='a'&&ch<='z')
            {
                sb.append(ch);
            }
            else
            {
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
     }
}

***************Approach-4*****************
// T.C : O(n)  Very good approach
// S.C : O(1)  

  class Solution {
    public String clearDigits(String s) {
        char arr[]=s.toCharArray();
        int j=0;
        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(arr[i]))
            {
                j=Math.max(j-1,0);
            }
            else
            {
                arr[j]=arr[i];
                j++;
            }
        }
        return new String(arr,0,j);
    }
}
       
