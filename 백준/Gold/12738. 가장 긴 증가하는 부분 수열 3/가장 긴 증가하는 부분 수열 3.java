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
        int[] dp = new int[N];
        int length =0;
        int[] parent= new int[N];
        Arrays.fill(parent,-1);
        for(int i=0;i<N;i++){
            int num = arr[i];
            int low = 0, high = length;
            while(low<high){
                int mid = (low+high)/2;
                if(arr[dp[mid]]<num){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }
            int pos = low;
            dp[pos] = i;
            if(pos>0){
                parent[pos] = dp[pos-1];
            }
            if(pos==length){
                length++;
            }
        }
        System.out.println(length);
    }
}