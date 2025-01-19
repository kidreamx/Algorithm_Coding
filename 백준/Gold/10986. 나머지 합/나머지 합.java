import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        int[] arr = new int[N];
        long[] percent = new long[M];
        long[] prefix_sum = new long[N];
        sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(sa[i]);
            if(i==0){
                prefix_sum[i] = arr[i];
            }
            else{
                prefix_sum[i] = prefix_sum[i-1]+arr[i];
            }
            long modValue = (prefix_sum[i] % M + M) % M;
            percent[(int)modValue]++;
        }
        long sum= percent[0];
        for(int i=0;i<M;i++){
            if(percent[i]>1) {
                sum += percent[i] * (percent[i] - 1) / 2;
            }
        }
        System.out.println(sum);
    }
}