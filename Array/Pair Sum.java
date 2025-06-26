 Pair Sum
Easy
40/40
Average time to solve is 15m
Contributed by
3123 upvotes
Asked in companies
Problem statement
You are given an integer array 'ARR' of size 'N' and an integer 'S'. Your task is to return the list of all pairs of elements such that each sum of elements of each pair equals 'S'.

Note:

Each pair should be sorted i.e the first value should be less than or equals to the second value. 

Return the list of pairs sorted in non-decreasing order of their first value. In case if two pairs have the same first value, the pair with a smaller second value should come first.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^3
-10^5 <= ARR[i] <= 10^5
-2 * 10^5 <= S <= 2 * 10^5

Time Limit: 1 sec
Sample Input 1:
5 5
1 2 3 4 5
Sample Output 1:
1 4
2 3
Explaination For Sample Output 1:
Here, 1 + 4 = 5
      2 + 3 = 5
Hence the output will be, (1,4) , (2,3).
Sample Input 2:
5 0
2 -3 3 3 -2
Sample Output 2:
-3 3
-3 3
-2 2



  import java.util.*;

public class Solution {
    public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int remaining = s - num;

            if (map.containsKey(remaining)) {
                int freq = map.get(remaining);
                for (int i = 0; i < freq; i++) {
                    int[] pair = new int[]{Math.min(num, remaining), Math.max(num, remaining)};
                    result.add(pair);
                }
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        
        result.sort((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        return result;
    }
}
