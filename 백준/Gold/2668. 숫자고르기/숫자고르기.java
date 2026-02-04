import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[] arr;
    static boolean[] can;
    static int max;
    static List<Integer> ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        can = new boolean[N+1];
        ans = new ArrayList<>();
        max= 0;
        for(int i=1;i<=N;i++){
            if(can[i]) continue;
            can[i] = true;
            dfs(new boolean[N+1],i);
        }
        System.out.println(ans.size());
        Collections.sort(ans);
        for(int i : ans){
            System.out.println(i);
        }
    }
    static void dfs(boolean[] visited , int index){
        if(visited[index]) {
            boolean[] cnt = new boolean[N+1];
            for(int i=1;i<=N;i++){
                if(visited[i]){
                    cnt[arr[i]] = true;
                }
            }
            boolean canMake = true;
            int count=0;
            List<Integer> list = new ArrayList<>();
            for(int i=1;i<=N;i++){
                if(visited[i]){
                    if(!cnt[i]){
                        canMake = false;
                    }else{
                        count++;
                        list.add(i);
                    }
                }else {
                    if(cnt[i]){
                        canMake = false;
                    }
                }
            }
            if(canMake){
                for(int i : list){
                    can[i] = true;
                    ans.add(i);
                }
            }
            return;
        }
        visited[index] = true;
        dfs(visited, arr[index]);
    }

}