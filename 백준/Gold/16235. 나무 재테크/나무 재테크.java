import java.util.*;
import java.io.*;

public class Main{
    static class Tree implements Comparable<Tree>{
        int r, c, age;
        Tree(int r, int c, int age){
            this.r =r;
            this.c = c;
            this.age = age;
        }
        @Override
        public int compareTo(Tree o){
            if(this.r == o.r ){
                if(this.c==o.c){
                    return this.age-o.age;
                }else{
                    return this.c - o.c;
                }
            }else{
                return this.r - o.r;
            }
        }
    }
    static int N,M,K;
    static int[][] A;
    static int[][] grow;
    static int[][] deadAge;
    static int[] dx = {1,1,0,-1,-1,-1,0,1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static List<Integer>[][] liveTree;
    static List<Tree> deathTree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        while(K-->0){
            spring();
            summer();
            autumn();
            winter();
        }
        int result=0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                result+= liveTree[i][j].size();
            }
        }
        System.out.println(result);
    }
    static void input(BufferedReader br) throws IOException{
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        K = Integer.parseInt(sa[2]);
        A = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            sa = br.readLine().split(" ");
            for(int j=1;j<=N;j++){
                A[i][j] = Integer.parseInt(sa[j-1]);
            }
        }
        grow = new int[N+1][N+1];
        deadAge = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            Arrays.fill(grow[i],5);
        }
        liveTree = new ArrayList[N+1][N+1];
        deathTree = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                liveTree[i][j] = new ArrayList<>();
            }
        }
        for(int i=0;i<M;i++){
             sa = br.readLine().split(" ");
             int r = Integer.parseInt(sa[0]);
             int c = Integer.parseInt(sa[1]);
             int age = Integer.parseInt(sa[2]);
             liveTree[r][c].add(age);
        }

    }
    static void spring(){
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                deadAge[i][j] = 0;
                List<Integer> tree= new ArrayList<>();
                for(int age: liveTree[i][j]){
                    if(grow[i][j]>=age){
                        grow[i][j] -= age;
                        tree.add(age+1);
                    }else{
                        deadAge[i][j] += age/2;
                    }
                }
                liveTree[i][j] = tree;
            }
        }
//        List<Tree> nextLive = new ArrayList<>();
//        for (Tree t : liveTree) {
//            if (grow[t.r][t.c] >= t.age) {
//                grow[t.r][t.c] -= t.age;
//                t.age++;
//                nextLive.add(t);
//            } else {
//                deathTree.add(t);
//            }
//        }
//        liveTree = nextLive;
    }
    static void summer(){
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                grow[i][j] += deadAge[i][j];
            }
        }
    }
    static void autumn(){
        List<Integer>[][] babies = new ArrayList[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                babies[i][j] = new ArrayList<>();
            }
        }

// 2) 기존 나무 순회하며 번식 대상을 찾아 babies에 모으기
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                List<Integer> cell = liveTree[i][j];
                // indexed for-loop 사용 (for-each도 가능하지만, 여기서는 셀 순회만 하고 추가는 babies로)
                for(int idx=0, sz=cell.size(); idx<sz; idx++){
                    int age = cell.get(idx);
                    if(age % 5 == 0){
                        for(int k=0;k<8;k++){
                            int nr = i + dy[k];
                            int nc = j + dx[k];
                            if(nr>0 && nr<=N && nc>0 && nc<=N){
                                babies[nr][nc].add(1);
                            }
                        }
                    }
                }
            }
        }

// 3) 순회가 모두 끝난 뒤에, 각 칸에 babies를 앞쪽(젊은 나무 순서)에 추가
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(!babies[i][j].isEmpty()){
                    // addAll(index, Collection)으로 리스트 맨 앞에 한 번에 삽입
                    liveTree[i][j].addAll(0, babies[i][j]);
                }
            }
        }
    }
    static void winter(){
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                grow[i][j] += A[i][j];
                Collections.sort(liveTree[i][j]);
            }
        }

    }
}