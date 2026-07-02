package lv1;
// 1. 다 채운 줄 수 totalRaw 구하기
// 2. 주어진 수(num)가 몇 번째 줄인지 구하기 numRaw
// 3. num 번째 상자 머리 위에 있는 확정된 개수 구하기 (answer = totalRaw - numRaw)
// 4. 마지막 상자와 num번째 상자의 원점으로부터 떨어진 수평 거리 구하기 distanceLast, distanceNum
// 5. 마지막 상자가 num번째 상자보다 ((좌상단 and 좌진행) or (우상단 and 우진행)) => answer + 1

class Solution_Box {
    public static void main(String[] args) {
        Solution_Box sb = new Solution_Box();
        int[][] testCases = new int[][]{
//                { 22, 6, 8 },
//                { 13, 3, 6 },
//                { 10, 2, 6 },
                { 15, 5, 1 },
                { 15, 5, 3 },
                { 15, 5, 5 },
                { 15, 5, 6 },
                { 15, 5, 8 },
                { 15, 5, 10 },
                { 15, 5, 11 },
                { 15, 5, 13 },
                { 15, 5, 15 },
                { 16, 5, 1 },
                { 16, 5, 3 },
                { 16, 5, 5 },
                { 16, 5, 6 },
                { 16, 5, 7 },



        };

        for (int[] testCase : testCases) {
            int result = sb.solution(testCase[0], testCase[1], testCase[2]);
            System.out.printf("[%d %d %d]: %d\n", testCase[0], testCase[1], testCase[2], result);
        }
    }

    public int solution(int n, int w, int num) {
        int answer = 0;

        // 1. 다 채운 줄 수 totalRow 구하기
        int totalRow = n / w;

        // 2. 주어진 수(num)가 몇 번째 줄인지 구하기 numRow
        int numRow = ( num - 1 ) / w + 1;

        // 3. num 번째 상자 머리 위에 있는 확정된 개수 구하기 (answer = totalRow - numRow + 1)
        answer = totalRow - numRow + 1;

        // 4. 마지막 상자와 num번째 상자의 원점으로부터 떨어진 수평 거리 구하기 distanceLast, distanceNum
        int lastRow = (n - 1) / w + 1;  // 마지막 상자의 줄 수
        int distanceLast = n - (lastRow - 1) * w;
        int distanceNum = num - (numRow - 1) * w;
        boolean isLastDirectionRight = (lastRow % 2 != 0);
        boolean isNumDirectionRight = (numRow % 2 != 0);
        if (!isLastDirectionRight)           // 홀수 줄일 경우 우진행, 짝수 줄일 경우 좌진행
            distanceLast = w - distanceLast + 1;

        if (!isNumDirectionRight)
            distanceNum = w - distanceNum + 1;      // 홀수 줄일 경우 우진행, 짝수 줄일 경우 좌진행

//        System.out.printf("distanceLast: %d\n", distanceLast);
//        System.out.printf("distanceNum: %d\n", distanceNum);

        // 5. 마지막 상자가 num번째 상자보다 ((좌상단 and 좌진행) or (우상단 and 우진행)) => answer + 1
        if (n % w == 0) return answer;

        if (distanceLast < distanceNum && !isLastDirectionRight) {
            answer++;
        } else if (distanceLast > distanceNum && isLastDirectionRight) {
            answer++;
        } else if (distanceLast == distanceNum) {
//            System.out.print("여기왜\n");
            answer++;
        }

        return answer;
    }
}
