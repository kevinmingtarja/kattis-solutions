import java.io.*;

public class sumkindofproblem {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int p = 0;

        try {
            p = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("cant read");
        }

        for (int i = 0; i < p; i++) {
            String k = "";
            int n = 0;

            try {
                String line = br.readLine();
                k = line.split(" ")[0];
                n = Integer.parseInt(line.split(" ")[1]);
            } catch (IOException e) {
                System.out.println("cant read");
            }

            int s1 = n * (n+1) / 2;
            int s2 = n * n;
            int s3 = n * (n+1);

            pw.printf("%s %d %d %d%n", k, s1, s2, s3);
        }
        pw.close();
    }
}
