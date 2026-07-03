package lv1;

class Solution_FlexTime {
    public static void main(String[] args) {
        Solution_FlexTime sf = new Solution_FlexTime();
        int[] schedules = {730, 855, 700, 720};
        int[][] timelogs = {
                {710, 700, 650, 735, 700, 931, 912},
                {908, 901, 805, 815, 800, 831, 835},
                {705, 701, 702, 705, 710, 710, 711},
                {707, 731, 859, 913, 934, 931, 905}
        };
        int startday = 1;
        int answer = sf.solution(schedules, timelogs, startday);
        System.out.printf("answer: %d\n", answer);
    }
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int commuteTime = schedules[i] + 10;
            if (commuteTime % 100 >= 60)
                commuteTime = commuteTime - commuteTime % 100 + 100 + ( commuteTime % 100) % 60;
            if (commuteTime / 100 >= 24)
                commuteTime = commuteTime - 2400;
//            System.out.printf("%d's commuteTime: %d\n", i+1, commuteTime);
            int passCount = 0;
            for (int j = 0; j < timelogs[i].length; j++) {
                if ((startday + j) % 7 == 6 || (startday + j) % 7 == 0) continue;
                if (timelogs[i][j] <= commuteTime) passCount++;
//                System.out.printf("%d's passCount: %d\n", i+1, passCount);
//                System.out.printf("j = %d, (timelogs[%d][%d])%d <= (commuteTime)%d == %b\n", j, i, j, timelogs[i][j], commuteTime, timelogs[i][j] <= commuteTime);
            }
            if (passCount >= 5)
                answer += 1;
        }

        return answer;
    }
}
