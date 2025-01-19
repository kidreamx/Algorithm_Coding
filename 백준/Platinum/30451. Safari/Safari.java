import java.io.*;
import java.util.*;

public class Main {
    
    static class Animal implements Comparable<Animal> {
        int start, end, index;
        
        Animal(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
        
        @Override
        public int compareTo(Animal other) {
            return this.end - other.end;
        }
    }
    
    static class Place {
        int x, y;
        
        Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int N;
    static List<Animal> animals = new ArrayList<>();
    static List<Place> places = new ArrayList<>();
    static int[] cache;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        cache = new int[N + 1];
        Arrays.fill(cache, -1);
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            places.add(new Place(x, y));
        }
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            animals.add(new Animal(start, end, i));
        }
        
        Collections.sort(animals);
        
        System.out.println(solve(-1));
    }
    
    static int solve(int index) {
        if (index == N - 1) return 0; 
        
        if (cache[index + 1] != -1) return cache[index + 1];
        
        int ret = 0;
        int curStart = 0, curEnd = 0, curX = 0, curY = 0;
        
        if (index != -1) {
            curStart = animals.get(index).start;
            curEnd = animals.get(index).end;
            curX = places.get(animals.get(index).index).x;
            curY = places.get(animals.get(index).index).y;
        }
        
        for (int i = index + 1; i < N; i++) {
            int nextStart = animals.get(i).start;
            int nextEnd = animals.get(i).end;
            int nextX = places.get(animals.get(i).index).x;
            int nextY = places.get(animals.get(i).index).y;
            
            int moveTime = Math.abs(curX - nextX) + Math.abs(curY - nextY);
            
            if (moveTime + curEnd >= nextEnd) continue; // Skip if we can't reach in time
            
            if (curEnd + moveTime < nextStart) {
                ret = Math.max(nextEnd - nextStart + solve(i), ret);
            } else {
                ret = Math.max(nextEnd - (moveTime + curEnd) + solve(i), ret);
            }
        }
        
        return cache[index + 1] = ret;
    }
}
