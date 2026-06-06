import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> list = new ArrayList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist,-1);
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edge.length;i++){
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        dist[1] = 0;
        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int next : list.get(num)){
                if(dist[next]==-1){
                    dist[next] = dist[num]+1;
                    queue.add(next);
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            max = Math.max(max, dist[i]);
        }
        for(int i=1;i<=n;i++){
            if(dist[i]==max) answer++;
        }
        return answer;
    }
}