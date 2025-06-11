import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }
        boolean[] visited= new boolean[N+1];
        for(int i=0;i<N-1;i++){
            String[] sa  = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }
        Queue<Integer>queue =new ArrayDeque<>();
        queue.add(1);
        int[] parents = new int[N+1];
        while(!queue.isEmpty()){
            int n = queue.poll();
            if(visited[n]) continue;
            visited[n] = true;
            for(int i : list.get(n)){
                if(visited[i]) continue;
                parents[i] = n;
                queue.add(i);
            }
        }
        for(int i=2;i<=N;i++){
            System.out.println(parents[i]);
        }

    }
}