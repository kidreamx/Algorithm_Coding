import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        int[] ans = new int[T];
        for(int t=0;t<T;t++){
            String[] sa = br.readLine().split(" ");
            int N = Integer.parseInt(sa[0]);
            int M = Integer.parseInt(sa[1]);
            int k = Integer.parseInt(sa[2]);
            int D = Integer.parseInt(sa[3]);
            int answer = 0;
            int start= 1;
            while(true){
                int result = (N-1)*M*start*M + (M-1)*M*k*start;
                if(result<=D){
                    answer = result;
                    start++;
                }
                else{
                    break;
                }
            }
            if(answer ==0){
                ans[t] = -1;
            }
            else {
                ans[t] = answer;
            }
        }
        for(int i=0;i<T;i++){
            System.out.println(ans[i]);
        }
    }
}