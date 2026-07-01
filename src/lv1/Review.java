package lv1;

class Review {
    public static void main(String[] args) {
        Review rv = new Review();
        int[][] signals = {
                { 3, 3, 3 },
                { 5, 4, 2 },
                { 2, 1, 2 }
        };
        System.out.printf("answer: %d\n", rv.solution(signals));
    }

    public int solution(int[][] signals) {
        int answer = -1;

        // signals의 주기 periods 구하기
        int[] periods = new int[signals.length];
        for (int i = 0; i < signals.length; i++) {
            for (int j = 0; j < signals[i].length; j++) {
                periods[i]+= signals[i][j];
            }
        }

        // periods의 최소공배수 LCM 구하기
        int LCM = periods[0];
        for (int i = 1; i < periods.length; i++) {
            LCM = getLCM(LCM, periods[i]);
        }

        // LCM 크기만큼 boolean 배열 yellowLights를 선언하고 노란불을 true 값으로 채우기
        boolean[][] yellowLights = new boolean[signals.length][LCM];
        for (int i = 0; i < signals.length; i++) {
            int iterateCount = LCM / periods[i];
            for (int j = 0; j < iterateCount; j++) {
                for (int k = 0; k < signals[i][1]; k++) {       // k: yellow lights count
                    yellowLights[i][signals[i][0] + k + j * periods[i]] = true;
                }
            }
        }

        //visualize(yellowLights);        // for debug

        // yellowLights가 모두 true인 index 찾기, 없으면 -1 반환하기
        boolean isAllYellow = true;
        for (int i = 0; i < LCM; i++) {
            for (boolean[] booleans : yellowLights) {
                isAllYellow &= booleans[i];
            }
            if (isAllYellow) {
                answer = i + 1;
                break;
            } else isAllYellow = true;
        }

        return answer;
    }

    public static int getGCD(int a, int b) {
        int tmp;
        while (b != 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public static int getLCM(int a, int b) {
        return a / getGCD(a, b) * b;
    }

    public static void visualize(boolean[][] yellowLight){
        for (boolean[] booleans : yellowLight) {
            for (boolean isYellow : booleans) {
                char ch = isYellow ? '■' : '□';
                System.out.print(ch);
            }
            System.out.print("\n");
        }
    }
}
