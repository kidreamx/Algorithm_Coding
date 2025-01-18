import java.util.*;
import java.io.*;

public class Main{
    static int N,M,index;
    static int[] arr;
    static int[] out;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        boolean[] num = new boolean[10001];
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        index=0;
        int max=0;
        sa =  br.readLine().split(" ");
        for(int i=0;i<N;i++){
            int tmp_num = Integer.parseInt(sa[i]);
            if(num[tmp_num]){
                continue;
            }
            index++;
            num[tmp_num] = true;
            max = Math.max(tmp_num,max);
        }
        arr = new int[index];
        int count=0;
        for(int i=1;i<=max;i++){
            if(num[i]){
                arr[count++] = i;
            }
        }
        Arrays.sort(arr);
        out = new int[M]; //+1을 해주는 이유는 index는 마지막 원소가 담긴 index를 의미하기때문에 실제로 사이즈 값보다 -1이 된 값이니 +1을 해주는 것이다.
        dfs(0,0);
    }
    static void dfs(int depth, int start){
        if(depth == M){
            for(int i=0;i<out.length;i++){
                System.out.print(out[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start;i<index;i++){
            out[depth] = arr[i];
            dfs(depth+1,i);
        }
    }
}