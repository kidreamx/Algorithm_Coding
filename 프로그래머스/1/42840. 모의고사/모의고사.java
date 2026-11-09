import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        List<Integer> list = new ArrayList<>();
        int[] ans = new int[3];
        for(int i=0;i<answers.length;i++){
            if(a[i%5]==answers[i]){
                ans[0]++;
            }
        }
        for(int i=0;i<answers.length;i++){
            if(b[i%8] == answers[i]){
                ans[1]++;
            }
        }
        for(int i=0;i<answers.length;i++){
            if(c[i%10] == answers[i]){
                ans[2]++;
            }
        }
        int max = Math.max(Math.max(ans[0],ans[1]),ans[2]);
        for(int i=0;i<3;i++){
            if(max==ans[i]){
                list.add(i+1);
            }
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}