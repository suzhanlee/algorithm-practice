package 프로그래머스.프로그래머스_깊이_너비_우선탐색;

import java.util.LinkedList;
import java.util.Queue;

public class 단어_변환 {

    static String[] words;

    static Queue<String> queue = new LinkedList<>();
    static int answer;
    static String target;
    static int[] dis;
    static int targetIdx = -1;

    public int solution(String begin, String target, String[] words) {

        this.words = words;
        this.target = target;
        boolean flag = false;
        dis = new int[words.length];

        for (int i = 0; i < words.length; i++) {

            if (words[i].equals(target)) {
                targetIdx = i;
                flag = true;
            }
        }

        if (flag) {
            queue.offer(begin);
            bfs();
            return answer;
        } else {
            return 0;
        }

    }

    public static void bfs() {

        while (!queue.isEmpty()) {

            String str = queue.poll();

            for (int i = 0; i < words.length; i++) {

                int cnt = 0;

                for (int j = 0; j < words[i].length(); j++) {
                    if (str.charAt(j) == words[i].charAt(j)) {
                        cnt++;
                    }

                }

                if (cnt == words[i].length() - 1) {
                    queue.offer(words[i]);
                    int idx = 0;
                    for (int j = 0; j < words.length; j++) {
                        if (str.equals(words[j])) {
                            idx = j;
                            break;
                        }

                    }
                    dis[i] = dis[idx] + 1;
                    if (words[i].equals(target)) {
                        answer = dis[targetIdx];
                        return;
                    }
                }
            }

        }

    }

}
