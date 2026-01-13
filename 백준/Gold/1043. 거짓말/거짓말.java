import java.util.*;
import java.io.*;

public class Main{
    static int N,M,knowNum;
    static List<Integer> know;
    static List<List<Integer>> party, room;
    static boolean[] canTell;
    static boolean[] visited;
    static boolean[] find;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        sa = br.readLine().split(" ");
        party = new ArrayList<>();
        know = new ArrayList<>();
        room = new ArrayList<>();
        knowNum = Integer.parseInt(sa[0]);
        for(int i=0;i<knowNum;i++){
            know.add(Integer.parseInt(sa[i+1]));
        }
        for(int i=0;i<=N;i++){
            party.add(new ArrayList<>());
        }
        for(int i=0;i<=M;i++){
            room.add(new ArrayList<>());
        }
        canTell = new boolean[M+1];
        visited = new boolean[M+1];
        find = new boolean[N+1];
        for(int i=1;i<=M;i++){
            sa = br.readLine().split(" ");
            int size = Integer.parseInt(sa[0]);
            for(int j=1;j<=size;j++){
                party.get(Integer.parseInt(sa[j])).add(i);
                room.get(i).add(Integer.parseInt(sa[j]));
            }
        }
        for(int i=0;i<know.size();i++){
            int target = know.get(i);
            dfs2(target);
        }
        int cnt=0;
        for(int i=1;i<=M;i++){
            if(!canTell[i]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static void dfs(int depth){
        if(visited[depth]){
            return;
        }
        visited[depth] = true;
        for(int num : room.get(depth)){
            if(find[num]) continue;
            dfs2(num);
        }
    }
    public static void dfs2(int person){
        if(find[person]) return;
        find[person] = true;
        for(int num : party.get(person)){
            if(canTell[num]) continue;
            canTell[num] = true;
            dfs(num);
        }
    }
}