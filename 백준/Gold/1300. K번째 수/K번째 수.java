import java.util.*;
import java.io.*;

public class Main{
    static long K,N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        long lo = 0;
        long hi = N*N;
        while(lo+1<hi){
            long mid = (lo+hi)/2;
            if(check(mid)) hi = mid;
            else lo = mid;
        }
        System.out.println(hi);
    }
    static boolean check(long num){
        long cnt=0;
        for(int i=1;i<=N;i++){
            cnt+= Math.min(num/i,N);
        }
        return cnt>=K;
    }
}