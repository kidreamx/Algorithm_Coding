import java.util.*;
class Solution {
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int len = number.length;
        int discountLen = discount.length;
        HashMap<String , Integer> hashMap = new HashMap<>();
        // 처음 10개 초기화
        for(int i=0;i<10;i++){
            if(hashMap.containsKey(discount[i])){
                hashMap.put(discount[i],hashMap.get(discount[i])+1);
            }else{
                hashMap.put(discount[i],1);   
            }            
        }
        for(int i=0;(i+9)<discountLen;i++){
            if(check(want,number,hashMap)){
                answer++;
            }
            if(i+10 < discountLen){
                hashMap.put(discount[i],hashMap.getOrDefault(discount[i],1)-1);
                hashMap.put(discount[i+10],hashMap.getOrDefault(discount[i+10],0)+1);    
            }
        }
        return answer;
    }
    public boolean check(String[] want, int[] number, HashMap<String,Integer> hashMap){
        for(int i=0;i<number.length;i++){
            int cnt = hashMap.getOrDefault(want[i],0);
            if(cnt < number[i]){
                return false;
            }
        }
        return true;
    }
}