import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N];
        for(int i=0;i<N;i++){
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);
        int ans = 0;
        for(int i=0;i<N;i++){
            ans = Math.max(ans,rope[i]*(N-i));
        }
        System.out.println(ans);

    }
}