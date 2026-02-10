import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> first = new ArrayDeque<>();
        long firstSum = 0;
        long secondSum = 0;
        int firstIndex =0;
        int secondIndex = 0;
        Queue<Integer> second = new ArrayDeque<>();
        for(int i=0;i<queue1.length;i++){
            first.add(queue1[i]);
            firstSum += queue1[i];
            second.add(queue2[i]);
            secondSum += queue2[i];
        }
        int limit = queue1.length*2 + queue2.length*2;
        while(answer < limit){
            // 일단 값의 차이가 얼마나 나는지 확인
            if(firstSum > secondSum){
                int num = first.poll();
                firstSum -= num;
                secondSum += num;
                second.add(num);
                answer++;
                firstIndex++;
            }else if(firstSum < secondSum){
                int num = second.poll();
                firstSum += num;
                secondSum -= num;
                first.add(num);
                answer++;
                secondIndex++;
            }else if(firstSum == secondSum){
                break;
            }
        
        }
        if(answer == limit){
            answer = -1;
        }
        return answer;
    }
}