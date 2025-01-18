import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Integer>[] list;
    static int N,M;
    static boolean[] visited;
    static boolean correct;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        list = new ArrayList[N];
        for(int i=0;i<N;i++){
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        correct = false;
        for(int i=0;i<M;i++){
            sa = br.readLine().split(" ");
            list[Integer.parseInt(sa[0])].add(Integer.parseInt(sa[1]));
            list[Integer.parseInt(sa[1])].add(Integer.parseInt(sa[0]));
        }
        for(int i=0;i<N;i++){
            visited = new boolean[N];
            if(!correct) dfs(i,0);
        }
        if(correct) bw.write(1+"");
        else bw.write(0+"");
        bw.flush();
        bw.close();
    }
    static void dfs(int i,  int depth){
        if(depth>=4){
            correct= true;
            return;
        }
        visited[i] = true; // for문 밖에서 true를 하면 다음 노드 이동시 전 노드로 다시 못오고 다 순회하면 다시 갈수 있게 설정
        for(int j : list[i]){
            if(visited[j]) continue;
            dfs(j,depth+1);
        }
        visited[i] = false; // for문 밖에 false로 설정함으로써 다른 노드 방문하고 그 노드 다시 방문할수 있게 설정해준다.
    }

}