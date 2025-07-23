//tc:o(n)
//sc:o(n)

/// https://leetcode.com/problems/daily-temperatures/description/



class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer>st=new Stack<>();
        int res[]=new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--)
        {

            while(!st.isEmpty()&&temperatures[st.peek()]<=temperatures[i])

            {
                st.pop();

            }

            if(st.isEmpty())
            {
                res[i]=0;
            }


                else
                {
                    res[i]=st.peek()-i;
                }

                st.push(i);

        }
        return res;
    }
}
