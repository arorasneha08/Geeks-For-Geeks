class Solution {
    private void func(List<Integer> preorder, List<Integer> res) {
        if (preorder.size() == 0) return;

        List<Integer> left = new ArrayList<>(); 
        List<Integer> right = new ArrayList<>(); 
        int n = preorder.size(); 
        
        for (int i = 1; i < n; i++) {
            if (preorder.get(i) < preorder.get(0)) 
                left.add(preorder.get(i));
            else 
                right.add(preorder.get(i)); 
        }
        if (left.size() == 0 && right.size() == 0) {
            res.add(preorder.get(0)); 
            return; 
        }

        if (left.size() != 0) func(left, res); 
        if (right.size() != 0) func(right, res); 
    }

    public ArrayList<Integer> leafNodes(int[] preorder) {
        ArrayList<Integer> res = new ArrayList<>();
        List<Integer> pre = new ArrayList<>(); 
        for (int i = 0; i < preorder.length; i++) {
            pre.add(preorder[i]); 
        }
        func(pre, res); 
        return res; 
    }
}
