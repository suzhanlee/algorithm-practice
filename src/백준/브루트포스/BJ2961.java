package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2961 {

    static int N;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Taste> tastes = new ArrayList<>();
    static boolean flag = false;

    static class Taste {

        int sour;
        int bitter;

        public Taste(int sour, int bitter) {
            this.sour = sour;
            this.bitter = bitter;
        }
    }

    public static void dfs(int L, int s, int b) {

        if (L == 1 && L == N) {
            answer = Math.abs(s - b);
            flag = true;
            return;
        }

        if (L == N) {
            if (s == 0 && b == 0) {
                return;
            }
            answer = Math.min(Math.abs(s - b), answer);
        } else {
            if (s == 0) {
                dfs(L + 1, tastes.get(L).sour, b + tastes.get(L).bitter);

            } else {
                dfs(L + 1, s * tastes.get(L).sour, b + tastes.get(L).bitter);
            }
            if (flag) {
                return;
            }
            dfs(L + 1, s, b);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tastes.add(new Taste(s, b));
        }

        dfs(0, 0, 0);
        System.out.println(answer);


    }

}
