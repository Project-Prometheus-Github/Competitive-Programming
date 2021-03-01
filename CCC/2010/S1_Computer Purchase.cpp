import java.util.Scanner;

/*
 *  CCC: 15/15
 *  DMOJ: N/A
 *  Problem Type: Simple Math, String Comparisons
 */

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useDelimiter("\\s+");
        int[] in = new int[3];
        String first = "";
        String second = "";
        int f = 0;
        int s = 0;
        int options = scan.nextInt();

        for (int i = 0; i < options; i++) {
            scan.skip("\\p{javaWhitespace}+");
            String str = scan.next();
            for (int I = 0; I < 3; I++) {
                in[I] = Integer.parseInt(scan.next());
            }
            int f1 = (in[0] * 2) + (in[1] * 3) + in[2];
            if (f < f1) {
                second = first;
                first = str;
                s = f;
                f = f1;
            }
            else if (f == f1) {
                if (str.compareTo(first) < 0) {
                    second = first;
                    first = str;
                    s = f;
                    f = f1;
                }
                else {
                    second = str;
                    s = f1;
                }
            }
            else if (s < f1) {
                second = str;
                s = f1;
            }
            else if (s == f1) {
                if (str.compareTo(second) < 0) {
                    second = str;
                    s = f1;
                }
            }
        }
        System.out.println(first + "\n" + second);
    }
}