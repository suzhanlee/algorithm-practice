package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ16987 {

    static ArrayList<Egg> eggs;
    static int N;
    static int[] visited;
    static int answer = Integer.MIN_VALUE;

    static class Egg {

        int s;
        int w;

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }

    public static void dfs(int L, int sum) {

        if (L == N) {
            answer = Math.max(answer, sum);
            return;
        }

        if (eggs.get(L).s < 1 || sum == N - 1) {
            dfs(L + 1, sum);
        }

        for (int i = 0; i < N; i++) {
            if (eggs.get(i).s < 1) {
                continue;
            }

            int newSum = sum;
            if (i != L) {
                if (eggs.get(i).s > 0 && eggs.get(L).s > 0) {
                    eggs.get(i).s -= eggs.get(L).w;
                    eggs.get(L).s -= eggs.get(i).w;

                    if (eggs.get(i).s < 1) {
                        sum++;
                    }

                    if (eggs.get(L).s < 1) {
                        sum++;
                    }

                    dfs(L + 1, sum);

                    eggs.get(i).s += eggs.get(L).w;
                    eggs.get(L).s += eggs.get(i).w;
                    sum = newSum;

                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        eggs = new ArrayList<Egg>();
        visited = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs.add(new Egg(s, w));

        }

        dfs(0, 0);
        System.out.println(answer);

    }
}
