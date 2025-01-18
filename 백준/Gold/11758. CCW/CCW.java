import java.io.*;

public class Main {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Point[] points = new Point[3];

        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            points[i] = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        int dx1 = points[1].x - points[0].x;
        int dy1 = points[1].y - points[0].y;
        int dx2 = points[2].x - points[0].x;
        int dy2 = points[2].y - points[0].y;

        int determinant = dx1 * dy2 - dy1 * dx2;

        if (determinant > 0) {
            System.out.println(1); 
        } else if (determinant < 0) {
            System.out.println(-1); 
        } else {
            System.out.println(0); 
        }
    }
}
