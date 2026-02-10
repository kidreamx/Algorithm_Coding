class Solution {
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        for(int i=0;i<dungeons.length;i++){
            boolean[] visited = new boolean[dungeons.length];
            visited[i] = true;
            dfs(k,i,1,visited,dungeons);
        }
        answer = max;
        return answer;
    }
    
    public void dfs(int bored,int index,int depth,boolean[] visited, int[][] dungeons){
        if(depth>dungeons.length){
            return;
        }
        int boredSum=bored;
        if(dungeons[index][0]<=bored){
            boredSum -= dungeons[index][1];
            max = Math.max(max,depth);
        }else{
            return;
        }
        for(int i=0;i<dungeons.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(boredSum,i,depth+1,visited,dungeons);
            visited[i] = false;
        }
    }
}