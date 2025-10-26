import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        // 1. 곡괭이 리스트부터 만든다.
        List<Integer> tools = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < picks[i]; j++) {
                tools.add(i);
            }
        }
        
        // 2. 캘 수 있는 최대 광물/묶음 수를 계산한다.
        int totalPicks = tools.size();
        if (totalPicks == 0) return 0; // 캘 곡괭이가 없으면 0 리턴

        int maxMinerals = totalPicks * 5;
        // 실제 캘 광물 수 (전체 광물 수와 최대 캘 수 있는 광물 수 중 작은 값)
        int effectiveMineralsLength = Math.min(minerals.length, maxMinerals);

        // 3. "캘 수 있는 묶음"의 개수를 계산한다.
        int size = 0;
        if (effectiveMineralsLength % 5 == 0) {
            size = effectiveMineralsLength / 5;
        } else {
            size = effectiveMineralsLength / 5 + 1;
        }
        
        if (size == 0) return 0; // 캘 광물이 없으면 0 리턴

        // 4. "캘 수 있는 묶음"만 rocks 배열에 추가한다.
        int[][] rocks = new int[size][2];
        int sum = 0;
        
        // for문이 'effectiveMineralsLength'까지만 돈다. (minerals.length 아님!)
        for (int i = 0; i < effectiveMineralsLength; i++) {
            if (minerals[i].equals("diamond")) {
                sum += 25;
            } else if (minerals[i].equals("iron")) {
                sum += 5;
            } else if (minerals[i].equals("stone")) {
                sum += 1;
            }
            
            // 묶음 저장
            if (i % 5 == 4 || i == effectiveMineralsLength - 1) {
                rocks[i / 5][0] = sum;
                rocks[i / 5][1] = i / 5;
                sum = 0;
            }
        }

        // 5. "캘 수 있는 묶음"들만 정렬한다.
        Arrays.sort(rocks, (a, b) -> b[0] - a[0]);

        // 6. 정렬된 묶음에 최고의 곡괭이부터 배정하여 피로도 계산 (이 부분은 기존 로직과 동일)
        int index = 0;
        for (int i = 0; i < size; i++) { // 어차피 size는 totalPicks보다 작거나 같음
            int bundleIndex = rocks[i][1];
            int startMineral = bundleIndex * 5;
            int endMineral = Math.min(startMineral + 5, effectiveMineralsLength); // minerals.length 대신 effectiveMineralsLength
            
            int tool = tools.get(index); // index는 0부터 시작하므로 최고의 곡괭이(dia)가 배정됨

            for (int j = startMineral; j < endMineral; j++) {
                if (tool == 0) { // 다이아
                    answer += 1;
                } else if (tool == 1) { // 철
                    answer += (minerals[j].equals("diamond") ? 5 : 1);
                } else { // 돌
                    if (minerals[j].equals("diamond")) {
                        answer += 25;
                    } else if (minerals[j].equals("iron")) {
                        answer += 5;
                    } else {
                        answer += 1;
                    }
                }
            }
            
            index++;
            // (index == tools.size() break는 사실상 필요 없어짐. 
            //  i < size 루프와 index < totalPicks는 같은 횟수만큼 돌기 때문)
        }
        return answer;
    }
}