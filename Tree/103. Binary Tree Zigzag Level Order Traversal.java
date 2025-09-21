class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> alist = new ArrayList<>();
        if(root==null) return alist;

        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        boolean leftToRight=true;
        while(!q.isEmpty())
        {
            int size=q.size();
            LinkedList<Integer>row=new LinkedList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                if (leftToRight) 
                {
                    row.addLast(node.val);   // left → right
                } 
                else 
                {
                    row.addFirst(node.val);  // right → left
                }
                
            }
             alist.add(row);
            leftToRight = !leftToRight;
        }
        return alist;
    }
}
