import java.util.*;
import java.io.*;

public class Main{
    static int[][] num;
    static int N,sample;
    static boolean[] mixed;
    static int[] out;
    static int max = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N][N];
        out = new int[5];
        String[] sa;
        for(int i=0;i<N;i++){
            sa = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                num[i][j] = Integer.parseInt(sa[j]);
            }
        }
        game(0);
        // 일단 한번 진행해서 잘 되는지 확인 하기 위한 코드 작성
        System.out.println(max);

    }
    static void game(int depth){
        if(depth == 5){
            int[][] arr = new int[N][N];
            for(int i=0;i<N;i++){
               arr[i] =  Arrays.copyOf(num[i],num[i].length);
            }
            for(int r = 0; r<5;r++) {
                sample = out[r];
                for (int i = 0; i < N; i++) {
                    mixed = new boolean[N];
                    int start;
                    if (sample == 0) {
                        start = N - 1;
                        while (start >= 0) {
                            if (start == N - 1) {
                                start--;
                                continue;
                            }
                            if (arr[i][start] == 0) {
                                start--;
                            } else { // 자연수인 경우
                                if (arr[i][start + 1] == 0) {
                                    int tmp;
                                    boolean mixed_tmp;
                                    tmp = arr[i][start];
                                    arr[i][start] = arr[i][start + 1];
                                    arr[i][start + 1] = tmp;
                                    mixed_tmp = mixed[start];
                                    mixed[start] = mixed[start + 1];
                                    mixed[start + 1] = mixed_tmp;
                                    start++;
                                } else {
                                    if (arr[i][start] == arr[i][start + 1]) {
                                        if (mixed[start] || mixed[start + 1]) {
                                            start--;
                                            continue;
                                        }
                                        arr[i][start + 1] = arr[i][start] + arr[i][start + 1];
                                        mixed[start + 1] = true;
                                        arr[i][start] = 0;
                                        start++;
                                    } else {
                                        start--;
                                    }
                                }
                            }
                        }
                    } else if (sample == 1) {
                        start = N - 1;
                        while (start >= 0) {
                            if (start == N - 1) {
                                start--;
                                continue;
                            }
                            if (arr[start][i] == 0) {
                                start--;
                            } else { // 자연수인 경우
                                if (arr[start + 1][i] == 0) {
                                    int tmp;
                                    boolean mixed_tmp;
                                    tmp = arr[start][i];
                                    arr[start][i] = arr[start + 1][i];
                                    arr[start + 1][i] = tmp;
                                    mixed_tmp = mixed[start];
                                    mixed[start] = mixed[start + 1];
                                    mixed[start + 1] = mixed_tmp;
                                    start++;
                                } else {
                                    if (arr[start][i] == arr[start + 1][i]) {
                                        if (mixed[start] || mixed[start + 1]) {
                                            start--;
                                            continue;
                                        }
                                        arr[start + 1][i] = arr[start + 1][i] + arr[start][i];
                                        mixed[start + 1] = true;
                                        arr[start][i] = 0;
                                        start++;
                                    } else {
                                        start--;
                                    }
                                }
                            }
                        }
                    } else if (sample == 2) {
                        start = 0;
                        while (start < N) {
                            if (start == 0) {
                                start++;
                                continue;
                            }
                            if (arr[i][start] == 0) {
                                start++;
                            } else { // 자연수인 경우
                                if (arr[i][start - 1] == 0) {
                                    int tmp;
                                    boolean mixed_tmp;
                                    tmp = arr[i][start];
                                    arr[i][start] = arr[i][start - 1];
                                    arr[i][start - 1] = tmp;
                                    mixed_tmp = mixed[start];
                                    mixed[start] = mixed[start - 1];
                                    mixed[start - 1] = mixed_tmp;
                                    start--;
                                } else {
                                    if (arr[i][start] == arr[i][start - 1]) {
                                        if (mixed[start] || mixed[start - 1]) {
                                            start++;
                                            continue;
                                        }
                                        arr[i][start - 1] = arr[i][start] + arr[i][start - 1];
                                        mixed[start - 1] = true;
                                        arr[i][start] = 0;
                                        start--;
                                    } else {
                                        start++;
                                    }
                                }
                            }
                        }
                    } else if (sample == 3) {
                        start = 0;
                        while (start < N) {
                            if (start == 0) {
                                start++;
                                continue;
                            }
                            if (arr[start][i] == 0) {
                                start++;
                            } else { // 자연수인 경우
                                if (arr[start - 1][i] == 0) {
                                    int tmp;
                                    boolean mixed_tmp;
                                    tmp = arr[start][i];
                                    arr[start][i] = arr[start - 1][i];
                                    arr[start - 1][i] = tmp;
                                    mixed_tmp = mixed[start];
                                    mixed[start] = mixed[start - 1];
                                    mixed[start - 1] = mixed_tmp;
                                    start--;
                                } else {
                                    if (arr[start][i] == arr[start - 1][i]) {
                                        if (mixed[start] || mixed[start - 1]) {
                                            start++;
                                            continue;
                                        }
                                        arr[start - 1][i] = arr[start - 1][i] + arr[start][i];
                                        mixed[start - 1] = true;
                                        arr[start][i] = 0;
                                        start--;
                                    } else {
                                        start++;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    max = Math.max(max,arr[i][j]);
                }
            }
            return;
        }
        for(int i=0;i<=3;i++){
            out[depth] = i;
            game(depth+1);
        }
    }
}