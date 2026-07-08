package lv1;

class Solution_bill {
    public static void main(String[] args) {
        int[] wallet = { 50, 50 };
        int[] bill = { 100, 241 };

        Solution_bill sb = new Solution_bill();
        System.out.printf("%d\n", sb.solution(wallet, bill));
    }

    static void sort(int[] arr) {       // 내림차순
        if (arr[0] > arr[1]) return;
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
        return;
    }

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        sort(bill);
        sort(wallet);
        //int i = 10;
        while (bill[0] > wallet[0] || bill[1] > wallet[1]) {
            //System.out.printf("bill: %d, %d\n", bill[0], bill[1]);
            answer++;
            bill[0] /= 2;
            sort(bill);

//            i--;
//            if (i < 0) break;
        }
        return answer;
    }
}
