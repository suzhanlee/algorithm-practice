package sw역량테스트문제집.여러유형연습.dfsbfs;

public class 타겟넘버 {

    static int[] arr;
    static int answer;
    static int target;

    public static void main(String[] args) {

//        arr = new int[]{1, 1, 1, 1, 1};
//        target = 3;
        arr = new int[]{4, 1, 2, 1};
        target = 4;

        dfs(0, 0);
        System.out.println(answer);

    }

    private static void dfs(int L, int sum) {

        if (L == arr.length) {
            if (sum == target) {
                answer++;
            }

        } else {
            dfs(L + 1, sum + arr[L]);
            dfs(L + 1, sum - arr[L]);
        }


    }

}
