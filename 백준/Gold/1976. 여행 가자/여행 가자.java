import java.util.*;
import java.io.*;

public class Main{
    static int[] parent;
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i]= i;
        }
        for(int i=1;i<=N;i++){
            String[] sa = br.readLine().split(" ");
            for(int j=1;j<=N;j++) {
                if (Integer.parseInt(sa[j- 1]) == 1) {
                    union(i, j);
                }
            }
        }
        String[] sa = br.readLine().split(" ");
        int[] order = new int[M];
        for(int i=0;i<M;i++){
            order[i] = Integer.parseInt(sa[i]);
        }
        boolean isVisited=true;
        int test = find(order[0]);
        for(int i=1;i<M;i++){
            if(find(order[i])!=test){
                isVisited = false;
                break;
            }
        }
        if(!isVisited) System.out.println("NO");
        else System.out.println("YES");
    }
    static int find(int x){
        if(parent[x] == x){
            return parent[x];
        }
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y){
        int X = find(x);
        int Y = find(y);
        if(X!= Y){
            parent[X] = Y;
        }
    }
}