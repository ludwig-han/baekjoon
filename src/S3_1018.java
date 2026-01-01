import java.util.Scanner;

public class S3_1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 초기 세팅
        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            arr[i] = line.toCharArray();
        }

        int min = N * M;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int countW = 0;
                int countB = 0;

                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {

                        // case of starting with W:
                        if ((k + l) % 2 == 0 && arr[k][l] != 'W')
                            countW++;
                        if ((k + l) % 2 == 1 && arr[k][l] != 'B')
                            countW++;

                        // case of starting with B:
                        if ((k + l) % 2 == 0 && arr[k][l] != 'B')
                            countB++;
                        if ((k + l) % 2 == 1 && arr[k][l] != 'W')
                            countB++;
                    }
                }
                int _min = Math.min(countW, countB);
                min = Math.min(_min, min);
            }
        }

        System.out.println(min);
    }
}
