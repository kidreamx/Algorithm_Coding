import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int[] weight = new int[241];
        for(int i=0;i<people.length;i++){
            weight[people[i]]++;
        }
        Arrays.sort(people);
        for(int i= 240;i>=1;i--){
            while(weight[i]>0){
                weight[i]--;
                for(int j=1; j<=limit-i;j++){
                    if(weight[j]>0){
                        weight[j]--;
                        break;
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}