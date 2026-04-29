import java.util.*;
class Solution{
    public int solution(String s){
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        stack.add(chars[0]);
        for(int i=1;i<s.length();i++){
            if(!stack.isEmpty()){
                if(stack.peek() == chars[i]){
                    stack.pop();
                    continue;
                }
            }
            stack.add(chars[i]);
        }
        if(stack.size()==0){
            return 1;
        }else{
            return 0;
        }
    }
}