import java.util.*;
import java.io.*;

public class Main{
    static int R,C;
    static int max=0;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static char[][] arr;
    static List<Character> list;
    static boolean[] alpha;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        R = Integer.parseInt(sa[0]);
        C = Integer.parseInt(sa[1]);
        arr= new char[R+1][C+1];
        alpha = new boolean[26];
        list = new ArrayList<>();
        for(int i=1;i<=R;i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=1;j<=C;j++){
                arr[i][j] = chars[j-1];
            }
        }
        alpha[arr[1][1]-'A'] = true;
        list.add(arr[1][1]);
        dfs(1,1);
        System.out.println(max);

    }
    static void dfs(int x, int y){
        for(int i=0;i<4;i++){
            int h_x = x+dx[i];
            int h_y = y+dy[i];
            if(h_x>=1 && h_x<=C && h_y>=1 && h_y<=R){
                if(!alpha[arr[h_y][h_x]-'A']){
                    alpha[arr[h_y][h_x]-'A'] = true;
                    list.add(arr[h_y][h_x]);
                    dfs(h_x,h_y);
                    list.remove(list.size()-1);
                    alpha[arr[h_y][h_x]-'A'] = false;

                }
            }
        }
        max = Math.max(max,list.size());
    }
}