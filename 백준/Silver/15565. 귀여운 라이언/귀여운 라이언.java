import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        int[] arr = new int[N];
        int cnt=0;
        sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(sa[i]);
            if(arr[i]==1){
                cnt++;
            }
        }
        int[] numFirst = new int[cnt];
        int index=0;
        for(int i=0;i<N;i++){
            if(arr[i]==1){
                numFirst[index++]= i;
            }
        }
        int end = K-1;
        int start = 0;
        int min = Integer.MAX_VALUE;
        while(end<cnt){
            min = Math.min(min,numFirst[end]-numFirst[start]+1);
            end++;
            start++;
        }
        if(min==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);

    }
}