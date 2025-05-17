import java.util.*;
class Edge{
    int dot , len;
    Edge(int dot , int len){
        this.dot = dot;
        this.len = len;
    }
}
class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> list = new ArrayList<>();
        int len = edge.length;
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<len;i++){
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        int result=0;
        boolean[] visited = new boolean[n+1];
        Queue<Edge>queue = new ArrayDeque<>();
        queue.add(new Edge(1,0));
        int[] cnt = new int[n+1];
        while(!queue.isEmpty()){
            Edge e = queue.poll();
            if(visited[e.dot]) continue;
            visited[e.dot] = true;
            cnt[e.dot] = e.len;
            for(int i : list.get(e.dot)){
                if(visited[i]) continue;
                queue.add(new Edge(i,e.len+1));
            }
        }
        int max =0;
        for(int i=1;i<=n;i++){
            max = Math.max(cnt[i],max);
        }
        for(int i=1;i<=n;i++){
            if(max == cnt[i]){
                result++;
            }   
        }
        return result;
    }
    
}