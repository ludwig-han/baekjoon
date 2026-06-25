package lv1;// 프로그래머스 레벨 1 "추억 점수"

import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                for (int k = 0; k < name.length; k++)
                    if (photo[i][j].equals(name[k]))
                        answer[i] += yearning[k];
            }
        }

        return answer;
    }

    public int[] solution_HashMap(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++)
            map.put(name[i], yearning[i]);

        for (int i = 0; i < photo.length; i++)
            for (String person : photo[i])
                answer[i] += map.getOrDefault(person, 0);

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may", "kein", "kain", "radi"},
                {"may", "kein"},
                {"kain", "radi"}
        };
        int[] result = sol.solution(name, yearning, photo);
        for (int r : result) System.out.print(r + " ");
    }
}