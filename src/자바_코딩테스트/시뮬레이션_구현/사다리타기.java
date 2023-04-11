package 자바_코딩테스트.시뮬레이션_구현;

class 사다리타기 {

    public char[] solution(int n, int[][] ladder) {

        char[] answer = new char[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (char) (i + 65);
        }

        for (int[] line : ladder) {

            for (int x : line) {
                char tmp = answer[x];
                answer[x] = answer[x - 1];
                answer[x - 1] = tmp;
            }

        }

        return answer;

    }
}


