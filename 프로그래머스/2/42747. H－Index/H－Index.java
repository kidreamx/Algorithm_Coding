import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<citations.length;i++){
            list.add(citations[i]);
        }
        Collections.sort(list,Collections.reverseOrder());
        int max = 0;
        int len = list.size();
        for(int i =0;i<len;i++){
            int tmp = list.get(i);
            if((tmp >=(i+1)) ){
                answer = i+1;
            }
                
        }
        return answer;
    }
}