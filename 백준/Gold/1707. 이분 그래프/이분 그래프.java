import java.util.*;
import java.io.*;

public class Main{
    static int[] circle;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<K;t++){
            String[] sa = br.readLine().split(" ");
            int V = Integer.parseInt(sa[0]);
            int E = Integer.parseInt(sa[1]);
            circle = new int[V+1];
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<=V;i++){
                list.add(new ArrayList<>());
            }
            for(int i=0;i<E;i++){
                sa = br.readLine().split(" ");
                int a = Integer.parseInt(sa[0]);
                int b = Integer.parseInt(sa[1]);
                list.get(a).add(b);
                list.get(b).add(a);
            }
            boolean result = false;
            for(int v=1;v<=V;v++){
                if(circle[v]==0){
                   result  = isDivided(v,list);
                }
                if(!result) break;
            }
            if(!result) sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.println(sb);
    }
    static boolean isDivided(int vertex,List<List<Integer>> list){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(vertex);
        circle[vertex] = 1;
        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int v : list.get(num)){
                if(circle[v] == circle[num]){
                    return false;
                }
                if(circle[v] == 0){
                    circle[v] = circle[num] * (-1);
                    queue.add(v);
                }
            }
        }

        return true;
    }
}