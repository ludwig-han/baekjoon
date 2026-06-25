package baekjoon;// https://www.acmicpc.net/problem/14626
// case가 몇 개 없으면 브루트 포스(Brute Force)가 더 효율적일 수 있다!
// Mod 분배법칙 조심하자!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_14626 {
    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int _total = 0;
        int unknownIdx = 0;

        for (int i = 0; i < 13; i++) {
            if (line.charAt(i) != '*')
                _total = _total + (line.charAt(i) - '0') * (i % 2 == 0 ? 1 : 3);
            else
                unknownIdx = i;
        }

        int weight = (unknownIdx % 2 == 0 ? 1 : 3);
        for (int i = 0; i < 10; i++) {
            if ((_total + (i * weight)) % 10 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
