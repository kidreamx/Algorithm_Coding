import java.util.*;
import java.io.*;

public class Main{
    static class Sentence{
        Pos p;
        String s;
        Sentence(Pos p , String s){
            this.p = p;
            this.s = s;
        }
    }
    static class Pos{
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N,M,K;
    static char[][] chars;
    static String[] want;
    static Queue<Sentence> queue;
    static int[] result;
    static int[][][] dp;
    static int[] dx ={1,1,0,-1,-1,-1,0,1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        for(int t=0;t<K;t++){
            queue = new ArrayDeque<>();
            dp = new int[N+1][M+1][want[t].length()];
            for(int i = 1; i<=N;i++){
                for(int j=1;j<=M;j++){
                    Arrays.fill(dp[i][j],-1);
                }
            }
            char first = want[t].charAt(0);
            for(int i = 1 ; i<=N;i++){
                for(int  j = 1 ; j <= M; j++){
                    if (chars[i][j] == first) {
                        result[t] += find(j, i, t, 0);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.print(sb);

    }
    static void input(BufferedReader br) throws IOException{
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        K = Integer.parseInt(sa[2]);
        want = new String[K];
        result = new int[K];
        chars = new char[N+1][M+1];

        for(int i=1;i<=N;i++){
            char[] input = br.readLine().toCharArray();
            for(int j=1;j<=M;j++){
                chars[i][j] = input[j-1];
            }
        }
        for(int i=0;i<K;i++){
            want[i] = br.readLine();
        }
    }
    static int find(int x, int y , int seq, int depth){
        int L = want[seq].length();
        if (depth == L - 1) {
            return dp[y][x][depth] = 1;
        }
        if (dp[y][x][depth] != -1) {
            return dp[y][x][depth];
        }
        int count=0;
        char nextChar = want[seq].charAt(depth+1);
        for(int i=0;i<8;i++){
            int nx = wrap(x+dx[i],M), ny = wrap(y+dy[i],N);
            if(chars[ny][nx] == nextChar){
                count += find(nx,ny,seq,depth+1);
            }
        }
        return dp[y][x][depth] = count;
    }
    static int wrap(int v, int max){
        if(v<1) return max;
        if(v>max) return 1;
        return v;
    }

}