import java.util.*;
import java.io.*;

public class Main{
    static List<List<Integer>> list = new ArrayList<>();
    static int N,M,R;
    static boolean[] visited;
    static int[] cnt;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        N  = Integer.parseInt(sa[0]);
        M  = Integer.parseInt(sa[1]);
        R = Integer.parseInt(sa[2]);
        visited = new boolean[N+1];
        cnt = new int[N+1];
        count=1;
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i=1;i<=N;i++){
            Collections.sort(list.get(i));
        }
        cnt[R] = count++;
        dfs(R);
        for(int i=1;i<=N;i++){
            System.out.println(cnt[i]);
        }

    }
    static void dfs(int a){
        visited[a] = true;
        for(int  i : list.get(a)){
            if(visited[i]) continue;
            visited[i] = true;
            cnt[i] = count++;
            dfs(i);
        }
    }
}