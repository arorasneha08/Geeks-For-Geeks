class Solution {
    Stack<Character> undo = new Stack<>(); 
    Stack<Character> redo = new Stack<>(); 
    StringBuilder str = new StringBuilder(); 
    
    public void append(char x) {
        str.append(x); 
        undo.push(x); 
        redo.clear(); 
    }

    public void undo() {
        if(str.length() == 0) return ; 
        char remove = str.charAt(str.length()-1); 
        str.deleteCharAt(str.length()-1); 
        redo.push(remove); 
    }

    public void redo() {
        if(redo.isEmpty()) return ; 
        char ch = redo.pop(); 
        str.append(ch); 
        undo.push(ch); 
    }

    public String read() {
        return str.toString(); 
    }
}
