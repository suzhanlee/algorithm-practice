package sortingandsearching;

public class 결정알고리즘 {

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st1 = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st1.nextToken());
//        int M = Integer.parseInt(st1.nextToken());
//
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//        int[] arr = new int[N];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = Integer.parseInt(st2.nextToken());
//        }
//        결정알고리즘.solution(arr, M);
//    }
//
//    public static void solution(int[] arr, int M) {
//        int sum = 0;
//        int max = -1;
//        for (int i = 0; i < arr.length; i++) {
//            sum += arr[i];
//            if (arr[i] > max) {
//                max = arr[i];
//            }
//        }
//
//        int lt = max;
//        int rt = sum;
//        int[] array = new int[sum - max + 1];
//
//        int mid = (lt + rt) / 2;
//        int num = 0;
//        int idx = 0;
//        if (idx == M) {
//            while (idx < M) {
//                rt--;
//            }
//        } else if (idx < M) {
//            rt = mid - 1;
//        } else {
//            lt = mid + 1;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            if (num > mid) {
//                idx += 1;
//                num = 0;
//            }
//            num += arr[i];
//        }
//
//        while (true) {
//
//        }
//
//
//    }

}
