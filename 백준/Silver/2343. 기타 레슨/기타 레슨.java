import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);
        
        int[] lessons = new int[N];
        tokens = br.readLine().split(" ");
        long sum = 0;
        int maxLesson = 0;
        for (int i = 0; i < N; i++) {
            lessons[i] = Integer.parseInt(tokens[i]);
            sum += lessons[i];
            maxLesson = Math.max(maxLesson, lessons[i]);
        }
        
        long lo = maxLesson;  // 최소 Blu-ray 용량은 강의들 중 최대 길이
        long hi = sum;        // 최대 Blu-ray 용량은 모든 강의를 하나로 합친 경우
        long answer = hi;
        
        while(lo <= hi) {
            long mid = (lo + hi) / 2;
            if (isValid(lessons, mid, M)) { // candidate 용량이 유효하면
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        System.out.println(answer);
    }
    
    // candidate 용량(capacity)으로 강의들을 M개 이하의 Blu-ray로 나눌 수 있는지 체크
    static boolean isValid(int[] lessons, long capacity, int M) {
        int count = 1;
        long sum = 0;
        for (int lesson : lessons) {
            if (sum + lesson > capacity) { // 현재 그룹에 강의를 추가하면 용량 초과 → 새로운 Blu-ray 시작
                count++;
                sum = lesson;
            } else {
                sum += lesson;
            }
        }
        return count <= M;
    }
}
