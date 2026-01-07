import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int [][] travel;
    static int [][] dp;
    static int min;
    static final int INF = 16000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        travel = new int[N][N];
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                travel[i][j] = Integer.parseInt(sa[j]);
            }
        }
        min = Integer.MAX_VALUE;
        dp = new int[N][1<<N];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],-1);
        }
        // 출발지를 포문으로 돌면서 바꾼다.
        System.out.println(dfs(0,1));
    }
    static int dfs(int index, int visited){
        if(visited == (1<<N)-1 && travel[index][0]!=0) {
            return travel[index][0];
        }
        if(dp[index][visited]!= -1) return dp[index][visited];
        dp[index][visited] = INF;
        for(int i=0;i<N;i++){
            if((visited & (1<<i))!= 0 || (i==index) || travel[index][i] == 0) continue;
            int newVisited = visited | (1<<i);
            int temp = dfs(i, newVisited);
            if(temp != INF){
                dp[index][visited] = Math.min(dp[index][visited], travel[index][i]+temp);
            }
        }
        return dp[index][visited];
    }
}