50. Pow(x, n)
Solved
Medium
Topics
premium lock icon
Companies
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104

////////////USED BINARY EXPONENETIOAL SIR TECHNIQUE

  //Tc:LOG(N)
  SC = O(log n)
//APPROACH-1
  class Solution {
    double myPow(double x, int n) {
        long z= n; 
        if (z < 0) 
        {
            x = 1 / x;
            z = -z;
        }
        return fastPow(x, z);
    }
    
     double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}

//////APPROACH-2
class Solution {

    double solve(double x, long n) {
        
        if(n == 0)
            return 1;
        
        if(n < 0)
            return 1/solve(x, -n);
        
        
        if(n%2 == 0) {
            return solve(x*x, n/2);
        }
        
        return x*solve(x*x, (n-1)/2);
        
    }
    public double myPow(double x, int n) {
        return solve(x, (long)n);
    }
}
