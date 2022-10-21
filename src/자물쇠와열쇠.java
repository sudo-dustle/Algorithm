
class 자물쇠와열쇠 {
    public static void main(String[] args) {
        int[][] key = {
                        {0,0,0},
                        {1,0,0},
                        {0,1,1}
                        };

        int[][] lock = {
                            {1,1,1},
                            {1,1,0},
                            {1,0,1}
                        };

        System.out.println(solution(key, lock));
    }
    //11시 45분
    public static boolean solution(int[][] key, int[][] lock) {
        int idx = lock.length + (key.length * 2) - 2;
        int[][] map = new int[idx][idx];

        for(int i = 0; i < lock.length; i++) {
            for(int j = 0; j < lock.length; j++) {
                map[key.length - 1 + i][key.length - 1 + j] = lock[i][j];
            }
        }

        for(int rotate = 0; rotate < 4; rotate++) {
            int[][] newKey = turnKey(key);
            key = newKey.clone();

            for(int i = 0; i < idx - key.length + 1; i++) {
                for(int j = 0; j < idx - key.length + 1; j++) {

                    for(int k = 0; k < key.length; k++) {
                        for(int m = 0; m < key.length; m++) {
                            map[i + k][j + m] += key[k][m];
                        }
                    }

                    if(check(map, lock.length, key.length)) return true;

                    for(int k = 0; k < key.length; k++) {
                        for(int m = 0; m < key.length; m++) {
                            map[i + k][j + m] -= key[k][m];
                        }
                    }

                }
            }
        }

        return false;
    }
    public static int[][] turnKey(int[][] key) { //90도로 표 돌리기
        int[][] tmpKey = new int[key.length][key.length];

        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key.length; j++) {
                if(key[i][j] == 1) {
                    tmpKey[j][key.length - i - 1] = key[i][j];
                }
            }
        }
        return tmpKey;
    }
    public static boolean check(int[][] arr, int lock, int key) {
        for(int i = 0; i < lock; i++) {
            for(int j = 0; j < lock; j++) {
                if(arr[key-1+i][key-1+j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
