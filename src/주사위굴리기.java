import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 주사위굴리기 {
    static int[] dice = new int[7];
    static int N,M,x,y;
    static int[][] map;
    static int[] X = {1, -1, 0, 0};
    static int[] Y = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            int tmp = Integer.parseInt(st.nextToken());
            move(tmp);
        }
    }

    static void move(int d) {
        int tmpX = x + X[d-1];
        int tmpY = y + Y[d-1];
        if(tmpX >= 0 &&  tmpX <= M - 1 && tmpY >= 0 && tmpY <= N - 1) {
            roll(d, tmpX, tmpY);
            x = tmpX; y = tmpY;
        }
    }

    static void roll(int d, int x, int y) {
        int tmp = dice[3];
        switch(d) {
            case 1:
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 2:
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 3:
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[1];
                dice[1] = tmp;
                break;
            case 4:
                dice[3] = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;
        }
        if(map[y][x] == 0) {
            map[y][x] = dice[6];
        } else {
            dice[6] = map[y][x];
            map[y][x] =0;
        }
        System.out.println(dice[3]);
    }
}
