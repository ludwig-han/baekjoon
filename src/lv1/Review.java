package lv1;
// 1. completeRow(꽉 찬 줄 개수) 구하기
// 2. numRow(num이 속한 줄) 구하기
// 3. 최소 answer = complelteRow - numRow
// 4. 맨 윗 줄이 꽉찬 줄일 경우 (n % w == 0) => answer 반환
// 5. numDistance, lastDistance 정의 (가장 왼쪽 세로 줄로부터의 거리)
// 6. answer의 1 증가 조건:
// ((last줄 좌향) and (numDistance > lastDistance))
// or ((last줄 우향) and (numDistance < lastDistance))
// or (numDistance == lastDistance)
class Review {
    public static void main(String[] args) {
        Review rv = new Review();
        int[][] testCase = {
                { 22, 6, 8 },
                { 13, 3, 6 }
        };

        for (int[] testcase : testCase) {
            int answer = rv.solution(testcase[0], testcase[1], testcase[2]);
            System.out.printf("{ %d, %d, %d }: %d\n", testcase[0], testcase[1], testcase[2], answer);
        }
    }

    public int solution(int n, int w, int num) {
        int answer = 0;

        // 1. completeRow(꽉 찬 줄 개수) 구하기
        int completeRow = n / w;

        // 2. numRow(num이 속한 줄) 구하기
        int numRow = (num - 1) / w + 1;
        int lastRow = (n - 1) / w + 1;

        // 3. 최소 answer = completeRow - numRow + 1
        answer = completeRow - numRow + 1;

        // 4. 맨 윗 줄이 꽉찬 줄일 경우 (n % w == 0) => answer 반환
        if (n % w == 0) return answer;

        // 5. numDistance, lastDistance 정의 (가장 왼쪽 세로 줄로부터의 거리)
        boolean isNumDirectionLeft = (numRow % 2 == 0);
        boolean isLastDirectionLeft = (lastRow % 2 == 0);

        int numDistance = (num - 1) % w;
        if (isNumDirectionLeft) numDistance = (w - 1) - numDistance;

        int lastDistance = (n - 1) % w;
        if (isLastDirectionLeft) lastDistance = (w - 1) - lastDistance;

        // 6. answer의 1 증가 조건:
        // ((last줄 좌향) and (numDistance > lastDistance))
        // or ((last줄 우향) and (numDistance < lastDistance))
        // or (numDistance == lastDistance)

        if (((isLastDirectionLeft) && (numDistance > lastDistance)) ||
                ((!isLastDirectionLeft) && (numDistance < lastDistance)) ||
                (numDistance == lastDistance))
            answer += 1;

        return answer;
    }
}
