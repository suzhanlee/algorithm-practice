package hashmaptreeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 모든아나그램찾기 {

    public static int solution(String S, String T) {

        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = S.toCharArray();
        char[] anaChars = T.toCharArray();

        HashMap<Character, Integer> anaMap = new HashMap<>();

        for (int i = 0; i < T.length(); i++) {
            anaMap.put(anaChars[i], anaMap.getOrDefault(anaChars[i], 0) + 1);
        }

        for (int rt = 0; rt < T.length() - 1; rt++) {
            map.put(chars[rt], map.getOrDefault(chars[rt], 0) + 1);
        }

        int lt = 0;
        for (int rt = T.length() - 1; rt < S.length(); rt++) {

            map.put(chars[rt], map.getOrDefault(chars[rt], 0) + 1);

            if (map.equals(anaMap)) {
                answer++;
            }
            map.put(chars[lt], map.get(chars[lt]) - 1);
            if (map.get(chars[lt]) == 0) {
                map.remove(chars[lt]);
            }
            lt++;

        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        System.out.println(모든아나그램찾기.solution(S, T));
    }
}
