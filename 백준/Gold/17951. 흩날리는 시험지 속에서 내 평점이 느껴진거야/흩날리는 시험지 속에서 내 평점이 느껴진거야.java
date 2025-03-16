import java.util.*;
import java.io.*;

public class Main{
    static int N,K;
    static int[] paper;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);
        sa = br.readLine().split(" ");
        paper = new int[N];
        int allsum = 0;
        for(int i=0;i<N;i++){
            paper[i] = Integer.parseInt(sa[i]);
            allsum += paper[i];
        }
        int lo= 0;
        int hi = allsum+1;
        while(lo+1<hi){
            int mid = (lo+hi)/2;
            if(paperCount(mid)) lo = mid;
            else hi = mid;
        }
        System.out.println(lo);

    }
    static boolean paperCount(int Score){
        int count=0;
        int sum=0;
        for(int i=0;i<N;i++){
            sum+= paper[i];
            if(sum>=Score){
                count++;
                sum=0;
            }
        }
        return count>=K;
    }
}