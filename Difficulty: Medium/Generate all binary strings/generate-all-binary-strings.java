class Solution {
    private void func(int index , char[] bit , ArrayList<String> list , StringBuilder str, int n){
        if(index == n) {
            list.add(str.toString());
            return ; 
        }
        for(char c : bit){
            str.append(c);
            func(index + 1 , bit, list, str , n); 
            str.deleteCharAt(str.length()-1); 
        }
    }
    public ArrayList<String> binstr(int n) {
        char bit[] = {'0', '1'}; 
        ArrayList<String> list = new ArrayList<>(); 
        StringBuilder str = new StringBuilder();
        func(0 , bit , list , str, n);
        return list;
    }
}
