import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        int[] memory = new int[N+1];
        sa = br.readLine().split(" ");
        for(int i=1;i<=N;i++){
            memory[i] = Integer.parseInt(sa[i-1]);
        }
        int[] cost = new int[N+1];
        int costSum = 0;
        sa = br.readLine().split(" ");
        for(int i=1;i<=N;i++){
            cost[i]  = Integer.parseInt(sa[i-1]);
            costSum += cost[i];
        }
        int[] dp = new int[costSum+1];
        for(int i=1;i<=N;i++){
            for(int j=costSum;j>=cost[i];j--){
                dp[j] = Math.max(dp[j],dp[j-cost[i]]+memory[i]);
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=costSum;i++){
            if(dp[i]>=M){
                answer = i;
                break;
            }
        }
        if(answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);
    }
}