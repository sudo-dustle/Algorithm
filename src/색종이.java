import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이 {
    public static int N;
    public static int white = 0;
    public static int blue = 0;
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0, N, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void recursive(int startX, int startY, int endX, int endY) {
        if(isSameColor(startX, startY, endX, endY)) {
            if(map[startX][startY] == 0) {
                white++;
            }
            else {
                blue++;
            }
        }
        else {
            int tmp = (endX - startX)/2;
            recursive(startX, startY, startX + tmp, startY + tmp);//1
            recursive(startX + tmp, startY, endX, startY + tmp);//2
            recursive(startX, startY + tmp, startX + tmp, endY);//3
            recursive(startX + tmp, startY + tmp, endX, endY);//4
        }
    }

    public static boolean isSameColor(int startX, int startY, int endX, int endY) {
        int init = map[startX][startY];

        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if (map[i][j] != init) {
                    return false;
                }
            }
        }

        return true;
    }
}
