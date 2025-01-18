import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        int min = Integer.MAX_VALUE;
        int max = 0;
        int max_sum=0;
        sa = br.readLine().split(" ");
        int[] tree = new int[N];
        for(int i=0;i<N;i++){
            tree[i] = Integer.parseInt(sa[i]);
            if(tree[i]>max){
                max = tree[i];
            }

        }
        int start=0;
        int end = max;
        int result =0;
        while(start<=end){
            int mid = (start+end)/2;
            long sum=0;
            for(int j=0;j<N;j++){
                if(tree[j]-mid>=0){
                    sum += tree[j]-mid;
                }
            }
            if(M<=sum) {
                result = mid;
                start = mid + 1;
            }
                else{
                    end = mid-1;
                }

        }
        System.out.println(result);

    }
}