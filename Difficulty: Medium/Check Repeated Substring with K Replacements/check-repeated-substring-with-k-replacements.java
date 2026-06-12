class Solution {
    public boolean kSubstr(String s, int k) {
        int n=s.length();
        if(n%k!=0) return false;
        
        if(n==k) return true;
        Map<String , Integer> map=new HashMap<>();
        int i=0;
        while(i<n){
            if(i+k==n){
                String st=s.substring(i);
                map.put(st,map.getOrDefault(st,0)+1);
            }else{
                String st=s.substring(i,i+k);
                map.put(st,map.getOrDefault(st,0)+1);
            }
            i=i+k;
        }
        if(map.size()>2) return false;
        if(map.size()==1) return true;
        List<Integer> li=new ArrayList<>();
        
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            String key=entry.getKey();
            int val=entry.getValue();
            li.add(val);
        }
        Collections.sort(li);
        if(li.get(0)!=1) return false;
        return true ; 
        
    }
}