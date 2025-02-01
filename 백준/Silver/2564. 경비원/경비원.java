import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int vertical , horizontal;
    static int[][] shop;
    static int[] person = new int[2];
    static int result=0;
    static int N ;
    public static void main(String[] args) throws IOException{
        init();
        init_person_pos();
        calculate_distance();
    }
    static void init() throws IOException{
        String[] input = br.readLine().split(" ");
        vertical = Integer.parseInt(input[0]);
        horizontal = Integer.parseInt(input[1]);
        N = Integer.parseInt(br.readLine());
        shop = new int[N][2];
        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            int way = Integer.parseInt(input[0]);
            int distance = Integer.parseInt(input[1]);
            if(way==1){
                shop[i][0] =  distance;
                shop[i][1] =  horizontal;
            }else if(way==2){
                shop[i][0] = distance;
                shop[i][1] = 0;
            }else if(way==3){
                shop[i][0] = 0;
                shop[i][1] = horizontal-distance;
            }else{
                shop[i][0] = vertical;
                shop[i][1] = horizontal - distance;
            }
        }


    }
    static void init_person_pos() throws IOException{
        String[] input = br.readLine().split(" ");
        int way = Integer.parseInt(input[0]);
        int distance = Integer.parseInt(input[1]);
        if(way==1){
            person[0] =  distance;
            person[1] =  horizontal;
        }else if(way==2){
            person[0] = distance;
            person[1] = 0;
        }else if(way==3){
            person[0] = 0;
            person[1] = horizontal-distance;
        }else{
            person[0] = vertical;
            person[1] = horizontal - distance;
        }
    }
    static void calculate_distance(){
        for(int i=0;i<N;i++){
            int min = Integer.MAX_VALUE;
            // 서쪽 동쪽 벽에 있을때
            if((shop[i][1]==0 && person[1]==horizontal) ||(shop[i][1]==horizontal && person[1]==0)){
                min = Math.min(min, shop[i][0] + shop[i][1] + person[0]+person[1]);
                min = Math.min(min, shop[i][1]+person[1]+(vertical-shop[i][0])+(vertical-person[0]));

            }
            else if((shop[i][0]==0 && person[0]==vertical) || (shop[i][0]==vertical && person[0]==0)){
                min= Math.min(min ,shop[i][0] + shop[i][1] + person[0]+person[1]);
                min = Math.min(min, shop[i][0]+person[0]+(horizontal-shop[i][1])+(horizontal-person[1]));
            }
            else {
                min =Math.min(min,Math.abs(shop[i][0] - person[0]) + Math.abs(shop[i][1] - person[1]));
            }
            result+=min;
        }
        System.out.println(result);
    }
}