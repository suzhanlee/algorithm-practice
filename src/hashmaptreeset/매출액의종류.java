package hashmaptreeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 매출액의종류 {

    public static ArrayList<Integer> solution(int N, int K, int[] arr) {
        ArrayList<Integer> array = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int rt = 0; rt < K - 1; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
        }

        int idx = 0;
        int lt = 0;

        for (int rt = K - 1; rt < N; rt++) {

            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            int size = map.size();
            array.add(idx, size);
            idx++;

            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            lt++;
        }
        return array;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        int[] arr = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i : 매출액의종류.solution(N, K, arr)) {
            System.out.print(i + " ");
        }
    }
}
