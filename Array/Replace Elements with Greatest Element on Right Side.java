Replace Elements with Greatest Element on Right Side
  tc:o(n)
  sc;o(1)

  class Solution {
    public int[] replaceElements(int[] arr) {
        int l = arr.length;
        int[] ans = new int[l]; 
        ans[l - 1] = -1;  
        int max = arr[l - 1];              
        for (int i = l - 2; i >= 0; i--) 
        {
            ans[i] = max;        
            if (arr[i] > max) 
            { 
                max = arr[i];
            }
        }
        
        return ans;
    }
}
