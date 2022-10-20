import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 감시 {
    static int N;
    static int M;
    static int[][] arr;
    static CCTV[] cctvs = new CCTV[8];
    static int countOfCctv = 0;
    static int[] dx = {0, 1, 0, -1}; //우하좌상
    static int[] dy = {1, 0, -1, 0};

    static int min = Integer.MAX_VALUE;

    static int[][] camera = new int[][]
            {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 2, 0, 0},
                    {0, 3, 0, 0},
                    {0, 2, 3, 0},
                    {0, 1, 2, 3}
            };

    static int[] cameraLength = {0, 1, 2, 2, 3, 4};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
            }
        }

        // arr 전체를 순회하면서 cctv만 찾기
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (arr[i][j] > 0 && arr[i][j] < 6) { // cctv 인거임
                    cctvs[countOfCctv++] = new CCTV(i, j, arr[i][j]);
                }
            }
        }

        cctv(0);
        System.out.println(min);


    }

    // cctv들의 방향을 결정하기
    static void cctv(int depth) { // depth는 cctv 인덱스
        if (countOfCctv == depth) {
            // 기저조건 == 카메라 방향을 다 결정했다
            for (int i = 0; i < countOfCctv; i++) {
                int kind = cctvs[i].kind;

                // 카메라 종류와 카메라가 보는 방향에 맞게 채워주기(recursive)
                for (int j = 0; j < cameraLength[kind]; ++j) {
                    recursive(cctvs[i].i, cctvs[i].j, (camera[kind][j] + cctvs[i].dir) % 4, -1);
                }
            }

            min = Math.min(count(), min);

            for (int i = 0; i < countOfCctv; i++) {
                int kind = cctvs[i].kind;

                // 카메라 종류와 카메라가 보는 방향에 맞게 채워주기(recursive)
                for (int j = 0; j < cameraLength[kind]; ++j) {
                    recursive(cctvs[i].i, cctvs[i].j, (camera[kind][j] + cctvs[i].dir) % 4, 0);
                }
            }

            return;
        }
        for (int i = 0; i < 4; ++i) {
            cctvs[depth].dir = i;
            cctv(depth + 1);
        }
    }

    static int count() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }

    static void recursive(int x, int y, int direction, int fill) {
        int nx = x + dx[direction];
        int ny = y + dy[direction];

        if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
        if (arr[nx][ny] == 6) return;

        if (!(arr[nx][ny] > 0 && arr[nx][ny] < 6)) {
            arr[nx][ny] = fill;
        }
        recursive(nx, ny, direction, fill);
    }
}

class CCTV {
    int i;
    int j;
    int kind; //카메라 번호
    int dir; //카메라가 보는 방향

    public CCTV(int i, int j, int kind) {
        this.i = i;
        this.j = j;
        this.kind = kind;
    }
}
/*
좌표랑 카메라 번호 받아서 동서남북 정하기 재귀호출
재귀 돌려서 채우기

재귀(int 행, int 열, 어느방향보는지, int 채움)
if(벽이나 좌표끝에 닿으면) 종료
재귀(int 다음 행, int 다음 열, 방향, 채움)

return에 사각지대값 가져오기
min으로 답 내기
 */
