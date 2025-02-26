import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N, M, R, line_count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String token[] = br.readLine().split(" ");
        N = Integer.parseInt(token[0]);   //vertical 크기
        M = Integer.parseInt(token[1]);   //horizontal 크기
        R = Integer.parseInt(token[2]);   //회전수
        line_count = Math.min(N, M) / 2;        //라인수
        int arr[][] = new int[N][M];

        for (int i = 0; i < N; i++) {           //배열 입력
            String token2[] = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token2[j]);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < line_count; j++) {
                int save = arr[j][j]; //시작값을 저장하고 시작위치가 0,0 ; 1,1 ; 2,2 지정
                // 한바퀴가 다 돌았으면 다시 line_count를 초기화 시켜줘야 한다
                // 1. 오른쪽상단 -> 왼쪽상단
                for (int k = j + 1; k < M - j; k++) {
                    arr[j][k - 1] = arr[j][k];
                }
                // 2. 오른쪽하단 -> 오른쪽상단
                for (int k = j + 1; k < N - j; k++) {
                    arr[k - 1][M - j - 1] = arr[k][M - j - 1];
                }
                // 3. 왼쪽하단 -> 오른쪽하단
                for (int k = M - 2 - j; k >= j; k--) {
                    arr[N - 1 - j][k + 1] = arr[N - 1 - j][k];
                }
                // 4. 왼쪽상단 -> 왼쪽하단
                for (int k = N - j - 2; k >= j; k--) {
                    arr[k + 1][j] = arr[k][j];
                }
                // 마무리 시작값을 끼어놓으면 한 라인 끝
                arr[j + 1][j] = save;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
                sb.append("\n");

        }
        System.out.print(sb);
    }
}