import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 숫자판점프 {
    public static Set<String> digitsSet = new HashSet<>();
    public static String[][] map = new String[5][5];
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0 , 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = st.nextToken();
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                recursive(i, j, "");
            }
        }
        System.out.println(digitsSet.size());
    }

    public static void recursive(int x, int y, String strings) {
        if(strings.length() >= 6) {
            digitsSet.add(strings);
            return;
        }

        strings += map[x][y];

        for(int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];

            if (tmpX < 0 || tmpX > 4 || tmpY < 0 || tmpY > 4) {
                continue;
            }

            recursive(tmpX, tmpY, strings);
        }
    }
}
