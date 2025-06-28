import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Boolean> hashmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!hashmap.containsKey(nums[i])){
                hashmap.put(nums[i],true);
            }
        }
        if(hashmap.size()>=(nums.length/2)){
            answer = (nums.length/2);
        }else{
            answer = hashmap.size();
        }
        return answer;
    }
}