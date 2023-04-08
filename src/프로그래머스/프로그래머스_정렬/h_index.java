package 프로그래머스.프로그래머스_정렬;


import java.util.Arrays;

public class h_index {

    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int tmp = citations.length - i;
            if (citations[i] >= tmp) {
                answer = tmp;
                break;
            }
        }

        return answer;
    }
}

