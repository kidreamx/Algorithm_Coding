import java.util.*;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int N = money.length;
        int[][] dp = new int[N][2]; 
        // 1. 0번을 털고 시작할때 -> N-2까지만 
        dp[0][0] = money[0];
        dp[1][0] = Math.max(money[0],money[1]);
        for(int i=2;i<N-1;i++){
            dp[i][0] = Math.max(dp[i-2][0]+money[i], dp[i-1][0]);
        }
        // 2. 0번을 안털고 시작 -> N-1까지
        dp[0][1] = 0;
        dp[1][1] = money[1];
        for(int i=2;i<N;i++){
            dp[i][1] = Math.max(dp[i-2][1]+money[i], dp[i-1][1]);
        }
        answer = Math.max(dp[N-2][0],dp[N-1][1]);
        return answer;
    }
}