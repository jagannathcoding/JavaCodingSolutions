
class Solution {
    public int[][] merge(int[][] intervals) {
       
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> alist = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            
            if (alist.isEmpty() || intervals[i][0] > alist.get(alist.size() - 1)[1]) 
            {
                alist.add(new int[]{intervals[i][0], intervals[i][1]});
            } 
            else 
            {
                
                alist.get(alist.size() - 1)[1] = 
                    Math.max(alist.get(alist.size() - 1)[1], intervals[i][1]);
            }
        }

        
        return alist.toArray(new int[alist.size()][]);
    }
}
