import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] result = new long[T];
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[N+1];
            for(int j=1;j<=N;j++){
                if(j>=1 && j<=3){
                    dp[j] = 1;
                }
                else if(j>=4 && j<=5){
                    dp[j] = 2;
                }
                else{
                    dp[j] = dp[j-1]+dp[j-5];
                }
            }
            result[i] = dp[N];
        }
        for(int i=0;i<T;i++){
            System.out.println(result[i]);
        }
    }
    
}