import java.io.*;
import java.util.*;
class Point{
    int x;
    int y;
    int count=0;
    Point(){}
    Point(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        int L = Integer.parseInt(sa[0]);
        int R = Integer.parseInt(sa[1]);
        char[][] chars = new char[L+1][R+1];
        Boolean[][] visited = new Boolean[L+1][R+1]; // 길 탐색 할때
        Boolean[][] checked = new Boolean[L+1][R+1]; // 브루트포스 할때
        for(Boolean[] a : checked){
            Arrays.fill(a, Boolean.FALSE);
        }
        int max= 0;
        for(int i=1;i<=L;i++){
            String line = br.readLine();
            for(int j=1;j<=R;j++){
                chars[i][j] = line.charAt(j-1);
            }
        }
        for(int i=1;i<=L;i++){
            for(int j=1;j<=R;j++){
                if(chars[i][j] == 'L' && !checked[i][j]){
                    int cnt=0;
                    checked[i][j] = true;
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(j, i,cnt));
                    for(Boolean[] a : visited){
                        Arrays.fill(a, Boolean.FALSE);
                    }
                    while(!queue.isEmpty()){
                        Point point = queue.poll();
                        if(visited[point.y][point.x]){
                            continue;
                        }
                        else{
                            visited[point.y][point.x] = true;
                            if(point.y-1>0 && chars[point.y-1][point.x] == 'L' ){
                                queue.add(new Point(point.x, point.y-1,point.count+1));
                            }
                            if(point.y+1<=L && chars[point.y+1][point.x] == 'L' ){
                                queue.add(new Point(point.x, point.y+1,point.count+1));
                            }
                            if(point.x-1>0 && chars[point.y][point.x-1] == 'L' ){
                                queue.add(new Point(point.x-1, point.y,point.count+1));
                            }
                            if(point.x+1<=R && chars[point.y][point.x+1] == 'L' ){
                                queue.add(new Point(point.x+1, point.y,point.count+1));
                            }
                        }
                        if(point.count>max){
                            max = point.count;
                        }
                    }


                }
            }
        }
        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }
}