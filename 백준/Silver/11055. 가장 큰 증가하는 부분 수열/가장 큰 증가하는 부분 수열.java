import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        int[] sum = new int[N];
        for(int i=0;i<N;i++){
            sum[i] = arr[i];
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]) {
                    sum[i] = Math.max(sum[i],arr[i]+sum[j]);
                }
            }
        }
        int max=0;
        for(int i=0;i<N;i++){
            max = Math.max(sum[i],max);
        }
        System.out.println(max);
    }
}
