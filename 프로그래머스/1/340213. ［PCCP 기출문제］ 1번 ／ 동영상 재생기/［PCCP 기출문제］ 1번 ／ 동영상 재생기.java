class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        String[] video = video_len.split(":");
        int videoTime = Integer.parseInt(video[0])*100 + Integer.parseInt(video[1]);
        String[] sa = pos.split(":");
        int pTime = Integer.parseInt(sa[0]);
        int pMin = Integer.parseInt(sa[1]);
        int current = pTime*100+pMin;
        sa = op_start.split(":");
        int opStime = Integer.parseInt(sa[0]);
        int opSmin = Integer.parseInt(sa[1]);
        int os = opStime*100+opSmin;
        sa = op_end.split(":");
        int opEtime = Integer.parseInt(sa[0]);
        int opEmin = Integer.parseInt(sa[1]);
        int oe = opEtime*100 + opEmin;
        
        if(os<= current  && current<= oe){
            current = oe;
            pTime = opEtime;
            pMin = opEmin;
        }
        for(int i=0;i<commands.length;i++){
            if(commands[i].equals("next")){
                if(pMin+10>=60){
                    pMin += 10;
                    pTime +=1;
                    pMin -= 60;
                }else{
                    pMin += 10;
                }
                current = pTime*100 + pMin;
                if(current >= videoTime){
                    current = videoTime;
                    pTime = Integer.parseInt(video[0]);
                    pMin = Integer.parseInt(video[1]);
                }
            }else if(commands[i].equals("prev")){
                if(pMin-10<0){
                    pMin -=10;
                    pTime -=1;
                    pMin += 60;
                }else{
                    pMin -= 10;
                }
                if(pTime <0){
                    pTime = 0;
                    pMin = 0;
                    current = 0;
                }else{
                    current = pTime*100 + pMin;
                }  
            }
            if(os<= current  && current<= oe){
            current = oe;
            pTime = opEtime;
            pMin = opEmin;
            }
            System.out.println(current+", "+pTime+" , "+pMin);
        }
        
        String time = Integer.toString(pTime);
        String zero = "0";
        if(pTime ==0) {
            time = "00";
        }else if(pTime <10){
            time = zero.concat(time);
        }
        String min = Integer.toString(pMin);
        if(pMin == 0) {
            min = "00";
        }else if(pMin < 10){
            min = zero.concat(min);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(time+":"+min);
        answer = sb.toString();
        return answer;
    }
}