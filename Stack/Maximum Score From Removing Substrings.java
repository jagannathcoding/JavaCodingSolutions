///company :Google, Meta, Amazon

//Approach-1 (Using Stack)
//T.C : O(n)
//S.C : O(n)

class Solution {


    public String removeSubstring(String s,String matchStr)
    {
        Stack<Character>st=new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(!st.isEmpty()&&ch==matchStr.charAt(1)&&st.peek()==matchStr.charAt(0))
            {
                st.pop();
            }
            else
            {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();

    }


    public int maximumGain(String s, int x, int y) {
        

        int l=s.length();
        int score=0;

        String maxStr=(x>y)?"ab":"ba";
        String minStr;
        if(maxStr.equals("ab")) { 
            minStr = "ba";
        }
        else {
            minStr = "ab";
        }

        String tempFirst=removeSubstring(s,maxStr);
        int removedPairs=(l-tempFirst.length())/2;
        score += removedPairs * Math.max(x, y);


        String tempSecond=removeSubstring(tempFirst,minStr);
        removedPairs=(tempFirst.length()-tempSecond.length())/2;
        score += removedPairs * Math.min(x, y);


        return score;

    }
}





/////////Appriach-2 wihtout stack

//tc:o(N)
//sc:o(1)

class Solution {


    public String removeSubstring(String s,String matchStr)
    {
        StringBuilder sb=new StringBuilder();
        int j=0;
        
        for(int i=0;i<s.length();i++)
        {
            sb.append(s.charAt(i));
            j++;

            if(j>1 && sb.charAt(j-2)==matchStr.charAt(0)&&sb.charAt(j - 1) == matchStr.charAt(1))
            {
                sb.delete(j-2,j);
                j-=2;
            }

        }

        return sb.toString();

    }


    public int maximumGain(String s, int x, int y) {
        

        int l=s.length();
        int score=0;

        String maxStr=(x>y)?"ab":"ba";
        String minStr;
        if(maxStr.equals("ab")) { 
            minStr = "ba";
        }
        else {
            minStr = "ab";
        }

        String tempFirst=removeSubstring(s,maxStr);
        int removedPairs=(l-tempFirst.length())/2;
        score += removedPairs * Math.max(x, y);


        String tempSecond=removeSubstring(tempFirst,minStr);
        removedPairs=(tempFirst.length()-tempSecond.length())/2;
        score += removedPairs * Math.min(x, y);


        return score;

    }
}
