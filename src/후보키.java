import java.util.*;

public class 후보키 {
    //3시 25분 ~
    public static Set<String> set = new HashSet<>();
    public static String[][] tmp;
    public static boolean[] visited = new boolean[8];
    public static String[][] relation;
    public static int r;
    public static List<Integer> ansList = new ArrayList<>();

    public static void main(String[] args) {
        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        System.out.println(solution(relation));
    }

    public static int solution(String[][] relations) {
        relation = relations;
        r = relation[0].length;
        tmp = new String[relations.length][relations[0].length];
        comb(0);

        // 유니크한 조합을 ansList에 들고있다.
        // 유일성에 대한 가공을 더 해줘야 ansList에 진짜 후보키만 남는다.


        processing();

        return ansList.size();
    }

    public static void comb(int depth) {
        if (depth == r) {
            int caseNumber = 0;
            for (int i = 0; i < relation.length; i++) {
                for (int j = 0; j < relation[0].length; j++) {
                    if (visited[j]) {
                        tmp[i][j] = relation[i][j];
                    } else {
                        tmp[i][j] = null;
                    }
                }
            }

            for (int j=0; j<relation[0].length; ++j) {
                if (visited[j]) {
                    caseNumber += (1 << j); // x x x o -> 1
//                    System.out.printf("caseNumber : %d%n", caseNumber);
                }
            }

//            {
//                for (int i=0; i< tmp.length; ++i) {
//                    for (int j=0; j<tmp[0].length; ++j) {
//                        System.out.print(tmp[i][j] + " ");
//                    }
//                    System.out.println();
//                }
//                //System.out.println();
//            }

            boolean ret = validation(tmp, relation.length, caseNumber);
//            System.out.println(ret);
//            System.out.println();
            return;
        }
        visited[depth] = false;
        comb(depth + 1);
        visited[depth] = true;
        comb(depth + 1);
    }

//    public static void print(String[] tmp) {
//        for (int i = 0; i < tmp.length; i++) {
//            System.out.print(tmp[i] + " ");
//        }
//        System.out.println();
//    }

    public static boolean validation(String[][] tmp, int n, int caseNumber) {
        System.out.println();
        for (int i = 0; i < tmp.length; i++) {
            set.add(Arrays.toString(tmp[i]));
//            System.out.println(Arrays.toString(tmp[i]));
        }
//        System.out.printf("caseNumber : %d, setSize = %d, n = %d%n", caseNumber, set.size(), n);
        if (set.size() == n) {
            ansList.add(caseNumber);
            set.clear();
            return true;
        }
        set.clear();
        return false;
    }

    public static void processing() {
        for (int i = 0; i < ansList.size(); ++i) {
            int caseNumber = ansList.get(i);
            int j = i + 1; // j는 index

//            System.out.printf("i : %d%n", i);

            while (j < ansList.size()) {
//                System.out.printf("caseNumber -> list.get(i) : %d, list.get(j) : %d%n", caseNumber, ansList.get(j));
//                System.out.printf("j : %d, if = %b%n", j, (caseNumber & ansList.get(j)) == caseNumber);
                if ((caseNumber & ansList.get(j)) == caseNumber) {
                    // caseNumber는 ansList에서 작은 순서로 담겨있다 (작은 조합부터 만들었기 때문에)
                    // 근데 caseNumber와 caseNumber 뒤에 있는 뭔가를 and쳤더니 caseNumber와 같은 수가 나온다는 뜻은
                    // caseNumber에서 고른 컬럼으로만으로도 이미 후보키인데
                    // ansList.get(j) 얘는 최소성 만족을 못하는 애인거임
                    // 그럼 빼버려
                    ansList.remove(j);
                } else {
                    // j번째 애가 caseNumber와 관계없으면 삭제안했으니까 j 인덱스를 증가
                    j++;
                }
            }
        }
    }
}
