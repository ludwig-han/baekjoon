import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            arr[tmp]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}
