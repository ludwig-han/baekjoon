package lv1;

class Solution_VideoPlayer {
    public static void main(String[] args) {
        Solution_VideoPlayer vp = new Solution_VideoPlayer();

        String[] str = { "34:33", "10:55", "07:22" };
        String[] pos = { "13:00", "00:05", "04:05" };
        String[] op_start = { "00:55", "00:15", "00:15" };
        String[] op_end = { "02:55", "06:55", "04:07" };
        String[][] commands = {
                { "next", "prev" },
                { "prev", "next", "next" },
                { "next" }
        };
        //String[] result = { "13:00", "06:55", "04:17" };
        System.out.println("video_len\tpos\top_start\top_end\tresult");
        for (int i = 0; i < str.length; i++) {
            String tmp = vp.solution(str[i], pos[i], op_start[i], op_end[i], commands[i]);
            System.out.printf("%s\t%s\t%s\t%s\t%s\n", str[i], pos[i], op_start[i], op_end[i], tmp);
        }
    }

    static int toSec(String str) {
        int minutes, seconds;
        String[] parsedStr = str.split(":");
        minutes = Integer.parseInt(parsedStr[0]);
        seconds = Integer.parseInt(parsedStr[1]);

        return minutes * 60 + seconds;
    }

    static String toString(int sec) {
        String str = String.format("%02d:%02d", sec / 60, sec % 60);
        return str;
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        int videoLen = toSec(video_len);
        int curPos = toSec(pos);
        int opStart = toSec(op_start);
        int opEnd = toSec(op_end);

        for (String command : commands) {
            if (opStart <= curPos && curPos <= opEnd)
                curPos = opEnd;
            switch (command) {
                case "prev":
                    if (curPos >= 10) curPos -= 10;
                    else curPos = 0;
                    break;
                case "next":
                    if (videoLen - curPos >= 10) curPos += 10;
                    else curPos = videoLen;
                    break;
            }
            if (opStart <= curPos && curPos <= opEnd)
                curPos = opEnd;
            //System.out.printf("tmp_answer: %s\n", tmp_answer);
        }

        answer = toString(curPos);
        return answer;
    }
}
