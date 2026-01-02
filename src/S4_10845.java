import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class S4_10845 { // 클래스명은 Main으로 제출해야 함
    public static void main(String[] args) throws IOException { // 입출력 예외 처리를 위해 throws IOException 추가

        // 1. BufferedReader: 입력을 버퍼에 담아 한꺼번에 읽기 때문에 Scanner보다 훨씬 빠름
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2. StringBuilder: 출력을 매번 System.out 하지 않고, 하나의 문자열로 모았다가 마지막에 한 번에 출력
        StringBuilder sb = new StringBuilder();

        // 첫 줄 읽기 (명령의 수 N)
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int front = 0;
        int rear = -1;

        // N번의 명령 처리 시작
        for (int i = 0; i < N; i++) {
            // 3. StringTokenizer: split()보다 훨씬 빠른 속도로 공백 기준 문자열 분리
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken(); // 명령어 추출

            switch (command) {
                case "push":
                    int num = Integer.parseInt(st.nextToken()); // 두 번째 토큰(숫자) 추출
                    rear++;
                    arr[rear] = num;
                    break;

                case "pop":
                    if (front > rear) {
                        sb.append("-1\n"); // System.out 대신 sb에 결과 저장
                    } else {
                        sb.append(arr[front]).append("\n");
                        front++;
                    }
                    break;

                case "size":
                    sb.append(rear - front + 1).append("\n");
                    break;

                case "empty":
                    sb.append(rear < front ? 1 : 0).append("\n");
                    break;

                case "front":
                    if (rear < front) sb.append("-1\n");
                    else sb.append(arr[front]).append("\n");
                    break;

                case "back":
                    if (rear < front) sb.append("-1\n");
                    else sb.append(arr[rear]).append("\n");
                    break;
            }
        }

        // 4. 모아둔 모든 결과를 한 번에 출력 (이게 시간 초과 해결의 핵심!)
        System.out.print(sb);
    }
}