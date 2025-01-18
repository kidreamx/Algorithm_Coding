import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i*i<=N;i++){
            for(int j=i*i;j<=N;j++){
                dp[j] =  Math.min(dp[j],dp[j-i*i]+1);
            }
        }
        bw.write(dp[N]+"");
        bw.flush();
        bw.close();

    }

}
