import java.util.*;
import java.io.*;

public class Main{
    static int T;
    static int N;
    static int[] card;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            input(br);
            calculate();
            sb.append(dp[1][N]+"\n");
        }
        System.out.println(sb);
    }
    static void input(BufferedReader br) throws IOException{
        N = Integer.parseInt(br.readLine());
        card= new int[N+1];
        String[] sa = br.readLine().split(" ");
        for(int i=1;i<=N;i++){
            card[i] = Integer.parseInt(sa[i-1]);
        }
        dp = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            dp[i][i] = card[i];
            if(i!=N){
                dp[i][i+1] = Math.max(card[i],card[i+1]);
            }
        }
    }
    static void calculate(){
        for(int len=3;len<=N;len++){
            for(int i=1;i<=N-len+1;i++){
                int j = i+len-1;
                dp[i][j] = Math.max(card[i]+Math.min(dp[i+2][j],dp[i+1][j-1]),card[j]+Math.min(dp[i][j-2],dp[i+1][j-1]));
            }
        }
    }
}