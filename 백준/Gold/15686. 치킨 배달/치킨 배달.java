import java.io.*;
import java.util.*;

public class Main{
    static int N,M;
    static int[][] arr;
    static boolean[] selected;
    static ArrayList<Point> person;
    static ArrayList<Point> chicken;
    static int ans;
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        person = new ArrayList<>();
        chicken = new ArrayList<>();
        arr = new int[N][N];
        ans = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            sa = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(sa[j]);
                if(arr[i][j]==1){
                    person.add(new Point(i,j));
                }
                else if(arr[i][j]==2){
                    chicken.add(new Point(i,j));
                }
            }
        }
        selected = new boolean[chicken.size()];
        dfs(0,0);
        bw.write(ans + "");
        bw.flush();
        bw.close();
    }
    public static void dfs(int start, int cnt){
        if(cnt == M){
            int res=0;
            for(int i=0;i<person.size();i++){
                int temp = Integer.MAX_VALUE;
                for(int j=0;j<chicken.size();j++){
                    if(selected[j]) {
                        int distance = Math.abs(person.get(i).x - chicken.get(j).x) + Math.abs(person.get(i).y - chicken.get(j).y);
                        temp = Math.min(temp, distance);
                    }
                }
                res+= temp;
            }
            ans = Math.min(res,ans);
            return;
        }
        for(int i=start;i<chicken.size();i++){
            selected[i] = true;
            dfs(i+1, cnt+1);
            selected[i] = false;
        }
    }
}