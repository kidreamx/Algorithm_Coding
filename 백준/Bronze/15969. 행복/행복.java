import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] sa = br.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(sa[i]);
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        System.out.println(max-min);

    }
}