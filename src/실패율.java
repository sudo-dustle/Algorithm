import java.util.*;

public class 실패율 {
    public static void main(String[] args) {
        int[] stages = {4,4,4,4,4};
        ArrayList<Integer> solution = solution(4, stages);
        System.out.println(solution.toString());
    }
    public static ArrayList<Integer> solution(int N, int[] stages) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();// 스테이지, 사람 수
        HashMap<Integer, Double> failure = new HashMap<>();

        //스테이지당 진행 중인 사람 찾는 로직
        for(int i = 0; i < stages.length; i++) {
            hm.put(stages[i], hm.getOrDefault(stages[i], 0) + 1);
        }
        int participants = stages.length;

        for(int i = 1; i <= N; i++){
            double tmp = 0.0;
            if(hm.get(i) != null){
                tmp = (double)hm.get(i) / (double)participants;
                participants -= hm.get(i);
            }
            failure.put(i, tmp);
        }

        List<Integer> listKeySet = new ArrayList<>(failure.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (failure.get(value2).compareTo(failure.get(value1))));

        for(int key : listKeySet) {
            answer.add(key);
        }

        return answer;
    }
}
