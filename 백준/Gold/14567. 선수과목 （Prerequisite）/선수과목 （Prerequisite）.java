import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        int[][] menu = new int[N+1][N+1];
        int[] menuCount = new int[N+1];
        int[] answer = new int[N+1];
        for(int i=0;i<M;i++){
            sa= br.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);
            menu[start][end] = 1;
            menuCount[end]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (menuCount[i] == 0) {
                queue.add(i);
            }
        }
        int time = 1;
        while(true) {
            int lesson = queue.size();
            if(lesson == 0){
                break;
            }
            while (lesson-- > 0) {
                int tmp = queue.poll();
                answer[tmp] = time;
                for (int i = 1; i <= N; i++) {
                    if (menu[tmp][i] == 1) {
                        menuCount[i]--;
                        if (menuCount[i] == 0) {
                            queue.add(i);
                        }
                    }
                }
            }
            time++;
        }
        for(int i=1;i<=N;i++){
            System.out.print(answer[i]+" ");
        }
    }
}