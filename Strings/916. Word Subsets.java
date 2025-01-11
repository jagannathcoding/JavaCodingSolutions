916. Word Subsets
 
  https://leetcode.com/problems/word-subsets/

 Company Tags   : Amazon, Google

  
Solved
Medium
Topics
Companies
You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

 

Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]

Output: ["facebook","google","leetcode"]

Example 2:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["lc","eo"]

Output: ["leetcode"]

Example 3:

Input: words1 = ["acaac","cccbb","aacbb","caacc","bcbbb"], words2 = ["c","cc","b"]

Output: ["cccbb"]

 

Constraints:

1 <= words1.length, words2.length <= 104
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.

//Approach - (Simple storing character frequency in map and checking)
//T.C : O(n*l1 + m*l2) , n = # of words in words1, l1 = average length of word in words1, similarly m and l2 for words2
//S.C : O(26) ~= O(1)

  class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int freq2[]=new int[26];
        for(String s:words2)
        {
            int temp[]=new int[26];
            for(char ch:s.toCharArray())
            {
                temp[ch-'a']++;
                freq2[ch-'a']=Math.max(freq2[ch-'a'],temp[ch-'a']);
            }
        }
        for(String word:words1)
        {
            int temp[]=new int[26];
            for(char ch:word.toCharArray())
            {
                temp[ch-'a']++;
            }
            if(isSubset(freq2,temp))
            {
                result.add(word);
            }
        }
        return result;
    }

    boolean isSubset(int freq2[],int temp[])
    {
        for(int i=0;i<26;i++)
        {
            if(temp[i]<freq2[i])return false;
        }
        return true;
    }
}
