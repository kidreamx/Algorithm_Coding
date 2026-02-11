import java.util.*;
class Solution {
    int[] parent;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[computers.length];
        for(int i=0;i<computers.length;i++){
            parent[i] = i;
        }
        for(int i=0;i<computers.length;i++){
            for(int j=0;j<computers.length;j++){
                if(i==j) continue;
                if(computers[i][j] == 1){
                    union(i,j);
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<parent.length;i++){
            System.out.println(i+"번째 수입니다 : "+find(parent[i]));
            set.add(find(parent[i]));
        }
        answer = set.size();
        return answer;
    }
    public int find(int x){
        if(parent[x] == x){
            return parent[x];
        }
        return parent[x] = find(parent[x]);
    }
    public void union(int x, int y){
        int X = find(x);
        int Y = find(y);
        if(X!=Y){
            parent[X] = Y;
        }
    }
}