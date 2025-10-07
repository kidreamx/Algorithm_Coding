class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int start = 0;
        int end = 100000;
        while(end>start+1){
            int mid = (start+end)/2;
            if(solve(diffs,times,limit,mid)) end = mid;
            else start = mid;
        }
        answer = end;
        return answer;
    }
    public boolean solve(int[] diffs, int[] times, long limit, int grade){
        long sum = 0;
        for(int i=0;i<diffs.length;i++){
            if(diffs[i]<= grade){
                sum += times[i];
            }else {
                if(i==0){
                   sum+= (diffs[i]-grade)*(times[i])+times[i];
                }else{
                    sum+= (diffs[i]-grade)*(times[i]+times[i-1])+times[i];
                }
            }
        }
        if(sum<= limit){
            return true;
        }else{
            return false;
        }
    }
}