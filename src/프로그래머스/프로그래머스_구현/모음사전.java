package 프로그래머스.프로그래머스_구현;

public class 모음사전 {
    static int answer = 0;
    static char[] chars = new char[]{'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {

        int[] x = {781, 156, 31, 6, 1};

        for (int i = 0; i < word.length(); i++) {

            int idx = -1;

            for (int j = 0; j < chars.length; j++) {

                if (word.charAt(i) == chars[j]) {
                    idx = j;
                    break;
                }
            }

            answer += (x[i] * idx + 1);

        }

        return answer;
    }

    public static void main(String[] args) {

    }

}
