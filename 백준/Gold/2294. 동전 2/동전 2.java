import java.util.*;
import java.io.*;

public class Main{
    static int n, k;
    static int[] coin;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        input(br);
        calculate();
        if(dp[k] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(dp[k]);
        }
    }
    static void input(BufferedReader br) throws IOException{
         String[] sa = br.readLine().split(" ");
         n = Integer.parseInt(sa[0]);
         k = Integer.parseInt(sa[1]);
        dp = new int[100001];
        coin = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
         for(int i=0;i<n;i++){
             coin[i] = Integer.parseInt(br.readLine());
             dp[coin[i]] = 1;
         }

    }
    static void calculate(){
        for(int i=0;i<n;i++){
            for(int j=coin[i];j<=k;j++){
                if(dp[j-coin[i]]!=Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j],dp[j-coin[i]]+1);
                }

            }
        }
    }
}