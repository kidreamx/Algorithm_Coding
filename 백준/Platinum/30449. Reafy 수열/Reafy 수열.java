import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Fraction implements Comparable<Fraction> {
    int numerator;
    int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public int compareTo(Fraction other) {
        return Integer.compare(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    @Override
    public String toString() {
        return numerator + " " + denominator;
    }
}

public class Main {
    // 특정 번째 분수를 찾는 함수 (Farey 수열 재귀적 생성)
    public static void generateFarey(int a, int b, int c, int d, int maxDenominator, List<Fraction> fractions) {
        if (b + d > maxDenominator) return;

        generateFarey(a, b, a + c, b + d, maxDenominator, fractions);
        fractions.add(new Fraction(a + c, b + d));
        generateFarey(a + c, b + d, c, d, maxDenominator, fractions);
    }

    public static Fraction getNthFraction(int maxDenominator, int n) {
        List<Fraction> fractions = new ArrayList<>();

        // 기본 Farey 수열의 시작 (0/1, 1/1)
        fractions.add(new Fraction(0, 1));
        generateFarey(0, 1, 1, 1, maxDenominator, fractions);
        fractions.add(new Fraction(1, 1));

        if (n > 0 && n <= fractions.size()) {
            return fractions.get(n - 1);  // 0-index 조정
        } else {
            throw new IllegalArgumentException("잘못된 n 값입니다.");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int maxDenominator = Integer.parseInt(sa[0]);  // 최대 분모
        int n = Integer.parseInt(sa[1]);  // 찾고 싶은 순서

        // Farey 수열 생성 및 n번째 분수 찾기
        Fraction nthFraction = getNthFraction(maxDenominator, n);


        // 결과 출력
        System.out.println(nthFraction);
    }
}
