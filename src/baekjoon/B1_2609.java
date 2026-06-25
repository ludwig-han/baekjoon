package baekjoon;// https://www.acmicpc.net/problem/2609
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1_2609 {
    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int max;
        int min;

        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        min = a * b;
        while (a % b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        max = b;
        min = min / max;

        System.out.println(max);
        System.out.println(min);
    }
}
