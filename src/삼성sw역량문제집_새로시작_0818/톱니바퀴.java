package 삼성sw역량문제집_새로시작_0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 톱니바퀴 {

    static List<Gear> gears = new ArrayList<>();
    static int answer;
    static int[] visited;

    static class Gear {

        public int[] numbers = new int[8];

        public int[] getNumbers() {
            return numbers;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String value = br.readLine();

            Gear gear = new Gear();
            for (int j = 0; j < 8; j++) {
                gear.numbers[j] = value.charAt(j) - '0';
            }
            gears.add(gear);
        }

        int nums = Integer.parseInt(br.readLine());

        for (int i = 0; i < nums; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st1.nextToken());
            int dir = Integer.parseInt(st1.nextToken());

            visited = new int[4];
            doProcess(gearNum - 1, dir);

        }

        calculateAnswer();

    }

    private static void calculateAnswer() {
        for (int i = 0; i < 4; i++) {
            if (gears.get(i).numbers[0] != 0) {
                answer += Math.pow(2, i);
            }
        }

        System.out.println(answer);
    }

    private static void doProcess(int gearNum, int dir) {
        rotation(gearNum, dir);
//        visited[gearNum] = 1;

        int L = 1;

        dfs(gearNum, dir, L);
    }

    private static void dfs(int gearNum, int dir, int L) {

        if (L == 4) {
            return;
        } else {
            if (gearNum - 1 >= 0 && visited[gearNum - 1] == 0) {
                int nx = gearNum - 1;
                rotation(nx, dir);
                visited[nx] = 1;
                dfs(nx, changeDir(dir), L + 1);
                visited[nx] = 0;
            }

            if (gearNum + 1 <= 3 && visited[gearNum + 1] == 0) {
                int nx = gearNum + 1;
                rotation(nx, dir);
                visited[nx] = 1;
                dfs(nx, changeDir(dir), L + 1);
                visited[nx] = 0;
            }
        }
    }

    private static int changeDir(int dir) {
        return -dir;
    }

    private static void rotation(int gearNum, int dir) {
        Gear gear = gears.get(gearNum);

        if (dir == 1) {
            //turn right
            int tmp = gear.numbers[7];

            for (int i = 7; i >= 1; i--) {
                gear.numbers[i] = gear.numbers[i - 1];
            }

            gear.numbers[0] = tmp;

        } else {
            // turn left

            int tmp = gear.numbers[0];

            for (int i = 0; i <= 6; i++) {
                gear.numbers[i] = gear.numbers[i + 1];
            }

            gear.numbers[7] = tmp;

        }
    }

}
