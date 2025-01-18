import java.io.*;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.*;
class Point{
    int x;
    int y;
    int z;
    Point(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        int[] dx = new int[]{1,  0, -1, 0};
        int[] dy = new int[]{0, -1,  0, 1};
        int days=1;
        int M = Integer.parseInt(sa[0]);
        int N = Integer.parseInt(sa[1]);
        int H = Integer.parseInt(sa[2]);
        int[][][] arr = new int[H][N][M];
        int remain = 0;
        int num_1=0;
        int num_before=0;
        Queue<Point> queue = new LinkedList<>();
        // 데이터 입력
        for(int i=0; i<H;i++){
            for(int j=0; j<N;j++){
                sa = br.readLine().split(" ");
                for(int k = 0; k < M; k++){
                    arr[i][j][k] = Integer.parseInt(sa[k]);
                    if(arr[i][j][k] == 1){
                        queue.add(new Point(k,j,i));
                        num_1++;
                    }
                    else if(arr[i][j][k]==0){
                        remain++;
                    }
                }
            }
        }
        if(remain ==0){
            days = 0;
        }
        else {
            // 구현
            while (!queue.isEmpty()) {
                num_1--;
                Point p = queue.poll();
                if (p.x + dx[0] < M) {
                    if (arr[p.z][p.y][p.x + dx[0]] != -1) {
                        if (arr[p.z][p.y][p.x + dx[0]] == 0) {
                            remain--;
                            arr[p.z][p.y][p.x + dx[0]] = 1;
                            queue.add(new Point(p.x + dx[0], p.y, p.z));
                            num_before++;
                        }

                    }
                }
                if (p.x + dx[2] >= 0) {
                    if (arr[p.z][p.y][p.x + dx[2]] != -1) {
                        if (arr[p.z][p.y][p.x + dx[2]] == 0) {
                            remain--;
                            arr[p.z][p.y][p.x + dx[2]] = 1;
                            queue.add(new Point(p.x + dx[2], p.y, p.z));
                            num_before++;
                        }

                    }
                }
                if (p.y + dx[0] < N) {
                    if (arr[p.z][p.y + dx[0]][p.x] != -1) {
                        if (arr[p.z][p.y + dx[0]][p.x] == 0) {
                            remain--;
                            arr[p.z][p.y + dx[0]][p.x] = 1;
                            queue.add(new Point(p.x, p.y + dx[0], p.z));
                            num_before++;
                        }

                    }
                }
                if (p.y + dx[2] >= 0) {
                    if (arr[p.z][p.y + dx[2]][p.x] != -1) {
                        if (arr[p.z][p.y + dx[2]][p.x] == 0) {
                            remain--;
                            arr[p.z][p.y + dx[2]][p.x] = 1;
                            queue.add(new Point(p.x, p.y + dx[2], p.z));
                            num_before++;
                        }

                    }
                }
                if (p.z + dx[0] < H) {
                    if (arr[p.z + dx[0]][p.y][p.x] != -1) {
                        if (arr[p.z + dx[0]][p.y][p.x] == 0) {
                            remain--;
                            arr[p.z + dx[0]][p.y][p.x] = 1;
                            queue.add(new Point(p.x , p.y, p.z+dx[0]));
                            num_before++;
                        }

                    }
                }
                if (p.z + dx[2] >= 0) {
                    if (arr[p.z + dx[2]][p.y][p.x] != -1) {
                        if (arr[p.z + dx[2]][p.y][p.x] == 0) {
                            remain--;
                            arr[p.z + dx[2]][p.y][p.x] = 1;
                            queue.add(new Point(p.x , p.y, p.z+dx[2]));
                            num_before++;
                        }

                    }
                }
                // 하루가 지난 경우 채킹해야될 조건문
                if(num_1==0){
                    if(remain==0){
                        break;
                    }
                    else{
                        days++;
                        num_1 = num_before;
                        num_before=0;
                    }
                }
            }
            if(remain>0){
                days = -1;
            }
        }

        bw.write(days+"");
        bw.flush();
        bw.close();
    }


}
