import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int[] answer = new int[2];
        int s_x=0;
        int s_y=0;
        int max_x = park[0].length();
        int max_y = park.length;
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length();j++){
                if(park[i].charAt(j) == 'S'){
                    s_x = j;
                    s_y = i;
                }
            }
        }
        for(int i=0;i<routes.length;i++){
            String[] sc = routes[i].split(" ");
            int cnt = Integer.parseInt(sc[1]);
            int tmp_x = s_x;
            int tmp_y = s_y;
            int direct =0;
            if(sc[0].equals("E")){
                direct = 0;
            }else if(sc[0].equals("S")){
                direct = 1;
            }else if(sc[0].equals("W")){
                direct = 2;
            }else if(sc[0].equals("N")){
                direct = 3;
            }
            boolean success=true;
            while(cnt-->0){
                tmp_x = tmp_x + dx[direct];
                tmp_y = tmp_y + dy[direct];
                if(tmp_x<0 || tmp_y<0 || tmp_x>=max_x || tmp_y>=max_y){
                    success = false;
                    break;
                }
                if(park[tmp_y].charAt(tmp_x) == 'X'){
                    success = false;
                    break;
                }
            }
            if(success){
                s_x = tmp_x;
                s_y = tmp_y;
            }
        }
        answer[0] = s_y;
        answer[1] = s_x;
        return answer;
    }
}