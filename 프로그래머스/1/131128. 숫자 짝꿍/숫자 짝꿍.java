import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] xCnt = new int[10];
        int[] yCnt = new int[10];
        int[] common = new int[10];
        char[] xchars = X.toCharArray();
        char[] ychars = Y.toCharArray();
        for(int i=0;i<xchars.length;i++){
            xCnt[xchars[i]-'0']++;
        }
        for(int i=0;i<ychars.length;i++){
            yCnt[ychars[i]-'0']++;
        }
        int len = 0;
        for(int i=0;i<10;i++){
            common[i] = Math.min(xCnt[i], yCnt[i]);
            len += common[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=9;i>=0;i--){
            for(int j=0;j<common[i];j++){
                sb.append(Integer.toString(i));
            }
        }
        if(len ==0) answer = "-1";
        else {
            answer = sb.toString();
            if(answer.charAt(0)=='0'){
                answer = "0";
            }
        }
        return answer;
    }
}