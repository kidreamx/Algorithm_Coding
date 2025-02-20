import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        int[][] dp = new int[N+1][N+1];
        int[][] arr = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            sa= br.readLine().split(" ");
            for(int j=1;j<=N;j++){
                arr[i][j] = Integer.parseInt(sa[j-1]);
                dp[i][j] = arr[i][j]+ dp[i-1][j];
            }
        }
        for(int i=0;i<M;i++){
            int sum=0;
            sa = br.readLine().split(" ");
            int x1 = Integer.parseInt(sa[0]);
            int y1 = Integer.parseInt(sa[1]);
            int x2 = Integer.parseInt(sa[2]);
            int y2 = Integer.parseInt(sa[3]);
            for(int j= y1 ; j<= y2;j++){
                if(x1==1){
                    sum+= dp[x2][j];
                }
                else{
                    sum += dp[x2][j]- dp[x1-1][j];
                }
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }
}