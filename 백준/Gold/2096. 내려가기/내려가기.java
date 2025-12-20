import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];
        int[][] arr = new int[N][3];
        int[][] min = new int[N][3];
        for(int i=0;i<N;i++){
            Arrays.fill(min[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(sa[0]);
            arr[i][1] = Integer.parseInt(sa[1]);
            arr[i][2] = Integer.parseInt(sa[2]);
        }
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        min[0][0] = arr[0][0];
        min[0][1] = arr[0][1];
        min[0][2] = arr[0][2];
        for(int i=1;i<N;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1])+ arr[i][0];
            dp[i][1] = Math.max(Math.max(dp[i-1][0],dp[i-1][1]),dp[i-1][2])+arr[i][1];
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2])+arr[i][2];
            min[i][0] = Math.min(min[i-1][0],min[i-1][1])+ arr[i][0];
            min[i][1] = Math.min(Math.min(min[i-1][0],min[i-1][1]),min[i-1][2])+arr[i][1];
            min[i][2] = Math.min(min[i-1][1],min[i-1][2])+arr[i][2];
        }
        int max = Math.max(dp[N-1][0],Math.max(dp[N-1][1],dp[N-1][2]));
        int minValue = Math.min(min[N-1][0],Math.min(min[N-1][1],min[N-1][2]));
        System.out.println(max+" "+minValue);
    }
}