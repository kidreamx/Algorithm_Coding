import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static int n;
    static int[] arr;
    static long[][] dp;
    public static void main(String[] args) throws IOException{
        init();
        calculate();
    }
    public static void init() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp = new long[100001][4];
    }
    public static void calculate(){
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][3] = 1;
        dp[3][2] = 1;
        dp[3][1] = 1;
        for(int i=4;i<=100000;i++){
            dp[i][1] = (dp[i-1][2]+dp[i-1][3])%1000000009;
            dp[i][2] = (dp[i-2][3]+dp[i-2][1])%1000000009;
            dp[i][3] = (dp[i-3][1]+dp[i-3][2])%1000000009;
//            if(i<=10)  System.out.println(i+"번쨰 숫자는 1: "+dp[i][1] +", 2: "+dp[i][2]+", 3: "+dp[i][3]);
        }
        for(int i=0;i<n;i++){
            System.out.println((dp[arr[i]][1]+dp[arr[i]][2]+dp[arr[i]][3])%1000000009);
        }
    }
}