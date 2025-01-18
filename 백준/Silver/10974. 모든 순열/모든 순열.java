import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static boolean[] permutation;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        permutation = new boolean[N + 1];
        arr = new int[N];
        dfs( 0);
    }
    public static void dfs( int num){
        if(num==N){
            for(int i=0;i<N;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<N;i++){
            if(permutation[i]){
                continue;
            }
            arr[num] = i+1;
            permutation[i] = true;
            dfs( num+1);
            permutation[i] = false;
        }
    }
}