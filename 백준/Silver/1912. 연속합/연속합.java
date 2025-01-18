import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] sa = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        int max = Integer.MIN_VALUE;
        int currentSum = 0;

        // 최대 부분합 구하기 (카데인 알고리즘)
        for (int i = 0; i < n; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            max = Math.max(max, currentSum);
        }

        System.out.println(max);
    }
}
