import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[][] paper;
    static int[] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        findAll(1,1,N);
        for(int i=0;i<3;i++){
            System.out.println(answer[i]);
        }
    }
    static void input(BufferedReader br)throws IOException{
        N = Integer.parseInt(br.readLine());
        paper = new int[N+1][N+1];
        answer = new int[3];
        for(int i=1;i<=N;i++){
            String[] sa = br.readLine().split(" ");
            for(int j=1;j<=N;j++){
                paper[i][j] = Integer.parseInt(sa[j-1]);
            }
        }
    }
    static void findAll(int x, int y, int size){
        if(size==1){
            answer[judge(x,y)]++;
            return;
        }
        boolean isPaper=true;
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(paper[y][x] != paper[i][j]){
                    isPaper=false;
                }
            }
        }
        if(!isPaper){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    findAll(x+(size/3)*(j),y+(size/3)*(i),size/3);
                }
            }
        }else{
            answer[judge(x,y)]++;
        }
    }
    static int judge(int x, int y){
        if(paper[y][x]==-1){
            return 0;
        }else if(paper[y][x]==0){
            return 1;
        }else{
            return 2;
        }
    }

}