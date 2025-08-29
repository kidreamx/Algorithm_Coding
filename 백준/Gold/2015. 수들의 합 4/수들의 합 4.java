import java.util.*;
import java.io.*;

public class Main{
    static int N,K;
    static long sum=0;
    static int[] prefixSum;
    static HashMap<Integer, Long> numCounts;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        calculate();
        System.out.println(sum);
    }
    static void init(BufferedReader br)throws IOException{
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);
        numCounts = new HashMap<>();
        prefixSum = new int[N+1];
        sa = br.readLine().split(" ");
        for(int i=1;i<=N;i++){
            prefixSum[i] = prefixSum[i-1]+Integer.parseInt(sa[i-1]);
        }
    }
    static void calculate(){
        for(int i=1;i<=N;i++){
            if(prefixSum[i] == K){
                sum++;
            }
            if(numCounts.containsKey(prefixSum[i]-K)){
                sum += numCounts.get(prefixSum[i]-K);
            }
            if(numCounts.containsKey(prefixSum[i])){
                numCounts.compute(prefixSum[i], (k, count) -> count + 1);
            }else{
                numCounts.put(prefixSum[i],1L);
            }
        }
    }

}