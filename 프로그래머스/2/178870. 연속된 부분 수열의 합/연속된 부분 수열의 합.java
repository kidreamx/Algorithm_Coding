class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int[] prefix = new int[sequence.length];
        prefix[0] = sequence[0];
        for(int i=1;i<sequence.length;i++){
            prefix[i]= prefix[i-1] + sequence[i];
        }
        int end = 0;
        int start = 0;
        int ans_start=0;
        int ans_end=0;
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<prefix.length;i++){
            if(k<prefix[i]){
                end = i;
                break;
            }else if(k==prefix[i]){
                ans_start = 0;
                ans_end = i;
                end = i;
                start = 0;
                diff = i;
            }
        }  
        while(true){
            if(end == prefix.length){
                break;
            }
            if(prefix[end]-prefix[start]>k){
                start++;
            }else if(prefix[end]-prefix[start]==k){
                if((end-start-1)<diff){
                    ans_start = start+1;
                    ans_end = end;
                    diff = end-start-1;
                }
                end++;
            }else{
                end++;
            }
        }
        answer[0] = ans_start;
        answer[1] = ans_end;
        return answer;
    }
}