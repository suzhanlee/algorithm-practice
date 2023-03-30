package 프로그래머스.pccp모의고사;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 유전법칙 {

    static int[][] queries;
    static String[] answer;
    static ArrayList<ArrayList<String>> graph = new ArrayList<>();
    static Queue<String> queue = new LinkedList<>();
    static List<String> answerList = new ArrayList<>();
    static int[] dx = {0, 0, 0, 1};
    static int[] dy = {0, 1, 1, 1};
    static int max;
    static boolean flag = false;

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String[] solution(int[][] queries) {
        this.queries = queries;

        for (int[] query : queries) {
            max = Math.max(query[0], max);
        }

        for (int i = 0; i < 100; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add("Rr");

        queue.offer("Rr");

        bfs();

        for (int[] query : queries) {
            int x = query[0];
            int y = query[1];
            String str = graph.get(x - 1).get(y - 1);
            answerList.add(str);
        }

        answer = new String[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public void bfs() {

        int cnt = 0;
        int L = 1;
        int num = 4;

        while (!queue.isEmpty()) {

            String poll = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nx = dx[i];
                int ny = dy[i];

                String bean = "";
                bean += poll.charAt(nx);
                bean += poll.charAt(ny);

                graph.get(L).add(bean);
                cnt++;
                queue.offer(bean);

                if (cnt >= num) {
                    num *= 4;
                    L++;
                    cnt = 0;
                }

                if (L == max + 1) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }

        }
    }

    public static void main(String[] args) {

        int[][] ints = {{3, 1}, {2, 3}, {3, 9}};

        유전법칙 ㅇ = new 유전법칙();
        String[] solution = ㅇ.solution(ints);
        for (String s : solution) {
            System.out.println(s);

        }
    }

}
