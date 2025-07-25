https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1


class Solution {
    public int[] leftSmaller(int[] arr) {
        // code here
        int nums[]=new int[arr.length];
        int index=0;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            
            while(!st.isEmpty()&&st.peek()>=arr[i])
            {
                st.pop();
            }
            
            if(st.isEmpty())
            {
                nums[index]=-1;
            }
            else
            {
                nums[index]=st.peek();
            }
            st.push(arr[i]);
            index++;
            
        }
        return nums;
    }
}
