import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3_4153 {
    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a, b, c;
        while (true) {
            String line = br.readLine();
            if (line == null || line.equals("0 0 0"))
                break;
            StringTokenizer st = new StringTokenizer(line);
//            a = Integer.parseInt(st.nextToken());
//            b = Integer.parseInt(st.nextToken());
//            c = Integer.parseInt(st.nextToken());
//            if (a == 0)
//                break;
//            if (a*a == b*b + c*c || b*b == a*a + c*c || c*c == a*a+b*b)
//                sb.append("right").append("\n");
//            else sb.append("wrong").append("\n");
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            if (Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2))
                sb.append("right").append("\n");
            else sb.append("wrong").append("\n");
        }

        System.out.print(sb);
    }
}
