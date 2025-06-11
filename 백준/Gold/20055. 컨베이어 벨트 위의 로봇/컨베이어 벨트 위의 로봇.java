import java.util.*;
import java.io.*;

public class Main{
    static int N,K,cnt;
    static int[] conveyBelt;
    static boolean[] canMove;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);
        conveyBelt = new int[2*N];
        sa =  br.readLine().split(" ");
        for(int i=0;i<2*N;i++){
            conveyBelt[i] = Integer.parseInt(sa[i]);
        }
        canMove = new boolean[N];
        cnt=0;
        while(true){
            cnt++;
            spin();
            move();
            start();
            if(isEnd()){
                break;
            }
        }
        System.out.println(cnt);
    }
    // 1) 첫번째로 회전
    static void spin(){
        // conveyBelt 및 canMove 이동
        int tmp = conveyBelt[2*N-1];
        for(int i=2*N-1;i>=1;i--){
            conveyBelt[i] = conveyBelt[i-1];
            if(i<N){
                canMove[i] = canMove[i-1];
            }
        }
        conveyBelt[0] = tmp;
        canMove[0] = false;
        // 내리는 위치에 값이 있으면 내리기 , 내리는 위치 : N-1
        canMove[N-1] = false;

    }
    // 2) 이동 N-2부터 확인해서 이동시킨다. N-1은 항상 비어있기 때문이다.
    static void move(){
        for(int i=N-2;i>=0;i--){
            // 이동시에는 그 칸이 내구도 1 이상인지 그 칸에 로봇이 없는지
            if(canMove[i]) {
                if (conveyBelt[i + 1] >= 1 && !canMove[i + 1]) {
                    canMove[i + 1] = true;
                    conveyBelt[i + 1]--;
                    // 항상 N-1에 도달하면 그 즉시 내려야 하기 때문에 이동시에 신경써주어야한다.
                    if (i + 1 == N - 1) {
                        canMove[i + 1] = false;
                    }
                    canMove[i] = false;
                }
            }
        }
    }
    // 3) 올리는 위치에 로봇 올리기
    static void start(){
        if(conveyBelt[0]>0 && !canMove[0]){
            conveyBelt[0]--;
            canMove[0] = true;
        }
    }
    // 4) 종료되는지 체크
    static boolean isEnd(){
        int count=0;
        for(int i=0;i<2*N;i++){
            if(conveyBelt[i]==0){
                count++;
            }
        }
        if(count>=K){
            return true;
        }
        else{
            return false;
        }
    }
}