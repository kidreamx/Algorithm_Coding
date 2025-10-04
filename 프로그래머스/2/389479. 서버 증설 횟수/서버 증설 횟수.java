import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<players.length;i++){
            // 먼저 queue 돌면서 현재시간 - 들어간 시간 = k인것 다 poll 한다.
            while(!queue.isEmpty()){
                int time = queue.peek();
                if(i - time < k){
                    break;
                }else{
                    queue.poll();
                }
            }
            // n*m <= x < n+1 * m 으로 n구하고 - queue 크기 만큼 증설
            int n = players[i] / m ; 
            if(n - queue.size()>0){
                int size = n-queue.size();
                answer += size;
                while(size-->0){
                    queue.add(i);
                }
            }
        }
        return answer;
    }
}