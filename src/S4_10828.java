import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_10828 {
    static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int idx = -1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    idx++;
                    arr[idx] = Integer.parseInt(st.nextToken());
                    break;
                case "pop":
                    if (idx != -1) {
                        sb.append(arr[idx]).append('\n');
                        idx--;
                    }
                    else sb.append(-1).append('\n');
                    break;
                case "size":
                    sb.append(idx+1).append('\n');
                    break;
                case "empty":
                    sb.append(idx==-1?1:0).append('\n');
                    break;
                case "top":
                    if (idx != -1) sb.append(arr[idx]).append('\n');
                    else sb.append(-1).append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }
}
