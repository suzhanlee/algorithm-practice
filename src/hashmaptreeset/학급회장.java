package hashmaptreeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 학급회장 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char answer = ' ';
        int max = Integer.MIN_VALUE;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        System.out.println(answer);
        //forEach 는 기본 배열을 반환하고, 배열내의 수정이 이루어 지지 않음
        // map 은 새로운 배열을 반환한다.
        //forEach 로 할수있는것은 map 으로도 할 수 있고, map 으로 할 수 있는것도 forEach 로 가능하다!

    }

}
