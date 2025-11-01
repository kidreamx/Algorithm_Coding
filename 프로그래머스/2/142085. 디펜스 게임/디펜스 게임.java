import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int len = enemy.length;
        int limit = n;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<len;i++){
            if(pq.size()<k){
                pq.add(enemy[i]);
            }
            else{
                pq.add(enemy[i]);
                limit -= pq.poll();
                if(limit<0){
                    answer = i;
                    break;
                }
            }
        }
        if(answer ==0) answer = enemy.length;
        return answer;
    }
}

/*
    1. n명을 순서대로 막는다.
    2. 남은 병사의 수보다 현재 라운드의 적의 수가 더 많으면 게임이 끝
    3. 무적권이 있는데 병사의 소모없이 한 라운드의 공격을 막을 수 있다.
    4. 무적권은 k번 사용가능하다.
    5. 준호가 몇 라운드까지 막을 수 있을지 return
    풀이 : 누적합 -> x , dp인듯하다
    dp로 풀면 무적권을 쓴경우 , 안쓴 경우 이렇게 해서 분기처리해서 풀면 될듯하다.
*/