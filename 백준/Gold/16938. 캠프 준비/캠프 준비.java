import java.util.*;
import java.io.*;

public class Main{
    static int N,L,R,X;
    static int[] arr;
    static boolean[] visited;
    static int cnt=0;
    static List<Integer>list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        L = Integer.parseInt(sa[1]);
        R = Integer.parseInt(sa[2]);
        X = Integer.parseInt(sa[3]);
        arr = new int[N];
        visited = new boolean[N];
        sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        for(int i=2;i<=N;i++){
            dfs(0,i,0);
        }
        System.out.println(cnt);
    }
    static void dfs(int depth, int limit, int start){
        if(depth==limit){
            int sum=0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i=0;i<list.size();i++){
                sum+= list.get(i);
                max = Math.max(max,list.get(i));
                min = Math.min(min,list.get(i));
            }
            if(sum>=L && sum<=R){
                if(max-min>=X){
                    cnt++;
                }
            }
        }
        for(int i=start;i<N;i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            list.add(arr[i]);
            dfs(depth+1,limit, i+1);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}