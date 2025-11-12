class Solution {
    public int minCost(String colors, int[] neededTime) {
        int l=neededTime.length;
        int time=0;
        int previousMax=0;
        for(int i=0;i<l;i++)
        {
             if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
                previousMax = 0;
            }

            int currentTime=neededTime[i];
            time+=Math.min(previousMax,currentTime);

            previousMax=Math.max(previousMax,currentTime);
        }
        return time;
    }
}
