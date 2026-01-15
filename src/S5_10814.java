import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S5_10814 {
    static ArrayList<User> tmp;
    static class User {
        int age;
        String str;

        User(int age, String str) {
            this.age = age;
            this.str = str;
        }

        String print() {
            return this.age + " " + this.str + "\n";
        }
    }

    static void mergeSort(int start, int end, ArrayList<User> list) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid, list);
            mergeSort(mid + 1, end, list);
            merge(start, mid, end, list);
        }
    }

    static void merge(int start, int mid, int end, ArrayList<User> list) {
        int p = start;
        int q = mid + 1;
        int index = start;
        while(p <= mid && q <= end) {
            if (list.get(p).age <= list.get(q).age) {
                tmp.set(index++, list.get(p++));
            } else {
                tmp.set(index++, list.get(q++));
            }
        }

        while(p <= mid) {
            tmp.set(index++, list.get(p++));
        }

        while(q <= end) {
            tmp.set(index++, list.get(q++));
        }

        for (int i = start; i <= end; i++) {
            list.set(i, tmp.get(i));
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<User> list = new ArrayList<>();
        tmp = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tmp.add(null);
            list.add(null);
        }
        String _tmp;
        for (int i = 0; i < N; i++) {
            _tmp = br.readLine();
            StringTokenizer st = new StringTokenizer(_tmp);
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.set(i, new User(age, name));
        }
        mergeSort(0, N-1, list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(list.get(i).print());
        }

        System.out.print(sb);
    }
}
