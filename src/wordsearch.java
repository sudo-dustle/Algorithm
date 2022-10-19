public class wordsearch {
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean answer = false;

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
//
//        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
//        String word = "AAB";
        System.out.println( exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        N = board.length;
        M = board[0].length;
        char[] chars = word.toCharArray();
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                char c = board[i][j];
                if(c == chars[0]) {
                    check(i, j, board, chars, 1, visited);
                    if(answer) {
                        answer = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static void check(int n, int m, char[][] board, char[] chars, int idx, boolean[][] visited) {
        if(idx == chars.length) {
            answer = true;
            //System.out.println("true 발사  " + idx);
            return;
        }
        visited[n][m] = true;
        for(int i = 0; i < 4; i++) {
            int tmpN = n + dx[i];
            int tmpM = m + dy[i];
            //System.out.println(tmpN + ", " + tmpM);
            if(tmpN < 0 || tmpN >= board.length || tmpM < 0 || tmpM >= board[0].length) continue;
            //System.out.println(chars[idx]);
            if(board[tmpN][tmpM] == chars[idx] && !visited[tmpN][tmpM]) {
                //System.out.println("일치함" + idx);
                check(tmpN, tmpM, board, chars, idx+1, visited);
            }
        }
        visited[n][m] = false;
    }
}
