import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_15829 {
    static long modPow(int a, int r, int i, int M) {
        long result = (long)a;
        for (int j = 0; j < i; j++) {
            result = result * r;
            if (result >= M)
                result = result % M;
        }
        return result;
    }

    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = 1234567891;
        int r = 31;

        String str = br.readLine();

        long hash = 0;

        for (int i = 0; i < N; i++) {
            //hash += (str.charAt(i) - 'a' + 1) * (long)Math.pow(r, i);
            hash = (hash + modPow(str.charAt(i) - 'a' + 1, r, i, M)) % M;
        }

        //System.out.println(hash % M);
        System.out.println(hash);

    }
}
