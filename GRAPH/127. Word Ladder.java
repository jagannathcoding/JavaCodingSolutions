class Pair{
    String first;
    int second;
    Pair(String s1,int s)
    {
        this.first=s1;
        this.second=s;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair>q=new LinkedList<>();
        HashSet<String>set=new HashSet<>();
        for(String s:wordList)
        {
            set.add(s);
        }
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty())
        {
            String w1=q.peek().first;
            int steps=q.peek().second;
            q.remove();

            if(w1.equals(endWord)==true) return steps;

           for(int i=0;i<w1.length();i++)
           {
                for(char ch='a';ch<='z';ch++)
                {
                    char w2[]=w1.toCharArray();
                    w2[i]=ch;
                    String w3=new String(w2);
                    if(set.contains(w3))
                    {
                        q.add(new Pair(w3,steps+1));
                        set.remove(w3);
                    }
                    
                }
           }
        }
        return 0;
    }
}
