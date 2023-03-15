public class CountNumberofTeams {
    public static void main(String[] args) {
        int[] rating = {2,5,3,4,1};
        int answer = numTeams(rating);
        System.out.println(answer);
    }

    public static int numTeams(int[] rating) {
        int[][] memoi = new int[1000][4];
        int[][] memoi2 = new int[1000][4];
        int count = 0;

        for (int i = 0; i < 1000; i++) {
            memoi[i][1] = 1;
            memoi2[i][1] = 1;
        }

        for (int size = 2; size < 4; size++) {
            for (int i = 0; i < rating.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (rating[i] < rating[j]) {
                        memoi[i][size] += memoi[j][size - 1];
                    }
                }
            }
        }

        for (int size = 2; size < 4; size++) {
            for (int i = 0; i < rating.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (rating[i] > rating[j]) {
                        memoi2[i][size] += memoi2[j][size - 1];
                    }
                }
            }
        }

        for(int i = 0; i < 1000; i++) {
            count += memoi[i][3];
            count += memoi2[i][3];
        }

        return count;
    }
}
