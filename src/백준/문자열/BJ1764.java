package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ1764 {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set;
    static ArrayList<String> arrayList;
    static int answer;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new HashSet<>();
        arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                arrayList.add(str);
                answer++;
            }
        }

        Collections.sort(arrayList);

        for (String x : arrayList) {
            sb.append(x).append('\n');
        }

        System.out.println(answer);

        System.out.println(sb);
    }
}
