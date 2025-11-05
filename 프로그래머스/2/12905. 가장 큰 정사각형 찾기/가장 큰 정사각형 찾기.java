import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int answer =0;
        int rows = board.length;
        int cols = board[0].length;
        int maxLen = 0;
        int[][] dp = new int[rows][cols];
        for(int i=0;i<rows;i++){
            dp[i][0] = board[i][0];
            maxLen = Math.max(maxLen,dp[i][0]);
        }
        for(int j=0;j<cols;j++){
            dp[0][j] = board[0][j];
            maxLen = Math.max(maxLen,dp[0][j]);
        }
        
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(board[i][j] == 1){
                    int left = dp[i][j-1];
                    int right = dp[i-1][j];
                    int cross = dp[i-1][j-1];
                    dp[i][j] = Math.min(left, Math.min(right,cross))+1;
                }else{
                    dp[i][j] =0;
                }
                maxLen = Math.max(dp[i][j],maxLen);
            }
        }
        answer = maxLen*maxLen;
        return answer;
    }
}