package sortingandsearching;

public class 이분검색 {

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st1 = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st1.nextToken());
//        int M = Integer.parseInt(st1.nextToken());
//
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//        int[] arr = new int[N];
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = Integer.parseInt(st2.nextToken());
//        }
//
//        Arrays.sort(arr);
//        int answer = 이분검색.solution(arr, M);
//        System.out.println(answer);
//
//    }
//
//    public static int solution(int[] arr, int M) {
//        int answer = 0;
//        int lt = 0;
//        int rt = arr.length - 1;
//
//        while (lt <= rt) {
//            int mid = (lt + rt) / 2;
//            if (arr[mid] == M) {
//                answer = mid + 1;
//                break;
//            } else if (arr[mid] < M) {
//                lt = mid + 1;
//            } else {
//                rt = mid - 1;
//            }
//        }
//        return answer;
//    }
}
