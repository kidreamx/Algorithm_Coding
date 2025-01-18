import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long [][]dp = new long[N+1][3];
        long result=3;
        for(int i=1;i<=N;i++){
            if(i==1){
                dp[1][0] = 1;
                dp[1][1] = 1;
                dp[1][2] = 1;
                result = 3;
            }
            else{
                 dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
                 dp[i][2] = (dp[i-1][0]+dp[i-1][1])%9901;
                 dp[i][1] = (dp[i-1][0]+dp[i-1][2])%9901;
                 result = (dp[i][0]+dp[i][1]+dp[i][2])%9901;
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }

}