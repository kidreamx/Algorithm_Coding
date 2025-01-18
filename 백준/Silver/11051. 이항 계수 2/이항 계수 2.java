import java.io.*;

public class Main {
    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        int T = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        long result = binomialCoefficient(T, K);
        bw.write(result + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    private static long binomialCoefficient(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;

        k = Math.min(k, n - k); // 대칭성을 이용한 최적화
        long numerator = 1;
        long denominator = 1;

        for (int i = 0; i < k; i++) {
            numerator = (numerator * (n - i)) % MOD;
            denominator = (denominator * (i + 1)) % MOD;
        }

        // 모듈러 역수를 구해서 나눗셈을 곱셈으로 변경
        return (numerator * modInverse(denominator, MOD)) % MOD;
    }

    private static long modInverse(long a, int mod) {
        return pow(a, mod - 2, mod);
    }

    private static long pow(long base, int exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}