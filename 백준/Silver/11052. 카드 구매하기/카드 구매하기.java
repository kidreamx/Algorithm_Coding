import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int[] num = new int[N+1];
        String[] sa = br.readLine().split(" ");
        for(int i=1;i<=N;i++){
            num[i] = Integer.parseInt(sa[i-1]);
        }
        dp[1]= num[1];
        for(int i=2;i<=N;i++){
            for(int j=1;j<=i;j++) {
                dp[i] = Math.max(dp[i], num[j] + dp[i - j]);
            }
        }
        System.out.println(dp[N]);
    }
}