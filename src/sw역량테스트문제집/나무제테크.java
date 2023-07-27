package sw역량테스트문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나무제테크 {

    static int N, M, K;
    static int[][] nutrition, additionalNu;
    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static Queue<Tree> trees;
    static class Tree implements Comparable<Tree>{
        int x, y, age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age, o.age);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 땅 크기
        M = Integer.parseInt(st.nextToken()); // 구매할 나무
        K = Integer.parseInt(st.nextToken()); // 몇년 후

        nutrition = new int[N][N];
        additionalNu = new int[N][N];

        trees = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                nutrition[i][j] = 5;
                additionalNu[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken());

            trees.add(new Tree(x, y, a));
        }

        Collections.sort((List<Tree>) trees);

        System.out.println(process());
    }

    private static int process() {

        while(K-- > 0) {
            springToSummer();
            fall();
            winter();
        }

        return trees.size();
    }

    private static void winter() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nutrition[i][j] += additionalNu[i][j];
            }
        }

    }

    private static void fall() {

        ArrayList<Tree> parents = new ArrayList<>();

        int size = trees.size();
        while (size-- > 0) {

            Tree now = trees.poll();

            if(now.age % 5 == 0) {

                for (int i = 0; i < 8; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    trees.add(new Tree(nx, ny, 1));
                }
            }

            parents.add(now);
        }

        trees.addAll(parents);
    }

    private static void springToSummer() {

        ArrayList<Tree> die = new ArrayList<>();

        int size = trees.size();
        while (size -- > 0) {
            Tree now = trees.poll();

            if(nutrition[now.x][now.y] - now.age < 0) {
                die.add(new Tree(now.x, now.y, now.age / 2));
            } else {
                nutrition[now.x][now.y] -= now.age;
                trees.add(new Tree(now.x, now.y, now.age + 1));
            }
        }

        for (Tree t : die) {
            nutrition[t.x][t.y] += t.age;
        }
    }

}