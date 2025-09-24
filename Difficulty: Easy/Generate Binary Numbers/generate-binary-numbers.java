class Solution {
    public ArrayList<String> generateBinary(int n) {
        ArrayList<String> res = new ArrayList<>(); 
        Queue<String> q = new LinkedList<>(); 
        q.offer("1") ;
        while(n > 0){
            String curr = q.peek(); 
            res.add(q.poll()); 
            q.offer(curr + "0"); 
            q.offer(curr + "1"); 
            n-- ; 
        }
        return res ; 
    }
}
