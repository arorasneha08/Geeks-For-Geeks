// User function Template for Java

class Solution {
    static class Pair{
        int node ;
        int steps ;
        
        Pair(int node , int steps){
            this.node = node; 
            this.steps = steps; 
        }
    }
    static int minThrow(int n , int arr[]) {
        int moves[] = new int[31]; 
        for(int i = 1 ; i <= 30 ; i++){
            moves[i] = i ; 
        }
        for(int i = 0 ; i < arr.length ; i+=2){
            int u = arr[i];
            int v = arr[i+1]; 
            moves[u] = v;  
        }
        
        Queue<Pair> q = new LinkedList<>(); 
        q.offer(new Pair(1 , 0)); 
        int visited[] = new int[31];
        visited[1] = 1  ;
        
        while(!q.isEmpty()){
            
            Pair curr = q.poll();
            int currNode = curr.node; 
            int currSteps = curr.steps; 
            
            if(currNode == 30) return currSteps; 
            
            for(int dice = 1 ; dice <= 6 ; dice ++){
                int nextNode = currNode + dice; 
                
                if(nextNode <= 30){
                    nextNode = moves[nextNode]; 
                    
                    if(visited[nextNode] == 0){
                        visited[nextNode] = 1; 
                        q.offer(new Pair(nextNode , currSteps + 1)); 
                    }
                }
            }
        }
        return -1; 
    }
}