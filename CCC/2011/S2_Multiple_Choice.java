import java.util.*;

/*
 *  CCC: 15/15
 *  DMOJ: N/A
 *  Problem Type: String Manipulation
 */

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.skip("\\p{javaWhitespace}+");
        char[] c = new char[N];
        for (int i = 0; i < N; i++) {
            c[i] = scan.next().charAt(0);
        }
        int o = 0;
        for (int i = 0; i < N; i++)
            if (c[i] == scan.next().charAt(0))
                o++;
        System.out.println(o);
    }
}