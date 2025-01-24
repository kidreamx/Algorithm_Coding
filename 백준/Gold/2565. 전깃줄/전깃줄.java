import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(sa[0]);
            arr[i][1] = Integer.parseInt(sa[1]);
        }
        Arrays.sort(arr, (o1,o2) ->{
           return o1[0] - o2[0];
        });
        int[] dp = new int[N];
        Arrays.fill(dp,1);
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[i][1]>arr[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max=0;
        for(int i=0;i<N;i++){
            max = Math.max(max,dp[i]);
        }
        System.out.println(N-max);
    }

}