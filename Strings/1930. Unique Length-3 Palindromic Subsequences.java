1930. Unique Length-3 Palindromic Subsequences
Solved
Medium
Topics
Companies
Hint
Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

A palindrome is a string that reads the same forwards and backwards.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")
Example 2:

Input: s = "adc"
Output: 0
Explanation: There are no palindromic subsequences of length 3 in "adc".
Example 3:

Input: s = "bbcbaba"
Output: 4
Explanation: The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "bbcbaba")
- "bcb" (subsequence of "bbcbaba")
- "bab" (subsequence of "bbcbaba")
- "aba" (subsequence of "bbcbaba")

Constraints:

3 <= s.length <= 105
s consists of only lowercase English letters.

    ***************Approach-1*********************
  //Approach-1
//T.C : O(n)
//S.C : O(1) - ONly 26 sized always
class Solution {
    public int countPalindromicSubsequence(String s) {
        int l=s.length();
        Set<Character>set=new HashSet<>();
        for(char ch:s.toCharArray())
        {
            set.add(ch);
        }
        int res=0;
        for(char ch:set)
        {
            int firstIdx=-1;
            int lastIdx=-1;
            for(int i=0;i<l;i++)
            {
                if(s.charAt(i)==ch)
                {
                    if(firstIdx==-1)
                    {
                        firstIdx=i;
                    }
                    lastIdx=i;
                }
            }
            Set<Character>set1=new HashSet<>();
            for(int middle=firstIdx+1;middle<=lastIdx-1;middle++)
            {
                set1.add(s.charAt(middle));
            }
            res+=set1.size();
        }
        return res;
    }
}














    ***************Approach-2*********************
//Approach-2 (Storing first and last indices before hand
//T.C : O(n)
//S.C : O(1) - Only 26 sized always

  class Solution {
    public int countPalindromicSubsequence(String s) {
        int l=s.length();
        int first[]=new int[26];
        int last[]=new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        for(int i=0;i<l;i++)
        {
            char currentCharacter=s.charAt(i);
            int pos=currentCharacter-'a';
            if(first[pos]==-1)
            {
                first[pos]=i;
            }
            last[pos]=i;
        }

        int res=0;
        for(int i=0;i<26;i++)
        {
            if(first[i]==-1)continue;

            Set<Character>set=new HashSet<>();
            for(int j=first[i]+1;j<last[i];j++)
            {
                set.add(s.charAt(j));
            }
            res+=set.size();
        }
        return res;
    }
}
