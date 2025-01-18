import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            for(int j = 0; j<i+1;j++){
                arr[i][j] = Integer.parseInt(sa[j]);
            }
        }
        dp[0][0] = arr[0][0];
        for(int i=1;i<N;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    dp[i][j] = arr[i][j]+ dp[i-1][j];
                }
                else if(j==i){
                    dp[i][j] = arr[i][j] + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        int max=0;
        for(int i=0;i<N;i++){
            max = Math.max(dp[N-1][i],max);
        }
        System.out.println(max);
    }
}