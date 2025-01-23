import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int w = Integer.parseInt(sa[0]);
        int h = Integer.parseInt(sa[1]);

        sa = br.readLine().split(" ");
        int x = Integer.parseInt(sa[0]);
        int y = Integer.parseInt(sa[1]);

        int cnt = Integer.parseInt(br.readLine());

        // x와 y의 이동은 2w와 2h 주기로 반복됨
        int finalX = (x + cnt) % (2 * w);
        int finalY = (y + cnt) % (2 * h);

        // 주기를 벗어나는 경우 반대 방향으로 이동
        if (finalX > w) {
            finalX = 2 * w - finalX;
        }
        if (finalY > h) {
            finalY = 2 * h - finalY;
        }

        System.out.println(finalX + " " + finalY);
    }
}
