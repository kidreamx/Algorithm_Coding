import java.util.*;
import java.io.*;

public class Main{
    static int[] water;
    static int N , a,b;
    static long maxSum;
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
        water = new int[N];
        String[] sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            water[i] = Integer.parseInt(sa[i]);
        }
        int lo = 0;
        int hi = N-1;
        long min = Long.MAX_VALUE;
        while (lo<hi){
            int sum = Math.abs(water[lo]+water[hi]);
            if(sum < min){
                min = sum;
                a = water[lo];
                b = water[hi];
            }
            if(water[lo]+water[hi]>=0){
                hi--;
            }else{
                lo++;
            }
        }
        System.out.println(a+" "+b);
    }
    
}