1408. String Matching in an Array

Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.

A substring is a contiguous sequence of characters within a string

 

Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
Example 2:

Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".
Example 3:

Input: words = ["blue","green","bu"]
Output: []
Explanation: No string of words is substring of another string.
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 30
words[i] contains only lowercase English letters.
All the strings of words are unique.

***************************************Approach-1*************************
// Approach-1 (Brute Force)
// T.C : O(m*n^2), m = length of longest string in words, n = size of words
// S.C : O(1)
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }
}


*************************Appraoch-2********************
// Approach-2 (Using KMP)
// T.C : O(m*n^2), m = length of longest string in words, n = size of words
// S.C : O(m)


  class Solution 
{
    void lps(String pattern,int lps[])
    {
        int M=pattern.length();
        int len=0;
        lps[0]=0;
        int i=1;
        while(i<M)
        {
            if(pattern.charAt(i)==pattern.charAt(len))
            {
                len++;
                lps[i]=len;
                i++;
            }
            else
            {
                if(len!=0)
                {
                    len=len-1;
                }
                else
                {
                    lps[i]=0;
                    i++;
                }
            }
        }
    }
    boolean KMP(String pat,String txt)
    {
        int l=txt.length();
        int p=pat.length();
        int lps[]=new int[p];
        lps(pat,lps);


        int i=0;
        int j=0;
        while(i<l)
        {
            if(pat.charAt(j)==txt.charAt(i))
            {
                i++;
                j++;
            }
            if(j==p)
            {
                return true;
            }
            else if(i<l&&pat.charAt(j)!=txt.charAt(i))
            {
                if(j!=0)
                {
                    j=lps[j-1];
                }
                else
                {
                    i++;
                }
            }
        }
        return false;
    }

    public List<String> stringMatching(String[] words) 
    {
       int l=words.length;
         List<String> result = new ArrayList<>();
         for (int i = 0;i<l; i++) 
         {
            for (int j = 0; j<l; j++) {
                if (i == j)
                    continue;

                if (KMP(words[i], words[j])) 
                {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }
}

 
  
