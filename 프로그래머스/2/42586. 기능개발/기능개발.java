import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] days = new int[101];
        boolean[] finished = new boolean[101];
        for(int i=0;i<progresses.length;i++){
            int limit = 100- progresses[i];
            int day = limit/speeds[i];
            if(limit%speeds[i] == 0){
                days[day]++;
            }else{
                day += 1;
                days[day]++;
            }
            queue.add(day);
        }
        int before=queue.poll();
        int cnt=1;
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int day = queue.poll();
            if(day<=before){
                cnt++;
            }else{
                result.add(cnt);
                cnt=1;
                before = day;
            }
        }
        result.add(cnt);
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}