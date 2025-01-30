import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dice = new int[N][6];
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            for(int j=0;j<6;j++){
                dice[i][j] = Integer.parseInt(sa[j]);
            }
        }
        int[]max = new int[N];
        int max_sum = 0;
        for(int i=0;i<6;i++){
            boolean[] visited = new boolean[7];
            int down = dice[0][i];
            int top = find_pair(dice[0],i);
            visited[down] = true;
            visited[top] = true;
            max[0] =0;
            for(int j=1;j<=6;j++){
                if(!visited[j]) max[0] = Math.max(max[0],j);
            }
            for(int j=1;j<N;j++){
                visited = new boolean[7];
                down = top;
                for(int k=0;k<6;k++){
                    if(dice[j][k]==down){
                        top = find_pair(dice[j],k);
                    }
                }
                visited[down] = true;
                visited[top] = true;
                max[j] =0;
                for(int k=1;k<=6;k++){
                    if(!visited[k]) max[j] = Math.max(max[j],k);
                }
            }
            int sum = 0;
            for(int j=0;j<N;j++){
                sum+= max[j];
            }
            max_sum = Math.max(sum,max_sum);
        }
        System.out.println(max_sum);
    }
    static int find_pair(int[] dic, int index){
        if(index==0){
            return dic[5];
        }
        else if(index==1){
            return dic[3];
        }else if(index==2){
            return dic[4];
        }else if(index==3){
            return dic[1];
        }else if(index==4){
            return dic[2];
        }else {
            return dic[0];
        }

    }
}