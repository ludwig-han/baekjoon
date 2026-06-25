package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_1676 {
    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = N / (int)Math.pow(5, 3) + N / (int)Math.pow(5, 2) + N / 5;
        System.out.println(result);
    }
}
