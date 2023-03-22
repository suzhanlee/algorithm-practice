package 프로그래머스.프로그래머스_구현;

public class 최소직사각형 {

    static int answer;

    public static int solution(int[][] sizes) {

        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < sizes.length; i++) {
            int x = Math.max(sizes[i][0], sizes[i][1]); // 긴 변
            int y = Math.min(sizes[i][0], sizes[i][1]); // 짧은 변
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }
        return answer = maxX * maxY;
    }

    public static void main(String[] args) {

    }

}
