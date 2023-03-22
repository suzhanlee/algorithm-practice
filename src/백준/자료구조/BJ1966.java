package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1966 {

    static int testNum;
    static int answer = Integer.MIN_VALUE;
    static StringBuilder sb = new StringBuilder();

    static class Document {

        int weight;
        int location;

        public Document(int weight, int location) {
            this.weight = weight;
            this.location = location;
        }
    }

    public static void solution(int N, int M, int[] weight) {

        Queue<Document> queue = new LinkedList();

        for (int i = 0; i < N; i++) {
            queue.offer(new Document(weight[i], i));
        }
        int cnt = 0;

        for (Document document : queue) {
            answer = Math.max(document.weight, answer);
        }

        while (!queue.isEmpty()) {

            Document document = queue.poll();
            if (document.weight != answer) {
                queue.offer(document);
            } else {
                cnt++;
                answer = Integer.MIN_VALUE;
                for (Document document1 : queue) {
                    answer = Math.max(document1.weight, answer);
                }
                if (document.location == M) {
//                    System.out.println(cnt);
                    sb.append(cnt).append('\n');
                    answer = 0;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int[] weight = new int[N];
            for (int j = 0; j < N; j++) {
                weight[j] = Integer.parseInt(st1.nextToken());
            }
            solution(N, M, weight);
        }

        System.out.println(sb);
    }
}
