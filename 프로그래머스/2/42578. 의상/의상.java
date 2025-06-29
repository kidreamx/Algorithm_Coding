import java.util.*;
class Solution {
    int sum = 0;
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String , Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
           map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);           
        }
        int tmp = 1;
        for(int i : map.values()){
            tmp *= (i+1);
        }
        answer = tmp -1;
        return answer;
    }
  
}