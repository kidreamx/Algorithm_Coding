import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 입력이 "0"이면 바로 출력
        if(s.equals("0")) {
            System.out.println("0");
            return;
        }

        StringBuilder sb = new StringBuilder();

        // 첫 자리: 앞에 불필요한 0 없이 2진수로 변환
        int firstDigit = s.charAt(0) - '0';
        sb.append(Integer.toBinaryString(firstDigit));

        // 나머지 자리: 각 자릿수를 3자리 2진수 문자열로 변환 (앞에 0 채우기)
        for (int i = 1; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            // %3s를 이용해 오른쪽 정렬 후 공백을 0으로 치환하여 3자리 문자열을 얻음
            sb.append(String.format("%3s", Integer.toBinaryString(digit)).replace(' ', '0'));
        }

        System.out.println(sb.toString());
    }
}
