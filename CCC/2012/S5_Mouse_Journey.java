import java.util.*;

/*
 *  CCC: N/A
 *  DMOJ: 70/70 (1.090s, 60.96 MB)
 *  Problem type: Dynamic Programming
 */

public class Main {
    public static int[][] map;
    public static int r, c;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        r = scan.nextInt()-1;
        c = scan.nextInt()-1;
        map = new int[r+1][c+1];
        int cats = scan.nextInt();
        for (int i = 0; i < cats; i++) {
            int nr = scan.nextInt()-1;
            int nc = scan.nextInt()-1;
            map[nr][nc] = 1;
        }
        System.out.println(journeys(0,0));
    }
    public static int journeys(int x, int y) {
        /*System.out.println(x+1 + " " + (y+1));
        for(int i = 0; i < r+1; i++) {
            for(int j = 0; j < c+1; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }*/
        if (map[x][y] > 1)
            return map[x][y]-1;
        if (x == r && y == c)
            return 1;
        int out = 0;
        if (y < c && map[x][y+1] != 1)
            out+=journeys(x,y+1);
        if (x < r && map[x+1][y] != 1)
            out+=journeys(x+1,y);
        if (out > 0)
            map[x][y] = out+1;
        return out;
    }
}