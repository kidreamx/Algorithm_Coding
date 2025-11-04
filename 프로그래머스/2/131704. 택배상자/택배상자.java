import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> start = new Stack<>();
        for(int i=order.length-1;i>=0;i--){
            start.add(i+1);
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while(true){
            if(index == order.length){
                break;
            }
            if(!start.isEmpty()){
                if(start.peek() == order[index]){
                    index++;
                    answer++;
                    start.pop();
                    if(!stack.isEmpty()){
                        if(stack.peek() == order[index]){
                            index++;
                            answer++;
                            stack.pop();
                        }
                    }
                }else{
                    if(!stack.isEmpty()){
                        if(stack.peek() == order[index]){
                            index++;
                            answer++;
                            stack.pop();
                        }
                    }
                    stack.push(start.pop());
                }
            }
            else{
                if(!stack.isEmpty()){
                    if(stack.peek() == order[index]){
                        index++;
                        answer++;
                        stack.pop();
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        
        return answer;
    }
}

/*
    1. 보조 컨테이너가 앞 뒤로 이동이 간으하지만 입구 외에는 다른 면이 막혀 맨 앞 상자만 빼기 가능
    2. 마지막에 보조 
*/