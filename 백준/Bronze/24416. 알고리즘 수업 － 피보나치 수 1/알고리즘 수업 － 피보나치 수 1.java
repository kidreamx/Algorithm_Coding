import java.util.*;
import java.io.*;

public class Main{
    static int count1=0;
    static int count2=0;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        fib(n);
        fibonacci(n);
        System.out.println(count1+" "+count2);
    }
    static int fib(int n){
        
        if(n == 1 || n == 2){
            count1++;
            return 1;
        }
        else return (fib(n-1)+ fib(n-2));
    }
    static int fibonacci(int n){
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<=n;i++){
            count2++;
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}