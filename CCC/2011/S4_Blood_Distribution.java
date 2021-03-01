import java.util.*;

/*
 *  CCC: 15/15
 *  DMOJ: 50/50 (0.726s, 58.84 MB)
 *  Problem Type: Greedy Algorithms
 */

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int b[] = new int[8];
        int p[] = new int[8];
        for(int i = 0; i < 8; i++)
            b[i] = scan.nextInt();
        for(int i = 0; i < 8; i++)
            p[i] = scan.nextInt();
        int mP = 0;
        int bp = 0;
        int bn = 0;
        for (int i = 7; i >= 0; i--) {
            if (i == 3) {
                bp = p[5];
                bn = p[4];
                p[5] = 0;
                p[4] = 0;
            }
            if (i == 1) {
                p[5] = bp;
                p[4] = bn;
            }
            int r = 1;
            if (i%2!=0)
                r = 2;
            for (int j = i; j <= 7; j+=r) {
                int min = Math.min(b[i], p[j]);
                b[i]-= min;
                p[j]-= min;
                mP+=min;
            }
            /*for(int o = 0; o < 8; o++)
                System.out.print(b[o]+" ");
            System.out.println();
            for(int o = 0; o < 8; o++)
                System.out.print(p[o]+" ");
            System.out.println("\n");*/
        }
        System.out.println(mP);
    }
}