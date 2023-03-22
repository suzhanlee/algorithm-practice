package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ16508 {

    static String T; // 만들고자 하는 단어(대문자)
    static int N; // 전공책의 개수
    static int answer = Integer.MAX_VALUE;
    static ArrayList<MajorBook> majorBooks = new ArrayList<>();
    static int[] visited;
    static int[] alphabet;

    static class MajorBook implements Comparable<MajorBook> {

        int price;
        String book;

        public MajorBook(int price, String book) {
            this.price = price;
            this.book = book;
        }

        @Override
        public int compareTo(MajorBook o) {
            if (this.price == o.price) {
                return -1;
            } else {
                return this.price - o.price;
            }
        }
    }

    public static void dfs(int L, int total) {

        if (L == N) {
            if (check()) {
                answer = Math.min(answer, total);
            }
        } else {

            for (int i = 0; i < majorBooks.get(L).book.length(); i++) {

                visited[majorBooks.get(L).book.charAt(i) - 'A']++;
            }
            dfs(L + 1, total + majorBooks.get(L).price);

            for (int i = 0; i < majorBooks.get(L).book.length(); i++) {

                visited[majorBooks.get(L).book.charAt(i) - 'A']--;
            }
            dfs(L + 1, total);
        }


    }

    private static boolean check() {
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = br.readLine();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            String book = st.nextToken();

            majorBooks.add(new MajorBook(price, book));
        }

        majorBooks.sort(Comparable::compareTo);

        visited = new int[26];
        alphabet = new int[26];

        for (int i = 0; i < T.length(); i++) {
            alphabet[T.charAt(i) - 'A']++;
        }

        dfs(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }
}
