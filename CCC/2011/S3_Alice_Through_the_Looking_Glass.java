import java.util.*;

/*
 *  CCC: 15/15
 *  DMOJ: 50/50 (0.719s, 58.83 MB)
 *  Problem Type: Recursion
 */

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] m = new int[N];
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            m[i] = scan.nextInt();
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
        }
        for (int i = 0; i < N; i++) {
            if (y[i] < solve(m[i],x[i]))
                System.out.println("crystal");
            else
                System.out.println("empty");
        }
    }

    public static int solve(int m, int x) {
        if (m >= 1) {
            int multiple = (int)Math.pow(5,m-1);
            int column = (int)(x / multiple);
            if (column == 0 || column == 4)
                return 0;
            else if (column == 1 || column == 3)
                return 1 * multiple + solve(m-1,x % multiple);
            else if (column == 2)
                return 2 * multiple + solve(m-1,x % multiple);
            return multiple*5;
        }
        return 0;
    }
}