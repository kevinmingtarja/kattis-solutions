import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class bestrelayteam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = sc.nextInt();

        String[] names = new String[n];
        double[][] firstLeg = new double[n][2];
        double[][] otherLegs = new double[n][2];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            firstLeg[i][0] = i;
            otherLegs[i][0] = i;
            firstLeg[i][1] = sc.nextDouble();
            otherLegs[i][1] = sc.nextDouble();
        }

        // Sorts firstLeg
        Arrays.sort(firstLeg, new java.util.Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                return Double.compare(a[1], b[1]);
            }
        });

        Arrays.sort(otherLegs, new java.util.Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                return Double.compare(a[1], b[1]);
            }
        });

        double minTime = 80;
        int[] order = new int[4];

        for (int i = 0; i < 4; i++) {
            int counter = 1;
            int j = 0;
            double currTime = firstLeg[i][1];
            int[] currOrder = new int[4];
            currOrder[0] = (int) firstLeg[i][0];
            while (counter != 4) {
                if (otherLegs[j][0] != firstLeg[i][0]) {
                    currTime += otherLegs[j][1];
                    currOrder[counter] = (int) otherLegs[j][0];
                    counter++;
                }
                j++;
            }
            if (currTime < minTime) {
                minTime = currTime;
                order = currOrder;
            }
        }
        pw.println(minTime);
        for (int i = 0; i < 4; i++) {
            pw.println(names[order[i]]);
        }
        pw.close();
    }
}
