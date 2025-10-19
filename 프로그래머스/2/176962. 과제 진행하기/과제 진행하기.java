import java.util.*;
class Work implements Comparable<Work>{
    String name;
    int time;
    int minute;
    int playtime;
    int spend;
    Work(String name , int time, int minute, int playtime, int spend){
        this.name = name;
        this.time = time;
        this.minute = minute;
        this.playtime = playtime;
        this.spend = spend;
    }
    @Override
    public int compareTo(Work o){
        if(this.time == o.time){
            return this.minute - o.minute;
        }else{
            return this.time - o.time;
        }
    }
}
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Work[] works = new Work[plans.length];
        for(int i=0;i<plans.length;i++){
            String[] sa = plans[i][1].split(":");
            int time = Integer.parseInt(sa[0]);
            int minute = Integer.parseInt(sa[1]);
            works[i] = new Work(plans[i][0], time, minute, Integer.parseInt(plans[i][2]),0);
        }
        Arrays.sort(works);
        Stack<Work> queue = new Stack<>();
        int currentTime=0;
        int nextTime=0;
        int len =0;
        for(int i=0;i<plans.length;i++){
            if(i==0){
                currentTime = works[i].time*60+works[i].minute;
                queue.push(works[i]);
            }else{
                nextTime = works[i].time*60+works[i].minute;
                int remain = nextTime - currentTime;
                while(!queue.isEmpty()){
                    Work work = queue.pop();
                    if(remain>=work.playtime-work.spend){
                        answer[len++] = work.name;
                        remain -= work.playtime-work.spend;
                    }else{
                        work.spend += remain;
                        queue.push(work);
                        break;
                    }
                }
                currentTime = nextTime;
                queue.push(works[i]);
            }
        }
        while(!queue.isEmpty()){
            Work work = queue.pop();
            answer[len++] = work.name;
        }
        return answer;
    }
}