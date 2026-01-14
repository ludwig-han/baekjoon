import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
    public static int[] tmp;
    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        tmp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, 0, N - 1);

        for (int val: tmp) System.out.println(val);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int p1 = start;
        int p2 = mid + 1;
        int index = start;
        while (p1 <= mid && p2 <= end) {
            if (arr[p1] <= arr[p2])
                tmp[index++] = arr[p1++];
            else
                tmp[index++] = arr[p2++];
        }

        while (p1 <= mid) tmp[index++] = arr[p1++];
        while (p2 <= end) tmp[index++] = arr[p2++];

        for (int i = start; i < end; i++) {
            arr[i] = tmp[i];
        }
    }
}