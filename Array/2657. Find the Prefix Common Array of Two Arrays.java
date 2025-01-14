2657. Find the Prefix Common Array of Two Arrays
Solved
Medium

You are given two 0-indexed integer permutations A and B of length n.

A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.

Return the prefix common array of A and B.

A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.

 

Example 1:

Input: A = [1,3,2,4], B = [3,1,2,4]
Output: [0,2,3,4]
Explanation: At i = 0: no number is common, so C[0] = 0.
At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.
Example 2:

Input: A = [2,3,1], B = [3,1,2]
Output: [0,1,3]
Explanation: At i = 0: no number is common, so C[0] = 0.
At i = 1: only 3 is common in A and B, so C[1] = 1.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.


  
 

Constraints:

1 <= A.length == B.length == n <= 50
1 <= A[i], B[i] <= n
It is guaranteed that A and B are both a permutation of n integers.




  //Approach-1 (Brute Force)
//T.C : O(n^3)
//S.C : O(1)

  class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int l= A.length;

        int  result[] = new int[l];

        for(int i = 0; i < l; i++)
         {
            int count = 0;
            for(int x = 0; x <= i; x++) 
            {
                for(int y = 0; y <= i; y++) 
                {
                    if(B[y] == A[x]) {
                        count++;
                        break;
                    }
                }
            }

            result[i] = count;
        }

        return result;

    }
}


//********************Approach-2**************
//(Better Approach)
//T.C : O(n^2)
//S.C : O(n)

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int l= A.length;

        int  result[] = new int[l];
        boolean isPresentA[]=new boolean[l+1];
        boolean isPresentB[]=new boolean[l+1];

        for(int i = 0; i < l; i++)
        {
            isPresentA[A[i]]=true;
            isPresentB[B[i]]=true;
            int count=0;
            for(int number=1;number<=l;number++)
            {
                if(isPresentA[number]==true&&isPresentB[number]==true)
                {
                    count++;
                }
            }
            result[i]=count;
        }
        return result;
        
    }
}



//Approach-3 (Optimal Approach)
//T.C : O(n)
//S.C : O(n)

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int l= A.length;

        int  result[] = new int[l];
       int count=0;
       HashMap<Integer,Integer>map=new HashMap<>();
        for(int i = 0; i < l; i++)
        {
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            if(map.get(A[i])==2)
            {
                count++;
            }
             map.put(B[i],map.getOrDefault(B[i],0)+1);
            if(map.get(B[i])==2)
            {
                count++;
            }
            result[i]=count;
            
        }
        return result;
        
    }
}
