package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class BJ18870 {

    static int N;
    static int[] origin;
    static int[] sorted;
    static HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();
    static StringBuilder sb = new StringBuilder();

    private static void solution() {
        // 정렬 된 배열을 순회하면서 map에 넣어준다.
        int rank = 0;
        for (int v : sorted) {
            /*
             *  이 때 만약 앞선 원소가 이미 순위가 매겨졌다면
             *  중복되면 안되므로, 원소가 중복되지 않을 때만
             *  map에 원소와 그에 대응되는 순위를 넣어준다.
             */
            if (!rankingMap.containsKey(v)) {
                rankingMap.put(v, rank);
                rank++;        // map에 넣고나면 다음 순위를 가리킬 수 있도록 1을 더해준다.
            }
        }

        for (int key : origin) {
            int ranking = rankingMap.get(key);    // 원본 배열 원소(key)에 대한 value(순위)를 갖고온다.
            sb.append(ranking).append(' ');
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        origin = new int[N];
        sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            sorted[i] = origin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        solution();

        System.out.println(sb);

    }
}