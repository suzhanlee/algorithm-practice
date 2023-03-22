package hashmaptreeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class K번째큰수 {

    public static int solution(int[] arr, int N, int K) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    list.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }

        List<Integer> set = list.stream().distinct().collect(Collectors.toList());
        Collections.sort(set, Collections.reverseOrder());

        if (set.size() < K) {
            answer = -1;
        } else {
            answer = set.get(K - 1);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        System.out.println(K번째큰수.solution(arr, N, K));
    }
}
