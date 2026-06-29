package lv1;
// 각 signal 배열의 주기 구하기
// 주기들의 최소공배수 구하기
// 각 signal 배열에 대한 boolean 배열 선언
// 각 signal 배열 중 노란불에 해당하는 값을 true로 초기화
// 최소공배수 내에서 모두 true가 되는 index가 있는지 검사
// 있으면 index+1 반환, 없으면 -1 반환

class Solution_yellowlight{
    public static void main(String[] args) {
        int[][] signals = new int[][] {
                {3, 3, 3},
                {5, 4, 2},
                {2, 1, 2}
        };
        Solution_yellowlight s = new Solution_yellowlight();
        int answer = s.solution(signals);
        System.out.printf("answer: %d\n", answer);
    }

    public int solution(int[][] signals) {
        int answer = -1;

        // 각 signal 배열의 주기 구하기
        int[] signalsPeriod = new int[signals.length];
        for (int i = 0; i < signals.length; i++) {
            signalsPeriod[i] = 0;
            for (int j = 0; j < signals[i].length; j++)
                signalsPeriod[i] += signals[i][j];
        }

        // 주기들의 최소공배수 구하기
        int LCM = signalsPeriod[0];
        for (int i = 1; i <= signalsPeriod.length - 1; i++) {
            LCM = getLCM(LCM, signalsPeriod[i]);
        }
        //System.out.printf("LCM: %d\n", LCM);      // debugging


        // 각 signal 배열에 대한 boolean 배열 선언
        boolean[][] isYellow = new boolean[signalsPeriod.length][];
        for (int i = 0; i < isYellow.length; i++)
            isYellow[i] = new boolean[LCM];


        // 각 signal 배열 중 노란불에 해당하는 값을 true로 초기화
        for (int i = 0; i < isYellow.length; i++) {
            int repeatCount = isYellow[i].length / signalsPeriod[i];        // 주기가 반복되는 횟수
            for (int j = 0; j < repeatCount; j++) {

                for (int k = 0; k < signals[i][1]; k++) {
                    isYellow[i][signals[i][0] + signalsPeriod[i] * j + k] = true;
                }

            }
//            int tmp = signals[i][0];
//            for (int j = (record.length - 1) % signalsPeriod[i]; j < record.length; j++) {
//                if (tmp < 0) {
//                    record[i][j] = true;
//                }
//                tmp--;
//            }
        }

        // 디버깅용 출력
        //printSignal(record);

        // 최소공배수 내에서 모두 true가 되는 index가 있는지 검사
        // 있으면 index+1 반환, 없으면 -1 반환
        for (int i = 0; i < LCM; i++) {
            boolean isAllYellow = true;
            for (boolean[] booleans : isYellow) {
                isAllYellow = isAllYellow && booleans[i];
            }
            if (isAllYellow) {
                answer = i + 1;
                break;
            }

        }

        return answer;
    }

    public int getGCD(int a, int b) {
        while (b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public int getLCM(int a, int b) {
        //return (a * b) / getGCD(a, b);
        return a / getGCD(a, b) * b;
    }

    public void printSignal(boolean[][] record) {
        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record[i].length; j++) {
                char t = record[i][j] ? '■' : '□';
                System.out.print(t);
            }
            System.out.print("\n");
        }
    }
}
