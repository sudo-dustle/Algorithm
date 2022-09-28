import java.util.LinkedList;

public class 카카오캐시 {
    static final int hit = 1;
    static final int miss = 5;

    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return miss * cities.length;//0이면 hit 못시켜서 다 miss로 처리

        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();//예제 중 대소문자 다른거 판별

            if (cache.remove(city)) {//배열에 값이 존재하면 true 반환하고 지우기
                cache.addFirst(city);//첫번째로 이동
                answer += hit;
            } else {
                if (cache.size() == cacheSize) cache.pollLast();//배열 숫자 유지시키기
                cache.addFirst(city);//첫번째 넣기(값이 존재 안하니깐)
                answer += miss;
            }
        }
        return answer;
    }
}
