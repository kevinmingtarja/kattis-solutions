import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class sortofsorting {
    // Kevin Nathanael Mingtarja
    // A0219748N
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while (true) {
            int n = 0;
            try {
                n = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.out.println("cant read");
            }


            if (n == 0) {
                break;
            }

            String[] names = new String[n];
            for (int i = 0; i < n; i++) {
                try {
                    names[i] = br.readLine();
                } catch (IOException e) {
                    System.out.println("cant read");
                }

            }

            Comparator<String> firstTwoLetters = new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    if (a.charAt(0) > b.charAt(0)) {
                        return 1;
                    } else if (a.charAt(0) < b.charAt(0)) {
                        return -1;
                    } else {
                        if (a.charAt(1) > b.charAt(1)) {
                            return 1;
                        } else if (a.charAt(1) < b.charAt(1)) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }
            };
            // Sort
            Arrays.sort(names, firstTwoLetters);

            for (int i = 0; i < n; i++) {
                pw.println(names[i]);
            }
            pw.println();
        }
        pw.close();
    }
}
