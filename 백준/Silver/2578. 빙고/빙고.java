import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[5][5];
        int[][] teacher = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String[] sa = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(sa[j]);
            }
        }
        boolean[][] bingo = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            String[] sa = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                teacher[i][j] = Integer.parseInt(sa[j]);
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // 숫자 체크
                for (int r = 0; r < 5; r++) {
                    for (int c = 0; c < 5; c++) {
                        if (teacher[i][j] == arr[r][c]) {
                            bingo[r][c] = true;
                        }
                    }
                }

                // 빙고 확인
                int count = 0;

                // 행/열 체크
                for (int r = 0; r < 5; r++) {
                    // 행 체크
                    if (bingo[r][0] && bingo[r][1] && bingo[r][2] && bingo[r][3] && bingo[r][4]) {
                        count++;
                    }
                    // 열 체크
                    if (bingo[0][r] && bingo[1][r] && bingo[2][r] && bingo[3][r] && bingo[4][r]) {
                        count++;
                    }
                }

                // 대각선 체크
                if (bingo[0][0] && bingo[1][1] && bingo[2][2] && bingo[3][3] && bingo[4][4]) {
                    count++;
                }
                if (bingo[0][4] && bingo[1][3] && bingo[2][2] && bingo[3][1] && bingo[4][0]) {
                    count++;
                }

                // 빙고 3개 이상이면 출력 후 종료
                if (count >= 3) {
                    System.out.println(i * 5 + (j + 1));
                    return;
                }
            }
        }

    }
}