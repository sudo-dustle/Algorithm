import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사과빨리먹기 {
    public static int[][] map = new int[5][5];
    public static Boolean[][] visited = new Boolean[5][5];
    public static int X;
    public static int Y;
    public static int[] dx = {1, -1, 0, 0};//오왼위아래
    public static int[] dy = {0, 0, 1, -1};
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        recursive(0, X, Y, 0);

        if(answer != Integer.MAX_VALUE) {
            System.out.println(answer);
        }
        else {
            System.out.println("-1");
        }

    }

    public static void recursive(int appleNum, int x, int y, int count) {
        if(map[x][y] == 1) {
            appleNum++;
        }

        if (appleNum == 3) {
            answer = Math.min(count, answer);
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];

            if (tmpX < 0 || tmpX > 4 || tmpY < 0 || tmpY > 4) {
                continue;
            }

            if (!visited[tmpX][tmpY] && map[tmpX][tmpY] != -1) {
                recursive(appleNum, tmpX, tmpY, count + 1);
            }
        }

        visited[x][y] = false;
    }
}
