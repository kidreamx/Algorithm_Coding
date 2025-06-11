import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+3];
        Arrays.fill(dp,Integer.MAX_VALUE);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }
        for(int i=1;i<=N;i++){
            list.get(i).add(i);
        }
        dp[1]= 0;
        for(int i=1;i<N;i++){
            // 3의 배수
            if(i*3<=N){
                if(dp[i]+1 < dp[i*3]){
                    for(int j=1;j<list.get(i*3).size();){
                        list.get(i*3).remove(j);
                    }
                    for(int j=0;j<list.get(i).size();j++){
                        list.get(i*3).add(list.get(i).get(j));
                    }
                    dp[i*3] = Math.min(dp[i*3],dp[i]+1);
                }
            }
            // 2의 배수
            if(i*2<=N) {
                if(dp[i]+1 < dp[i*2]){
                    for(int j=1;j<list.get(i*2).size();){
                        list.get(i*2).remove(j);
                    }
                    for(int j=0;j<list.get(i).size();j++){
                        list.get(i*2).add(list.get(i).get(j));
                    }
                    dp[i*2] = Math.min(dp[i*2],dp[i]+1);
                }
            }
            // 1만 더할때
            if(dp[i]+1 < dp[i+1]){
                for(int j=1;j<list.get(i+1).size();){
                    list.get(i+1).remove(j);
                }
                for(int j=0;j<list.get(i).size();j++){
                    list.get(i+1).add(list.get(i).get(j));
                }
                dp[i+1] = Math.min(dp[i+1],dp[i]+1);
            }
        }
        System.out.println(dp[N]);
        for(int i=0;i<list.get(N).size();i++){
            System.out.print(list.get(N).get(i)+" ");
        }
    }
}