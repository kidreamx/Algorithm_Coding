import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] alpha = new int[26];
        Arrays.fill(alpha,Integer.MAX_VALUE);
        for(int i=0;i<keymap.length;i++){
            for(int j=0;j<keymap[i].length();j++){
                alpha[keymap[i].charAt(j)-'A'] = Math.min(alpha[keymap[i].charAt(j)-'A'], (j+1));
            }
            
        }
        // 합을 구하는 과정
        for(int i=0;i<targets.length;i++){
            int sum=0;
            boolean canMake=true;
            for(int j=0;j<targets[i].length();j++){
                if(alpha[targets[i].charAt(j)-'A']!=Integer.MAX_VALUE){
                    sum += alpha[targets[i].charAt(j)-'A'];
                }else{
                    canMake =false;
                }
            }
            if(!canMake){
                answer[i] = -1;
            }else{
                answer[i] = sum;
            }
            
        }
        return answer;
    }
}