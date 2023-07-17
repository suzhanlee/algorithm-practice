package sw역량테스트문제집.여러유형연습.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {

    static String target = "cog";
    static String begin = "hit";
    static String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
    //    static String[] words = {"hot", "dot", "dog", "lot", "log"};
    static Queue<String> queue = new LinkedList<>();
    static int[] dis;
    static int[] visited;

    public static void bfs() {

        while (!queue.isEmpty()) {
            String now = queue.poll();

            for (int i = 0; i < words.length; i++) {
                String compare = words[i];
                if (visited[i] == 0 && canChange(now, compare)) {
                    int before = 0;
                    visited[i] = 1;
                    for (int j = 0; j < words.length; j++) {
                        if (now.equals(words[j])) {
                            before = j;
                        }
                    }
                    dis[i] = dis[before] + 1;
                    if (compare.equals(target)) {
                        return;
                    }
                    queue.offer(compare);
                }
            }
        }

    }


    public static void main(String[] args) {

        dis = new int[words.length];
        visited = new int[words.length];
        queue.offer(begin);
        bfs();

        int cnt = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                System.out.println(dis[i]);
                cnt++;
            }
        }

        if (cnt == 0) {
            System.out.println(0);
        }
    }

    public static boolean canChange(String now, String compare) {

        int cnt = 0;

        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) == compare.charAt(i)) {
                cnt++;
            }
        }

        return cnt == 2;
    }


}
