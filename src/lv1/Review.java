package lv1;

class Review {
    public static void main(String[] args) {
        Review rv = new Review();
        int[] schedules = { 700, 800, 1100 };
        int[][] timelogs = {
                { 710, 2359, 1050, 700, 650, 631, 659 },
                { 800, 801, 805, 800, 759, 810, 809 },
                { 1105, 1001, 1002, 600, 1059, 1001, 1100 }
        };
        int startday = 5;

        System.out.printf("%d\n", rv.solution(schedules, timelogs, startday));
    }
    static int toMinutes(int time) {
        return (time / 100) * 60 + time % 100;
    }

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int commuteTime = toMinutes(schedules[i] + 10);       // change to minutes to easier compare
            int safeCount = 0;
            for (int j = 0; j < timelogs[i].length; j++) {
                if ((startday + j)%7 == 6 ||( startday + j)%7 == 0) continue;
                if (commuteTime >= toMinutes(timelogs[i][j])) safeCount++;
            }
            if (safeCount >= 5) answer++;
        }


        return answer;
    }
}