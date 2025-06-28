class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        for(int i=0;i<n;i++){
            int pCnt=0;
            int stdTime = schedules[i]/100;
            int stdMinute = schedules[i]%100;
            stdMinute += 10;
            if(stdMinute >=60){
                stdMinute -= 60;
                stdTime++;
            }
            int std = stdTime*100 + stdMinute;
            for(int j=0;j<7;j++){
                int day = startday+j;
                if(day%7==0 || day%7==6){
                    continue;
                }else{
                   if(timelogs[i][j]<=std){
                       pCnt++;
                   }
                }
            }
            if(pCnt==5){
                answer++;
            }
        }
        return answer;
    }
}