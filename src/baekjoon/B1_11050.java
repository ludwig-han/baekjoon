package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        K = Math.min((N - K), K);

        int result = 1;
        int tmp = N;
        for (int i = 0; i < K; i++) {
            result = result * tmp;
            tmp--;
        }
        tmp = K;
        for (int i = 0; i < K; i++) {
            result = result / tmp;
            tmp--;
        }

        System.out.println(result);
    }
}
