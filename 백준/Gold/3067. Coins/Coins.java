import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T =Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            String[] sa  =br.readLine().split(" ");
            int[] money = new int[N+1];
            for(int j=1;j<=N;j++){
                money[j] = Integer.parseInt(sa[j-1]);
            }
            int M = Integer.parseInt(br.readLine());
            int[][] dp = new int[N+1][M+1];
            for(int i=0;i<=N;i++){
                dp[i][0] = 1;
            }
            for(int i=1;i<=N;i++){
                for(int j=1;j<=M;j++){
                    dp[i][j] = dp[i-1][j];
                    if(j>=money[i]) {
                        dp[i][j] += dp[i][j-money[i]];
                    }
                }
            }

            sb.append(dp[N][M]+"\n");
        }
        System.out.println(sb);
    }
}