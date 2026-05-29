import java.util.*;
class Node implements Comparable<Node>{
    int index;
    int prior;
    Node(int index , int prior){
        this.index = index;
        this.prior = prior;
    }
    @Override
    public int compareTo(Node node){
        if(this.prior == node.prior) {
            return this.index - node.index;
        }
        else{
            return node.prior - this.prior;            
        }
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<priorities.length;i++){
            pq.add(new Node(i,priorities[i]));
            queue.add(i);
        }
        int cnt=0;
        while(!queue.isEmpty()){
            int index = queue.poll();
            if(priorities[index]>=pq.peek().prior){
                pq.poll();
                cnt++;
                if(location == index){
                    return cnt;
                }
            }else{
                queue.add(index);
            }
        }
        
        return answer;
    }
}