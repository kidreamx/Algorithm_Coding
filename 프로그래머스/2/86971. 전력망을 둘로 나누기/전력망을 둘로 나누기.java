import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=100;i++){
            list.add(new ArrayList<>());
        }
        // 초기화
        int max = 0;
        for(int i=0;i<wires.length;i++){
            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
            for(int j=0;j<2;j++) max = Math.max(max, wires[i][j]);
        }
        // 한 곳씩 제거하면서 크기 계산
        for(int i=0;i<wires.length;i++){
            int first = wires[i][0];
            int second = wires[i][1];
            boolean[] visited = new boolean[max+1];
            visited[second] = true;
            // bfs로 두번 탐색 후 결과 값 확인
            int firstScore = bfs(first,list,visited);
            visited = new boolean[max+1];
            visited[first] = true;
            int SecondScore = bfs(second,list,visited);
            min = Math.min(min,Math.abs(firstScore-SecondScore));
        }
        return min;
    }
    public int bfs(int start, List<List<Integer>> list, boolean[] visited){
        Queue<Integer> queue = new ArrayDeque<>();
        int cnt=0;
        queue.add(start);
        while(!queue.isEmpty()){
            int num = queue.poll();
            if(visited[num]) continue;
            visited[num] = true;
            cnt++;
            for(int n : list.get(num)){
                if(!visited[n]) queue.add(n);
            }
        }
        return cnt;
    }
}