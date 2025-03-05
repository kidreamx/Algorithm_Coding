import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[10001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4;i<10001;i++) {
            dp[i] = dp[i - 3] + (i / 2) + 1;
        }
        for(int i=0;i<N;i++){
            sb.append(dp[Integer.parseInt(br.readLine())]+"\n");
        }
        System.out.println(sb);
    }
}