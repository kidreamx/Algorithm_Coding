//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int T = sc.nextInt(); // 총 시간
//        int W = sc.nextInt(); // 최대 이동 횟수
//        int[] plums = new int[T + 1];
//
//        for (int i = 1; i <= T; i++) {
//            plums[i] = sc.nextInt(); // 자두가 떨어지는 위치 (1 또는 2)
//        }
//
//        // DP 배열 초기화
//        int[][] dp = new int[T + 1][W + 1];
//
//        // DP 계산
//        for (int t = 1; t <= T; t++) {
//            for (int w = 0; w <= W; w++) {
//                // 현재 위치에 자두가 떨어지는 경우 1을 더함
//                if (plums[t] == 1) {
//                    dp[t][w] = dp[t - 1][w] + (w % 2 == 0 ? 1 : 0);
//                } else {
//                    dp[t][w] = dp[t - 1][w] + (w % 2 == 1 ? 1 : 0);
//                }
//
//                // 이동할 수 있는 경우 (이동하지 않은 경우와 이동한 경우 중 최대값을 취함)
//                if (w > 0) {
//                    dp[t][w] = Math.max(dp[t][w], dp[t - 1][w - 1] + (plums[t] == (w % 2 + 1) ? 1 : 0));
//                }
//            }
//        }
//
//        // 결과 계산: T초 동안 W번 이동했을 때의 최대 자두 개수
//        int maxPlums = 0;
//        for (int w = 0; w <= W; w++) {
//            maxPlums = Math.max(maxPlums, dp[T][w]);
//        }
//
//        System.out.println(maxPlums);
//        sc.close();
//    }
//}

import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int T = Integer.parseInt(sa[0]);
        int W = Integer.parseInt(sa[1]);
        int[] arr = new int[T+1];
        int[][] dp = new int[T+1][W+1];
        for(int i=1;i<=T;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=1;i<=T;i++){
            for(int w=0;w<=W;w++){
                if(arr[i] == 1){
                    dp[i][w] = dp[i-1][w] + ((w % 2 == 0) ? 1 : 0);
                }
                else{
                    dp[i][w] = dp[i-1][w] + ((w % 2 == 1) ? 1: 0);
                }

                if(w>0){
                    dp[i][w] = Math.max(dp[i][w], dp[i-1][w-1] + (arr[i] == (w % 2 +1)?1:0));
                }
            }
        }
        int max=0;
        for(int i=0;i<=W;i++){
            max = Math.max(max,dp[T][i]);
        }
        System.out.println(max);
    }
}

