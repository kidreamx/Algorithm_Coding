import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        String[] sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        Arrays.fill(dp,1);
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[i]<arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max=0;
        for(int i=0;i<N;i++){
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}