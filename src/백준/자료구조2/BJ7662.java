package 백준.자료구조2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ7662 {

    static int T; // 테스트 수
    static int K; // 적용할 연산의 갯수


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {

            K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String string = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (string.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.size() == 0) {
                        continue;
                    }
                    int number = num == 1 ? map.lastKey() : map.firstKey();
                    if (map.put(number, map.get(number) - 1) == 1) {
                        map.remove(number);
                    }
                }
            }

            System.out.println(map.size() == 0 ? "EMPTY" : map.lastKey() + " " + map.firstKey());
        }
    }
}
