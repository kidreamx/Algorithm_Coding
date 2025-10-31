import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[3000001];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[x] = 0;
        for(int i = x; i<y; i++){
            if(dp[i] == Integer.MAX_VALUE) continue;
            dp[i+n]  = Math.min(dp[i+n],dp[i] + 1);
            dp[i*2]  = Math.min(dp[i*2],dp[i] + 1);
            dp[i*3] =  Math.min(dp[i*3],dp[i] + 1);
        }
        if(dp[y] == Integer.MAX_VALUE) return -1;
        answer = dp[y];
        return answer;
    }
}