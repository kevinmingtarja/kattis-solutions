import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class cardtrading {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 0;
        int t = 0;
        int k = 0;

        try {
            String[] in = br.readLine().split(" ");
            n = Integer.parseInt(in[0]);
            t = Integer.parseInt(in[1]);
            k = Integer.parseInt(in[2]);
        } catch (IOException e) {
            System.out.println("cant read");
        }

        long[][] prices = new long[t][4];

        try {
            String[] in = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                prices[Integer.parseInt(in[i]) - 1][3]++;
            }
        } catch(IOException e) {
            System.out.println("cant read");
        }


        int combosCompleted = 0;
        String[] line;

        for (int i = 0; i < t; i++) {
            prices[i][0] = i + 1;
            try {
                line = br.readLine().split(" ");
                prices[i][1] = Long.parseLong(line[0]);
                prices[i][2] = Long.parseLong((line[1]));
            } catch (IOException e) {
                System.out.println("cant read");
            }
        }

        Comparator<long[]> myComparator = new Comparator<long[]>() {
            @Override
            public int compare(long[] a, long[] b) {
                if (a[3] == b[3]) {
                    long x = a[2] * a[3] - b[1] * (2 - b[3]);
                    long y = b[2] * b[3] - a[1] * (2 - a[3]);

                    return Long.compare(x, y);
                }
                long x = a[2] * a[3] - b[1] * (2 - b[3]);
                long y = b[2] * b[3] - a[1] * (2 - a[3]);

                return Long.compare(x, y);

            }
        };

        // Sort
        Arrays.sort(prices, myComparator);

        for (int i = 0; i < t; i++) {
            System.out.println(Arrays.toString(prices[i]));
        }

        long bestProfit = 0;
        for (int i = 0; i < t; i++) {
            if (i < k) {
                bestProfit -= prices[i][1] * (2 - prices[i][3]);
            } else {
                bestProfit += prices[i][2] * prices[i][3];

            }
        }


        System.out.println(bestProfit);
    }
}