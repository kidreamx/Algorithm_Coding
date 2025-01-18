import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] arr ;
    static boolean[][] visited;
    static List<Integer>list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        sa = br.readLine().split(" ");
        arr = new int[N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(arr);
        dfs(0,0);
    }
    static void dfs(int depth, int start){
        if(depth == M){
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start;i<N;i++){
            list.add(arr[i]);
            dfs(depth+1,i);
            list.remove(list.size()-1);
        }

    }
}
