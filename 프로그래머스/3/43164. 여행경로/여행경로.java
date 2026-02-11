import java.util.*;
class Solution {
    String[][] tickets;
    boolean[] visited;
    String[] answer;
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.visited = new boolean[tickets.length];
        Arrays.sort(tickets,new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                return o1[1].compareTo(o2[1]);
            }
        });
        List<String> ans = new ArrayList<>();
        ans.add("ICN");
        dfs("ICN",ans);
        return answer;
    }
    public void dfs(String from , List<String> ans){
        if(answer != null) return;
        
        if(ans.size() == tickets.length+1){
            answer = ans.toArray(String[]::new);
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(visited[i] || !tickets[i][0].equals(from)) continue;
            visited[i] = true;
            ans.add(tickets[i][1]);
            dfs(tickets[i][1], ans);
            visited[i] = false;
            ans.remove(ans.size()-1);
        }
    }
}